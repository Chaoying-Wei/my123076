package com.neuedu.my12306.servlet;

import java.io.IOException;
import java.util.List;

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
 * 用户列表分页查询
 * @author admin
 *
 */
@WebServlet("/UserListServlet.do")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserinfoService iUserinfoService;
   
    public UserListServlet() {
        super();
       iUserinfoService=new IUserinfoServiceImpl();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、已使用过滤器
		//2、接收用户输入的数据防止乱码
		String pageString=request.getParameter("page");
		String sizeString=request.getParameter("size");
		int page=utils.parseInt(pageString, 1);//如果转换失败就默认查询第一页
		int size=utils.parseInt(sizeString, 5);//如果转换失败就默认查询10数据
		//3、进行分页查询
		List<reuserBean> list= iUserinfoService.findUser(page, size);
		//查询出总行数
		int total=iUserinfoService.findTotal();
		//根据总行数和分页参数进行计算分页
		int pages=total%size==0?total/size:total/size+1;//总页数的计算方法：用总行数对分页大小进行求模，能整数总页数为商，不能整除则需要加多一页
		int prePage=page-1==0?1:page-1;//上一页
		int nextPage=page+1==pages?pages:page+1;//下一页
		
		//4、跳转到用户列表页面中，并把分页查询到的数据传递到列表进行显示
		request.setAttribute("userlist", list);
		request.setAttribute("pages", pages);
		request.setAttribute("prePage", prePage);
		request.setAttribute("nextPage", nextPage);
		request.setAttribute("size", size);
		request.getRequestDispatcher("Admin/UserManageQuery.jsp").forward(request, response);
		
	}

}
