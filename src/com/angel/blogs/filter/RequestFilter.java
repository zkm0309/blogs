package com.angel.blogs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
* @ClassName: RequestFilter
* @Description: RequestFilter
* @author zkm
* @date  2018-08-28 10:28
 */
public class RequestFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RequestFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("拦截器销毁...blogs....");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        String url = httpRequest.getRequestURI();
        String method = httpRequest.getMethod();
       
        if((url.indexOf(".do") > 0 && url.indexOf("login.do") <= 0) || url.indexOf(".jsp") > 0){
        	if(session.getAttribute("account") == null && url.indexOf("getPhoneById.do") < 0){
        		httpRequest.getRequestDispatcher("/login.jsp").forward(httpRequest, response);
        	}else{
        		chain.doFilter(request, response);
        	}
        }else{
        	chain.doFilter(request, response);
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("拦截器初始化....blogs....");
	}
}
