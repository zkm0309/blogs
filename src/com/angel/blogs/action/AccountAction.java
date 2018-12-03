package com.angel.blogs.action;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.CellView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.angel.blogs.bean.Account;
import com.angel.blogs.service.AccountService;
import com.angel.blogs.utils.FileUtil;
import com.angel.blogs.utils.MD5Util;
import com.angel.blogs.utils.OperateProperties;
import com.angel.blogs.utils.Paginator;
import com.angel.blogs.utils.ToZipFile;

import net.sf.json.JSONObject;

/**
 * 
* @ClassName: AccountAction
* @Description: 账户管理
* @author zkm
* @date  2018-08-27 16:27
 */
@Controller
@RequestMapping("/account/*")
public class AccountAction {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired 
	private HttpServletRequest request;

	/**
	 * 
	* @Title: login     
	* @Description: 账号登录 
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-08-21 14:58
	 */
	@RequestMapping("login.do")
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
    		String loginName = request.getParameter("ln");
    		String loginPwd = request.getParameter("lp");
    		Account account = accountService.login(loginName, loginPwd,"pc");
    		if(account != null){
    			request.getSession().setAttribute("account", account);
    			json.put("success", true);
    			json.put("path", "/index.jsp");
    		}else{
    			//账户或密码错误
    			json.put("success", false);
    			json.put("msg", "账户或密码错误");
    		}
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
	* @Title: loginOut     
	* @Description: 账号退出 
	* @return   
	* ModelAndView    返回类型 
	* @author zkm 
	* @date 2018-08-21 17:12
	 */
	@RequestMapping("loginOut.do")
	public ModelAndView loginOut(){
		ModelAndView mav = new ModelAndView();
		request.getSession().removeAttribute("account");
		mav.setViewName("login");
		return mav;
	}
	
