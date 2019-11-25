package com.neuedu.my12306.servlet;

import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import com.neuedu.my12306.bean.reuserBean;

public class SessionListener implements ServletContextListener, HttpSessionAttributeListener {
	private ServletContext context;
	private Map<String, String> onlineUserMap ;

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// 当调用sessoin.setAttribute()方法时，这个方法会自动执行;即tomcat服务器会自动调用该方法
		// 注意：每次调用sessoin.setAttribute()方法时,都会触发该事件
		HttpSession session = event.getSession();
		System.out.println("session id-----"+session.getId());
		String reNames = (String) session.getAttribute("RENAMES");
		if (reNames != null) {
			onlineUserMap.put(reNames, reNames);
			System.out.println(reNames + " :::::::::::::上线了,当前在线用户数："+onlineUserMap.size());
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		System.out.println("session id-----"+session.getId());
		
		String attributeName = event.getName();
		if ("RENAMES".contentEquals(attributeName)) {
			String reNames=(String )event.getValue();
			if(reNames!=null) {
				onlineUserMap.remove(reNames);
				System.out.println(reNames + " ::::::::::::::::::::下线了,当前在线用户数："+onlineUserMap.size());
			}
			
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		String attributeName = event.getName();
		if ("RENAMES".contentEquals(attributeName)) {
			String reNames=(String )event.getValue();
			if(reNames!=null) {
				onlineUserMap.put(reNames, reNames);
				System.out.println(reNames + " ::::::::::::::::::::shang上线了,当前在线用户数："+onlineUserMap.size());
			}
			
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("执行contextDestroyed方法，监听服务器是否正在关闭,需要服务器正常关闭才会执行！");
		context = sce.getServletContext();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 当服务器启动时，监听服务器启动后，创建ServletContext对象
		System.out.println("执行contextInitialized方法，监听服务器是否启动成功！");
		context = sce.getServletContext();
		onlineUserMap = new Hashtable<String, String>();
		context.setAttribute("ONLINES", onlineUserMap);
	}

}
