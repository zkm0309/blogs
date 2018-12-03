package com.angel.blogs.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.blogs.bean.Area;
import com.angel.blogs.dao.BaseDao;
import com.angel.blogs.service.AreaService;


/**
 * 
* @ClassName: AreaServiceImpl
* @Description: 区域Service实现
* @author zkm
* @date  2018-08-28 15:54
 */
@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private BaseDao baseDao;
	
	/**
	 * 
	* @Title: findAll     
	* @Description:区域列表
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-08-29 17:31
	 */
	@Override
	public List<Area> findAll(int id) {
		List<Area> list = new ArrayList<Area>();
		try {
			String sql = "SELECT a.id,a.name,a.status,a.code,a.pid,a.layer,a.remark,a.iindex FROM b_area a WHERE  FIND_IN_SET(a.id,getChildrenList(?)) AND a.status=1 ";
			sql += " order by IINDEX asc";
			List<Map<String, Object>> mapList = baseDao.findAll(sql, new Object[]{id});
			Area area = null;
			for (Map<String, Object> map : mapList) {
				area = new Area();
				area.setId(Integer.parseInt(map.get("ID").toString()));
				area.setName(map.get("NAME").toString());
				area.setStatus(Integer.parseInt(map.get("STATUS").toString()));
				area.setCode(map.get("CODE")!=null?map.get("CODE").toString():"");
				area.setpId(Integer.parseInt(map.get("PID").toString()));
				area.setLayer(Integer.parseInt(map.get("LAYER").toString()));
				area.setiIndex(Integer.parseInt(map.get("IINDEX").toString()));
				area.setRemark(map.get("REMARK")!=null?map.get("REMARK").toString():"");
				list.add(area);
				area = null;
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
	* @Title: findAllNotLayer     
	* @Description: 根据ID查询列表 layer<>5
	* @param id
	* @return   
	* List<Area>    返回类型 
	* @author zkm 
	* @date 2018-09-02 09:34
	 */
	@Override
	public List<Area> findAllNotLayer(int id) {
		List<Area> list = new ArrayList<Area>();
		try {
			String sql = "SELECT a.id,a.name,a.status,a.code,a.pid,a.layer,a.remark,a.iindex FROM b_area a WHERE FIND_IN_SET(a.id,getChildrenList(?))  and  a.id <> -1 and a.layer <> 5 AND a.status <> -1 ORDER BY IINDEX asc";
		
			List<Map<String, Object>> mapList = baseDao.findAll(sql, new Object[]{id});
			Area area = null;
			for (Map<String, Object> map : mapList) {
				area = new Area();
				area.setId(Integer.parseInt(map.get("ID").toString()));
				area.setName(map.get("NAME").toString());
				area.setStatus(Integer.parseInt(map.get("STATUS").toString()));
				area.setCode(map.get("CODE")!=null?map.get("CODE").toString():"");
				area.setpId(Integer.parseInt(map.get("PID").toString()));
				area.setLayer(Integer.parseInt(map.get("LAYER").toString()));
				area.setiIndex(Integer.parseInt(map.get("IINDEX").toString()));
				area.setRemark(map.get("REMARK")!=null?map.get("REMARK").toString():"");
				list.add(area);
				area = null;
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
	* @Description: 根据id查询区域信息
	* @param id
	* @return   
	* Area    返回类型 
	* @author zkm 
	* @date 2018-08-30 09:05
	 */
	@Override
	public Area getById(int id) {
		Area area = null;
		try {
			area = new Area();
			String sql = "SELECT ID,NAME,STATUS,CODE,PID,LAYER,IINDEX,REMARK FROM b_area WHERE STATUS <> -1 AND ID = ?";
			Map<String, Object> map = baseDao.getById(sql, new Object[]{id});
			area.setId(Integer.parseInt(map.get("ID").toString()));
			area.setName(map.get("NAME").toString());
			area.setStatus(Integer.parseInt(map.get("STATUS").toString()));
			area.setCode(map.get("CODE")!=null?map.get("CODE").toString():"");
			area.setpId(Integer.parseInt(map.get("PID").toString()));
			area.setLayer(Integer.parseInt(map.get("LAYER").toString()));
			area.setiIndex(Integer.parseInt(map.get("IINDEX").toString()));
			area.setRemark(map.get("REMARK")!=null?map.get("REMARK").toString():"");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return area;
	}

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
	@Override
	public boolean add(String name, int status, String code, int pId, int layer, int iIndex, String remark) {
		
		try {
			String sql = "insert into b_area(ID,NAME,STATUS,CODE,PID,LAYER,IINDEX,REMARK) values(0,'"+
						name+"',"+status+",'"+code+"',"+pId+","+layer+","+iIndex+",'"+remark+"')";
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
	@Override
	public boolean update(int id, String name, int status, String code, int pId, int layer, int iIndex, String remark) {
		try {
			String sql = "update b_area set NAME=?,STATUS=?,CODE=?,PID=?,LAYER=?,IINDEX=?,REMARK=? where ID = ?";
			int result = baseDao.update(sql, new Object[]{
					name,status,code,pId,layer,iIndex,remark,id
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
	* @Description: 删除区域信息  
	* @param ids
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-02 13:21
	 */
	@Override
	public boolean delete(String ids) {
		try {
			
			String findSql = "select ID,NAME from b_area where PID in("+ids+")";
			List<Map<String, Object>> findList = baseDao.findAll(findSql, null);
			if(findList.size() > 0){
				return false;
			}else{
				String sql = "update b_area set STATUS = -1 where ID in ("+ids+")";
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
	public List<Area> findZAll(int id) {
		List<Area> list = new ArrayList<Area>();
		try {
			String sql = "select * from t_area where layer < 3  connect by prior id=pid start with id="+id+"";
			List<Map<String, Object>> mapList = baseDao.findAll(sql,null);
			Area area = null;
			for (Map<String, Object> map : mapList) {
				area = new Area();
				area.setId(Integer.parseInt(map.get("ID").toString()));
				area.setName(map.get("NAME").toString());
				area.setStatus(Integer.parseInt(map.get("STATUS").toString()));
				area.setCode(map.get("CODE")!=null?map.get("CODE").toString():"");
				area.setpId(Integer.parseInt(map.get("PID").toString()));
				area.setLayer(Integer.parseInt(map.get("LAYER").toString()));
				area.setiIndex(Integer.parseInt(map.get("IINDEX").toString()));
				area.setRemark(map.get("REMARK")!=null?map.get("REMARK").toString():"");
				list.add(area);
				area = null;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Area> findCAll(int id) {
		List<Area> list = new ArrayList<Area>();
		try {
			String sql = "select * from t_area where layer < 4  connect by prior id=pid start with id="+id+"";
			/*String sql ="select t.*,level from t_area t where STATUS <> -1 connect by prior t.id=t.pid start with t.pid='1'";*/
			List<Map<String, Object>> mapList = baseDao.findAll(sql,null);
			Area area = null;
			for (Map<String, Object> map : mapList) {
				area = new Area();
				area.setId(Integer.parseInt(map.get("ID").toString()));
				area.setName(map.get("NAME").toString());
				area.setStatus(Integer.parseInt(map.get("STATUS").toString()));
				area.setCode(map.get("CODE")!=null?map.get("CODE").toString():"");
				area.setpId(Integer.parseInt(map.get("PID").toString()));
				area.setLayer(Integer.parseInt(map.get("LAYER").toString()));
				area.setiIndex(Integer.parseInt(map.get("IINDEX").toString()));
				area.setRemark(map.get("REMARK")!=null?map.get("REMARK").toString():"");
				list.add(area);
				area = null;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public Map<String, Object> findZidByhlyid(String id,String roid) {
		String sql="";
		if(roid.equals("7")){
			sql=" SELECT  id FROM t_area where layer =2 START WITH id = "+id+" CONNECT BY PRIOR pid = id ";
		}else{
			sql=" select a.arid from  t_account a where a.id="+id+" ";
		}
		return baseDao.getById(sql, null);
	}


	@Override
	public List<Area> getCfindAll(int id) {
		List<Area> list = new ArrayList<Area>();
		try {
			String sql = "SELECT t.id,t.name,t.iindex,t.layer,t.code,t.remark,t.pid,t.status FROM b_area t WHERE t.status=1 AND FIND_IN_SET(id,getChildrenList(?))  ORDER BY IINDEX ASC;";
			List<Map<String, Object>> mapList = baseDao.findAll(sql, new Object[]{id});
			Area area = null;
			for (Map<String, Object> map : mapList) {
				area = new Area();
				area.setId(Integer.parseInt(map.get("ID").toString()));
				area.setName(map.get("NAME").toString());
				area.setStatus(Integer.parseInt(map.get("STATUS").toString()));
				area.setCode(map.get("CODE")!=null?map.get("CODE").toString():"");
				area.setpId(Integer.parseInt(map.get("PID").toString()));
				area.setLayer(Integer.parseInt(map.get("LAYER").toString()));
				area.setiIndex(Integer.parseInt(map.get("IINDEX").toString()));
				area.setRemark(map.get("REMARK")!=null?map.get("REMARK").toString():"");
				area.setStatus(Integer.parseInt(map.get("status").toString()));
				list.add(area);
				area = null;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<Map<String, Object>> findPeerArray(int id,int type) {
		String sql="";
		if(type==1){
			sql=" select id ,name,0 pid , 1 type  from t_account t where t.roid=2 and id!="+id+"";
		}else if(type==2){
			sql="select id ,name,pid ,2 type   from t_area t where layer<=2  and id!=(select arid from t_account where id="+id+") and status!=-1   start with  t.id=(select arid from t_account where id="+id+") connect by prior t.id =  t.pid ";
		}else if(type==3){
			sql="select id ,name,pid ,2 type   from t_area t where layer<=3  and id!=(select arid from t_account where id="+id+") and status!=-1   start with  t.id=(select arid from t_account where id="+id+") connect by prior t.id =  t.pid ";
		}
		return baseDao.findAll(sql,null);
	}


	@Override
	public List<Map<String, Object>> findZCAll(int id) {
		List<Map<String, Object>> list1=null;
		try {
			String sql = "select * from t_area where layer < 3 and id!=(select arid from t_account where id="+id+") connect by prior id=pid start with id=(select arid from t_account where id="+id+")";
			List<Map<String, Object>> list = baseDao.findAll(sql,null);
			list1=new ArrayList<Map<String, Object>>();
			if(list!=null&&!list.isEmpty()){
				for (int i = 0; i < list.size(); i++) {
					Map<String,Object> map=null;
					if(list.get(i)!=null&&!list.get(i).isEmpty()){
						map=new HashMap<String,Object>();
						String sql1="select * from t_area where layer <=3 and id!="+list.get(i).get("ID")+" connect by prior id=pid start with id="+list.get(i).get("ID")+"";
						List<Map<String, Object>> list2 = baseDao.findAll(sql1,null);
						List<Map<String,Object>> list3=new ArrayList<Map<String,Object>>();
						if(list2!=null&&!list2.isEmpty()){
							for (int j = 0; j < list2.size(); j++) {
								Map<String,Object> map1=new HashMap<String,Object>();
								if(list2.get(j)!=null&&!list2.get(j).isEmpty()){
									map1.put("id",list2.get(j).get("ID"));
									map1.put("name",list2.get(j).get("NAME"));
									map1.put("pid",list2.get(j).get("PID"));
									map1.put("type",0);
									list3.add(map1);
								}
							}
						}
						map.put("townId",list.get(i).get("ID"));
						map.put("townName",list.get(i).get("NAME"));
						map.put("townPid",list.get(i).get("PID"));
						map.put("villageArray", list3);
					}
					list1.add(map);
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	
	}


}
