package com.neuedu.my12306.service.impl;

import java.util.List;

import com.neuedu.my12306.bean.FareBean;
import com.neuedu.my12306.dao.IFareDao;
import com.neuedu.my12306.dao.impl.FareDaoImpl;
import com.neuedu.my12306.service.IFareService;

public class FareServiceImpl implements IFareService{
	private IFareDao ifareDao;
	public FareServiceImpl() {
		ifareDao=new FareDaoImpl();
	}

	@Override
	public int findCount(FareBean fareBean) {
		// TODO Auto-generated method stub
		return ifareDao.findCount(fareBean);
	}

	@Override
	public List<FareBean> findFare(int page, int size) {
		// TODO Auto-generated method stub
		return ifareDao.findFare(page, size);
	}

	@Override
	public FareBean findFareById(int fareId) {
		// TODO Auto-generated method stub
		return ifareDao.findFareById(fareId);
	}

	@Override
	public boolean add(FareBean fareBean) {
		// TODO Auto-generated method stub
		return ifareDao.add(fareBean);
	}

	@Override
	public boolean edit(FareBean fareBean) {
		// TODO Auto-generated method stub
		return ifareDao.edit(fareBean);
	}

	@Override
	public boolean deleteByIds(int[] fareIds) {
		// TODO Auto-generated method stub
		return ifareDao.deleteByIds(fareIds);
	}

}
