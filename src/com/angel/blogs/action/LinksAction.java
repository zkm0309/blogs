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

import com.angel.blogs.bean.Links;
import com.angel.blogs.service.LinksService;
import com.angel.blogs.utils.Paginator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
* @ClassName: LinksAction
* @Description: 友情链接Action
* @author zkm
* @date  2018-09-04 14:04
 */
@Controller
@RequestMapping("/links/*")
public class LinksAction {
	
	@Autowired 
	private HttpServletRequest request;
	
	@Autowired
	private LinksService linksService;
	
	/**
	 * 
	* @Title: findAll     
	* @Description: 友情链接列表
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-04 14:39
	 */
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
    		Paginator paginator = linksService.findAll(map, start);
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
            List<Links> list = linksService.findAll();
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
	* @Description: 根据ID查询友情链接信息
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-04 16:03
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
            Links role = linksService.getById(Integer.parseInt(id));
    		JSONObject json = JSONObject.fromObject(role);
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
	* @Description: 添加友情链接
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-04 15:03
	 */
	@RequestMapping("add.do")
	public String add(HttpServletResponse response){
	
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
		
        PrintWriter out = null;
        try {
            out = response.getWriter();
    		String title = request.getParameter("title");
    		String linksurl = request.getParameter("linksurl");
    		String code = request.getParameter("code");
    		String iindex = request.getParameter("iindex");
    		String status = request.getParameter("status");
    		String remark = request.getParameter("remark");
    		boolean bool = linksService.add(title, Integer.parseInt(status), code, Integer.parseInt(iindex), remark,linksurl);
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
	* @Title: update     
	* @Description: 修改友情链接
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-04 16:33
	 */
	@RequestMapping("update.do")
	public String update(HttpServletResponse response){

		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
		
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String id = request.getParameter("id");
            String title = request.getParameter("title");
    		String linksurl = request.getParameter("linksurl");
    		String code = request.getParameter("code");
    		String iindex = request.getParameter("iindex");
    		String status = request.getParameter("status");
    		String remark = request.getParameter("remark");
    		boolean bool = linksService.update(Integer.parseInt(id),title, Integer.parseInt(status), code, 
    				Integer.parseInt(iindex), remark,linksurl);
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
	* @Description: 删除友情链接（物理删除）
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-04 16:33
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
    		boolean bool = linksService.delete(ids);
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
