package com.neuedu.my12306.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.my12306.service.IUserinfoService;
import com.neuedu.my12306.service.impl.IUserinfoServiceImpl;
/*
import oracle.net.aso.i;*/
/**
 * 批量删除
 * @author admin
 *
 */
@WebServlet("/UserDeleteByNameServlet.do")
public class UserDeleteByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserinfoService iUserinfoService;
    public UserDeleteByNameServlet() {
        super();
       iUserinfoService=new IUserinfoServiceImpl();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2、接收用户输入的数据防止乱码 
		String[] reNames=request.getParameterValues("reNames");
		boolean a=iUserinfoService.deleteByName(reNames);
		if(a) {
			response.sendRedirect(request.getContextPath()+"/UserListServlet.do");
		}else {
			//删除失败，跳转到一个操作错误提示页面
			//页面跳转使用重定向后，需要使用httpsession传递数据
			request.getSession().setAttribute("MSG", "批量删除用户信息失败");
			request.getSession().setAttribute("BACKURL", request.getContextPath()+"/UserListServlet.do");
			response.sendRedirect(request.getContextPath()+"/Admin/error.jsp");
		}
	}

}
