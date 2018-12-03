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

import com.angel.blogs.bean.Tags;
import com.angel.blogs.service.TagsService;
import com.angel.blogs.utils.Paginator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
* @ClassName: TagsAction
* @Description: 标签action
* @author zkm
* @date  2018-09-05 10:14
 */
@Controller
@RequestMapping("/tags/*")
public class TagsAction {
	
	@Autowired 
	private HttpServletRequest request;
	
	@Autowired
	private TagsService tagsService;
	
	/**
	 * 
	* @Title: findAll     
	* @Description:标签列表 
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-05 10:16
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
    		Paginator paginator = tagsService.findAll(map, start);
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
	* @Title: selectRole     
	* @Description:查询tag标签
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-11 13:22
	 */
	@RequestMapping("selectTags.do")
	public String selectRole(HttpServletResponse response){
		
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
		
        PrintWriter out = null;
        try {
            out = response.getWriter();
            List<Tags> list = tagsService.findAll();
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
	* @Description: 根据ID查询标签信息
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-05 10:17
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
            Tags role = tagsService.getById(Integer.parseInt(id));
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
	* @Description: 添加标签  
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-05 10:18
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
    		String tagname = request.getParameter("tagname");
    		String tagurl = request.getParameter("tagurl");
    		String code = request.getParameter("code");
    		String iindex = request.getParameter("iindex");
    		String status = request.getParameter("status");
    		String remark = request.getParameter("remark");
    		boolean bool = tagsService.add(tagname, Integer.parseInt(status), code, Integer.parseInt(iindex), remark,tagurl);
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
	* @Description: 修改标签
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-05 10:18
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
            String tagname = request.getParameter("tagname");
    		String tagurl = request.getParameter("tagurl");
    		String code = request.getParameter("code");
    		String iindex = request.getParameter("iindex");
    		String status = request.getParameter("status");
    		String remark = request.getParameter("remark");
    		boolean bool = tagsService.update(Integer.parseInt(id),tagname, Integer.parseInt(status), code, 
    				Integer.parseInt(iindex), remark,tagurl);
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
	* @Description: 删除标签
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-05 10:18
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
    		boolean bool = tagsService.delete(ids);
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
