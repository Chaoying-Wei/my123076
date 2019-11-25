package com.neuedu.my12306.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	private String filterEncoding="ISO-8859-1";
	public EncodingFilter() {
		System.out.println("encodingFilter过滤器的构造方法初始化过滤器");
	}

	@Override
	public void destroy() {
		
		System.out.println("encodingFilter过滤器的destroy方法初始化过滤器");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(filterEncoding);
		response.setCharacterEncoding(filterEncoding);
		System.out.println("encodingFilter过滤器的doFilter方法初始化过滤器");
		System.out.println("-----------encodingFilter过滤器--before--------");
		//在dofilter方法内部调用dofilter，把请求传递到下一个过滤器或者其他servlet或jsp
		chain.doFilter(request, response);
		System.out.println("-----------encodingFilter过滤器---after--------");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("encodingFilter过滤器的init方法初始化过滤器");
		//项目一启动就开始初始化编码格式
		String encoding=filterConfig.getInitParameter("encoding");
		if(encoding!=null) {
			filterEncoding=encoding;
		}
		
	}

}
