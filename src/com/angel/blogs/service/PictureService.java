package com.angel.blogs.service;

import java.util.List;
import java.util.Map;

import com.angel.blogs.bean.Account;
import com.angel.blogs.bean.Files;
import com.angel.blogs.bean.Picture;
import com.angel.blogs.utils.Paginator;


/**
 * 
* @ClassName: PictureService
* @Description: 轮播图
* @author zkm
* @date  2018-09-05 14:24
 */
public interface PictureService {
	/**
	 * 
	* @Title: findAll     
	* @Description: 查询全部
	* @param map
	* @param start
	* @param account
	* @return   
	* Paginator    返回类型 
	* @author zkm 
	* @date 2018-09-05 15:08
	 */
	Paginator findAll(Map<String, String> map, String start,Account account) ;
	/**
	 * 根据id查询
	 * @param 
	 * @return
	 * @author lvxiangjin
	 * @date 2018-01-19 
	 */
	Map<String, Object> findByid(String tableName,int id);
	
	Map<String, Object> findcjrid(int id);
	/**
	 * 
	* @Title: addPicture     
	* @Description: 轮播图添加  
	* @param picture
	* @return   
	* Integer    返回类型 
	* @author zkm 
	* @date 2018-09-06 08:47
	 */
	Integer addPicture(Picture picture);
	/**
	 * 
	* @Title: delPicture     
	* @Description: 删除图片
	* @param ids
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-06 10:57
	 */
	boolean delPicture(String ids);
	
	
	
	Integer delFiles(String tableName,String fingerid);
	/**
	 * 修改新闻
	 * @param 
	 * @return
	 * @author lvxiangjin
	 * @date 2018-01-19 
	 */
	Integer updFile(Files files);
	Integer updPicture(Picture picture);
	
	/**
	 * 
	* @Title: findFileById     
	* @Description: 根据id查询文件信息
	* @param tablename
	* @param id
	* @return   
	* Map<String,Object>    返回类型 
	* @author zkm 
	* @date 2018-09-06 09:31
	 */
	Map<String, Object> findFileById(String tablename,int id);	
	
	
	Map<String, Object> findCreateId(int id);
	List<Map<String, Object>> findBusinessrange(String tableName,int id);
	List<Map<String, Object>> findArea(String ids);
	boolean addBusinessrange(String fingertable,String fingerid,String areaids);
	boolean delBusinessrange(String tableName,String fingertable,String ids);
	/**
	 * 手机端护林员查看接口
	 */
	Paginator findAllByPhone(String tableName,String start,String id) ;
	int promptTask(int arId);
	/**
	 * 通过所在村子id  拿到护林员id
	 */
	List<Map<String, Object>> findIdByCzId(String id);
	/**
	 * 通过id查询业务学习上传的视频
	 */
	List<Map<String, Object>> findVideo(String id);
}
