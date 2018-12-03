package com.angel.blogs.service;

import java.util.List;

import com.angel.blogs.bean.Area;
import com.angel.blogs.bean.Assortment;


/**
 * 
* @ClassName: AssortmentService
* @Description: 分类Service
* @author zkm
* @date  2018-09-04 08:57
 */
public interface AssortmentService {
	
	/**
	 * 
	* @Title: findAll     
	* @Description: 查询分类列表 
	* @param id
	* @return   
	* List<Assortment>    返回类型 
	* @author zkm 
	* @date 2018-09-04 09:09
	 */
	List<Assortment> findAll(int id);
	
	/**
	 * 
	* @Title: getById     
	* @Description: 根据ID查询分类信息 
	* @param id
	* @return   
	* Assortment    返回类型 
	* @author zkm 
	* @date 2018-09-04 09:10
	 */
	Assortment getById(int id);
	
	/**
	 * 
	* @Title: add     
	* @Description: 添加分类信息 
	* @param name
	* @param status
	* @param code
	* @param pId
	* @param iIndex
	* @param remark
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-04 09:10
	 */
	boolean add(String name, int status, String code, int pId, int iIndex, String remark);
	
	/**
	 * 
	* @Title: update     
	* @Description: 修改分类
	* @param id
	* @param name
	* @param status
	* @param code
	* @param pId
	* @param iIndex
	* @param remark
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-04 09:11
	 */
	boolean update(int id, String name, int status, String code, int pId, int iIndex, String remark);
	
	/**
	 * 
	* @Title: delete     
	* @Description: 删除分类信息 
	* @param ids
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-04 09:12
	 */
	boolean delete(String ids);
	
	/**
	 * 手机端查询分类列表
	 * @param 
	 * @return
	 * @author lv
	 * @date 2018-01-19 10:20:14
	 */
	List<Assortment> phonefindAll();
	
	/**
	 * 
	* @Title: findAssortmentAllNotLayer     
	* @Description: 查询分类
	* @return   
	* List<Assortment>    返回类型 
	* @author zkm 
	* @date 2018-09-10 17:03
	 */
	List<Assortment> findAssortmentAllNotLayer(int id);

}
