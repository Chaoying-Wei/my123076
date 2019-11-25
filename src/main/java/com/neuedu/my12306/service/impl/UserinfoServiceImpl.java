package com.neuedu.my12306.service.impl;

import java.util.List;

import com.neuedu.my12306.bean.reuserBean;
import com.neuedu.my12306.dao.IUserinfoDao;
import com.neuedu.my12306.dao.impl.IUserinfoDaoImpl;
import com.neuedu.my12306.service.IUserinfoService;
/**
 * 服务接口实现类
 * @author admin
 *
 */
public class UserinfoServiceImpl implements IUserinfoService {
	private IUserinfoDao userinfoDao=null;
	public UserinfoServiceImpl() {
		super();
		//this.userinfoDao = new IUserinfoDaoImpl();
	}

	@Override
	public reuserBean login(String reNames, String rePass) {
		return userinfoDao.login(reNames, rePass);
	}

	@Override
	public boolean reg(reuserBean reuserBean) {
		
		return userinfoDao.reg(reuserBean);
	}

	@Override
	public int findTotal() {
		
		return userinfoDao.findTotal();
	}

	@Override
	public List<reuserBean> findUser(int page, int size) {
		
		return userinfoDao.findUser(page, size);
	}

	@Override
	public boolean deleteByName(String[] names) {
		return userinfoDao.deleteByName(names);
	}

	@Override
	public reuserBean findUserById(String reNames) {
		return userinfoDao.findUserById(reNames);
	}

	@Override
	public boolean editUser(reuserBean reuserBean) {
		return userinfoDao.editUser(reuserBean);
	}

}
