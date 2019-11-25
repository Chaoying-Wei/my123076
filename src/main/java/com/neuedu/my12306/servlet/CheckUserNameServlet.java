package com.neuedu.my12306.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.neuedu.my12306.bean.reuserBean;
import com.neuedu.my12306.service.IUserinfoService;
import com.neuedu.my12306.service.impl.IUserinfoServiceImpl;

@WebServlet("/CheckUserNameServlet")
public class CheckUserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserinfoService iUserinfoService;
	public CheckUserNameServlet() {
		super();
		iUserinfoService=new IUserinfoServiceImpl();
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reNames=request.getParameter("reNames");
		
		boolean exists=false;
		if(reNames!=null) {
			reuserBean reuser=iUserinfoService.findUserById(reNames);
			if(reuser!=null) {
				exists=true;
			}
		}
		String result="";
		Result result2=null;
		if (exists) {
			 result2=new Result(true, "该账号已经存在！请重新输入!");
			
		}else {
			 result2=new Result(false, "该账号可以使用!");
			
		}
		//使用fastjon把java对象换成json字符串
		result=JSON.toJSONString(result2);
		System.out.println("最后查询结果："+result);
		//返回数据类型给浏览器，数据是json格式的数据是json字符串
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(result);
	}
	//内部类
	class Result{
		private boolean result;
		private String msg;
		public boolean isResult() {
			return result;
		}
		public void setResult(boolean result) {
			this.result = result;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public Result() {
			super();
		}
		public Result(boolean result, String msg) {
			super();
			this.result = result;
			this.msg = msg;
		}
		
	}

}
