package com.angel.blogs.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.blogs.bean.Role;
import com.angel.blogs.dao.BaseDao;
import com.angel.blogs.service.RoleService;
import com.angel.blogs.utils.FormatSql;
import com.angel.blogs.utils.Page;
import com.angel.blogs.utils.Paginator;


/**
 * 
* @ClassName: RoleServiceImpl
* @Description: 角色Service实现
* @author zkm
* @date  2018-08-30 10:34
 */
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private BaseDao baseDao;

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
	@Override
	public Paginator findAll(Map<String, String> map, String start) {
		Paginator paginator = new Paginator();
		try {
			String selectSql = "select ID,NAME,STATUS,CODE,IINDEX,REMARK from b_role where STATUS <> -1 ";
			if(map != null){
				if(map.containsKey("name")){
					selectSql += " and NAME like '%"+map.get("name")+"%'";
				}
			}
			selectSql += " order by ID asc";
			String columns = "ID,NAME,STATUS,CODE,IINDEX,REMARK";
			String sql = FormatSql.queryPageSql(columns, selectSql, start);
			List<Map<String, Object>> mapList = baseDao.findAll(sql, null);
			List<Role> list = new ArrayList<Role>();
			Role role = null;
			for (Map<String, Object> map2 : mapList) {
				role = new Role();
				role.setId(Integer.parseInt(map2.get("ID").toString()));
				role.setName(map2.get("NAME").toString());
				role.setStatus(Integer.parseInt(map2.get("STATUS").toString()));
				role.setCode(map2.get("CODE")!=null?map2.get("CODE").toString():"");
				role.setiIndex(Integer.parseInt(map2.get("IINDEX").toString()));
				role.setRemark(map2.get("REMARK")!=null?map2.get("REMARK").toString():"");
				list.add(role);
				role = null;
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
	* @Description: 根据ID查询角色信息 
	* @param id
	* @return   
	* Role    返回类型 
	* @author zkm 
	* @date 2018-08-30 17:04
	 */
	@Override
	public Role getById(int id) {
		Role role = null;
		try {
			role = new Role();
			String sql = "SELECT r.ID,r.NAME,r.STATUS,r.CODE,r.IINDEX,r.REMARK,GROUP_CONCAT(rmm.menuid) AS menuIds,GROUP_CONCAT(rmm.name) AS menuName FROM b_role r  LEFT JOIN (SELECT rm.roid, rm.menuid,m.name FROM b_rolemenu rm INNER JOIN b_menu m ON rm.menuid = m.id) rmm "
					+ " ON r.id = rmm.roid  WHERE r.ID =? GROUP BY  r.ID,r.NAME,r.STATUS,r.CODE,r.IINDEX,r.REMARK ";
			Map<String, Object> map = baseDao.getById(sql, new Object[]{id});
			role.setId(Integer.parseInt(map.get("ID").toString()));
			role.setName(map.get("NAME").toString());
			role.setStatus(Integer.parseInt(map.get("STATUS").toString()));
			role.setCode(map.get("CODE")!=null?map.get("CODE").toString():"");
			role.setiIndex(Integer.parseInt(map.get("IINDEX").toString()));
			role.setRemark(map.get("REMARK")!=null?map.get("REMARK").toString():"");
			role.setMenuIds(map.get("menuIds")!=null?map.get("menuIds").toString():"");
			role.setMenuName(map.get("menuName")!=null?map.get("menuName").toString():"");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}

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
	@Override
	public boolean add(String name, int status, String code, int iIndex, String remark,String menuIds) {
		try {
			String sql = "insert into b_role(ID,NAME,STATUS,CODE,IINDEX,REMARK) values(0,'"+
					name+"',"+status+",'"+code+"',"+iIndex+",'"+remark+"')";
			int id = baseDao.insert(sql);
			//查询表自增id
			String sqlid="select max(id) id from b_role";
			int roleid=baseDao.getmysqlid(sqlid);			
			if(id > 0){
				List<String> sqlList = new ArrayList<String>();
				for (String menuId : menuIds.split(",")) {
					String addSql = "insert into b_rolemenu(ID,ROID,MENUID) values(0,"+roleid+","+menuId+")";
					sqlList.add(addSql);
				}
				boolean result = baseDao.batchUpdate(sqlList.toArray(new String[0]));
				if(result){
					return true;					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

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
	@Override
	public boolean update(int id, String name, int status, String code, int iIndex, String remark,String menuIds) {
		
		String sql = "update b_role set NAME=?,STATUS=?,CODE=?,IINDEX=?,REMARK=? where ID=?";
		Object[] params = new Object[]{
				name,status,code,iIndex,remark,id
		};
		int result = baseDao.update(sql, params);
		if(result > 0){
			baseDao.delete("delete from b_rolemenu where ROID = ?", new Object[]{id});
			List<String> sqlList = new ArrayList<String>();
			for (String menuId : menuIds.split(",")) {
				String addSql = "insert into b_rolemenu(ID,ROID,MENUID) values(0,"+id+","+menuId+")";
				sqlList.add(addSql);
			}
			boolean bool = baseDao.batchUpdate(sqlList.toArray(new String[0]));
			if(bool){
				return true;					
			}
		}
		return false;
	}

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
	@Override
	public boolean delete(String ids) {
		try {
			baseDao.delete("delete from b_rolemenu where ROID in ("+ids+")", null);
			String sql = "update b_role set STATUS = -1 where ID in ("+ids+")";
			int result = baseDao.delete(sql, null);
			if(result > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Role> findAll() {
		List<Role> list = new ArrayList<Role>();
		try {
			String selectSql = "select ID,NAME,STATUS,CODE,IINDEX,REMARK from b_role where STATUS <> -1 ";
			selectSql += " order by IINDEX ";
			List<Map<String, Object>> mapList = baseDao.findAll(selectSql, null);
			Role role = null;
			for (Map<String, Object> map2 : mapList) {
				role = new Role();
				role.setId(Integer.parseInt(map2.get("ID").toString()));
				role.setName(map2.get("NAME").toString());
				role.setStatus(Integer.parseInt(map2.get("STATUS").toString()));
				role.setCode(map2.get("CODE")!=null?map2.get("CODE").toString():"");
				role.setiIndex(Integer.parseInt(map2.get("IINDEX").toString()));
				role.setRemark(map2.get("REMARK")!=null?map2.get("REMARK").toString():"");
				list.add(role);
				role = null;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
