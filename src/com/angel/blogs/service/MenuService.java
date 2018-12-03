package com.angel.blogs.service;

import java.util.List;

import com.angel.blogs.bean.Menu;


/**
 * 
* @ClassName: MenuService
* @Description: 菜单Serivce
* @author zkm
* @date  2018-08-29 14:41
 */
public interface MenuService {
	
	/**
	 * 查询菜单列表
	 * @param roId
	 * @return
	 * @author changbaolong
	 * @date 2018-01-19 09:07:06
	 */
	List<Menu> findAll(int roId);
	
	/**
	 * 
	* @Title: findAll     
	* @Description: 查询全部
	* @return   
	* List<Menu>    返回类型 
	* @author zkm 
	* @date 2018-08-30 16:13
	 */
	List<Menu> findAll();
	
	/**
	 * 根据ID查询菜单信息
	 * @param id
	 * @return
	 * @author changbaolong
	 * @date 2018-01-19 09:07:23
	 */
	Menu getById(int id);
	
	/**
	 * 
	* @Title: add     
	* @Description:添加菜单信息 
	* @param name
	* @param status
	* @param menuUrl
	* @param pId
	* @param openType
	* @param iIndex
	* @param remark
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-08-29 15:43
	 */
	boolean add(String name, int status, String menuUrl, int pId, int openType, int iIndex, String remark);
	
	/**
	 * 
	* @Title: update     
	* @Description: 菜单修改 
	* @param id
	* @param name
	* @param status
	* @param menuUrl
	* @param pId
	* @param openType
	* @param iIndex
	* @param remark
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-08-29 16:35
	 */
	boolean update(int id,String name, int status, String menuUrl, int pId, int openType, int iIndex, String remark);
	
	/**
	 * 
	* @Title: delete     
	* @Description: 删除菜单信息 
	* @param ids
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-02 13:33
	 */
	boolean delete(String ids);
	
	

}
