package com.angel.blogs.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.blogs.bean.Account;
import com.angel.blogs.dao.BaseDao;
import com.angel.blogs.service.AccountService;
import com.angel.blogs.utils.DateUtil;
import com.angel.blogs.utils.FormatSql;
import com.angel.blogs.utils.Paginator;





/**
 * ClassName:AccountServiceImpl<br/>
 * Description:账户信息Service实现<br/>
 * @author 	changboalong<br/>
 * @date 	2018-01-15 11:49:41<br/>
 */
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private BaseDao baseDao;

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
	@Override
	public Paginator findAll(Map<String, String> map, String start) {
		Paginator paginator = new Paginator();
		try {
			String selectSql = "select c.id,c.username, c.accountname,c.password, c.roid, c.arid, c.iindex, c.remark,c.createdate, b.name  as aname, (CASE WHEN c.sex = 1 THEN '男'ELSE '女'END) AS sex,c.telphone, r.name as rname, (CASE WHEN c.status = 0 THEN '未激活'ELSE '激活'END) AS status,c.useremail  from b_account c ";
			selectSql += " INNER JOIN (SELECT id,NAME FROM b_area  WHERE STATUS=1 AND FIND_IN_SET(id,getChildrenList("+map.get("arId")+"))) b ON c.arid = b.id INNER JOIN b_role r ON c.roid = r.id WHERE 1 = 1 AND c.status <> -1";
			if(map != null){
				if(map.containsKey("name")){
					selectSql += " and c.username like '%"+map.get("name")+"%'";
				}
				if(map.containsKey("accountName")){
					selectSql += " and c.accountName like '%"+map.get("accountName")+"%'";
				}
			}
			selectSql += " order by c.id desc ";
			String columns = "id,username,accountname,password,roid,arid,iindex,remark,createdate,aname,sex,telphone,rname,status";
			String sql = FormatSql.queryPageSql(columns, selectSql, start);
			List<Map<String, Object>> mapList = baseDao.findAll(sql, null);
			List<Account> list = new ArrayList<Account>();
			Account account = null;
			for (Map<String, Object> map2 : mapList) {
				account = new Account();
				account.setId(Integer.parseInt(map2.get("id").toString()));
				account.setUsername(map2.get("username").toString());
				account.setAccountName(map2.get("accountname").toString());
				account.setRoId(Integer.parseInt(map2.get("roid").toString()));
				account.setArId(Integer.parseInt(map2.get("arid").toString()));
				account.setiIndex(Integer.parseInt(map2.get("iindex").toString()));
				account.setRemark(map2.get("remark")!=null?map2.get("remark").toString():"");
				account.setCreateDate(DateUtil.formatTimestampToString(DateUtil.formatDateStringToTimestamp(map2.get("createdate").toString())));
				account.setSexname(map2.get("sex").toString());
				account.setTelphone(map2.get("telphone")!=null?map2.get("telphone").toString():"");
				account.setStatusname(map2.get("status").toString());
				account.setAname(map2.get("aname").toString());
				account.setRname(map2.get("rname").toString());
				list.add(account);
				account = null;
			}
			int count = baseDao.count(selectSql, null);
			paginator.setResult(list);
			paginator.setCurrentPage(Integer.parseInt(start)/10);
			paginator.setTotalCount(count);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paginator;
	}

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
	@Override
	public Account getById(int id) {
		Account account = new Account();
		try {
			String sql = "SELECT a.id,a.username,a.accountname,a.password,a.roid,a.arid,a.iindex,a.remark,a.createdate,b.name AS aname,a.sex,a.telphone,a.useremail,r.name AS rname ,f.name AS filename,f.fileurl "
					+ " FROM b_account a INNER JOIN b_area b ON a.arid = b.id INNER JOIN b_role r ON a.roid = r.id  LEFT JOIN b_files f ON a.id = f.fingerid AND f.STATUS = 1 WHERE a.id =? ";
					
			Object[] params = new Object[]{id};
			Map<String, Object> map = baseDao.getById(sql, params);
			if(map!=null&&!map.isEmpty()){
				account.setId(Integer.parseInt(map.get("id").toString()));
				account.setUsername(map.get("username").toString());
				account.setAname(map.get("aname").toString());
				account.setAccountName(map.get("accountname").toString());
				account.setRoId(Integer.parseInt(map.get("roid").toString()));
				account.setArId(Integer.parseInt(map.get("arid").toString()));
				account.setiIndex(Integer.parseInt(map.get("iindex").toString()));
				account.setRemark(map.get("remark")!=null?map.get("remark").toString():"");
				account.setCreateDate(DateUtil.formatTimestampToString(DateUtil.formatDateStringToTimestamp(map.get("createdate").toString())));
				account.setSex(Integer.parseInt(map.get("sex").toString()));
				account.setTelphone(map.get("telphone")!=null?map.get("telphone").toString():"");
				account.setUseremail(map.get("useremail")!=null?map.get("useremail").toString():"");
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

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
	@Override
	public boolean add(String name, String accountName, String password, int roId, int arId, int iIndex,
			String remark,int sex,String phone,int status,String useremail,String fileName,String fileUrl) {
		try {
			String sql = "insert into b_account(id,username,accountname,password,roid,arid,iindex,remark,createdate,sex,telphone,status,useremail) "
					+ " values(0,'"+name+"','"+accountName+"','"
					+password.toUpperCase()+"',"+roId+","+arId+","+iIndex+",'"+remark+"',now(),"+sex+",'"+phone+"','"+status+"','"+useremail+"')";
			int accountId = baseDao.insert(sql);
			int filesId = baseDao.addFiles(fileName, fileUrl, "b_account", String.valueOf(accountId));
			if(accountId > 0 && filesId > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

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
	@Override
	public boolean update(int id, String name, String accountName, int roId, int arId, int iIndex,
			String remark,int sex,String phone,int status,String useremail,String fileName,String fileUrl) {
		try {
			//Account account = this.getById(id);
			String sql = "update b_account set username = ?,accountname=?,roid=?,arid=?,iindex=?,remark=?,sex=?,telphone=?,status=?,useremail=? where id=?";
			Object[] params = new Object[]{
					name,accountName,roId,
					arId,iIndex,remark,sex,
					phone,status,useremail,id
			};
			int result = baseDao.update(sql, params);
			int filesId = baseDao.addFiles(fileName, fileUrl, "b_account", String.valueOf(id));
			if(result > 0 || filesId > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

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
	@Override
	public boolean delete(String ids) {
		try {
			String sql = "update b_account  a set  a.status=-1  where id in ("+ids+")";
			int result = baseDao.delete(sql, null);
			if(result > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

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
	@Override
	public Account login(String accountName, String password,String imei) {
		Account account = null;
		try {
			String sql = "SELECT a.id,a.username,a.accountname,a.password,a.roid,a.arid,a.iindex,a.remark,a.createdate,a.imei,a.sex,a.telphone,a.status,a.useremail  FROM b_account a  WHERE  a.status=1 AND  a.accountname = ? AND a.password = ?";
			Object[] params = new Object[]{accountName,password.toUpperCase()};
			Map<String, Object> map = baseDao.getById(sql, params);
			if(map != null){
				account = new Account();
				if(!imei.equals("pc")){
					if(map.get("imei")==null){
						this.updatePhoneId(imei, Integer.parseInt(map.get("id").toString()));
					}else{
						if(!map.get("imei").equals(imei)){
							account.setImei("error");
							return account;
						}
					}
				}
				account.setImei(imei);
				account.setId(Integer.parseInt(map.get("id").toString()));
				account.setUsername(map.get("username").toString());
				account.setUseremail(map.get("useremail")!=null?map.get("useremail").toString():"");
				account.setAccountName(map.get("accountname").toString());
				account.setRoId(Integer.parseInt(map.get("roid").toString()));
				account.setArId(Integer.parseInt(map.get("arid").toString()));
				account.setiIndex(Integer.parseInt(map.get("iindex").toString()));
				account.setRemark(map.get("remark")!=null?map.get("remark").toString():"");
				account.setCreateDate(DateUtil.formatTimestampToString(DateUtil.formatDateStringToTimestamp(map.get("createdate").toString())));
				account.setSex(Integer.parseInt(map.get("sex").toString()));
				account.setTelphone(map.get("telphone")!=null?map.get("telphone").toString():"");
				account.setStatus(Integer.parseInt(map.get("status").toString()));
			
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public Paginator findAllList(Map<String, String> map, String start) {
		Paginator paginator = new Paginator();
		try {
			String selectSql = "select a.id,a.name from T_ACCOUNT a ";
			selectSql += " inner join (select id,name from T_AREA where status = 1 connect by prior id=pid  start with id = "+map.get("arId")+") b on a.arid = b.id inner join T_ROLE r on a.roid = r.id where 1 = 1 ";
			if(map != null){
				if(map.containsKey("name")){
					selectSql += " and a.name like '%"+map.get("name")+"%'";
				}
				if(map.containsKey("accountName")){
					selectSql += " and a.accountName like '%"+map.get("accountName")+"%'";
				}
			}
			selectSql += " order by a.id desc ";
			String columns = "id,name ";
			String sql = FormatSql.queryPageSqlList(columns, selectSql, start);
			List<Map<String, Object>> mapList = baseDao.findAll(sql, null);
			List<Account> list = new ArrayList<Account>();
			Account account = null;
			for (Map<String, Object> map2 : mapList) {
				account = new Account();
				account.setId(Integer.parseInt(map2.get("id").toString()));
				account.setUsername(map2.get("username").toString());
				list.add(account);
				account = null;
			}
			int count = baseDao.count(selectSql, null);
			paginator.setResult(list);
			paginator.setCurrentPage(Integer.parseInt(start));
			paginator.setTotalCount(count);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paginator;
	}

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
	@Override
	public boolean resetPwd(int id, String password) {
		try {
			String sql = "update b_account set password=? where id=?";
			int result = baseDao.update(sql, new Object[]{password,id});
			if(result > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Account getSswzById(int id) {
		Account account = new Account();
		try {
			String sql = "select a.id,a.name,a.accountname,a.password,a.roid,a.arid,a.iindex,a.remark,a.createdate,"
					+ "b.name as aname,a.birthday,a.sex,a.phone,a.wx,a.qq,r.name as rname ,f.name as filename,f.fileurl "
					+ "from T_ACCOUNT a inner join T_AREA b on a.arid = b.id inner join T_ROLE r on a.roid = r.id "
					+ "left join T_FILES f on a.id = f.fingerid and f.STATUS = 1 where a.id = ?";
			Object[] params = new Object[]{id};
			Map<String, Object> map = baseDao.getById(sql, params);
			account.setId(Integer.parseInt(map.get("id").toString()));
			account.setUsername(map.get("username").toString());
			account.setAccountName(map.get("accountname").toString());
			account.setRoId(Integer.parseInt(map.get("roid").toString()));
			account.setArId(Integer.parseInt(map.get("arid").toString()));
			account.setiIndex(Integer.parseInt(map.get("iindex").toString()));
			account.setRemark(map.get("remark")!=null?map.get("remark").toString():"");
			account.setCreateDate(DateUtil.formatTimestampToString(DateUtil.formatDateStringToTimestamp(map.get("createdate").toString())));
			account.setSex(Integer.parseInt(map.get("sex").toString()));
			account.setTelphone(map.get("telphone")!=null?map.get("telphone").toString():"");
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public boolean updatePhoneId(String imei,int id) {
		try {
			String sql="update T_ACCOUNT set IMEI=? where id=?";
			Object[] params = new Object[]{imei,id};
			baseDao.update(sql, params);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

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
	@Override
	public List<Map<String, Object>> rzexportAll(Map<String, String> map) {
		String selectSql = "SELECT a.id,a.username,a.accountname,a.password,a.roid,a.arid,a.iindex,a.remark,a.createdate,b.name AS aName, (CASE WHEN a.sex = 1 THEN '男'ELSE '女'END) AS sex,a.telphone,a.status,r.name AS rname FROM b_account a  INNER JOIN (SELECT id,NAME FROM b_area WHERE STATUS = 1  and pid in (SELECT pid FROM  b_area WHERE id="+map.get("arid")+")) b ON a.arid = b.id INNER JOIN b_role r ON a.roid = r.id WHERE 1 = 1 ";

		if(map != null){
			if(map.containsKey("name")){
				selectSql += " and a.username like '%"+map.get("username")+"%'";
			}
			if(map.containsKey("accountName")){
				selectSql += " and a.accountName like '%"+map.get("accountName")+"%'";
			}
		}
		selectSql += " order by a.createdate desc ";
				String sql1 = " SELECT username,accountname,telphone,sex ,aname,rname,createdate  FROM ("+selectSql+") AS t ";
				List<Map<String, Object>> mapList = baseDao.findAll(sql1, null);
				return mapList;
			}

}
