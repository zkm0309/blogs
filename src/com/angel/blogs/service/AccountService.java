package com.angel.blogs.service;

import java.util.List;
import java.util.Map;

import com.angel.blogs.bean.Account;
import com.angel.blogs.utils.Paginator;





/**
 * ClassName:AccountService<br/>
 * Description:账户Service<br/>
 * @author 	changboalong<br/>
 * @date 	2018-01-15 11:42:25<br/>
 */
public interface AccountService {
	

	/**
	 * 
	* @Title: findAll     
	* @Description: 分页查询账户信息
	* @param map
	* @param start
	* @return   
	* Paginator    返回类型 
	* @author zkm 
	* @date 2018-09-02 10:35
	 */
	Paginator findAll(Map<String,String> map,String start);
	
	/**
	 * 分页查询账户信息
	 * @param map			参数Map
	 * @param start			数据位置(从1开始计算)
	 * @return
	 * @author changbaolong
	 * @date 2018-01-15 11:47:14
	 */
	Paginator findAllList(Map<String,String> map,String start);
	
	
	
	
	/**
	 * 
	* @Title: getById     
	* @Description: 根据ID查询账户信息
	* @param id
	* @return   
	* Account    返回类型 
	* @author zkm 
	* @date 2018-09-02 10:58
	 */
	Account getById(int id);
	
	/**
	 * 
	* @Title: add     
	* @Description: 添加账户信息  
	* @param name
	* @param accountName
	* @param password
	* @param roId
	* @param arId
	* @param iIndex
	* @param remark
	* @param sex
	* @param phone
	* @param status
	* @param fileName
	* @param fileUrl
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-08-31 17:35
	 */
	boolean add(String name, String accountName, String password, int roId, int arId, int iIndex,
			String remark,int sex,String phone,int status,String useremail,String fileName,String fileUrl);
	
	
	/**
	 * 
	* @Title: update     
	* @Description: 账户修改
	* @param id
	* @param name
	* @param accountName
	* @param roId
	* @param arId
	* @param iIndex
	* @param remark
	* @param sex
	* @param phone
	* @param status
	* @param fileName
	* @param fileUrl
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-08-31 17:34
	 */
	boolean update(int id, String name, String accountName, int roId, int arId, int iIndex,
			String remark,int sex,String phone,int status,String useremail,String fileName,String fileUrl);
	
	/**
	 * 
	* @Title: delete     
	* @Description: 删除账户信息
	* @param ids
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-08-31 16:40
	 */
	boolean delete(String ids);
	
	
	/**
	 * 
	* @Title: login     
	* @Description: 用户登录 
	* @param accountName
	* @param password
	* @param imei
	* @return   
	* Account    返回类型 
	* @author zkm 
	* @date 2018-08-31 16:42
	 */
	Account login(String accountName,String password,String imei);
	
	/**
	 * 
	* @Title: resetPwd     
	* @Description:密码重置（备注：默认123456） 
	* @param id
	* @param password
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-08-31 16:39
	 */
	boolean resetPwd(int id,String password);
	
	
	/**
	 * 根据ID查询账户信息
	 * @param id			账户ID
	 * @return
	 * @author 
	 * @date 2018-01-15 11:47:36
	 */
	Account getSswzById(int id);
	/**
	 * 重置手机唯一标识
	 * @param imei
	 * @return
	 */
	boolean updatePhoneId(String imei,int id);
	/**
	 * 
	* @Title: rzexportAll     
	* @Description: 导出账号信息
	* @param map
	* @return   
	* List<Map<String,Object>>    返回类型 
	* @author zkm 
	* @date 2018-09-02 12:00
	 */
	public List<Map<String, Object>> rzexportAll(Map<String, String> map) ;
	

}
