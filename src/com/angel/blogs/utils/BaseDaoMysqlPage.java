package com.angel.blogs.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoMysqlPage {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	public long countBy(Map<String, Object> values,JdbcTemplate jdbcTemplate) {
		String sql = "select count(0) from ( " + values.get("sql") + " ) t";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public Page findPage(PageRequest pageRequest , Map<String, Object> values) {
		
        values = (values == null) ? new HashMap<String, Object>(1) : values;
		
		values.put("pageRequest", pageRequest);
		
		Page page = new Page(pageRequest);
		
		long totalItems = countBy(values , jdbcTemplate);
		
		page.setTotalItems(totalItems);
		
		List<?> result = find(values,jdbcTemplate);
		
		page.setResult(result);
		
		return page;
	}
	
	public List<?> find(Map<String, Object> values,JdbcTemplate jdbcTemplate) {
		
		PageRequest pg = (PageRequest)values.get("pageRequest");
		int begin = pg.getOffset();
		int end = pg.getPageSize()*pg.getPageNo();
		String sql = values.get("sql")+" limit "+begin+",10";
		return (List<?>)jdbcTemplate.queryForList(sql);
	}
    public JdbcTemplate getJdbcTemplate()
    {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }
	
}
