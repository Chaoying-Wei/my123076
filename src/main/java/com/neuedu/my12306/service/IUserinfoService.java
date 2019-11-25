package com.neuedu.my12306.service;

import com.neuedu.my12306.bean.reuserBean;
/**
 * 用户服务接口
 * @author admin
 *
 */
public interface IUserinfoService {
	public reuserBean login(String reNames,String rePass);
	public boolean reg(reuserBean reuserBean);
	/**
	 * 查询记录总数，用于进行分页参数控制
	 * @return
	 */
	public int findTotal();
	/**
	 * 
	 * @param page 查询第page页
	 * @param size 每页查询size条
	 * @return
	 */
	public java.util.List<reuserBean> findUser(int page,int size);
	/**
	 * 根据用户批量删除
	 * @param names
	 * @return
	 */
	public boolean deleteByName(String [] names);
	/**
	 * 根据用户账号查询用户信息
	 * @param reNames
	 * @return
	 */
	public reuserBean findUserById(String reNames);
	/**
	 * 修改用户信息
	 * @param reuserBean
	 * @return
	 */
	public boolean editUser(reuserBean reuserBean);
	
	
}
