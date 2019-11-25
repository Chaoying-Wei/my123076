package com.neuedu.my12306.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 * 设计一个jdbc操作工具类，用于封装通用操作
 * @author admin
 *
 */
public class DBHelper {
	//封装4个参数
	/*private static final String driver="oracle.jdbc.driver.OracleDriver";
	private static final String url="jdbc:oracle:thin://localhost:1521/orcl";*/
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/my12306";
	private static final String user="root";
	private static final String password="123456";
	//连接数据库
	public static Connection getconn() {
		Connection conn=null;
		//查询tomcat服务器是否配置了连接池
		try {
			Context ctxContext=new InitialContext();
//			方法1
//			Context envContext=(Context)ctxContext.lookup("java:/comp/env");
//			DataSource dataSource=(DataSource)envContext.lookup("jdbc/webdb");
			
//			方法二
			DataSource dataSource=(DataSource)ctxContext.lookup("java:/comp/env/jdbc/webdb");
			conn=dataSource.getConnection();
		} catch (NamingException | SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			if(conn!=null) {
				System.out.println("通过连接池获取数据库连接");
			}else {
				Class.forName(driver);
				conn=DriverManager.getConnection(url, user, password);
				System.out.println("使用连接池获取连接失败，使用jdbc重新获取数据库的连接");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
		return conn;
	}
	
	//关闭数据库
	public static void close(ResultSet rs,PreparedStatement stmt,Connection conn) {
		//这个一个标准的关闭动作
				if(rs!=null) {
					try {
						rs.close();
					} catch (SQLException e) {
					}
				}
				if(stmt!=null) {
					try {
						stmt.close();
					} catch (SQLException e) {
					}
				}
				
				if(conn!=null) {
					try {
						conn.close();
					} catch (SQLException e) {
					}
				}
	}

}
