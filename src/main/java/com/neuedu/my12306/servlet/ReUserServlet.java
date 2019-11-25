package com.neuedu.my12306.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.my12306.bean.reuserBean;
import com.neuedu.my12306.service.IUserinfoService;
import com.neuedu.my12306.service.impl.IUserinfoServiceImpl;
import com.neuedu.my12306.util.utils;
/**
 * 用户注册操作类
 * @author admin
 *
 */
@WebServlet("/ReUserServlet.do")
public class ReUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserinfoService userinfoService;
	public ReUserServlet() {
		userinfoService=new IUserinfoServiceImpl();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2、接收用户输入的数据防止乱码
		String reNames=request.getParameter("reNames");
		String rePass=request.getParameter("rePass");
		String reTrueName=request.getParameter("reTrueName");
		String sex=request.getParameter("sex");
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String cardTpye=request.getParameter("cardTpye");
		String idNumber=request.getParameter("idNumber");
		String passengerType=request.getParameter("passengerType");
		String tips=request.getParameter("tips");
		String birthday=request.getParameter("borthday");
		Date brithday2=utils.parseDate(birthday);
		reuserBean reuserBean=new reuserBean(reNames, rePass, reTrueName, sex, province, city, cardTpye, idNumber, passengerType, tips, brithday2);
		boolean ret=userinfoService.reg(reuserBean);
		if(ret) {
			response.sendRedirect("Login.jsp");
		}else {
			request.getRequestDispatcher("UserRegistration.jsp").forward(request, response);
			
		}
	}

}
