package com.angel.blogs.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.angel.blogs.bean.Account;
import com.angel.blogs.bean.Area;
import com.angel.blogs.service.AreaService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
* @ClassName: AreaAction
* @Description:区域Action
* @author zkm
* @date  2018-08-28 15:52
 */
@Controller
@RequestMapping("/area/*")
public class AreaAction {

	
	@Autowired 
	private HttpServletRequest request;
	
	@Autowired
	private AreaService areaService;
	
	
	/**
	 * 
	* @Title: findAll     
	* @Description:区域列表
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-08-29 17:31
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
            Account account = (Account)request.getSession().getAttribute("account");
            List<Area> list = areaService.findAll(account.getArId());
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
	 * 区域列表只展示到村
	 * @param response
	 * @return
	 * @author zlfeng
	 * @date 2018-01-18 09:22:26
	 */
	@RequestMapping("getCfindAll.do")
	public String getCfindAll(HttpServletResponse response){
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
        
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Account account = (Account)request.getSession().getAttribute("account");
            List<Area> list = areaService.getCfindAll(account.getArId());
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
	* @Title: findAllNotLayer     
	* @Description: 列表查询Layer  
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-02 09:22
	 */
	@RequestMapping("findAllNotLayer.do")
	public String findAllNotLayer(HttpServletResponse response){
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
        
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Account account = (Account)request.getSession().getAttribute("account");
            List<Area> list = areaService.findAllNotLayer(account.getArId());
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
	 * 镇列表
	 * @param response
	 * @return
	 * @author lv
	 * @date 2018-01-23 
	 */
	@RequestMapping("findZAll.do")
	public String findZAll(HttpServletResponse response){
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
        
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Account account = (Account)request.getSession().getAttribute("account");
            List<Area> list = areaService.findZAll(account.getArId());
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
	 * 村列表
	 * @param response
	 * @return
	 * @author lv
	 * @date 2018-01-23 
	 */
	@RequestMapping("findCAll.do")
	public String findCAll(HttpServletResponse response){
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
        
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Account account = (Account)request.getSession().getAttribute("account");
            List<Area> list = areaService.findCAll(account.getArId());
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
	* @Description: 添加区域信息
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-08-30 08:59
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
            String layer = request.getParameter("layer");
            String code = request.getParameter("code");
            String status = request.getParameter("status");
            String iIndex = request.getParameter("iIndex");
            String remark = request.getParameter("remark");
          
            boolean bool = areaService.add(name, Integer.parseInt(status), code, 
            		Integer.parseInt(pId), Integer.parseInt(layer), 
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
	 * 修改区域信息
	 * @param response
	 * @return
	 * @author changbaolong
	 * @date 2018-01-18 09:22:58
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
            String layer = request.getParameter("layer");
            String code = request.getParameter("code");
            String status = request.getParameter("status");
            String iIndex = request.getParameter("iIndex");
            String remark = request.getParameter("remark");
       
            boolean bool = areaService.update(Integer.parseInt(id),name, Integer.parseInt(status), code, 
            		Integer.parseInt(pId), Integer.parseInt(layer), 
            		Integer.parseInt(iIndex), remark);
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
	 * 根据ID查询区域信息
	 * @param response
	 * @return
	 * @author changbaolong
	 * @date 2018-01-18 09:23:05
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
            Area area = areaService.getById(Integer.parseInt(id));
    		JSONObject json = JSONObject.fromObject(area);
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
	 * 删除区域信息
	 * @param response
	 * @return
	 * @author changbaolong
	 * @date 2018-01-18 09:23:14
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
            boolean bool = areaService.delete(ids);
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
