package com.neuedu.my12306.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.my12306.bean.reuserBean;
import com.neuedu.my12306.service.IUserinfoService;
import com.neuedu.my12306.service.impl.UserinfoServiceImpl;

/**
 * 用户登录操作类
 * @author admin
 *
 */
@WebServlet("/LoginServlet.do")
public class LoginServlet<UserinfoService> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserinfoService userinfoService;
	public LoginServlet() {
		userinfoService=new UserinfoServiceImpl();
		//使用iUserinfoService接口解耦CheckUserNameServlet与IUserinfoServiceImpl的关系
		
	}
	private String getCookieValue(Cookie[] cookies,String name) {
		if(cookies==null || name ==null) {
			return null;
		}
		for(Cookie cookie : cookies) {
			if(name.equals(cookie.getName())) {
				//在循环中的return语句如何执行?
				return cookie.getValue();
			}
		}
		return null;
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、接收数据时进行编码装换
		//2、接收用户输入的数据防止乱码
		//2、接收用户输入的参数
		String reNames=request.getParameter("reNames");
		String rePass=request.getParameter("rePass");
		String yanz=request.getParameter("yanz");
		String autoLogin=request.getParameter("autoLogin");
		
		Cookie[] cookies=request.getCookies();
		String cookiereNames=getCookieValue(cookies, "reNames");
		System.out.println(reNames);
		System.out.println(rePass);
		System.out.println(yanz);
		if(cookiereNames!=null) {
			//如果是自动登录
			reuserBean reuserBean=userinfoService.findUserById(cookiereNames);
			if(reuserBean!=null) {
				//cookie自动登录，登录自动延长7天
				Cookie cookie=new Cookie("reNames", cookiereNames);
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(7*24*60*60);
				//把cookie响应回客户端，浏览器客户端收到后会保存cookie
				response.addCookie(cookie);
				request.getSession().setAttribute("RENAMES", cookiereNames);
//				response.sendRedirect("Admin/Index.jsp");
				
				if(reuserBean.getIsAdmin()==1) {
					response.sendRedirect("Admin/Index.jsp");
				}else {
					response.sendRedirect("User/Index.jsp");
				}
				
				
			}else {
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}else {
			//正常登录流程
			
			//3、调用业务层进行登录处理
			//检查验证码是否相同
			String randString=(String)request.getSession().getAttribute("rand");
			boolean isValidateCode=randString!=null&&randString.equalsIgnoreCase(yanz);
			boolean a=false;
			//使用逻辑运算的短路特性避免绕过验证码检查
			if (isValidateCode && userinfoService.login(reNames, rePass)!=null) {
				a=true;
			}else {
				//登录失败
			}
			//4、根据业务处理结果进行返回数据或进行页面跳转
			if(a) {//登录成功进入管理页
				if(autoLogin!=null&&autoLogin.equals("autovalue")) {
					//当用户选择了自动登录，且登录成功，需要把用户信息返回到浏览器进行登录
					//cookie使用原理：（session的传递与识别就是使用了cookie技术）
					//1、服务器返回到客户端的信息可以使用cookie进行传递，服务器把数据保存到cookie中，
					//2、浏览器可以读取到服务器返回的cookie，并保存到浏览器本地
					//3、浏览器会根据访问地址和本地cookie的有效状态，在每次访问特定页面时会把cookie发送回服务器
					//4、服务器可以取得客户端发送来的cookie数据
					Cookie cookie=new Cookie("reNames", reNames);
					cookie.setPath(request.getContextPath());
					cookie.setMaxAge(7*24*60*60);
					//把cookie响应回客户端，浏览器客户端收到后会保存cookie
					response.addCookie(cookie);
					
				}
				//session进行会话跟踪
				HttpSession session=request.getSession();
				session.setAttribute("RENAMES", reNames);
//				response.sendRedirect("Admin/Index.jsp");//这是重定向
				reuserBean reuserBean=userinfoService.findUserById(reNames);
				if(reuserBean.getIsAdmin()==1) {
					response.sendRedirect("Admin/Index.jsp");
				}else {
					response.sendRedirect("User/Index.jsp");
				}
			}
			else {//登录失败返回登录页面
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				

			}
		
		}
	}

}
