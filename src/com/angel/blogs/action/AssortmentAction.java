package com.angel.blogs.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.angel.blogs.bean.Assortment;
import com.angel.blogs.service.AssortmentService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
* @ClassName: AssortmentAction
* @Description: 分类Action
* @author zkm
* @date  2018-09-04 08:50
 */
@Controller
@RequestMapping("/assortment/*")
public class AssortmentAction {
	
	@Autowired 
	private HttpServletRequest request;
	
	@Autowired
	private AssortmentService assortmentService;
	
	/**
	 * 
	* @Title: findAll     
	* @Description: 分类列表查询 
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-04 09:00
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
            List<Assortment> list = assortmentService.findAll(1);
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
	* @Title: add     
	* @Description: 添加分类信息
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-04 09:13
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
            String name = request.getParameter("name");
            String pId = request.getParameter("pId");
            String status = request.getParameter("status");
            String code = request.getParameter("code");
            String iIndex = request.getParameter("iIndex");
            String remark = request.getParameter("remark");
            boolean bool = assortmentService.add(name, Integer.parseInt(status), code,Integer.parseInt(pId), 
            		iIndex!=null&&!"".equals(iIndex)?Integer.parseInt(iIndex):1, remark);
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
	* @Description: 修改分类信息 
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-04 09:13
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
            String name = request.getParameter("name");
            String pId = request.getParameter("pId");
            String status = request.getParameter("status");
            String code = request.getParameter("code");
            String iIndex = request.getParameter("iIndex");
            String remark = request.getParameter("remark");
            boolean bool = assortmentService.update(Integer.parseInt(id),name, Integer.parseInt(status), code,Integer.parseInt(pId), 
            		iIndex!=null&&!"".equals(iIndex)?Integer.parseInt(iIndex):1, remark);
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
	* @Title: getById     
	* @Description: 根据ID分类信息
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-04 09:13
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
            Assortment assortment = assortmentService.getById(Integer.parseInt(id));
    		JSONObject json = JSONObject.fromObject(assortment);
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
	* @Description: 删除分类信息
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-04 09:14
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
            boolean bool = assortmentService.delete(ids);
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
	* @Title: findAssortmentAllNotLayer     
	* @Description: 查询分类
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-10 17:01
	 */
	@RequestMapping("findAssortmentAllNotLayer.do")
	public String findAssortmentAllNotLayer(HttpServletResponse response){
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
        
        PrintWriter out = null;
        try {
            out = response.getWriter();
            // id  分类顶级0
            List<Assortment> list = assortmentService.findAssortmentAllNotLayer(1);
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
}
