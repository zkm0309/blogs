package com.angel.blogs.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.blogs.bean.Account;
import com.angel.blogs.bean.Files;
import com.angel.blogs.bean.Picture;
import com.angel.blogs.bean.YwxwPublic;
import com.angel.blogs.dao.BaseDao;
import com.angel.blogs.service.PictureService;
import com.angel.blogs.utils.FormatSql;
import com.angel.blogs.utils.OperateProperties;
import com.angel.blogs.utils.Paginator;



@Service
public class PictureServiceImpl implements PictureService{
	@Autowired
	private BaseDao baseDao;

	@Override
	public Paginator findAll(Map<String, String> map, String start,Account account) {
		Paginator paginator = new Paginator();
		List<Picture> list=new ArrayList<Picture>();
		String selectSql="SELECT 	id, pname, psketch, pstatus, date_format(pcreatedate, '%Y-%m-%d %H:%i:%s')  as pcreatedate, piindex, pcreateid, purl FROM b_picture  where pstatus <> -1";

		if(map!=null){
			if(map.containsKey("name")){
				selectSql += " and pname like '%"+map.get("name")+"%'";
			}
			if(map.containsKey("begintime")&&map.containsKey("endtime")){
				selectSql += " and pcreatedate between to_date('"+map.get("begintime")+"','yyyy-mm-dd') and to_date('"+map.get("endtime")+"','yyyy-mm-dd') ";
			}else if(map.containsKey("begintime")){
				selectSql += " and pcreatedate date '"+map.get("begintime")+"'";
			}else if(map.containsKey("endtime")){
				selectSql += " and pcreatedate < date '"+map.get("endtime")+"'";
			}
		}
		selectSql+=" order by pcreatedate desc";
		String columns = "id, pname, psketch, pstatus, pcreatedate, piindex, pcreateid, purl";
		String sql = FormatSql.queryPageSql(columns, selectSql, start);
		List<Map<String, Object>> mapList=	baseDao.findAll(sql, null);
		Picture picture=null;
		if(mapList!=null&&!mapList.isEmpty()){
			for (Map<String, Object> map1 : mapList) {
				picture=new Picture();
				picture.setId(Integer.parseInt(map1.get("ID").toString()));
				Map<String, Object> file=this.findFileById("b_picture",Integer.parseInt(map1.get("ID").toString()));
				if(file!=null&&!file.equals("")){
					picture.setFileName(file.get("NAME").toString());
					picture.setFileUrl(OperateProperties.readValueByKey("fileUploadPath")+file.get("FILEURL").toString());
				}
				picture.setPname(map1.get("pname").toString());
				picture.setPsketch(map1.get("psketch").toString());
				picture.setPcreatedate(map1.get("pcreatedate").toString());
				picture.setPstatus(Integer.parseInt(map1.get("pstatus").toString()));
				Map<String, Object>  t_account=this.findCreateId(Integer.parseInt(map1.get("pcreateid").toString()));
				if(t_account!=null&&!t_account.equals("")){
				picture.setCreateName(t_account.get("username").toString());
				}
				picture.setPcreateid(Integer.parseInt(map1.get("pcreateid").toString()));
				list.add(picture);
			}
		}
		int count = baseDao.count(selectSql, null);
		paginator.setResult(list);
		paginator.setCurrentPage(Integer.parseInt(start)/10);
		paginator.setTotalCount(count);
		return paginator;
	}

	@Override
	public Map<String, Object> findByid(String tableName,int id) {
		String sql="select * from "+tableName+" where id="+id+"";
		return baseDao.getById(sql,null);
	}
	
