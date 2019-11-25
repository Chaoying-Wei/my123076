package com.neuedu.my12306.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.my12306.service.ITicketService;
import com.neuedu.my12306.service.impl.TicketServiceImpl;
import com.neuedu.my12306.util.utils;

/**
 * Servlet implementation class TicketDeleteByIdServlet
 */
@WebServlet("/TicketDeleteByIdServlet.do")
public class TicketDeleteByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITicketService iTicketService;
    
    public TicketDeleteByIdServlet() {
        super();
        iTicketService=new TicketServiceImpl();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2、接收用户输入的数据防止乱码
		 
		String[] ticketId=request.getParameterValues("ticketId");
		int[] ticketIds=utils.stringToInt(ticketId);
		boolean a=iTicketService.deleteById(ticketIds);
		if(a) {
			response.sendRedirect(request.getContextPath()+"/TicketSerlvet.do");
		}else {
			//删除失败，跳转到一个操作错误提示页面
			//页面跳转使用重定向后，需要使用httpsession传递数据
			request.getSession().setAttribute("MSG", "批量删除用户信息失败");
			request.getSession().setAttribute("BACKURL", request.getContextPath()+"/TicketSerlvet.do");
			response.sendRedirect(request.getContextPath()+"/Admin/error.jsp");
		}
	}

}
