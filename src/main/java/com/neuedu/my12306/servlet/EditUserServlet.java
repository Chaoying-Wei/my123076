package com.neuedu.my12306.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.neuedu.my12306.bean.reuserBean;
import com.neuedu.my12306.service.IUserinfoService;
import com.neuedu.my12306.service.impl.IUserinfoServiceImpl;
import com.neuedu.my12306.util.utils;

/**
 * <pre>
 * 	1、使用了enctype="multipart/form-data"编码提交表单数据后，不能直接使用request.getpasament()方法获取参数
 *  2、在servlet3.0,可以对servlet进行声明@MultipartConfig，声明后才能使用request.getpasament()方法获取参数
 *  3、获取文件流使用：Collection<Part> files =  request.getParts();文件流会封装到一个collection集合的part对象中
 *  4、可以遍历part集合，取出每一个文件流，并进行上传；可以一次处理多个文件上传
 * </pre>
 * @author admin
 *
 */
@WebServlet("/EditUserServlet.do")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024,
maxRequestSize = 200 * 1024 * 1024)
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserinfoService iUserinfoService;
	public EditUserServlet() {
	     super();
	     iUserinfoService=new IUserinfoServiceImpl();
	}

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String outPutFileName=null;
		String img = null;
		//2、接收用户输入的数据防止乱码
		String reNames=request.getParameter("reNames");
		String isAdmin=request.getParameter("isAdmin");
		int isAdmin2=utils.parseInt(isAdmin, 0);
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
		System.out.println(reNames);
		System.out.println(isAdmin2);
		System.out.println(reTrueName);
		System.out.println(sex); 
		System.out.println(province);
		System.out.println(city);
		System.out.println(cardTpye);
		System.out.println(idNumber);
		System.out.println(passengerType);
		System.out.println(tips);
		System.out.println(brithday2);
		
		
		//获取服务器的上传的真实目录
		String realPath=request.getServletContext().getRealPath("/");
		
		//当需要上传大量文件，需要分目录管理；目录一般需要动态生成
		//可以使用时间进行管理文件，根据上传的日期动态生成文件夹
		Calendar calendar=Calendar.getInstance();
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH)+1;
		int day=calendar.get(Calendar.DAY_OF_MONTH);
		
		//然后动态生成文件路径
		String newPath="uploads/"+year+"/"+month+"/"+day+"/";
		
		
		File realFile=new File(realPath+newPath);
		//.mkdirs()可以在不存在的目录中创建文件夹。.mkdir()只能在已经存在的目录中创建文件夹
		realFile.mkdirs();
		//所有的数据都会封装到part对象中，包括text，select，checkbox,radio,file等等
		Collection<Part> files =  request.getParts();
		 
		for(Part part:files) {
			String fileName=part.getSubmittedFileName();
				//满足这两个条件上传的才是文件，其他不是文件
			if(fileName!=null&&fileName.trim().length()!=0) {
				//这是上传的源文件名（可能有多个用户上传有名称相同的文件或有不雅的文件名），
				//一般对上传后的文件进行重命名比较好（修改文件前缀名，后缀名不能修改）
				String fileType=fileName.substring(fileName.lastIndexOf("."));//取到后缀名（最后一个点）
				//使用时间戳来重命名上传后的文件
				long nowFlieName=System.currentTimeMillis();
				
				String newFileName=newPath+nowFlieName+fileType;
				
				//把文件写入服务器的磁盘路径(重命名后的文件)
				outPutFileName=realPath+newFileName;
				System.out.println("服务器上的文件路径：：：："+outPutFileName);
				img = newFileName;
				System.out.println("工作空间上的文件路径：：：："+img);
				part.write(outPutFileName);
				//上传文件后然后删除临时文件
				part.delete();
			}
		}

		
		reuserBean reuserBean=new reuserBean(reNames, null, reTrueName, sex, province, city, cardTpye, idNumber, passengerType, tips, brithday2, isAdmin2, img);
		boolean ret=iUserinfoService.editUser(reuserBean);
		if(ret) {
			response.sendRedirect(request.getContextPath()+"/UserListServlet.do");
		}else {
			//修改失败，跳转到一个操作错误提示页面
			//页面跳转使用重定向后，需要使用httpsession传递数据
			request.getSession().setAttribute("MSG", "修改信息失败！！！");
			request.getSession().setAttribute("BACKURL", request.getContextPath()+"/UserListServlet.do");
			response.sendRedirect(request.getContextPath()+"/Admin/error.jsp");
		}
	}

}
