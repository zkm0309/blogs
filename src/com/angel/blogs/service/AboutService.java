
package com.angel.blogs.service;

import java.util.List;
import java.util.Map;

import com.angel.blogs.bean.About;
import com.angel.blogs.bean.Tags;
import com.angel.blogs.utils.Paginator;

/**
 * 
* @ClassName: AboutService
* @Description: 关于我service
* @author zkm
* @date  2018-09-13 11:05
 */
public interface AboutService {
	
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
	Paginator findAll(Map<String,String> map,String start);
	
	
	/**
	 * 
	* @Title: findAll     
	* @Description: 查询全部标签
	* @return   
	* List<Tags>    返回类型 
	* @author zkm 
	* @date 2018-09-11 13:23
	 */
	List<About> findAll();
	
	/**
	 * 
	* @Title: getById     
	* @Description: 根据ID查询关于我信息
	* @param id
	* @return   
	* About    返回类型 
	* @author zkm 
	* @date 2018-09-13 11:06
	 */
	About getById(int id);
	
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
	boolean add(String tagname, int status, String code, int iIndex, String remark,String tagurl);
	
	/**
	 * 
	* @Title: update     
	* @Description: 修改关于我们
	* @param id
	* @param aboutme
	* @param domainname
	* @param servers
	* @param record
	* @param remark
	* @param qq
	* @param git
	* @param email
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-13 11:28
	 */
	boolean update(int id,String aboutme, String domainname, String servers, String record, String remark,String qq, String git,String email);
	
	
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
	boolean delete(String ids);
	
}
