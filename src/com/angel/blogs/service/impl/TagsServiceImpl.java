package com.angel.blogs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.blogs.bean.Tags;
import com.angel.blogs.dao.BaseDao;
import com.angel.blogs.service.TagsService;
import com.angel.blogs.utils.FormatSql;
import com.angel.blogs.utils.Paginator;


/**
 * 
* @ClassName: TagsServiceImpl
* @Description: 标签Service实现
* @author zkm
* @date  2018-09-05 09:49
 */
@Service
public class TagsServiceImpl implements TagsService {
	
	@Autowired
	private BaseDao baseDao;

	/**
	 * 
	* @Title: findAll     
	* @Description: 分页查询标签列表 
	* @param map
	* @param start
	* @return   
	* Paginator    返回类型 
	* @author zkm 
	* @date 2018-09-05 09:57
	 */
	@Override
	public Paginator findAll(Map<String, String> map, String start) {
		Paginator paginator = new Paginator();
		try {
			String selectSql = "SELECT 	id, tagname, STATUS, CODE,iindex, tagurl, date_format(createdate, '%Y-%m-%d %H:%i:%s')  as createdate, remark FROM b_tags WHERE STATUS <> -1";
			if(map != null){
				if(map.containsKey("name")){
					selectSql += " and tagname like '%"+map.get("name")+"%'";
				}
			}
			selectSql += " order by id asc";
			String columns = "ID, TAGNAME, STATUS, CODE,IINDEX, TAGURL, CREATEDATE, REMARK";
			String sql = FormatSql.queryPageSql(columns, selectSql, start);
			List<Map<String, Object>> mapList = baseDao.findAll(sql, null);
			List<Tags> list = new ArrayList<Tags>();
			Tags tags = null;
			for (Map<String, Object> map2 : mapList) {
				tags = new Tags();
				tags.setId(Integer.parseInt(map2.get("ID").toString()));
				tags.setTagname(map2.get("TAGNAME").toString());
				tags.setStatus(Integer.parseInt(map2.get("STATUS").toString()));
				tags.setCode(map2.get("CODE")!=null?map2.get("CODE").toString():"");
				tags.setIindex(Integer.parseInt(map2.get("IINDEX").toString()));
				tags.setTagurl(map2.get("TAGURL").toString());
				tags.setCreatedate(map2.get("CREATEDATE").toString());
				tags.setRemark(map2.get("REMARK")!=null?map2.get("REMARK").toString():"");
				list.add(tags);
				tags = null;
			}
			int count = baseDao.count(selectSql, null);
			paginator.setResult(list);
			paginator.setCurrentPage(Integer.parseInt(start)/10);
			paginator.setTotalCount(count);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paginator;
	}

	/**
	 * 
	* @Title: getById     
	* @Description: 根据ID查询标签信息
	* @param id
	* @return   
	* Tags    返回类型 
	* @author zkm 
	* @date 2018-09-05 09:58
	 */
	@Override
	public Tags getById(int id) {
		Tags tags = null;
		try {
			tags = new Tags();
			String sql = "SELECT 	id, tagname, STATUS, CODE,iindex, tagurl, createdate, remark FROM b_tags WHERE STATUS <> -1 AND id=?";
			Map<String, Object> map = baseDao.getById(sql, new Object[]{id});
			tags.setId(Integer.parseInt(map.get("ID").toString()));
			tags.setTagname(map.get("TAGNAME").toString());
			tags.setStatus(Integer.parseInt(map.get("STATUS").toString()));
			tags.setCode(map.get("CODE")!=null?map.get("CODE").toString():"");
			tags.setIindex(Integer.parseInt(map.get("IINDEX").toString()));
			tags.setTagurl(map.get("TAGURL").toString());
			tags.setCreatedate(map.get("CREATEDATE").toString());
			tags.setRemark(map.get("REMARK")!=null?map.get("REMARK").toString():"");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tags;
	}

	/**
	 * 
	* @Title: add     
	* @Description: 添加标签
	* @param tagname
	* @param status
	* @param code
	* @param iIndex
	* @param remark
	* @param tagurl
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-05 10:03
	 */
	@Override
	public boolean add(String tagname, int status, String code, int iIndex, String remark,String tagurl) {
		try {
			String sql = "INSERT INTO b_tags (id, tagname, STATUS, CODE, iindex, tagurl, createdate, remark)VALUES(0,'"+
					tagname+"',"+status+",'"+code+"',"+iIndex+",'"+tagurl+"',now(),'"+remark+"')";
			int id = baseDao.insert(sql);		
			if(id > 0){
					return true;					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	* @Title: update     
	* @Description: 修改友情链接信息  
	* @param id
	* @param title
	* @param status
	* @param code
	* @param iIndex
	* @param remark
	* @param linksurl
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-04 15:58
	 */
	@Override
	public boolean update(int id,String tagname, int status, String code, int iIndex, String remark,String tagurl) {
		
		String sql = "update b_tags set tagname=?,STATUS=?,CODE=?,IINDEX=?,REMARK=?,tagurl=? where ID=?";
		Object[] params = new Object[]{tagname,status,code,iIndex,remark,tagurl,id
		};
		int result = baseDao.update(sql, params);
		if(result > 0){
				return true;					
			}
		return false;
	}

	/**
	 * 
	* @Title: delete     
	* @Description: 删除标签（物理删除）
	* @param ids
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-05 10:06
	 */
	@Override
	public boolean delete(String ids) {
		try {
			String sql = "delete from  b_tags  where ID in ("+ids+")";
			int result = baseDao.delete(sql, null);
			if(result > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	* @Title: findAll     
	* @Description: 查询全部标签
	* @return   
	* List<Tags>    返回类型 
	* @author zkm 
	* @date 2018-09-11 13:23
	 */
	@Override
	public List<Tags> findAll() {
		List<Tags> list = new ArrayList<Tags>();
		try {
			String selectSql = "SELECT 	id, tagname, STATUS, CODE, iindex, tagurl, createdate, remark from b_tags  WHERE STATUS <> -1  ";
			selectSql += " ORDER BY iindex ";
			List<Map<String, Object>> mapList = baseDao.findAll(selectSql, null);
			Tags tags = null;
			for (Map<String, Object> map2 : mapList) {
				tags = new Tags();
				tags.setId(Integer.parseInt(map2.get("ID").toString()));
				tags.setTagname(map2.get("TAGNAME").toString());
				tags.setStatus(Integer.parseInt(map2.get("STATUS").toString()));
				tags.setCode(map2.get("CODE")!=null?map2.get("CODE").toString():"");
				tags.setIindex(Integer.parseInt(map2.get("IINDEX").toString()));
				tags.setTagurl(map2.get("TAGURL").toString());
				tags.setCreatedate(map2.get("CREATEDATE").toString());
				tags.setRemark(map2.get("REMARK")!=null?map2.get("REMARK").toString():"");
				list.add(tags);
				tags = null;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
