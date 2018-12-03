package com.angel.blogs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.blogs.bean.Area;
import com.angel.blogs.bean.Assortment;
import com.angel.blogs.dao.BaseDao;
import com.angel.blogs.service.AssortmentService;



/**
 * 
* @ClassName: AssortmentServiceImpl
* @Description: 分类Service实现
* @author zkm
* @date  2018-09-04 08:58
 */
@Service
public class AssortmentServiceImpl implements AssortmentService {
	
	@Autowired
	private BaseDao baseDao;

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
	@Override
	public List<Assortment> findAll(int id) {
		List<Assortment> list = new ArrayList<Assortment>();
		try {
			String sql = "SELECT ID,NAME,STATUS,CODE,PID,IINDEX,REMARK FROM b_assortment WHERE   FIND_IN_SET(id,getAssortmentChildrenList(?)) AND  STATUS <> -1";
			sql += " order by IINDEX asc";
			List<Map<String, Object>> mapList = baseDao.findAll(sql, new Object[]{id});
			Assortment assortment = null;
			for (Map<String, Object> map : mapList) {
				assortment = new Assortment();
				assortment.setId(Integer.parseInt(map.get("ID").toString()));
				assortment.setName(map.get("NAME").toString());
				assortment.setStatus(Integer.parseInt(map.get("STATUS").toString()));
				assortment.setCode(map.get("CODE")!=null?map.get("CODE").toString():"");
				assortment.setpId(Integer.parseInt(map.get("PID").toString()));
				assortment.setiIndex(Integer.parseInt(map.get("IINDEX").toString()));
				assortment.setRemark(map.get("REMARK")!=null?map.get("REMARK").toString():"");
				list.add(assortment);
				assortment = null;
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
	* @Title: getById     
	* @Description: 根据ID查询分类信息 
	* @param id
	* @return   
	* Assortment    返回类型 
	* @author zkm 
	* @date 2018-09-04 09:10
	 */
	@Override
	public Assortment getById(int id) {
		Assortment assortment = null;
		try {
			assortment = new Assortment();
			String sql = "select ID,NAME,STATUS,CODE,PID,IINDEX,REMARK from b_assortment where ID=? ";
			Map<String, Object> map = baseDao.getById(sql, new Object[]{id});
			assortment.setId(Integer.parseInt(map.get("ID").toString()));
			assortment.setName(map.get("NAME").toString());
			assortment.setStatus(Integer.parseInt(map.get("STATUS").toString()));
			assortment.setCode(map.get("CODE")!=null?map.get("CODE").toString():"");
			assortment.setpId(Integer.parseInt(map.get("PID").toString()));
			assortment.setiIndex(Integer.parseInt(map.get("IINDEX").toString()));
			assortment.setRemark(map.get("REMARK")!=null?map.get("REMARK").toString():"");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return assortment;
	}

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
	@Override
	public boolean add(String name, int status, String code, int pId, int iIndex, String remark) {
		try {
			String sql = "insert into b_assortment(ID,NAME,STATUS,CODE,PID,IINDEX,REMARK) values(0,"
					+ "'"+name+"',"+status+",'"+code+"',"+pId+","+iIndex+",'"+remark+"')";
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
	@Override
	public boolean update(int id, String name, int status, String code, int pId, int iIndex, String remark) {
		try {
			String sql = "update b_assortment set NAME=?,STATUS=?,CODE=?,PID=?,IINDEX=?,REMARK=? where ID = ?";
			int result = baseDao.update(sql, new Object[]{
					name,status,code,pId,iIndex,remark,id
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
	* @Description: 删除分类信息 
	* @param ids
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-04 09:12
	 */
	@Override
	public boolean delete(String ids) {
		try {	
			String findSql = "select ID,NAME from b_assortment where PID in("+ids+")";
			List<Map<String, Object>> findList = baseDao.findAll(findSql, null);
			if(findList.size() > 0){
				return false;
			}else{
				String sql = "update b_assortment set STATUS = -1 where ID in ("+ids+")";
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

	@Override
	public List<Assortment> phonefindAll() {
		List<Assortment> list = new ArrayList<Assortment>();
		try {
			String sql = "select ID,NAME,STATUS,CODE,PID,IINDEX,REMARK from T_ASSORTMENT where STATUS <> -1 and id!=2";
			sql += " connect by prior id=pid  start with id = 2";
			sql += " order by IINDEX asc";
			List<Map<String, Object>> mapList = baseDao.findAll(sql,null);
			Assortment assortment = null;
			for (Map<String, Object> map : mapList) {
				assortment = new Assortment();
				assortment.setId(Integer.parseInt(map.get("ID").toString()));
				assortment.setName(map.get("NAME").toString());
				assortment.setStatus(Integer.parseInt(map.get("STATUS").toString()));
				assortment.setCode(map.get("CODE")!=null?map.get("CODE").toString():"");
				assortment.setpId(Integer.parseInt(map.get("PID").toString()));
				assortment.setiIndex(Integer.parseInt(map.get("IINDEX").toString()));
				assortment.setRemark(map.get("REMARK")!=null?map.get("REMARK").toString():"");
				list.add(assortment);
				assortment = null;
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
	* @Title: findAssortmentAllNotLayer     
	* @Description: 查询分类
	* @return   
	* List<Assortment>    返回类型 
	* @author zkm 
	* @date 2018-09-10 17:03
	 */
	@Override
	public List<Assortment> findAssortmentAllNotLayer(int id) {
		List<Assortment> list = new ArrayList<Assortment>();
		try {
			String sql = "SELECT ID,NAME,STATUS,CODE,PID,IINDEX,REMARK FROM b_assortment WHERE   FIND_IN_SET(id,getAssortmentChildrenList(?)) AND  STATUS <> -1";
			sql += " order by IINDEX asc";
		
			List<Map<String, Object>> mapList = baseDao.findAll(sql, new Object[]{id});
			Assortment assortment = null;
			for (Map<String, Object> map : mapList) {
				assortment = new Assortment();
				assortment.setId(Integer.parseInt(map.get("ID").toString()));
				assortment.setName(map.get("NAME").toString());
				assortment.setStatus(Integer.parseInt(map.get("STATUS").toString()));
				assortment.setCode(map.get("CODE")!=null?map.get("CODE").toString():"");
				assortment.setpId(Integer.parseInt(map.get("PID").toString()));
				assortment.setiIndex(Integer.parseInt(map.get("IINDEX").toString()));
				assortment.setRemark(map.get("REMARK")!=null?map.get("REMARK").toString():"");
				list.add(assortment);
				assortment = null;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
