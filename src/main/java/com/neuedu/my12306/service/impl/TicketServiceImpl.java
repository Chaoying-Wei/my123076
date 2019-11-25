package com.neuedu.my12306.service.impl;

import java.util.List;

import com.neuedu.my12306.bean.TicketBean;
import com.neuedu.my12306.dao.ITicketDao;
import com.neuedu.my12306.dao.impl.TicketDaoImpl;
import com.neuedu.my12306.service.ITicketService;
/**
 * 服务接口实现类
 * @author admin
 *
 */
public class TicketServiceImpl implements ITicketService{
	private ITicketDao itcketDao;
	public TicketServiceImpl() {
		super();
		this.itcketDao=new TicketDaoImpl();
	}

	@Override
	public boolean add(TicketBean ticketBean) {
		
		return itcketDao.add(ticketBean);
	}

	@Override
	public int findNum() {
		
		return itcketDao.findNum();
	}

	@Override
	public List<TicketBean> findTicket(int page, int size) {
		
		return itcketDao.findTicket(page, size);
	}

	@Override
	public boolean edit(TicketBean ticketBean) {
		
		return itcketDao.edit(ticketBean);
	}

	@Override
	public boolean delete(TicketBean ticketBean) {
		// TODO Auto-generated method stub
		return itcketDao.delete(ticketBean);
	}

	@Override
	public boolean deleteById(int[] ids) {
		// TODO Auto-generated method stub
		return itcketDao.deleteById(ids);
	}

	@Override
	public TicketBean findTicketById(int ticketId) {
		// TODO Auto-generated method stub
		return itcketDao.findTicketById(ticketId);
	}

}
