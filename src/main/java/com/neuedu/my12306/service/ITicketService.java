package com.neuedu.my12306.service;

import java.util.List;

import com.neuedu.my12306.bean.TicketBean;

public interface ITicketService {
	/**
	 * 添加车票信息
	 * @param ticketBean
	 * @return
	 */
	public boolean add(TicketBean ticketBean);
	/**
	 * 查询车票记录总数，用于进行分页参数控制
	 * @return
	 */
	public int findNum();
	/**
	 * 分页查询
	 * @param page
	 * @param size
	 * @return
	 */
	public List<TicketBean> findTicket(int page,int size);
	/**
	 * 修改
	 * @param ticketBean
	 * @return
	 */
	public boolean edit(TicketBean ticketBean);
	/**
	 * 删除
	 * @param ticketBean
	 * @return
	 */
	public boolean delete(TicketBean ticketBean);
	/**
	 * 根据id批量删除
	 * @param ids
	 * @return
	 */
	public boolean deleteById(int [] ids);
	/**
	 * 根据查找信息
	 * @param ticketId
	 * @return
	 */
	public TicketBean findTicketById(int ticketId);


}
