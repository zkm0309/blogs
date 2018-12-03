
package com.angel.blogs.service;

import java.util.List;
import java.util.Map;

import com.angel.blogs.bean.Links;
import com.angel.blogs.utils.Paginator;


/**
 * 
* @ClassName: LinksService
* @Description: 友情链接Service
* @author zkm
* @date  2018-09-04 14:06
 */
public interface LinksService {
	
	/**
	 * 
	* @Title: findAll     
	* @Description: 分页查询友情链接
	* @param map
	* @param start
	* @return   
	* Paginator    返回类型 
	* @author zkm 
	* @date 2018-09-04 16:43
	 */
	Paginator findAll(Map<String,String> map,String start);
	
	
	/**
	 * 查询全部角色信息
	 * @return
	 * @author changbaolong
	 * @date 2018-01-19 04:03:43
	 */
	List<Links> findAll();
	
	/**
	 * 
	* @Title: getById     
	* @Description: 根据ID查询友情链接信息
	* @param id
	* @return   
	* Links    返回类型 
	* @author zkm 
	* @date 2018-09-04 15:49
	 */
	Links getById(int id);
	
	/**
	 * 
	* @Title: add     
	* @Description: 添加友情链接 
	* @param title
	* @param status
	* @param code
	* @param iIndex
	* @param remark
	* @param linksurl
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-04 15:07
	 */
	boolean add(String title, int status, String code, int iIndex, String remark,String linksurl);
	
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
	boolean update(int id,String title, int status, String code, int iIndex, String remark,String linksurl);
	
	
	/**
	 * 
	* @Title: delete     
	* @Description: 删除链接（物理删除）
	* @param ids
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-04 16:34
	 */
	boolean delete(String ids);
	
}
