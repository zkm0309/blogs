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

import com.angel.blogs.bean.Role;
import com.angel.blogs.service.RoleService;
import com.angel.blogs.utils.Paginator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
* @ClassName: RoleAction
* @Description:角色Action
* @author zkm
* @date  2018-08-30 10:36
 */
@Controller
@RequestMapping("/role/*")
public class RoleAction {
	
	@Autowired 
	private HttpServletRequest request;
	
	@Autowired
	private RoleService roleService;
	
	
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
    		Paginator paginator = roleService.findAll(map, start);
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
            List<Role> list = roleService.findAll();
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
            Role role = roleService.getById(Integer.parseInt(id));
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
	
	
	@RequestMapping("add.do")
	public String add(HttpServletResponse response){
	
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
		
        PrintWriter out = null;
        try {
            out = response.getWriter();
    		String name = request.getParameter("name");
    		String status = request.getParameter("status");
    		String code = request.getParameter("code");
    		String iIndex = request.getParameter("iIndex");
    		String remark = request.getParameter("remark");
    		String menuIds = request.getParameter("menuIds");
    		boolean bool = roleService.add(name, status!=null&&!"".equals(status)?Integer.parseInt(status):1, code, 
    				iIndex!=null&&!"".equals(iIndex)?Integer.parseInt(iIndex):1, remark,menuIds);
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
		
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String id = request.getParameter("id");
    		String name = request.getParameter("name");
    		String status = request.getParameter("status");
    		String code = request.getParameter("code");
    		String iIndex = request.getParameter("iIndex");
    		String remark = request.getParameter("remark");
    		String menuIds = request.getParameter("menuIds");
    		boolean bool = roleService.update(Integer.parseInt(id),name, Integer.parseInt(status), code, 
    				iIndex!=null&&!"".equals(iIndex)?Integer.parseInt(iIndex):1, remark,menuIds);
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
	* @Description: 角色删除  （逻辑删除）
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
    		boolean bool = roleService.delete(ids);
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
