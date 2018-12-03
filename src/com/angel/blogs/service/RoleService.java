
package com.angel.blogs.service;

import java.util.List;
import java.util.Map;

import com.angel.blogs.bean.Role;
import com.angel.blogs.utils.Page;
import com.angel.blogs.utils.Paginator;


/**
 * 
* @ClassName: RoleService
* @Description: 角色Service
* @author zkm
* @date  2018-08-30 10:34
 */
public interface RoleService {
	
	/**
	 * 
	* @Title: findAll     
	* @Description: 分页查询角色信息 
	* @param map
	* @param start
	* @return   
	* Paginator    返回类型 
	* @author zkm 
	* @date 2018-08-30 10:40
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
	 * 
	* @Title: getById     
	* @Description: 根据ID查询角色信息 
	* @param id
	* @return   
	* Role    返回类型 
	* @author zkm 
	* @date 2018-08-30 17:04
	 */
	Role getById(int id);
	
	/**
	 * 
	* @Title: add     
	* @Description: 添加角色信息 
	* @param name
	* @param status
	* @param code
	* @param iIndex
	* @param remark
	* @param menuIds
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-08-30 17:05
	 */
	boolean add(String name, int status, String code, int iIndex, String remark,String menuIds);
	
	/**
	 * 
	* @Title: update     
	* @Description: 修改角色信息 
	* @param id
	* @param name
	* @param status
	* @param code
	* @param iIndex
	* @param remark
	* @param menuIds
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-08-31 08:58
	 */
	boolean update(int id,String name, int status, String code, int iIndex, String remark,String menuIds);
	
	
	/**
	 * 
	* @Title: delete     
	* @Description: 角色删除  （逻辑删除）
	* @param ids
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-02 13:12
	 */
	boolean delete(String ids);
	
}
