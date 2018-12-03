package com.angel.blogs.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.angel.blogs.bean.Account;
import com.angel.blogs.bean.Menu;
import com.angel.blogs.service.MenuService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
* @ClassName: MenuAction
* @Description: 菜单Action
* @author zkm
* @date  2018-08-29 14:42
 */
@Controller
@RequestMapping("/menu/*")
public class MenuAction {
	
	@Autowired 
	private HttpServletRequest request;
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * 查询菜单列表
	 * @param response
	 * @return
	 * @author changbaolong
	 * @date 2018-01-19 09:28:02
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
            List<Menu> list = menuService.findAll();
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
	* @Title: findAllByRole     
	* @Description: 查询菜单
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-08-30 16:13
	 */
	@RequestMapping("findAllByRole.do")
	public String findAllByRole(HttpServletResponse response){
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
        
        PrintWriter out = null;
        try {
            out = response.getWriter();
            List<Menu> list = menuService.findAll();
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
	* @Title: add     
	* @Description: 添加菜单信息
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-08-29 15:40
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
            String menuUrl = request.getParameter("menuUrl");
            String openType = request.getParameter("openType");
            String status = request.getParameter("status");
            String iIndex = request.getParameter("iIndex");
            String remark = request.getParameter("remark");
            boolean bool = menuService.add(name, Integer.parseInt(status), menuUrl, 
            		Integer.parseInt(pId), Integer.parseInt(openType), 
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
	 * 修改菜单信息
	 * @param response
	 * @return
	 * @author changbaolong
	 * @date 2018-01-19 09:28:29
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
            String menuUrl = request.getParameter("menuUrl");
            String openType = request.getParameter("openType");
            String status = request.getParameter("status");
            String iIndex = request.getParameter("iIndex");
            String remark = request.getParameter("remark");
            boolean bool = menuService.update(Integer.parseInt(id),name, Integer.parseInt(status), menuUrl, 
            		Integer.parseInt(pId), Integer.parseInt(openType), 
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
	* @Description:根据ID查询菜单信息  
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-08-29 15:28
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
            Menu menu = menuService.getById(Integer.parseInt(id));
    		JSONObject json = JSONObject.fromObject(menu);
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
	* @Description: 删除菜单信息 
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-02 13:33
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
            boolean bool = menuService.delete(ids);
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
	* @Title: myMenu     
	* @Description: 我的菜单 
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-08-29 15:14
	 */
	@RequestMapping("myMenu.do")
	public String myMenu(HttpServletResponse response){

		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
		
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Account account = (Account)request.getSession().getAttribute("account");
            List<Menu> list = menuService.findAll(account.getRoId());
            JSONArray pJson = new JSONArray();
            for (Menu menu : list) {
            	if(menu.getMenuUrl() == "#" || "#".equals(menu.getMenuUrl())){
            		JSONObject json = new JSONObject();
            		json.put("id", menu.getId());
            		json.put("name", menu.getName());
            		pJson.add(json);
            	}else{
            		for (Object object : pJson) {
            			JSONObject json = (JSONObject)object;
            			if(json.getString("id") == String.valueOf(menu.getpId())
            					|| json.getString("id").equals(String.valueOf(menu.getpId()))){
            				List<Menu> childrenList = json.containsKey("children")?(List<Menu>)json.get("children"):new ArrayList<Menu>();
            				childrenList.add(menu);
            				json.put("children", childrenList);
            			}
					}
            	}
			}
            out.print(pJson);
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
	
	
	@RequestMapping("getNav.do")
	public String getNav(HttpServletResponse response){
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
        
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String id = request.getParameter("id");
            Menu menu = menuService.getById(Integer.parseInt(id));
            Menu pMenu = menuService.getById(menu.getpId());
    		JSONObject json = new JSONObject();
    		json.put("pName", pMenu.getName());
    		json.put("name", menu.getName());
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
