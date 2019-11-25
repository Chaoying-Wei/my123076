package com.neuedu.my12306.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OutLoginServlet
 */
@WebServlet("/OutLoginServlet.do")
public class OutLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public OutLoginServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		//当参数为true时，功能与空参方法相同；即获取当前请求所在的session，如果session不存在则新建立一个session并返回
		//session=request.getSession(true);
		//当参数为false时，会话返回当前请求所在的session，如果session不存在（或session失效）则返回null；
		//session=request.getSession(false);
		
		//删除属性session绑定方法一
		session.removeAttribute("RENAMES");
		//删除属性session方法二（session创建后，如果没有新的操作到服务器，则session过一段时间会自动失效（默认是30分钟））
		//session.setMaxInactiveInterval(0);设置会话自动失效的时间，单位是秒
		//删除属性session绑定方法三:session.invalidate();且删除所有绑定的数据
		//session.invalidate();
		
		//在服务端清cookie，需要写一个同名同路径的cookie到客户端，并且把cookie的有效期设置为0
		Cookie cookie=new Cookie("reNames", null);
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(0);
		//把cookie响应回客户端，浏览器客户端收到后会保存cookie
		response.addCookie(cookie);
		
		response.sendRedirect(request.getContextPath()+"/Login.jsp");
	}

}
