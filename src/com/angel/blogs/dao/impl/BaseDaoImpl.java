package com.angel.blogs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.angel.blogs.dao.BaseDao;
import com.angel.blogs.utils.Page;
import com.angel.blogs.utils.PageRequest;




/**
 * 
* @ClassName: BaseDaoImpl
* @Description: BaseDao实现
* @author zkm
* @date  2018-08-27 16:15
 */
@Repository
public class BaseDaoImpl implements BaseDao  {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> findAll(String sql, Object[] params) {
		try {
			return jdbcTemplate.queryForList(sql, params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Map<String, Object> getById(String sql,Object[] params) {
		try {
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, params);
			if(list.size() > 0){
				return list.get(0);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insert(String sql,String seq) {
		try {
			List<Map<String, Object>> list = jdbcTemplate.queryForList("select "+seq+" id from dual");
			String id = list.get(0).get("id").toString();
			jdbcTemplate.update(sql, new Object[]{id});
			return Integer.parseInt(id);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	* @Title: update     
	* @Description: 修改数据 
	* @param sql
	* @param params
	* @return   
	* int    返回类型 
	* @author zkm 
	* @date 2018-09-06 09:35
	 */
	@Override
	public int update(String sql, Object[] params) {
		try {
			return jdbcTemplate.update(sql,params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	* @Title: delete     
	* @Description: 删除数据  
	* @param sql
	* @param params
	* @return   
	* int    返回类型 
	* @author zkm 
	* @date 2018-08-31 09:00
	 */
	@Override
	public int delete(String sql, Object[] params) {
		try {
			return jdbcTemplate.update(sql,params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int count(String sql, Object[] params) {
		try {
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, params);
			return list.size();
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public boolean batchUpdate(String[] sqls) {
		try {
			int[] result = jdbcTemplate.batchUpdate(sqls);
			for (int i : result) {
				if(i <= 0){
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}


	@Override
	public int insert(String sql, String seq, Object[] obj) {
		try {
			List<Map<String, Object>> list = jdbcTemplate.queryForList("select "+seq+" id from dual");
			String id = list.get(0).get("id").toString();
			if(obj!=null&&obj.length>=1){
				obj[0]=id;
			}
			jdbcTemplate.update(sql, obj);
			return Integer.parseInt(id);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	* @Title: addFiles     
	* @Description: 添加文件信息
	* @param fileName
	* @param fileUrl
	* @param table
	* @param id
	* @return   
	* int    返回类型 
	* @author zkm 
	* @date 2018-08-31 17:30
	 */
	@Override
	public int addFiles(String fileName,String fileUrl,String table,String id) {
		int filesId = 0;
		try {
			if(fileUrl != null && !"".equals(fileUrl)){
				this.update("update b_files set STATUS = -1 where FINGERTABLE = '"+table+"' and FINGERID = "+id, null);
				String addFilesSql = "insert into b_files(ID,NAME,STATUS,FILEURL,FINGERTABLE,FINGERID,TYPE,SUFFIX) values(0,'"+
						fileName+"',1,'"+fileUrl+"','"+table+"',"+id+",1,'"+fileUrl.substring(fileUrl.indexOf(".")+1)+"')";
				filesId = this.insert(addFilesSql);				
			}else if((fileName == null || "".equals(fileName)) && (fileUrl == null || "".equals(fileUrl))){
				this.update("update b_files set STATUS = -1 where FINGERTABLE = '"+table+"' and FINGERID = "+id, null);
				filesId = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filesId;
	}


	@Override
	public int insert(String sql) {
		try {
		 
			int id=jdbcTemplate.update(sql);
			return id;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public int getid(String sql) {
		List<Map<String, Object>> list = jdbcTemplate.queryForList("select "+sql+" id from dual");
		String id = list.get(0).get("id").toString();
		return Integer.parseInt(id);
	}


	@Override
	public int insert(String sql, Object[] obj) {
		try {
			int id=jdbcTemplate.update(sql, obj);
			return id;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int count1(String sql, Object[] params) {
		
		try {
			int count = jdbcTemplate.queryForObject("select count(1) from ("+sql+")", Integer.class) ;
			return count;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


	/**
	 * 
	* @Title: getmysqlid     
	* @Description: 获取表插入最大id
	* @param sql
	* @return   
	* int    返回类型 
	* @author zkm 
	* @date 2018-08-31 08:42
	 */
	@Override
	public int getmysqlid(String sql) {
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		String id = list.get(0).get("id").toString();
		return Integer.parseInt(id);
	}
}
