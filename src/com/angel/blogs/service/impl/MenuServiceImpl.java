package com.angel.blogs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.blogs.bean.Menu;
import com.angel.blogs.dao.BaseDao;
import com.angel.blogs.service.MenuService;



/**
 * 
* @ClassName: MenuServiceImpl
* @Description: 菜单Service实现
* @author zkm
* @date  2018-08-29 14:41
 */
@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private BaseDao baseDao;

	@Override
	public List<Menu> findAll(int roId) {
		List<Menu> list = new ArrayList<Menu>();
		try {
			String sql = "SELECT m.ID,m.NAME,m.STATUS,m.MENUURL,m.PID,m.OPENTYPE,m.IINDEX,m.REMARK FROM b_menu m INNER JOIN  b_rolemenu rm ON m.id = rm.menuid  WHERE m.STATUS =1 AND m.PID <> 0  AND rm.ROID = ? ORDER BY m.PID,m.IINDEX ASC  ";
			List<Map<String, Object>> mapList = baseDao.findAll(sql, new Object[]{roId});
			Menu menu = null;
			for (Map<String, Object> map : mapList) {
				menu = new Menu();
				menu.setId(Integer.parseInt(map.get("ID").toString()));
				menu.setName(map.get("NAME").toString());
				menu.setStatus(Integer.parseInt(map.get("STATUS").toString()));
				menu.setMenuUrl(map.get("MENUURL")!=null?map.get("MENUURL").toString():"");
				menu.setpId(Integer.parseInt(map.get("PID").toString()));
				menu.setOpenType(Integer.parseInt(map.get("OPENTYPE").toString()));
				menu.setiIndex(Integer.parseInt(map.get("IINDEX").toString()));
				menu.setRemark(map.get("REMARK")!=null?map.get("REMARK").toString():"");
				list.add(menu);
				menu = null;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	* @Title: findAll     
	* @Description: 查询全部
	* @return   
	* List<Menu>    返回类型 
	* @author zkm 
	* @date 2018-08-30 16:13
	 */
	@Override
	public List<Menu> findAll() {
		List<Menu> list = new ArrayList<Menu>();
		try {
			String sql = "SELECT m.ID,m.NAME,m.STATUS,m.MENUURL,m.PID,m.OPENTYPE,m.IINDEX,m.REMARK FROM b_menu m WHERE m.STATUS <> -1 ORDER BY m.IINDEX asc ";
			List<Map<String, Object>> mapList = baseDao.findAll(sql, null);
			Menu menu = null;
			for (Map<String, Object> map : mapList) {
				menu = new Menu();
				menu.setId(Integer.parseInt(map.get("ID").toString()));
				menu.setName(map.get("NAME").toString());
				menu.setStatus(Integer.parseInt(map.get("STATUS").toString()));
				menu.setMenuUrl(map.get("MENUURL")!=null?map.get("MENUURL").toString():"");
				menu.setpId(Integer.parseInt(map.get("PID").toString()));
				menu.setOpenType(Integer.parseInt(map.get("OPENTYPE").toString()));
				menu.setiIndex(Integer.parseInt(map.get("IINDEX").toString()));
				menu.setRemark(map.get("REMARK")!=null?map.get("REMARK").toString():"");
				list.add(menu);
				menu = null;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Menu getById(int id) {
		Menu menu = null;
		try {
			menu = new Menu();
			String sql = "SELECT ID,NAME,STATUS,MENUURL,PID,OPENTYPE,IINDEX,REMARK FROM b_menu WHERE ID = ?";
			Map<String, Object> map = baseDao.getById(sql, new Object[]{id});
			menu.setId(Integer.parseInt(map.get("ID").toString()));
			menu.setName(map.get("NAME").toString());
			menu.setStatus(Integer.parseInt(map.get("STATUS").toString()));
			menu.setMenuUrl(map.get("MENUURL")!=null?map.get("MENUURL").toString():"");
			menu.setpId(Integer.parseInt(map.get("PID").toString()));
			menu.setOpenType(Integer.parseInt(map.get("OPENTYPE").toString()));
			menu.setiIndex(Integer.parseInt(map.get("IINDEX").toString()));
			menu.setRemark(map.get("REMARK")!=null?map.get("REMARK").toString():"");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menu;
	}

	
	/**
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
	@Override
	public boolean add(String name, int status, String menuUrl, int pId, int openType, int iIndex, String remark) {
		try {
			String sql = "insert into b_menu(ID,NAME,STATUS,MENUURL,PID,OPENTYPE,IINDEX,REMARK) values(0,"
					+ "'"+name+"',"+status+",'"+menuUrl+"',"+pId+","+openType+","+iIndex+",'"+remark+"')";
			int id = baseDao.insert(sql);
			if(id > 0){
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
	@Override
	public boolean update(int id, String name, int status, String menuUrl, int pId, int openType, int iIndex,
			String remark) {
		try {
			String sql = "update b_menu set NAME=?,STATUS=?,MENUURL=?,PID=?,OPENTYPE=?,IINDEX=?,REMARK=? where ID=?";
			int result = baseDao.update(sql, new Object[]{
					name,status,menuUrl,pId,openType,iIndex,remark,id
			});
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
	* @Title: delete     
	* @Description: 删除菜单信息 
	* @param ids
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-02 13:33
	 */
	@Override
	public boolean delete(String ids) {
		try {	
			String findSql = "select ID,NAME from b_menu where PID in("+ids+")";
			List<Map<String, Object>> findList = baseDao.findAll(findSql, null);
			if(findList.size() > 0){
				return false;
			}else{
				String sql = "update b_menu set STATUS = -1 where ID in ("+ids+")";
				int result = baseDao.update(sql,null);
				if(result > 0){
					return true;
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
