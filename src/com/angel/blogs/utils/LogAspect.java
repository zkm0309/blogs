package com.angel.blogs.utils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ClassName:LogAspect<br/>
 * Description:<br/>
 * @author 	changboalong<br/>
 * @date 	2018-01-05 10:32:58<br/>
 */
@Aspect  
@Component
public class LogAspect {
	
//	@Resource
//	private LogService logService;
	
	//Service层切点
    @Pointcut("@annotation(com.tbwy.forest.utils.ServiceLog)")
    public void serviceAspect() {
        
    }
    //Controller层切点After
    @Pointcut("@annotation(com.tbwy.forest.utils.ControllerLog)")
    public void controllerAspect() {
    	
    }
    
    //Controller层切点Before
    @Pointcut("@annotation(com.tbwy.forest.utils.ControllerBeforeLog)")
    public void controllerBeforeAspect() {
    	
    }
    
    
    /**
     * 后置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //请求的IP
        String requestIp = request.getRemoteAddr();
        try {
            //获取用户请求方法的参数并序列化为JSON格式字符串
            Map<String, String[]> map = request.getParameterMap();
            Set<String> set = map.keySet();
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = null;
            for (String key : set) {
                jsonObject = new JSONObject();
                Object[] value = map.get(key);
                jsonObject.put(key, String.valueOf(value[0]));
                jsonArray.add(jsonObject);
                jsonObject = null;
            }
            String params = jsonArray.toString();
            String description = getControllerMethodDescription(joinPoint);
//            Account account = (Account)request.getSession().getAttribute("account");
//            if(account != null){
//            	String createBy = account.getUserName()+"("+account.getLoginName()+")";
//            	String method = joinPoint.getSignature().getName();
//            	logService.add(description, method, params, createBy, requestIp);            	
//            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     * @param joinPoint
     * @author changbaolong
     * @date 2018-01-10 09:18:33
     */
    @Before("controllerBeforeAspect()")
    public void doBefore(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //请求的IP
        String requestIp = request.getRemoteAddr();
        try {
            //获取用户请求方法的参数并序列化为JSON格式字符串
            Map<String, String[]> map = request.getParameterMap();
            Set<String> set = map.keySet();
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = null;
            for (String key : set) {
                jsonObject = new JSONObject();
                Object[] value = map.get(key);
                jsonObject.put(key, String.valueOf(value[0]));
                jsonArray.add(jsonObject);
                jsonObject = null;
            }
            String params = jsonArray.toString();
            String description = getControllerBeforeMethodDescription(joinPoint);
//            Account account = (Account)request.getSession().getAttribute("account");
//            if(account != null){
//            	String createBy = account.getUserName()+"("+account.getLoginName()+")";
//            	String method = joinPoint.getSignature().getName();
//            	logService.add(description, method, params, createBy, requestIp);            	
//            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 异常通知 用于拦截service层记录异常日志
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //读取session中的用户
        
        //获取请求ip
        String ip = request.getRemoteAddr();
        //获取用户请求方法的参数并序列化为JSON格式字符串
//        String params = "";
//        if(joinPoint.getArgs() !=   null  && joinPoint.getArgs().length > 0) {
//            for(int i = 0;i < joinPoint.getArgs().length;i++) {
//                params += joinPoint.getArgs()[i].toString() + ";";
//            }
//        }
        
        try{
        	String description = getServiceMthodDescription(joinPoint) + ":";
        	
        	
            /*========控制台输出=========*/
//            System.out.println("=====异常通知开始=====");
//            System.out.println("异常代码:" + e.getClass().getName());
//            System.out.println("异常信息:" + e.getMessage());
//            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
//            System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));
//            System.out.println("请求人:" + user.getLoginname()+"_"+user.getUsername()+"(ID:"+user.getId()+")");
//            System.out.println("请求IP:" + ip);
//            System.out.println("请求参数:" + joinPoint.getArgs());
            //利用webservice接口保存异常记录
        }catch  (Exception ex) {
        	
        }
    }
    /**
     * 获取注解中对方法的描述信息 用于service层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getServiceMthodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for(Method method : methods) {
            if(method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if(clazzs.length == arguments.length) {
                    description = method.getAnnotation(ServiceLog.class).description();
                    break;
                }
            }
        }
        return description;
    }
    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for(Method method : methods) {
            if(method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if(clazzs.length == arguments.length) {
                    description = method.getAnnotation(ControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }
    
    
    public static String getControllerBeforeMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for(Method method : methods) {
            if(method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if(clazzs.length == arguments.length) {
                    description = method.getAnnotation(ControllerBeforeLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

}
