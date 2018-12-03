package com.angel.blogs.service;

import java.util.List;

import com.angel.blogs.bean.Files;



/**
 * 
* @ClassName: FilesService
* @Description: 文件Service
* @author zkm
* @date  2018-09-05 14:18
 */
public interface FilesService {
	
	/**
	 * 根据指定表和指定ID查询文件
	 * @param fingerTable		指定表
	 * @param fingerId			指定ID
	 * @return
	 * @author changbaolong
	 * @date 2018-01-23 01:47:40
	 */
	List<Files> findAll(String fingerTable,String fingerId);
	
	/**
	 * 根据ID查询文件信息
	 * @param id				文件ID
	 * @return
	 * @author changbaolong
	 * @date 2018-01-23 01:48:09
	 */
	Files getById(int id);
	
	/**
	 * 
	* @Title: add     
	* @Description:添加文件信息
	* @param name				文件名称
	 * @param fileUrl			文件URL
	 * @param fingerTable		指定表
	 * @param fingerId			指定ID
	 * @param type				文件类型	1图片2文件
	 * @param suffix			文件后缀
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-06 08:54
	 */
	boolean add(String name, String fileUrl, 
			String fingerTable, int fingerId, int type, String suffix);
	
	/**
	 * 删除文件信息
	 * @param ids				删除ID集合
	 * @return
	 * @author changbaolong
	 * @date 2018-01-23 01:49:32
	 */
	boolean delete(String ids);
	
	//boolean addVideos(Videos video);
	/**
	 * 删除视频文件
	 */
	boolean delVideo(String fileUrl);
}