	/**
	 * 
	* @Title: findAll     
	* @Description: 账号列表
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-08-21 17:12
	 */
	@RequestMapping("findAll.do")
	public String findAll(HttpServletResponse response){
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
        
        Account account =(Account) request.getSession().getAttribute("account");
        
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String start = request.getParameter("start");
    		String name = request.getParameter("name");
    		
    		//zkm 2018-9-2 获取用户所属区域id
    		String arId = String.valueOf(account.getArId());
    		
    		String accountName = request.getParameter("accountName");
    		Map<String,String> map = new HashMap<String,String>();
    		if(name != null && !"".equals(name)){
    			map.put("name", name);			
    		}
    		if(accountName != null && !"".equals(accountName)){
    			map.put("accountName", accountName);			
    		}
    		if(arId != null && !"".equals(arId)){
    			map.put("arId", arId);			
    		}
    		Paginator paginator = accountService.findAll(map, start);
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
	* @Description: 添加账户  
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-09-02 10:18
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
    		String name = request.getParameter("username");
    		String accountName = request.getParameter("accountName");
    		String password = request.getParameter("password");
    		String roId = request.getParameter("roId");
    		String arId = request.getParameter("arId");
    		String remark = request.getParameter("remark");
    		String iindex = request.getParameter("iindex");
    		String sex = request.getParameter("sex");
    		String phone = request.getParameter("telphone");
    		String useremail = request.getParameter("useremail");
    		String status = request.getParameter("status");
    		String fileUrl = request.getParameter("fileUrl");
    		String fileName = request.getParameter("fileName");
    		boolean bool = accountService.add(name, accountName, password, 
    				Integer.parseInt(roId), Integer.parseInt(arId), Integer.parseInt(iindex), remark,
    				 Integer.parseInt(sex), phone,Integer.parseInt(status),useremail,fileName,fileUrl);
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
	* @Description: 修改账户信息 
	* @param response
	* @return   
	* String    返回类型 
	* @author zkm 
	* @date 2018-08-31 17:38
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
    		String name = request.getParameter("username");
    		String accountName = request.getParameter("accountName");
    		String password = request.getParameter("password");
    		String roId = request.getParameter("roId");
    		String arId = request.getParameter("arId");
    		String remark = request.getParameter("remark");
    		String iindex = request.getParameter("iindex");
    		String sex = request.getParameter("sex");
    		String phone = request.getParameter("telphone");
    		String status = request.getParameter("status");
    		String useremail = request.getParameter("useremail");
    		String fileUrl = request.getParameter("fileUrl");
    		String fileName = request.getParameter("fileName");
    		boolean bool = accountService.update(Integer.parseInt(id), name, accountName,
    				Integer.parseInt(roId), Integer.parseInt(arId), Integer.parseInt(iindex), remark,
    			    Integer.parseInt(sex), phone, Integer.parseInt(status),useremail,fileName,fileUrl);
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
	 * 删除账户
	 * @param response
	 * @return
	 * @author changbaolong
	 * @date 2018-01-17 11:22:17
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
    		boolean bool = accountService.delete(ids);
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
	 * 根据ID查询账户信息
	 * @param response
	 * @return
	 * @author changbaolong
	 * @date 2018-01-17 11:32:09
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
    		Account account = accountService.getById(Integer.parseInt(id));
    		JSONObject json = JSONObject.fromObject(account);
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
	 * 修改密码
	 * @param response
	 * @return
	 * @author changbaolong
	 * @date 2018-02-05 03:46:43
	 */
	@RequestMapping("reset.do")
	public String resetPwd(HttpServletResponse response){
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
        
        PrintWriter out = null;
        try {
            out = response.getWriter();
    		String id = request.getParameter("id");
    		String password = "";
    		if(request.getParameter("password") != null && !"".equals(request.getParameter("password"))){
    			password = request.getParameter("password");
    		}else{
    			password = MD5Util.getStringMD5String("123456");
    		}
    		boolean bool = accountService.resetPwd(Integer.parseInt(id),password.toUpperCase());
    		JSONObject json = new JSONObject();
    		json.put("success", bool);
            out.print(json);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.flush();
            out.close();
        }
		return null;
	}
	
	
	//重置手机标识唯一码
	@RequestMapping("resetPhoneid.do")
	public void resetPhoneid(HttpServletResponse response){
		response.setContentType("text/Xml;charset=utf-8");
        PrintWriter out = null;
        try {
			out = response.getWriter();
			String imei = request.getParameter("imei");
			int id = Integer.parseInt(request.getParameter("id"));
			boolean flg=accountService.updatePhoneId(imei, id);
			JSONObject json = new JSONObject();
			json.put("success", flg);
			out.print(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
            out.flush();
            out.close();
        }
				
	}
    		
	/**
	 * 账号导出
	 * @param task
	 * @param type
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("LogexportAll.do")
	public String LogexportAll(String name,String accountName,String arId,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/text");
		//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
        
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy_MM_dd");
		 Date date=new Date();
		String downloadtime=dateFormater.format(date); 
		
		//获取session 用户对象
		 Account account =(Account) request.getSession().getAttribute("account");
		//zkm 2018-9-2 获取用户所属区域id
 		String arId1 = String.valueOf(account.getArId());
		
        String expusername="账户信息";
        PrintWriter out = null;
        try {
        	 out = response.getWriter();
     		Map<String,String> map = new HashMap<String,String>();
     		//姓名
     		if(name!=null && !name.equals("")){
     			map.put("name", name);
     		}
     		//时间
     		if(accountName!=null && !accountName.equals("")){
     			map.put("accountName", accountName);
     		}
     		map.put("arid", arId1);
    		 List<Map<String, Object>> list = accountService.rzexportAll(map);
            String pathName = OperateProperties.readValueByKey("excelPath");
            ServletContext context = request.getServletContext();
			String replaceUrl = context.getRealPath("");
			pathName = replaceUrl.substring(0, replaceUrl.lastIndexOf(File.separator)) + pathName;
			File file = new File(pathName);
			if (file.exists()) {
				this.clearFiles(pathName);
			}
			if (!file.exists()) {
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				file.mkdir();
			}
			CellView navCellView = new CellView();
			navCellView.setAutosize(true); // 设置自动大小
			navCellView.setSize(18);
			String fileName = expusername+"_"+downloadtime;//sheet1 名称
			ToZipFile toZipFile = new ToZipFile();
			String[] areaopts = { "姓名","账号","手机号码","性别","对应角色","所属区域","创建时间"};
			Map<String, String> mapxa = new HashMap<String, String>();
			String[] tatelcode = { "USERNAME","ACCOUNTNAME","TELPHONE","SEX", "RNAME","ANAME","CREATEDATE"};
			String path = pathName + File.separator + fileName;
			response.reset();
			OutputStream outx = null;
			outx = response.getOutputStream();
			String pathx = toZipFile.toExcel(fileName, list, request, 50000, outx, areaopts, mapxa, tatelcode);
			FileUtil.download1(expusername+"导出_"+downloadtime+".zip", pathx, response);
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
	
	private void clearFiles(String workspaceRootPath) {
		File file = new File(workspaceRootPath);
		if (file.exists()) {
			deleteFile(file);
		}
	}

	private void deleteFile(File file) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				deleteFile(files[i]);
			}
		}
		file.delete();
	}
}
