package com.angel.blogs.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.angel.blogs.bean.Account;
import com.angel.blogs.bean.Files;
import com.angel.blogs.bean.Picture;
import com.angel.blogs.service.FilesService;
import com.angel.blogs.service.PictureService;
import com.angel.blogs.utils.OperateProperties;
import com.angel.blogs.utils.Paginator;


/**
 * 
* @ClassName: PictureAction
* @Description: 轮播图action
* @author zkm
* @date  2018-09-05 15:03
 */
@Controller
@RequestMapping("/t_picture/*")
public class PictureAction {
	String pathLoad1 = OperateProperties.readValueByKey("fileUploadImage");
	String pathLoad = OperateProperties.readValueByKey("fileUploadPath");
	@Autowired 
	private HttpServletRequest request;
	@Autowired
	private FilesService filesService;
	@Autowired
	private PictureService pictureService;
	
	/**
	 * 
	* @Title: findAll     
	* @Description: 查询轮播图
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-05 15:04
	 */
	@RequestMapping("findAll.do")
	public String findAll(HttpServletResponse response){
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
		
        PrintWriter out = null;
        try {
        	//去除session中的数据
        	Object obj=request.getSession().getAttribute("account");
        	Account account=(Account) obj;
            out = response.getWriter();
            //获取request中的值
            String start = request.getParameter("start");
    		String name = request.getParameter("name");
    		String arId = request.getParameter("arId");
    		String begintime = request.getParameter("begintime");
    		String endtime = request.getParameter("endtime");
    		Map<String,String> map = new HashMap<String,String>();
    		if(name != null && !"".equals(name)){
    			map.put("name", name);			
    		}
    		if(begintime != null && !"".equals(begintime)){
    			map.put("begintime", begintime);			
    		}
    		if(endtime != null && !"".equals(endtime)){
    			map.put("endtime", endtime);			
    		}
    		if(arId != null && !"".equals(arId)){
    			map.put("arId", arId);			
    		}
    		Paginator paginator=null;
    		//判断session中名称是否为空
    		if(account.getUsername()!=null&&!account.getUsername().equals("")){
    		 paginator = pictureService.findAll(map, start,account);
    		}
    		JSONObject json = JSONObject.fromObject(paginator);
            out.print(json);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            out.flush();
            out.close();
        }
		return null;
	}
	
	/**
	 * 
	* @Title: add     
	* @Description: 新增图片
	* @param request
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-06 08:44
	 */
	@RequestMapping("add.do")
	public String add(HttpServletRequest request, HttpServletResponse response){
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
		
        PrintWriter out = null;
        try {
            Account account = (Account)request.getSession().getAttribute("account");
			out = response.getWriter();
			String pname = request.getParameter("pname");
			String psketch = request.getParameter("psketch");
			String piindex = request.getParameter("piindex");
			String pstatus = request.getParameter("pstatus");
			String fileUrl = request.getParameter("fileUrl");
    		String fileName = request.getParameter("fileName");
    		String purl = request.getParameter("purl");
			Picture picture=new Picture();
			picture.setPname(pname);
			picture.setPsketch(psketch);
			picture.setPiindex(Integer.parseInt(piindex));
			picture.setPstatus(Integer.parseInt(pstatus));
			picture.setPcreateid(account.getId());	
			picture.setPurl(purl);
			
			//添加图片    
			Integer id=pictureService.addPicture(picture);
			
			if(fileName!=null&&!fileName.equals("")){
				String suffix=fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
				//type 文件类型	1图片2文件
				int type =1;
	    		filesService.add(fileName,fileUrl, "b_picture", id, type, suffix);
			}
			JSONObject json = new JSONObject();
			json.put("flag",id);
			out.print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
            out.flush();
            out.close();
        }
		return null;
	}
	
	/**
	 * 删除新闻
	 * @param response
	 * @return
	 * @author lvxiangjin
	 * @date 2018-01-19 
	 */
	@RequestMapping("delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response){

		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
		
        PrintWriter out = null;
		try {
			out = response.getWriter();
			String ids = request.getParameter("ids");
			boolean flag = pictureService.delPicture(ids);
		
			Integer flag2=pictureService.delFiles("b_picture", ids);
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			json.put("flag2", flag2);
			out.print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
            out.flush();
            out.close();
        }
       
		return null;
	}
	
