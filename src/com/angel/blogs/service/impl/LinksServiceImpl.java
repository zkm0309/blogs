package com.angel.blogs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.blogs.bean.Links;
import com.angel.blogs.dao.BaseDao;
import com.angel.blogs.service.LinksService;
import com.angel.blogs.utils.FormatSql;
import com.angel.blogs.utils.Paginator;


/**
 * 
* @ClassName: LinksServiceImpl
* @Description: 友情链接Service实现
* @author zkm
* @date  2018-09-04 14:07
 */
@Service
public class LinksServiceImpl implements LinksService {
	
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
	* @date 2018-09-04 14:22
	 */
	@Override
	public Paginator findAll(Map<String, String> map, String start) {
		Paginator paginator = new Paginator();
		try {
			String selectSql = "SELECT l.id,l.title,l.status,l.code,l.iindex,l.linksurl, date_format(l.createdate, '%Y-%m-%d %H:%i:%s')  as createdate,l.remark FROM b_links l WHERE l.status <> -1 ";
			if(map != null){
				if(map.containsKey("name")){
					selectSql += " and l.title like '%"+map.get("name")+"%'";
				}
			}
			selectSql += " order by id asc";
			String columns = "ID,TITLE,STATUS,CODE,IINDEX,LINKSURL,CREATEDATE,REMARK";
			String sql = FormatSql.queryPageSql(columns, selectSql, start);
			List<Map<String, Object>> mapList = baseDao.findAll(sql, null);
			List<Links> list = new ArrayList<Links>();
			Links links = null;
			for (Map<String, Object> map2 : mapList) {
				links = new Links();
				links.setId(Integer.parseInt(map2.get("ID").toString()));
				links.setTitle(map2.get("TITLE").toString());
				links.setStatus(Integer.parseInt(map2.get("STATUS").toString()));
				links.setCode(map2.get("CODE")!=null?map2.get("CODE").toString():"");
				links.setIindex(Integer.parseInt(map2.get("IINDEX").toString()));
				links.setLinksurl(map2.get("LINKSURL").toString());
				links.setCreatedate(map2.get("CREATEDATE").toString());
				links.setRemark(map2.get("REMARK")!=null?map2.get("REMARK").toString():"");
				list.add(links);
				links = null;
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
	* @Description: 根据ID查询友情链接信息
	* @param id
	* @return   
	* Links    返回类型 
	* @author zkm 
	* @date 2018-09-04 15:49
	 */
	@Override
	public Links getById(int id) {
		Links links = null;
		try {
			links = new Links();
			String sql = "SELECT 	id, title, STATUS, CODE, iindex, linksurl, createdate, remark FROM b_links  WHERE STATUS<>-1 AND id=?";
			Map<String, Object> map = baseDao.getById(sql, new Object[]{id});
			links.setId(Integer.parseInt(map.get("ID").toString()));
			links.setTitle(map.get("TITLE").toString());
			links.setStatus(Integer.parseInt(map.get("STATUS").toString()));
			links.setCode(map.get("CODE")!=null?map.get("CODE").toString():"");
			links.setIindex(Integer.parseInt(map.get("IINDEX").toString()));
			links.setLinksurl(map.get("LINKSURL").toString());
			links.setCreatedate(map.get("CREATEDATE").toString());
			links.setRemark(map.get("REMARK")!=null?map.get("REMARK").toString():"");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return links;
	}

	/**
	 * 
	* @Title: add     
	* @Description: 添加友情链接 
	* @param title
	* @param status
	* @param code
	* @param iIndex
	* @param remark
	* @param linksurl
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-04 15:07
	 */
	@Override
	public boolean add(String title, int status, String code, int iIndex, String remark,String linksurl) {
		try {
			String sql = "insert into b_links(id, title, STATUS, CODE, iindex, linksurl, createdate, remark) values(0,'"+
					title+"',"+status+",'"+code+"',"+iIndex+",'"+linksurl+"',now(),'"+remark+"')";
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
	* @Description: 修改友情链接信息  
	* @param id
	* @param title
	* @param status
	* @param code
	* @param iIndex
	* @param remark
	* @param linksurl
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-04 15:58
	 */
	@Override
	public boolean update(int id,String title, int status, String code, int iIndex, String remark,String linksurl) {
		
		String sql = "update b_links set title=?,STATUS=?,CODE=?,IINDEX=?,REMARK=?,linksurl=? where ID=?";
		Object[] params = new Object[]{title,status,code,iIndex,remark,linksurl,id
		};
		int result = baseDao.update(sql, params);
		if(result > 0){
				return true;					
			}
		return false;
	}

	/**
	 * 
	* @Title: delete     
	* @Description: 删除链接（物理删除）
	* @param ids
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-04 16:34
	 */
	@Override
	public boolean delete(String ids) {
		try {
			String sql = "delete from  b_links  where ID in ("+ids+")";
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
	public List<Links> findAll() {
		List<Links> list = new ArrayList<Links>();
		try {
			String selectSql = "SELECT l.id,l.title,l.code,l.iindex,l.linksurl,l.createdate,l.remark FROM b_links l WHERE l.status <> -1  ";
			selectSql += " ORDER BY l.iindex ";
			List<Map<String, Object>> mapList = baseDao.findAll(selectSql, null);
			Links links = null;
			for (Map<String, Object> map2 : mapList) {
				links = new Links();
				links.setId(Integer.parseInt(map2.get("ID").toString()));
				links.setTitle(map2.get("TITLE").toString());
				links.setStatus(Integer.parseInt(map2.get("STATUS").toString()));
				links.setCode(map2.get("CODE")!=null?map2.get("CODE").toString():"");
				links.setIindex(Integer.parseInt(map2.get("IINDEX").toString()));
				links.setLinksurl(map2.get("LINKSURL").toString());
				links.setCreatedate(map2.get("CREATEDATE").toString());
				links.setRemark(map2.get("REMARK")!=null?map2.get("REMARK").toString():"");
				
				list.add(links);
				links = null;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
