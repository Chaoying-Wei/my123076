package com.neuedu.my12306.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.my12306.bean.reuserBean;
import com.neuedu.my12306.service.IUserinfoService;
import com.neuedu.my12306.service.impl.IUserinfoServiceImpl;

@WebServlet("/UserByIdServlet2.do")
public class UserByIdServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserinfoService iUserinfoService;
    public UserByIdServlet2() {
        super();
        iUserinfoService=new IUserinfoServiceImpl();
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2、接收用户输入的数据防止乱码
		String reNames=request.getParameter("reNames");
		
		reuserBean reuserBean=iUserinfoService.findUserById(reNames);
		request.setAttribute("reNames",reuserBean );
		request.getRequestDispatcher("User/UserManageInfo.jsp").forward(request, response);
		
	}

}