	/**
	 * 
	* @Title: update     
	* @Description: 修改图片  
	* @param request
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-06 09:23
	 */
	@RequestMapping("update.do")
	public String update(HttpServletRequest request, HttpServletResponse response){
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
		
        PrintWriter out = null;
        try {
         Account account = (Account)request.getSession().getAttribute("account");
 			out = response.getWriter();
 			String id = request.getParameter("id");	
 			String pname = request.getParameter("pname");
 			String psketch = request.getParameter("psketch");
 			String piindex = request.getParameter("piindex");
 			String pstatus = request.getParameter("pstatus");
     		String purl = request.getParameter("purl");
 			Picture picture=new Picture();
 			picture.setPname(pname);
 			picture.setPsketch(psketch);
 			picture.setPiindex(Integer.parseInt(piindex));
 			picture.setPstatus(Integer.parseInt(pstatus));
 			picture.setPcreateid(account.getId());	
 			picture.setPurl(purl);
 			picture.setId(Integer.parseInt(id));
		
		Integer flag=pictureService.updPicture(picture);
		
		Files files=new Files();
		String fileName=request.getParameter("fileName");
		String fileUrl=request.getParameter("fileUrl");
		Map<String, Object> file=pictureService.findFileById("b_picture", Integer.parseInt(id));
		
		//type 文件类型	1图片2文件
		int type =1;
		
		if(fileName!=null&&!fileName.equals("")){
			String suffix=fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
    		if(file!=null&&!file.isEmpty()){
    			files.setFileUrl(fileUrl);
    			files.setName(fileName);
    			files.setFingerId(Integer.parseInt(id));
    			pictureService.updFile(files);
    		}else{
    			filesService.add(fileName,fileUrl, "b_picture", Integer.parseInt(id), type, suffix);
    		}
		}else{
			pictureService.delFiles("b_picture", id);
		}
		
		JSONObject json = new JSONObject();
		json.put("flag", flag);
		out.print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
            out.flush();
            out.close();
        }
		return null;
	}
	/**
	 * 
	* @Title: getById     
	* @Description: 查看图片详情
	* @param request
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-05 16:35
	 */
	@RequestMapping("getById.do")
	public String getById(HttpServletRequest request, HttpServletResponse response){
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
		
        PrintWriter out = null;
        try {
        	out = response.getWriter();
        	Integer id=Integer.parseInt(request.getParameter("id"));
        	Map<String, Object> map=pictureService.findByid("b_picture",id);
        	Map<String, Object> file=pictureService.findFileById("b_picture", id);
        	JSONObject json = new JSONObject();
        	Date dates= (Date) map.get("pcreatedate");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date=sdf.format(dates);
			map.remove("pcreatedate");
			map.put("pcreatedate", date);

        	json.put("map", map);
        	json.put("file", file);
        	if(file!=null&&!file.isEmpty()){
        		if(file.get("FILEURL")!=null){
            		json.put("fileURL", OperateProperties.readValueByKey("fileUploadPath")+file.get("FILEURL"));
            	}else{
            		json.put("fileURL", "");
            	}
        	}
        	out.print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
            out.flush();
            out.close();
        }
		return null;
	}
	/**
	 * 查询新闻详情
	 * @param response
	 * @return
	 * @author lvxiangjin
	 * @date 2018-01-19 
	 */
	@RequestMapping("findbyId.do")
	public Picture findbyId(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		 PrintWriter out = null;
			try {
				out = response.getWriter();
				String id=request.getParameter("ids");
				Map<String, Object> map=pictureService.findByid("Picture",Integer.parseInt(id));
				Map<String, Object> map1=pictureService.findcjrid(Integer.parseInt(map.get("CREATEID").toString()));
				JSONObject json = new JSONObject();
				json.put("map", map);
				json.put("map1", map1);
				out.print(json);
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
	            out.flush();
	            out.close();
	        }
		return null;
	}
	
	@RequestMapping("getClub.do")
	public String getClub(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/text");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String id=request.getParameter("id");
            Map<String, Object> listmap= pictureService.findByid("Picture",Integer.parseInt(id));
    		JSONObject json = JSONObject.fromObject(listmap);
            out.print(json);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
		}finally{
            out.flush();
            out.close();
        }
		return null;
	}
	
	
	@RequestMapping("getPhoneById.do")
	public ModelAndView getPhoneById(@RequestParam(value="id") String id,@RequestParam(value="tableName") String tableName){
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map=pictureService.findByid(tableName,Integer.parseInt(id));
		mv.addObject("map",map);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createdate=sdf.format(map.get("CREATEDATE"));
		map.put("createdate", createdate);
		mv.setViewName("ywxw/ywxxnrzs");
		return mv;
	}
	
	

	
}
