
package com.angel.blogs.service;

import java.util.List;
import java.util.Map;

import com.angel.blogs.bean.Articles;
import com.angel.blogs.bean.Role;
import com.angel.blogs.utils.Paginator;


/**
 * 
* @ClassName: ArticlesService
* @Description: 博文Service
* @author zkm
* @date  2018-09-10 10:31
 */
public interface ArticlesService {
	
	/**
	 * 
	* @Title: findAll     
	* @Description: 分页查询博文信息
	* @param map
	* @param start
	* @return   
	* Paginator    返回类型 
	* @author zkm 
	* @date 2018-09-10 10:32
	 */
	Paginator findAll(Map<String,String> map,String start);
	
	
	/**
	 * 查询全部角色信息
	 * @return
	 * @author changbaolong
	 * @date 2018-01-19 04:03:43
	 */
	List<Role> findAll();
	
	/**
	* @Title: getById     
	* @Description: 根据id查询文章信息
	* @param id
	* @return   
	* Articles    返回类型 
	* @author zkm 
	* @date 2018-09-11 17:26
	 */
	Articles getById(int id);

	/**
	 * 
	* @Title: add     
	* @Description: 添加文章 
	* @param title
	* @param keywords
	* @param abstracts
	* @param authors
	* @param sources
	* @param iindex
	* @param assId
	* @param auditstatus
	* @param content
	* @param fileName
	* @param fileUrl
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-11 16:05
	 */
	boolean add(String title,int uid,String keywords,String abstracts,String authors,String sources, int iindex,int assId, int auditstatus, String content,String fileName,String fileUrl,String[] articlesTagIds);
	
	/**
	 * 
	* @Title: update     
	* @Description: 修改文章信息 
	* @param title
	* @param uid
	* @param keywords
	* @param abstracts
	* @param authors
	* @param sources
	* @param iindex
	* @param assId
	* @param auditstatus
	* @param content
	* @param fileName
	* @param fileUrl
	* @param articlesTagIds
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-12 11:03
	 */
	boolean update(int id,String title,int uid,String keywords,String abstracts,String authors,String sources, int iindex,int assId, int auditstatus, String content,String fileName,String fileUrl,String[] articlesTagIds);
	
	
	/**
	 * 
	* @Title: delete     
	* @Description: 博文删除  （逻辑删除）
	* @param ids
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-02 13:12
	 */
	boolean delete(String ids);
	
}
