package com.neuedu.my12306.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neuedu.my12306.bean.TicketBean;
import com.neuedu.my12306.bean.reuserBean;
import com.neuedu.my12306.dao.DBHelper;
import com.neuedu.my12306.dao.ITicketDao;
/**
 * 车票接口实现类
 * @author admin
 *
 */
public class TicketDaoImpl implements ITicketDao{

	/**
	 * 新增车票信息
	 */
	@Override
	public boolean add(TicketBean ticketBean) {
		boolean a=false;
		Connection connection=null;
		PreparedStatement pre=null;
		connection=DBHelper.getconn();
		String sql="insert into TICKET(ticketId,startStation,endStation,startDate,startTime,renames) values(SEQ_TICKTE.NEXTVAL,?,?,?,?,?)";
		try {
			pre=connection.prepareStatement(sql);
			pre.setString(1, ticketBean.getStartStation());
			pre.setString(2, ticketBean.getEndStation());
			pre.setDate(3, new java.sql.Date(ticketBean.getStartDate().getTime()));
			pre.setTimestamp(4, new Timestamp(ticketBean.getStartTime().getTime()));
			pre.setString(5, ticketBean.getRenames());
			int count=pre.executeUpdate();
			if(count==1) {
				a=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, pre, connection);
		}
		return a;
	}

	/**
	 * 查询车票记录总数
	 */
	@Override
	public int findNum() {
		int num=0;
		Connection connection=null;
		PreparedStatement pre=null;
		ResultSet rs=null;
		String sql="select count(*) from ticket";
		try {
			connection=DBHelper.getconn();
			pre=connection.prepareStatement(sql);
			rs=pre.executeQuery();
			if (rs.next()) {
				num=rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, pre, connection);
		}
		return num;
	}

	/**
	 * 查询车票信息并分页显示
	 */
	@Override
	public List<TicketBean> findTicket(int page, int size) {
		List<TicketBean> list=new ArrayList<TicketBean>();
		Connection connection=null;
		PreparedStatement pre=null;
		ResultSet rs=null;
		connection=DBHelper.getconn();
		String sql="select ticketId,startStation,endStation,startDate,startTime,renames from (select t.*,rownum ro from ticket t where rownum <=?) where ro>?";
		try {
			pre=connection.prepareStatement(sql);
			pre.setInt(1, page*size);
			pre.setInt(2, (page-1)*size);
			rs=pre.executeQuery();
			while (rs.next()) {
				int ticketId=rs.getInt("ticketId");
				String startStation=rs.getString("startStation");
				String endStation =rs.getString("endStation");
				Date startDate=rs.getDate("startDate");
				Date startTime=rs.getTime("startTime");
				String renames=rs.getString("renames");
				TicketBean ticketBean=new TicketBean(ticketId, startStation, endStation, startDate, startTime, renames);
				list.add(ticketBean);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, pre, connection);
		}
		return list;
	}

	@Override
	public boolean edit(TicketBean ticketBean) {
		boolean ret = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		connection = DBHelper.getconn();
		String sql = "update ticket set startStation=?,endStation=?,startDate=?,startTime=? where ticketId=?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, ticketBean.getStartStation());
			pstmt.setString(2, ticketBean.getEndStation());
			pstmt.setDate(3, new java.sql.Date(ticketBean.getStartDate().getTime()));
			pstmt.setTimestamp(4, new Timestamp(ticketBean.getStartTime().getTime()));
			pstmt.setInt(5, ticketBean.getTicketId());
			int count = pstmt.executeUpdate();
			if(count==1) {
				ret = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, pstmt, connection);
		}
		return ret;
	}

	@Override
	public boolean delete(TicketBean ticketBean) {
		
		return false;
	}

	
	/**
	 * 根据id批量删除
	 */
	@Override
	public boolean deleteById(int[] ids) {
		boolean a=false;
		Connection connection=null;
		PreparedStatement pre=null;
		connection=DBHelper.getconn();
		String sql="delete from ticket where ticketId=?";
		try {
			pre=connection.prepareStatement(sql);
			//按批次添加参数
			for(int ticketId:ids) {
				pre.setInt(1, ticketId);
				pre.addBatch();
			}
			//批量更新可能存在某部分数据没有更新成功，需要根据数组返回数据进行判断
			//executeBatch()会返回一个大于或等于0的数组，0表示更新失败
			int[] counts=pre.executeBatch();
			int success=0;
			for (int c : counts) {
				System.out.println(Statement.SUCCESS_NO_INFO + " ------- " + c);
				if (c == Statement.SUCCESS_NO_INFO || c > 0) {
					success++;
				}
			}
			a=true;
			System.out.println("成功删除  "+success+" 条记录");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBHelper.close(null, pre, connection);
		}
		return a;
	}
	/**
	 * 根据id查找信息
	 */
	@Override
	public TicketBean findTicketById(int ticketId) {
		TicketBean ticketBean=null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		connection = DBHelper.getconn();
		String sql = "select ticketId,startStation,endStation,startDate,startTime,renames from ticket where ticketId=?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, ticketId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int ticketID=rs.getInt("ticketId");
				String startStation=rs.getString("startStation");
				String endStation =rs.getString("endStation");
				Date startDate=rs.getDate("startDate");
				Date startTime=rs.getTime("startTime");
				String renames=rs.getString("renames");
				ticketBean=new TicketBean(ticketID, startStation, endStation, startDate, startTime, renames);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, pstmt, connection);
		}
		return ticketBean;
	}

}
