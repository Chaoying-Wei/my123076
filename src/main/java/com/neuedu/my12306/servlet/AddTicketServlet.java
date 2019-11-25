package com.neuedu.my12306.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.my12306.bean.TicketBean;
import com.neuedu.my12306.service.ITicketService;
import com.neuedu.my12306.service.impl.TicketServiceImpl;
import com.neuedu.my12306.util.utils;
@WebServlet("/AddTicketServlet.do")
public class AddTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITicketService iTicketService;
    public AddTicketServlet() {
        super();
        iTicketService=new TicketServiceImpl();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2、接收用户输入的数据防止乱码
		String startStation=request.getParameter("startStation");
		String endStation=request.getParameter("endStation");
		
		String startDate=request.getParameter("startDate");
		Date startDate2=utils.parseDate(startDate);
		
		String startTime=request.getParameter("startTime");
		Date startTime2=utils.parseTime(startTime);
		
		String renames=request.getParameter("renames");
		System.out.println(startStation);
		System.out.println(endStation);
		System.out.println(startDate2);
		System.out.println(startTime2);
		System.out.println(renames);
		TicketBean ticketBean=new TicketBean();
		ticketBean.setStartStation(startStation);
		ticketBean.setEndStation(endStation);
		ticketBean.setStartDate(startDate2);
		ticketBean.setStartTime(startTime2);
		ticketBean.setRenames(renames);
		boolean a=iTicketService.add(ticketBean);
		if (a) {
			response.sendRedirect("TicketSerlvet.do");
		}else {
			request.getRequestDispatcher("Admin/Ticket_Add.jsp").forward(request, response);
			
		}
	}

}
