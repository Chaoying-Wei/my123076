package com.neuedu.my12306.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.my12306.bean.TicketBean;
import com.neuedu.my12306.bean.reuserBean;
import com.neuedu.my12306.service.ITicketService;
import com.neuedu.my12306.service.impl.TicketServiceImpl;
import com.neuedu.my12306.util.utils;

/**
 * Servlet implementation class EditTicketServlet
 */
@WebServlet("/EditTicketServle.do")
public class EditTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITicketService iTicketService;
    public EditTicketServlet() {
        super();
        iTicketService=new TicketServiceImpl();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2、接收用户输入的数据防止乱码
		String tickIdString=request.getParameter("ticketId");
		int tickId=utils.parseInt(tickIdString, 201949);
		String startStation=request.getParameter("startStation");
		String endStation=request.getParameter("endStation");
		
		String startDate=request.getParameter("startDate");
		Date startDate2=utils.parseDate(startDate);
		
		String startTime=request.getParameter("startTime");
		Date startTime2=utils.parseTime(startTime);
		TicketBean ticketBean=new TicketBean(tickId, startStation, endStation, startDate2, startTime2, null);
		boolean ret=iTicketService.edit(ticketBean);
		if(ret) {
			response.sendRedirect(request.getContextPath()+"/TicketSerlvet.do");
		}else {
			//修改失败，跳转到一个操作错误提示页面
			//页面跳转使用重定向后，需要使用httpsession传递数据
			request.getSession().setAttribute("MSG", "修改信息失败！！！");
			request.getSession().setAttribute("BACKURL", request.getContextPath()+"/TicketSerlvet.do");
			response.sendRedirect(request.getContextPath()+"/Admin/error.jsp");
		}
	}

}
