package com.angel.blogs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.angel.blogs.service.InitService;

import net.sf.json.JSONObject;

/**
 * 
* @ClassName: InitAction
* @Description: 初始加载信息跳转
* @author zkm
* @date  2018-09-17 10:38
 */
@Controller
@RequestMapping("/init/*")
public class InitAction {
  
	@Autowired
	private InitService initservice;
	
	@Autowired 
	private HttpServletRequest request;
	
	@RequestMapping("init.do")
	public String login(HttpServletResponse response){
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
		
        PrintWriter out = null;
        try {
        	out = response.getWriter();
            //登录用户名、登录密码
            JSONObject json = new JSONObject();
        	
        	System.err.println("00000");
 
        	response.sendRedirect("index.jsp");
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
