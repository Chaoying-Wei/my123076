package com.neuedu.my12306.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * 登录过滤器
 * @author admin
 *
 */
public class LoginFilter implements Filter{
	@Override
	public void destroy() {
		System.out.println("LoginFilter过滤器执行destroy方法");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoginFilter过滤器执行doFilter方法    -----before");
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		//取出当前请求的网络资源地址，req.getRequestURI()不带请求参数；（URL则是带请求参数）
		String uirString=req.getRequestURI();
		
		Object loginUser= req.getSession().getAttribute("RENAMES");
		//如果登录成功才可以跳转到首页 或 没有登录的用户可以执行登录||注册
		//使用登录控制器后可能会拦截某些必要的操作，需要在登录控制器中进行排除
		if(loginUser!=null||uirString.indexOf("LoginServlet.do")!=-1||uirString.indexOf("ReUserServlet.do")!=-1) {
			//在过滤器中，必须编写chain.doFilter(request, response);，把请求交给下一个过滤器或者其他网络资源
			chain.doFilter(request, response);
			System.out.println("LoginFilter过滤器执行doFilter方法  --------after");
			
		}else {//没有登录回到登录页面
			res.sendRedirect(req.getContextPath()+"/Login.jsp");
		}
		
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("LoginFilter过滤器执行init方法");
	}

}
