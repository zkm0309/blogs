package com.angel.blogs.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.blogs.bean.Files;
import com.angel.blogs.dao.BaseDao;
import com.angel.blogs.service.FilesService;


/**
 * 
* @ClassName: FilesServiceImpl
* @Description: 文件Service实现
* @author zkm
* @date  2018-09-05 14:20
 */
@Service
public class FilesServiceImpl implements FilesService {
	
	@Autowired
	private BaseDao baseDao;

	@Override
	public List<Files> findAll(String fingerTable, String fingerId) {
		List<Files> list = new ArrayList<Files>();
		try {
			String sql = "select ID,NAME,STATUS,FILEURL,FINGERTABLE,FINGERID,TYPE,SUFFIX from T_FILES where STATUS = 1 ";
			if(fingerTable != null && !"".equals(fingerTable)){
				sql += " and FINGERTABLE = '"+fingerTable+"'";
			}
			if(fingerId != null && !"".equals(fingerId)){
				sql += " and FINGERID = "+fingerId;
			}
			sql += " order by ID asc";
			List<Map<String, Object>> mapList = baseDao.findAll(sql, null);
			Files files = null;
			for (Map<String, Object> map : mapList) {
				files = new Files();
				files.setId(Integer.parseInt(map.get("ID").toString()));
				files.setName(map.get("NAME").toString());
				files.setStatus(Integer.parseInt(map.get("STATUS").toString()));
				files.setFileUrl(map.get("FILEURL").toString());
				files.setFingerId(Integer.parseInt(map.get("FINGERID").toString()));
				files.setType(Integer.parseInt(map.get("TYPE").toString()));
				files.setSuffix(map.get("SUFFIX").toString());
				list.add(files);
				files = null;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Files getById(int id) {
		Files files = null;
		try {
			String sql = "select ID,NAME,STATUS,FILEURL,FINGERTABLE,FINGERID,TYPE,SUFFIX from T_FILES where ID = ? ";
			Map<String, Object> map = baseDao.getById(sql, new Object[]{id});
			files = new Files();
			files.setId(Integer.parseInt(map.get("ID").toString()));
			files.setName(map.get("NAME").toString());
			files.setStatus(Integer.parseInt(map.get("STATUS").toString()));
			files.setFileUrl(map.get("FILEURL").toString());
			files.setFingerId(Integer.parseInt(map.get("FINGERID").toString()));
			files.setType(Integer.parseInt(map.get("TYPE").toString()));
			files.setSuffix(map.get("SUFFIX").toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return files;
	}

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
	@Override
	public boolean add(String name, String fileUrl, String fingerTable, int fingerId, int type, String suffix) {
		try {
			String sql = "insert into b_files(ID,NAME,STATUS,FILEURL,FINGERTABLE,FINGERID,TYPE,SUFFIX) values(0,'"+
					name+"',1,'"+fileUrl+"','"+fingerTable+"',"+fingerId+","+type+",'"+suffix+"')";
			int id = baseDao.insert(sql);
			if(id > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(String ids) {
		try {
			String sql = "update T_FILES set STATUS = -1 where ID in("+ids+")";
			int result = baseDao.update(sql, null);
			if(result > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

//	@Override
//	public boolean addVideos(Videos video) {
//		String sql = "insert into T_VIDEOS(ID,SID,VIDEO1,VIDEO2,VIDEO3,VIDEO1NAME,VIDEO2NAME,VIDEO3NAME,STATUS) values(?,?,?,?,?,?,?,?,1)";
//		int id = baseDao.insert(sql, "SEQ_VIDEOS.Nextval",new Object[]{1,video.getSid(),video.getVideo1(),video.getVideo2(),video.getVideo3(),video.getVideo1Name(),video.getVideo2Name(),video.getVideo3Name()});
//		if(id>0){
//			return true;
//		}
//		return false;
//	}

	@Override
	public boolean delVideo(String fileUrl) {
		File file =new File(fileUrl);
		 if (file.exists() && file.isFile()) {
	            if (file.delete()) {
	                return true;
	            } else {
	                return false;
	            }
	        } else {
	            return false;
	        }
	}

}
