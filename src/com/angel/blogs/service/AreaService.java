package com.angel.blogs.service;

import java.util.List;
import java.util.Map;

import com.angel.blogs.bean.Area;



/**
 * 
* @ClassName: AreaService
* @Description: 区域Service
* @author zkm
* @date  2018-08-28 15:54
 */
public interface AreaService {
	
	/**
	 * 
	* @Title: findAll     
	* @Description: 根据ID查询列表 
	* @param id
	* @return   
	* List<Area>    返回类型 
	* @author zkm 
	* @date 2018-08-29 17:31
	 */
	List<Area> findAll(int id);
	
	/**
	 * 根据ID查询列表
	 * @param id			ID
	 * @return
	 * @author ZLFENG
	 * @date 2018-01-17 03:35:55
	 */
	List<Area> getCfindAll(int id);
	
	/**
	 * 
	* @Title: findAllNotLayer     
	* @Description: 根据ID查询列表 layer<>5
	* @param id
	* @return   
	* List<Area>    返回类型 
	* @author zkm 
	* @date 2018-09-02 09:34
	 */
	List<Area> findAllNotLayer(int id);
	
	/**
	 * 根据ID查询镇列表
	 * @param id			ID
	 * @return
	 * @author lv
	 * @date 2018-01-23 
	 */
	List<Area> findZAll(int id);
	/**
	 * 根据ID查询村列表
	 * @param id			ID
	 * @return
	 * @author lv
	 * @date 2018-01-23 
	 */
	List<Area> findCAll(int id);
	/**
	 * 根据ID查询镇村列表
	 * @param id			ID
	 * @return
	 * @author lv
	 * @date 2018-06-29 
	 */
	List<Map<String,Object>> findZCAll(int id);
	
	/**
	 * 
	* @Title: getById     
	* @Description: 根据id查询区域信息
	* @param id
	* @return   
	* Area    返回类型 
	* @author zkm 
	* @date 2018-08-30 09:05
	 */
	Area getById(int id);
	
	/**
	 * 
	* @Title: add     
	* @Description: 添加区域信息 
	* @param name
	* @param status
	* @param code
	* @param pId
	* @param layer
	* @param iIndex
	* @param remark
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-08-30 09:01
	 */
	boolean add(String name, int status, String code, int pId, int layer, int iIndex, String remark);
	
	/**
	 * 
	* @Title: update     
	* @Description: 区域修改 
	* @param id
	* @param name
	* @param status
	* @param code
	* @param pId
	* @param layer
	* @param iIndex
	* @param remark
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-08-30 09:01
	 */
	boolean update(int id, String name, int status, String code, int pId, int layer, int iIndex, String remark);
	
	/**
	 * 
	* @Title: delete     
	* @Description: 删除区域信息  
	* @param ids
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-02 13:21
	 */
	boolean delete(String ids);
	/**
	 * 根据护林员id查询所在镇id
	 * @param id		
	 * @return
	 * @author lv
	 * @date 2018-01-26 
	 */
	Map<String, Object> findZidByhlyid(String id,String roid);
	/**
	 * 根据id查询同级别下 其他账户id  本(县,镇)下   (镇,村) id
	 */
	List<Map<String, Object>> findPeerArray(int id,int type);
	
}
