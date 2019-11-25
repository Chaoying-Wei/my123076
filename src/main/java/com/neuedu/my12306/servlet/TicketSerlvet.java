package com.neuedu.my12306.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.my12306.bean.TicketBean;
import com.neuedu.my12306.service.ITicketService;
import com.neuedu.my12306.service.impl.TicketServiceImpl;
import com.neuedu.my12306.util.utils;
/**
 * 车票分页查询
 * @author admin
 *
 */
@WebServlet("/TicketSerlvet.do")
public class TicketSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITicketService iTicketService;
    public TicketSerlvet() {
        super();
        iTicketService=new TicketServiceImpl();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2、接收用户输入的数据防止乱码
		String pageString=request.getParameter("page");
		String sizeString=request.getParameter("size");
		int page=utils.parseInt(pageString, 1);
		int size=utils.parseInt(sizeString, 5);
		List<TicketBean> list=iTicketService.findTicket(page, size);
		int num=iTicketService.findNum();
		//根据总行数和分页参数进行计算分页
		int pages=num%size==0?num/size:num/size+1;//总页数的计算方法：用总行数对分页大小进行求模，能整数总页数为商，不能整除则需要加多一页
		int prePage=page-1==0?1:page-1;//上一页
		int nextPage=page+1==pages?pages:page+1;//下一页
		request.setAttribute("ticketlist", list);
		request.setAttribute("pages", pages);
		request.setAttribute("prePage", prePage);
		request.setAttribute("nextPage", nextPage);
		request.setAttribute("size", size);
		request.getRequestDispatcher("Admin/TicketQuery.jsp").forward(request, response);
		
	}

}
