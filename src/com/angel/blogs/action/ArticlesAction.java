package com.angel.blogs.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.angel.blogs.bean.Account;
import com.angel.blogs.bean.Articles;
import com.angel.blogs.bean.Role;
import com.angel.blogs.service.ArticlesService;
import com.angel.blogs.utils.Paginator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
* @ClassName: ArticlesAction
* @Description: 博文action
* @author zkm
* @date  2018-09-10 10:27
 */
@Controller
@RequestMapping("/articles/*")
public class ArticlesAction {
	
	@Autowired 
	private HttpServletRequest request;
	
	@Autowired
	private ArticlesService articlesService;
	
	
	@RequestMapping("findAll.do")
	public String findAll(HttpServletResponse response){
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String start = request.getParameter("start");
    		String name = request.getParameter("name");
    		Map<String,String> map = new HashMap<String,String>();
    		if(name != null && !"".equals(name)){
    			map.put("name", name);			
    		}
    		Paginator paginator = articlesService.findAll(map, start);
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
	
	@RequestMapping("selectRole.do")
	public String selectRole(HttpServletResponse response){
		
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
		
        PrintWriter out = null;
        try {
            out = response.getWriter();
            List<Role> list = articlesService.findAll();
    		JSONArray json = JSONArray.fromObject(list);
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
	* @Title: getById     
	* @Description: 根据文章id查询文章信息
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-11 17:25
	 */
	@RequestMapping("getById.do")
	public String getById(HttpServletResponse response){
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
		
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String id = request.getParameter("id");
            Articles  articles  = articlesService.getById(Integer.parseInt(id));
    		JSONObject json = JSONObject.fromObject(articles);
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
	* @Description: 添加文章 
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-11 15:21
	 */
	@RequestMapping("add.do")
	public String add(HttpServletResponse response){
	
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
		
        Account account = (Account)request.getSession().getAttribute("account");
        int uid=account.getId();
        PrintWriter out = null;
        try {
            out = response.getWriter();
    		String title = request.getParameter("title");
    		String keywords = request.getParameter("keywords");
    		String abstracts = request.getParameter("abstracts");
    		String authors = request.getParameter("authorss");
    		String sources = request.getParameter("sources");
    		String iindex = request.getParameter("iindex");
    		String assId = request.getParameter("assId");
    		String auditstatus = request.getParameter("auditstatus");
    		String[] articlesTagIds =request.getParameterValues("articlesTagIds");
    		String content = request.getParameter("content");
    		
    		String fileUrl = request.getParameter("fileUrl");
    		String fileName = request.getParameter("fileName");
    		
    		
    		boolean bool = articlesService.add(title,uid,keywords,abstracts,authors,sources,Integer.parseInt(iindex),Integer.parseInt(assId), 
    				Integer.parseInt(auditstatus),content,fileName,fileUrl,articlesTagIds);
    		JSONObject json = new JSONObject();
    		json.put("success", bool);
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
	
	
	@RequestMapping("update.do")
	public String update(HttpServletResponse response){

		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
		
        Account account = (Account)request.getSession().getAttribute("account");
        int uid=account.getId();
        
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String id = request.getParameter("id");
            String title = request.getParameter("title");
    		String keywords = request.getParameter("keywords");
    		String abstracts = request.getParameter("abstracts");
    		String authorss = request.getParameter("authorss");
    		String sources = request.getParameter("sources");
    		String iindex = request.getParameter("iindex");
    		String assId = request.getParameter("assId");
    		String auditstatus = request.getParameter("auditstatus");
    		String[] articlesTagIds =request.getParameterValues("articlesTagIds");
    		String content = request.getParameter("content");
    		
    		String fileUrl = request.getParameter("fileUrl");
    		String fileName = request.getParameter("fileName");
    	
    		boolean bool = articlesService.update(Integer.parseInt(id),title,uid,keywords,abstracts,authorss,sources,Integer.parseInt(iindex),Integer.parseInt(assId),Integer.parseInt(auditstatus),content,fileName,fileUrl,articlesTagIds);
    		JSONObject json = new JSONObject();
    		json.put("success", bool);
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
	* @Title: delete     
	* @Description: 博文删除  （逻辑删除）
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-02 13:11
	 */
	@RequestMapping("del.do")
	public String delete(HttpServletResponse response){
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
		
        PrintWriter out = null;
        try {
            out = response.getWriter();
    		String ids = request.getParameter("ids");
    		boolean bool = articlesService.delete(ids);
    		JSONObject json = new JSONObject();
    		json.put("success", bool);
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
	

}
