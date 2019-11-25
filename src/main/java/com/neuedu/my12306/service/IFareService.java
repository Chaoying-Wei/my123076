package com.neuedu.my12306.service;

import java.util.List;

import com.neuedu.my12306.bean.FareBean;

/**
 * 车站服务类接口
 * @author admin
 *
 */
public interface IFareService {
	/**
	 * 查找总记录数（为分页准备）
	 * @param fareBean
	 * @return
	 */
	public int findCount(FareBean fareBean);
	/**
	 * 查找所有信息并分页
	 * @param page
	 * @param size
	 * @return
	 */
	public List<FareBean> findFare(int page,int size);
	/**
	 * 通过id查找
	 * @param fareId
	 * @return
	 */
	public FareBean findFareById(int fareId);
	/**
	 * 添加
	 * @param fareBean
	 * @return
	 */
	public boolean add(FareBean fareBean);
	/**
	 * 修改
	 * @param fareBean
	 * @return
	 */
	public boolean edit(FareBean fareBean);
	/**
	 * 通过id批量删除
	 * @param fareIds
	 * @return
	 */
	public boolean deleteByIds(int[] fareIds);
	
}
