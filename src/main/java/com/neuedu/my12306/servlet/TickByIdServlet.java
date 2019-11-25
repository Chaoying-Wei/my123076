package com.neuedu.my12306.servlet;

import java.io.IOException;
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

@WebServlet("/TickByIdServlet.do")
public class TickByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITicketService iTicketService;
    public TickByIdServlet() {
        super();
        iTicketService=new TicketServiceImpl();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2、接收用户输入的数据防止乱码
		String ticketId=request.getParameter("ticketId");
		int ticketID=utils.parseInt(ticketId, 201949);
		TicketBean ticketBean=iTicketService.findTicketById(ticketID);
		request.setAttribute("ticketID",ticketBean );
		request.getRequestDispatcher("Admin/Ticket_Edit.jsp").forward(request, response);
		
	}

}