	/**
	 * 
	* @Title: addPicture     
	* @Description: 轮播图添加  
	* @param picture
	* @return   
	* Integer    返回类型 
	* @author zkm 
	* @date 2018-09-06 08:47
	 */
	@Override
	public Integer addPicture(Picture picture) {
		int id=0;
		try {
		String sql = "INSERT INTO b_picture (id, pname, psketch, pstatus, pcreatedate, piindex, pcreateid, purl)VALUES(0,'"
				+picture.getPname()+"','"+picture.getPsketch()+"',"+picture.getPstatus()+",now(),"+ picture.getPiindex() + "," + picture.getPcreateid() + ",'"+picture.getPurl()+"')";
		id = baseDao.insert(sql);
		if(id>0){
			//查询表自增id
			String sqlid="select max(id) id from b_picture";
			int pid=baseDao.getmysqlid(sqlid);
			return pid;
		} 
		}catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * 
	* @Title: delPicture     
	* @Description: 删除图片
	* @param ids
	* @return   
	* boolean    返回类型 
	* @author zkm 
	* @date 2018-09-06 10:57
	 */
	@Override
	public boolean delPicture(String ids) {
		try {
			String sql="update b_picture t set t.pstatus=-1 where t.id in ("+ids+")";
			int result=	baseDao.update(sql, null);
			if(result > 0){
				return true;
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
	}

	@Override
	public Integer updPicture(Picture picture) {
		int id=0;
		try {
			String sql = "update b_picture set pname='" + picture.getPname()+ "',psketch='" + picture.getPsketch() + "',pstatus="+picture.getPstatus()+",piindex=" + picture.getPiindex()+ ",pcreateid=" + picture.getPcreateid() +",purl='"+picture.getPurl()+ "' where id="+ picture.getId() + " ";
		id = baseDao.update(sql,null);
		if(id>0){
			return id;
		} 
		}catch (Exception e) {
			e.printStackTrace();
		}
			return id;
	}

	@Override
	public boolean addBusinessrange(String fingertable,String fingerid,String areaids) {
		try {
		int ids=0;
		String [] areaid=areaids.split(",");
		for (String id : areaid) {
			if(id!=null&&!id.equals("")){
				String sql = "insert into T_BUSINESSRANGE(ID,FINGERTABLE,FINGERID,AID) values(?,'"+fingertable+"','"+fingerid+"','"+id+"')";
				 ids += baseDao.insert(sql,"SEQ_BUSINESSRANGE.Nextval");
			}
		}
		 if(ids>0){
				return true;
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delBusinessrange(String tableName,String fingertable,String ids) {
			if(ids!=null&&!ids.equals("")){
					String sql1="delete from T_BUSINESSRANGE where FINGERTABLE ='"+fingertable+"' and FINGERID in("+ids+")";
					int	i=baseDao.delete(sql1, null);
				if(i>0){
					return true;
				}
		}
		return false;
	}

	@Override
	public Map<String, Object> findcjrid(int id) {
		String sql="SELECT 	id, username, accountname, PASSWORD, roid, arid, iindex, remark, createdate, sex, telphone, imei, STATUS, useremail FROM b_account  where id="+id+"";
		return baseDao.getById(sql, null);
	}

	/**
	 * 
	* @Title: findFileById     
	* @Description: 根据id查询文件信息
	* @param tablename
	* @param id
	* @return   
	* Map<String,Object>    返回类型 
	* @author zkm 
	* @date 2018-09-06 09:31
	 */
	@Override
	public Map<String, Object> findFileById(String tablename,int id) {
		String sql="SELECT 	id, NAME, STATUS, fileurl, fingertable, fingerid, TYPE, suffix FROM b_files  where fingertable ='"+tablename+"' and status =1 and fingerid = "+id+"";
		return baseDao.getById(sql, null);
	}

	@Override
	public Map<String, Object> findCreateId(int id) {
		String sql="SELECT 	id, username, accountname, PASSWORD, roid, arid, iindex, remark, createdate, sex, telphone, imei, STATUS, useremail FROM b_account where id="+id+"";
		return baseDao.getById(sql, null);
	}

	@Override
	public List<Map<String, Object>>  findBusinessrange(String tableName,int id) {
		String sql="select * from t_Businessrange where fingertable='"+tableName+"' and fingerid ='"+id+"'";
		return baseDao.findAll(sql, null);
	}

	@Override
	public List<Map<String, Object>> findArea(String ids) {
		String sql="select 	id, name, status, code, pid, layer, iindex, remark from b_area where id in ("+ids+")";
		return baseDao.findAll(sql, null);
	}

	@Override
	public Integer updFile(Files files) {
		String sql="update b_files set 	Name='"+files.getName()+"',FILEURL='"+files.getFileUrl()+"' where fingerid="+files.getFingerId()+"";
		return baseDao.update(sql, null);
	}

	@Override
	public Integer delFiles(String tableName, String fingerid) {
		String sql="update b_files t set t.status =-1 where t.fingertable='"+tableName+"' and t.fingerid in ("+fingerid+")";
		return baseDao.update(sql, null);
	}

	@Override
	public Paginator findAllByPhone(String tableName,String start,String id) {
		Paginator paginator = new Paginator();
		start = String.valueOf(Integer.parseInt(start)*paginator.getPageSize());
		List<YwxwPublic> list=new ArrayList<YwxwPublic>();
		String selectSql="";
		//护林员查看  自己村子的新闻 和 发布的全部可查看新闻
		selectSql="select * from ( select * from "+tableName+" t where t.leve=0 "
				+" union all "
				+" select * from "+tableName+" t where t.id in (  "
				+" select b.fingerid from ( "
				+" select area.* from t_account a  inner join t_area area on a.arid=area.id where a.id="+id+") "
				+" t inner join t_businessrange b on t.id=b.aid) and status=1 )t where t.status=1";
		selectSql+=" order by t.createdate desc";
		String columns = "id,title,sketch,createdate,content,leve,createid,wxurl";
		
		/**String sql = FormatSql.queryPageSql(columns, selectSql, start);
		 * 上述代码不删除
		 */
		/*String sql =FormatSql.queryTenListSql(columns, selectSql, start);*/
		String sql =FormatSql.queryTenListSql(columns, selectSql, start);
		List<Map<String, Object>> mapList=	baseDao.findAll(sql, null);
		YwxwPublic yp=null;
		for (Map<String, Object> map1 : mapList) {
			yp=new YwxwPublic();
			yp.setId(Integer.parseInt(map1.get("ID").toString()));
			Map<String, Object> file=this.findFileById(tableName,Integer.parseInt(map1.get("ID").toString()));
			if(file!=null&&!file.equals("")){
				yp.setImg(OperateProperties.readValueByKey("fileUploadPath")+file.get("FILEURL").toString());
			}
			//判断表名是否为业务学习表  是的话进行查询  
			if(tableName.equals("T_STUDY")){
				String url=OperateProperties.readValueByKey("fileUploadVideoPath");
				List<Map<String, Object>> list1=this.findVideo(map1.get("ID").toString());
				if(list1!=null&&!list1.isEmpty()){
					List<Map<String,Object>> list2=new ArrayList<Map<String,Object>>();
					for (int i = 0; i < list1.size(); i++) {
						Map<String,Object> map=new HashMap<String,Object>();
						if(list1.get(i)!=null&&!list1.get(i).isEmpty()){
								map.put("videoName",list1.get(i).get("NAME"));
								map.put("videoUrl",url+list1.get(i).get("FILEURL"));
								list2.add(map);
						}
					}
					yp.setVideoList(list2);
				}
			}
			yp.setTitle(map1.get("TITLE").toString());
			yp.setSketch(map1.get("SKETCH").toString());
			if(map1.get("WXURL")!=null&&!map1.get("WXURL").equals("")){
				yp.setWxUrl(map1.get("WXURL").toString());
			}
			Date dates= (Date) map1.get("CREATEDATE");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date=sdf.format(dates);
			yp.setCreatedate(date);
			//暂时网址!!!!
			yp.setInfoUrl(OperateProperties.readValueByKey("NewsUrl")+"?id="+map1.get("ID").toString()+"&tableName="+tableName);  
			list.add(yp);
		}
		int count = baseDao.count(selectSql, null);
		paginator.setResult(list);
		paginator.setCurrentPage(Integer.parseInt(start)/10);
		paginator.setTotalCount(count);
		return paginator;
	}
	@Override
	public int promptTask(int arId) {
		String sql ="select SEQ_TASKread.Nextval ttid, s.id sid,s.aid,t.id from T_TASK t  inner join T_TASKASSIGN s on s.tid=t.id left join t_taskread r on t.id=r.tid and r.taid=s.id and r.aid=s.aid where s.aid="+arId+" and s.status=0 and r.id is null";
		return   baseDao.insert(" insert into T_TASKread(id,taid,aid,tid) "+sql);
		
	}

	@Override
	public List<Map<String, Object>> findIdByCzId(String id) {
		String sql="select a.id from t_account a where a.arid in ("+id+")";
		return baseDao.findAll(sql, null);
	}

	@Override
	public List<Map<String, Object>> findVideo(String id) {
		String sql="select * from t_files t where t.fingerid="+id+" and t.fingertable ='T_VIDEO' and t.status=1";
		return baseDao.findAll(sql, null);
	}

	
}
