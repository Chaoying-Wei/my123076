package com.neuedu.my12306.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neuedu.my12306.bean.reuserBean;
import com.neuedu.my12306.dao.DBHelper;
import com.neuedu.my12306.dao.IUserinfoDao;
/**
 * 用户接口实现类
 * @author admin
 *
 */
public class IUserinfoDaoImpl implements IUserinfoDao{
	/**
	 *登录
	 */
	@Override
	public reuserBean login(String reNames, String rePass) {
		System.out.println("=====================数据库111111111111111111111111=================================");
		reuserBean reuserBean=null;
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		connection=DBHelper.getconn();
		String sql = "select reNames,rePass,reTrueName,sex,province,city,cardTpye,idNumber,passengerType,tips,borthday,isAdmin,img "
				+ "from reuser where reNames=? and rePass=?";
		System.out.println("=====================数据库22222222222222222222=================================");
		try {
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, reNames);
			System.out.println("=====================数据库=================================");
			pstmt.setString(2, rePass);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				String reTrueName=rs.getString("reTrueName");
				String sex=rs.getString("sex");
				String province=rs.getString("province");
				String city=rs.getString("city");
				String cardTpye=rs.getString("cardTpye");
				String idNumber=rs.getString("idNumber");
				String passengerType=rs.getString("passengerType");
				String tips=rs.getString("tips");
				Date brithday=rs.getDate("borthday");
				int isAdmin=rs.getInt("isAdmin");
				String img=rs.getString("img");
				reuserBean = new reuserBean(reNames, rePass, reTrueName, sex, province, city, cardTpye, idNumber, passengerType, tips, brithday, isAdmin, img);


			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, pstmt, connection);
		}
		
		return reuserBean;
	}
	/**
	 * 注册
	 */
	@Override
	public boolean reg(reuserBean reuserBean) {
		boolean ret=false;
		Connection connection=null;
		PreparedStatement pstmt=null;
		connection=DBHelper.getconn();
		String sql="insert into reuser(reNames,rePass,reTrueName,sex,province,city,cardTpye,idNumber,passengerType,tips,borthday) values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, reuserBean.getReNames());
			pstmt.setString(2, reuserBean.getRePass());
			pstmt.setString(3, reuserBean.getReTrueName());
			pstmt.setString(4, reuserBean.getSex());
			pstmt.setString(5, reuserBean.getProvince());
			pstmt.setString(6, reuserBean.getCity());
			pstmt.setString(7, reuserBean.getCardTpye());
			pstmt.setString(8, reuserBean.getIdNumber());
			pstmt.setString(9, reuserBean.getPassengerType());
			pstmt.setString(10, reuserBean.getTips());
			pstmt.setDate(11, new java.sql.Date(reuserBean.getBirthday().getTime()));
			int count =pstmt.executeUpdate();
			if (count ==1) {
				ret= true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBHelper.close(null, pstmt, connection);
		}
		
		return ret;
	}
	/**
	 * 查询记录总数
	 */
	@Override
	public int findTotal() {
		int total = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		connection = DBHelper.getconn();
		String sql = "select count(*)  from reuser ";
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total=rs.getInt(1);//查询记录总数的sql返回一行一列数据，即只返回记录总数
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, pstmt, connection);
		}
		return total;

	}
	@Override
	public List<reuserBean> findUser(int page, int size) {
		List<reuserBean> list=new ArrayList<reuserBean>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		connection = DBHelper.getconn();
		String sql = "select reNames,rePass,reTrueName,sex,province,city,cardTpye,idNumber,passengerType,tips,borthday "
				+ "from (select r.*,rownum ro from reuser r where rownum <=?)"
				+ " where ro>?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, page*size);
			pstmt.setInt(2, (page-1)*size);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String reNames=rs.getString("reNames");
				String rePass=rs.getString("rePass");
				String reTrueName=rs.getString("reTrueName");
				String sex=rs.getString("sex");
				String province=rs.getString("province");
				String city=rs.getString("city");
				String cardTpye=rs.getString("cardTpye");
				String idNumber=rs.getString("idNumber");
				String passengerType=rs.getString("passengerType");
				String tips=rs.getString("tips");
				Date brithday=rs.getDate("borthday");
				reuserBean reuserBean=new reuserBean(reNames, rePass, reTrueName, sex, province, city, cardTpye, idNumber, passengerType, tips, brithday);
				list.add(reuserBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, pstmt, connection);
		}
		return list;
	}
	/**
	 * 根据用户账号批量删除
	 */
	@Override
	public boolean deleteByName(String[] names) {
		boolean ret=false;
		Connection connection=null;
		PreparedStatement pstmt=null;
		connection=DBHelper.getconn();
		//超级管理员不能删除
		String sql="delete from reuser where reNames=? and isAdmin!=-1";
		try {
			pstmt=connection.prepareStatement(sql);
			//按批次添加参数
			for(String reNames:names) {
				pstmt.setString(1, reNames);
				pstmt.addBatch();
			}
			//批量跟新时可能存在部分数据没有更新成功；需要根据数组的返回值进行判断
			//executebatch会返回一个有大于或等于0数组，0表示更新失败
			int [] counts=pstmt.executeBatch();
			int success=0;
			for (int c : counts) {
				System.out.println(Statement.SUCCESS_NO_INFO + " ++++++++++++++++++++==  " + c);
				if (c == Statement.SUCCESS_NO_INFO || c > 0) {
					success++;
				}
			}
			System.out.println("成功删除  "+success+" 条记录");
			ret=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(null, pstmt, connection);
		}
		return ret;
	}
	/**
	 * 根据用户账号查找用户信息
	 */
	@Override
	public reuserBean findUserById(String reNames) {
		reuserBean reuserBean=null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		connection = DBHelper.getconn();
		String sql = "select reNames,rePass,reTrueName,sex,province,city,cardTpye,idNumber,passengerType,tips,borthday,isAdmin,img "
				+ "from reuser where reNames=?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, reNames);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String rePass=rs.getString("rePass");
				String reTrueName=rs.getString("reTrueName");
				String sex=rs.getString("sex");
				String province=rs.getString("province");
				String city=rs.getString("city");
				String cardTpye=rs.getString("cardTpye");
				String idNumber=rs.getString("idNumber");
				String passengerType=rs.getString("passengerType");
				String tips=rs.getString("tips");
				Date brithday=rs.getDate("borthday");
				int isAdmin=rs.getInt("isAdmin");
				String img=rs.getString("img");
				reuserBean = new reuserBean(reNames, rePass, reTrueName, sex, province, city, cardTpye, idNumber, passengerType, tips, brithday, isAdmin, img);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, pstmt, connection);
		}
		return reuserBean;
	}
	/**
	 * 修改用户信息
	 */
	@Override
	public boolean editUser(reuserBean reuserBean) {
		boolean ret = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		connection = DBHelper.getconn();
		// 超级管理员不能修改，或另外做接口进行修改
		String sql = "update reuser set reTrueName=?,sex=?,province=?,city=?,"
				+ "cardTpye=?,idNumber=?,passengerType=?,tips=?,borthday=?,isAdmin=?,img=? "
				+ "  where reNames=? and isAdmin !=-1 ";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, reuserBean.getReTrueName());
			pstmt.setString(2, reuserBean.getSex());
			pstmt.setString(3, reuserBean.getProvince());
			pstmt.setString(4, reuserBean.getCity());
			pstmt.setString(5, reuserBean.getCardTpye());
			pstmt.setString(6, reuserBean.getIdNumber());
			pstmt.setString(7, reuserBean.getPassengerType());
			pstmt.setString(8, reuserBean.getTips());
			// 时间精度只保留年月日，可以使用java.sql.Date进行保存数据：把util.Date转换sql.Date
			pstmt.setDate(9, new java.sql.Date(reuserBean.getBirthday().getTime()));
			pstmt.setInt(10, reuserBean.getIsAdmin());
			pstmt.setString(11, reuserBean.getImg());
			pstmt.setString(12, reuserBean.getReNames());
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

}
