package com.neuedu.my12306.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.my12306.bean.FareBean;
import com.neuedu.my12306.dao.DBHelper;
import com.neuedu.my12306.dao.IFareDao;
/*
import oracle.net.aso.f;*/
/**
 * 车站接口实现类
 * @author admin
 *
 */
public class FareDaoImpl implements IFareDao{

	@Override
	public int findCount(FareBean fareBean) {
		int count=0;
		Connection connection=null;
		PreparedStatement pre=null;
		ResultSet rs=null;
		connection=DBHelper.getconn();
		String sql="select count(*) from fare";
		try {
			pre=connection.prepareStatement(sql);
			rs=pre.executeQuery();
			if (rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, pre, connection);
		}
		return count;
	}

	@Override
	public List<FareBean> findFare(int page, int size) {
		List<FareBean> list=new ArrayList<FareBean>();
		Connection connection=null;
		PreparedStatement pre=null;
		ResultSet rs=null;
		connection=DBHelper.getconn();
		String sql="select fareId,fareName,fProvince,fImg from (select f.*,rownum ro from fare f where rownum<=?) where ro>?";
		try {
			pre=connection.prepareStatement(sql);
			rs=pre.executeQuery();
			while (rs.next()) {
				int fareId=rs.getInt("fareId");
				String fareName=rs.getString("fareName");
				String fProvince=rs.getString("fProvince");
				String fImg=rs.getString("fImg");
				FareBean fareBean=new FareBean(fareId, fareName, fProvince, fImg);
				list.add(fareBean);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, pre, connection);
		}
		return list;
	}

	@Override
	public FareBean findFareById(int fareId) {
		FareBean fareBean=null;
		Connection connection=null;
		PreparedStatement pre=null;
		ResultSet rs=null;
		connection=DBHelper.getconn();
		String sql="select fareId,fareName,fProvince,fImg from fare where fareId=?";
		try {
			pre=connection.prepareStatement(sql);
			pre.setInt(1, fareId);
			rs=pre.executeQuery();
			if(rs.next()) {
				int fareID=rs.getInt("fareId");
				String fareName=rs.getString("fareName");
				String fProvince=rs.getString("fProvince");
				String fImg=rs.getString("fImg");
				fareBean=new FareBean(fareID, fareName, fProvince, fImg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, pre, connection);
		}
		return fareBean;
	}

	@Override
	public boolean add(FareBean fareBean) {
		boolean add=false;
		Connection connection=null;
		PreparedStatement pre=null;
		connection=DBHelper.getconn();
		String sql="insert into fare(fareId,fareName,fProvince,fImg) values(SEQ_FARE.NEXTVAL,?,?,?)";
		try {
			pre=connection.prepareStatement(sql);
			pre.setString(1, fareBean.getFareName());
			pre.setString(2, fareBean.getfProvince());
			pre.setString(3, fareBean.getfImg());
			int count=pre.executeUpdate();
			if(count==1) {
				add=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, pre, connection);
		}
		return add;
	}

	@Override
	public boolean edit(FareBean fareBean) {
		boolean edit=false;
		Connection connection=null;
		PreparedStatement pre=null;
		String sql="update fare set fareName=?,fProvince=?fImg=? where fareId=?";
		try {
			pre=connection.prepareStatement(sql);
			pre.setString(1, fareBean.getFareName());
			pre.setString(2, fareBean.getfProvince());
			pre.setString(3, fareBean.getfImg());
			pre.setInt(4, fareBean.getFareId());
			int count =pre.executeUpdate();
			if (count==1) {
				edit=true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, pre, connection);
		}
		return edit;
	}

	@Override
	public boolean deleteByIds(int[] fareIds) {
		boolean deletByIds=false;
		Connection connection=null;
		PreparedStatement pre=null;
		connection=DBHelper.getconn();
		String sql="delete from fare where fareId=?";
		try {
			pre=connection.prepareStatement(sql);
			//1、按批次添加参数
			for(int fareId:fareIds) {
				pre.setInt(1, fareId);
				pre.addBatch();
	
			}
			//批量删除可能存在某部分数据没有跟新成功，需要根据数组返回数据进行判断
			//executeBath()会返回一个大于或等于0的数组，0表示跟新失败
			int [] counts=pre.executeBatch();
			int success=0;
			for(int c:counts) {
				if(c==Statement.SUCCESS_NO_INFO||c>0) {
					success++;
				}
			}
			deletByIds=true;
			System.out.println("成功删除："+success+"条记录");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, pre, connection);
		}
		return deletByIds;
	}

}
