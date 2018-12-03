package com.angel.blogs.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.blogs.bean.Articles;
import com.angel.blogs.bean.Role;
import com.angel.blogs.dao.BaseDao;
import com.angel.blogs.service.ArticlesService;
import com.angel.blogs.utils.FormatSql;
import com.angel.blogs.utils.Paginator;


/**
 * 
* @ClassName: ArticlesServiceImpl
* @Description: 博文Service实现
* @author zkm
* @date  2018-09-10 10:33
 */
@Service
public class ArticlesServiceImpl implements ArticlesService {
	
	@Autowired
	private BaseDao baseDao;

	/**
	 * 
	* @Title: findAll     
	* @Description: 分页查询博文信息
	* @param map
	* @param start
	* @return   
	* Paginator    返回类型 
	* @author zkm 
	* @date 2018-09-10 10:32
	 */
	@Override
	public Paginator findAll(Map<String, String> map, String start) {
		Paginator paginator = new Paginator();
		try {
			String selectSql = "SELECT 	ar.id, ar.uid, ar.title, ar.keywords,abstracts, ar.content, ar.authorss, ar.sources, ar.iindex, ar.views, ar.comments, date_format(ar.createdate, '%Y-%m-%d %H:%i:%s')  as createdate, ar.likenum,  (CASE WHEN ar.auditstatus = 0 THEN '未审核'ELSE '审核通过'END) AS auditstatus,ass.name as assname,ass.id AS assid	FROM b_articles  ar INNER JOIN b_assortment ass ON ass.id=ar.assortmentid  AND ass.status =1 WHERE 1=1 AND ar.auditstatus <> -1 ";
			if(map != null){
				if(map.containsKey("name")){
					selectSql += " and ar.title like '%"+map.get("name")+"%'";
				}
			}
			selectSql += " order by ar.id asc";
			String columns = "id, uid, title, keywords,abstracts, content, authorss, sources, iindex, views, comments, createdate, likenum, auditstatus,assname";
			String sql = FormatSql.queryPageSql(columns, selectSql, start);
			List<Map<String, Object>> mapList = baseDao.findAll(sql, null);
			List<Articles> list = new ArrayList<Articles>();
			Articles articles= null;
			for (Map<String, Object> map2 : mapList) {
				articles = new Articles();
				articles.setId(Integer.parseInt(map2.get("ID").toString()));
				articles.setTitle(map2.get("title").toString());
				articles.setAuthorss(map2.get("authorss").toString());
				articles.setKeywords(map2.get("keywords")!=null?map2.get("keywords").toString():"");
				articles.setIindex(Integer.parseInt(map2.get("IINDEX").toString()));
				articles.setContent(map2.get("content")!=null?map2.get("content").toString():"");
				articles.setAssortmentname(map2.get("assname").toString());
				articles.setCreatedate(map2.get("createdate").toString());
				articles.setAuditstatusname(map2.get("auditstatus").toString());
				articles.setAbstracts(map2.get("abstracts").toString());
				list.add(articles);
				articles = null;
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
	* @Title: getById     
	* @Description: 根据id查询文章信息
	* @param id
	* @return   
	* Articles    返回类型 
	* @author zkm 
	* @date 2018-09-11 17:26
	 */
	@Override
	public Articles getById(int id) {
		Articles articles = null;
		try {
			articles = new Articles();
			String sql = "SELECT 	ar.id, ar.uid, ar.title, ar.keywords,ar.abstracts, ar.content, ar.authorss, ar.sources, ar.iindex, ar.views, ar.comments, DATE_FORMAT(ar.createdate, '%Y-%m-%d %H:%i:%s')  AS createdate, ar.likenum,  ar.auditstatus,ar.assortmentid,ass.name AS assname,ass.id AS assid,f.fileurl,f.name as filename"
					+ "  FROM b_articles  ar INNER JOIN b_assortment ass ON ass.id=ar.assortmentid  AND ass.status =1 LEFT JOIN b_files f ON ar.id=f.fingerid AND f.status=1 WHERE 1=1 AND ar.auditstatus <> -1 AND ar.id=?";
			Map<String, Object> map = baseDao.getById(sql, new Object[]{id});
			articles.setId(Integer.parseInt(map.get("ID").toString()));
			articles.setTitle(map.get("title").toString());
			articles.setKeywords(map.get("keywords")!=null?map.get("keywords").toString():"");
			articles.setAbstracts(map.get("abstracts").toString());
			articles.setAuditstatus(Integer.parseInt(map.get("auditstatus").toString()));
			articles.setContent(map.get("content")!=null?map.get("content").toString():"");
			articles.setIindex(Integer.parseInt(map.get("iindex").toString()));
			articles.setAuthorss(map.get("authorss")!=null?map.get("authorss").toString():"");
			articles.setAssortmentid(Integer.parseInt((map.get("assortmentid").toString())));
			articles.setUid(Integer.parseInt(map.get("uid").toString()));
			articles.setAssortmentname(map.get("assname")!=null?map.get("assname").toString():"");
			articles.setSources(map.get("sources")!=null?map.get("sources").toString():"");
			articles.setFileName((map.get("filename")!=null?map.get("filename").toString():""));
			articles.setFileUrl((map.get("fileurl")!=null?map.get("fileurl").toString():""));
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
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
	public boolean add(String title,int uid, String keywords,String abstracts,String authors,String sources, int iindex,int assId, int auditstatus, String content,String fileName,String fileUrl,String[] articlesTagIds) {
		try {
			String sql = "INSERT INTO b_articles (id, uid, title, keywords, abstracts, content, authorss, sources, iindex, views, comments, createdate, likenum, auditstatus, assortmentid)VALUES(0,"+
					uid+",'"+title+"','"+keywords+"','"+abstracts+"','"+content+"','"+authors+"','"+sources+"',"+iindex+",0,0,now(),0,"+auditstatus+","+assId+")";
			int id = baseDao.insert(sql);
			//查询表自增id
			String sqlid="select max(id) id from b_articles";
			int articlesid=baseDao.getmysqlid(sqlid);			
			if(id > 0){
				List<String> sqlList = new ArrayList<String>();
				 // 输出标签
			      for (int i = 0; i < articlesTagIds.length; i++) {
			         String addSql = "INSERT INTO b_articlestags (id, articlesid, tagsid)VALUES(0,"+articlesid+","+articlesTagIds[i]+")";
						sqlList.add(addSql);
			      }
				boolean result = baseDao.batchUpdate(sqlList.toArray(new String[0]));
				int filesId = baseDao.addFiles(fileName, fileUrl, "b_articles", String.valueOf(articlesid));
				if(result && filesId>0 ){
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
	public boolean update(int id,String title,int uid,String keywords,String abstracts,String authors,String sources, int iindex,int assId, int auditstatus, String content,String fileName,String fileUrl,String[] articlesTagIds) {
		String xsql="UPDATE b_articles SET uid =? , title =? , keywords =? , abstracts =? , content =? , authorss =? , sources =? , iindex =? , auditstatus =? , assortmentid =?  WHERE id =? ";
		Object[] params = new Object[]{
				uid,title,keywords,abstracts,content,authors,sources,iindex,auditstatus,assId,id
		};
		int result = baseDao.update(xsql, params);
		if(result > 0){
			baseDao.delete("delete from b_articlestags where articlesid = ?", new Object[]{id});
			List<String> sqlList = new ArrayList<String>();
			// 重新插入标签
		      for (int i = 0; i < articlesTagIds.length; i++) {
		         String addSql = "INSERT INTO b_articlestags (id, articlesid, tagsid)VALUES(0,"+id+","+articlesTagIds[i]+")";
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
			baseDao.delete("DELETE FROM b_articlestags  WHERE  articlesid in ("+ids+")", null);
			String sql = "UPDATE b_articles ar SET ar.auditstatus = -1 WHERE ar.id in ("+ids+")";
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
