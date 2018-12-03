package com.angel.blogs.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.angel.blogs.utils.Page;


/**
 * 
* @ClassName: BaseDao
* @Description: BaseDao
* @author zkm
* @date  2018-08-27 16:14
 */
public interface BaseDao {


	/**
	 * 获取全部数据
	 * @param sql			sql语句
	 * @param params		sql语句参数
	 * @return				数据集合
	 * @author changbaolong
	 * @date 2018-01-15 10:48:48
	 */
	List<Map<String,Object>> findAll(String sql,Object[] params);
	
	/**
	 * 根据ID查询数据
	 * @param sql			sql语句
	 * @param params		sql语句参数
	 * @return				数据Map对象
	 * @author changbaolong
	 * @date 2018-01-15 10:57:16
	 */
	Map<String,Object> getById(String sql,Object[] params);
	
	/**
	 * 添加数据
	 * @param sql			sql语句
	 * @param seq			oracle数据库序列名称
	 * @return				添加的数据ID
	 * @author changbaolong
	 * @date 2018-01-15 10:57:24
	 */
	int insert(String sql,String seq);

	/**
	 * 添加数据
	 * @param sql			sql语句
	 * @return				添加的数据ID
	 * @author changbaolong
	 * @date 2018-01-15 10:57:24
	 */
	int insert(String sql );
	/**
	 * 添加数据
	 * @param sql			sql语句
	 * @param seq			oracle数据库序列名称
	 * @return				添加的数据ID
	 * @author changbaolong
	 * @date 2018-01-15 10:57:24
	 */
	int insert(String sql,String seq,Object [] obj);
	/**
	 * 添加数据
	 * @param sql			sql语句
	 * @param seq			oracle数据库序列名称
	 * @return				添加的数据ID
	 * @author changbaolong
	 * @date 2018-01-15 10:57:24
	 */
	int insert(String sql,Object [] obj);
	
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
	int update(String sql,Object[] params);
	
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
	int delete(String sql,Object[] params);
	
	/**
	 * 获取数据总数
	 * @param sql			sql语句
	 * @param params		sql语句参数
	 * @return				数据数量
	 * @author changbaolong
	 * @date 2018-01-15 10:58:41
	 */
	int count(String sql,Object[] params);
	/**
	 * 获取数据总数
	 * @param sql			sql语句
	 * @param params		sql语句参数
	 * @return				数据数量
	 * @author changbaolong
	 * @date 2018-01-15 10:58:41
	 */
	int count1(String sql,Object[] params);
	
	/**
	 * 批量修改数据
	 * @param sqls			sql语句
	 * @return
	 * @author changbaolong
	 * @date 2018-01-19 02:35:46
	 */
	boolean batchUpdate(String[] sqls);
	
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
	int addFiles(String fileName,String fileUrl,String table,String id);
	/**
	 * 获取id
	 * @author 张旗
	 * @date 2018-01-23 03:59:30
	 */
	int getid(String sql);
	
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
	int getmysqlid(String sql);
	
}
