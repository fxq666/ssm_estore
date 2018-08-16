package com.briup.estore.service.interfaces;

import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.common.exception.EstoreCommonException;

public interface ICustomerService {
	/**
	 * 注册
	 * @param customer
	 * @throws EstoreCommonException
	 */
	void register(Customer customer) throws EstoreCommonException;
	/**
	 * 登录
	 * @param name
	 * @param password
	 * @return
	 * @throws EstoreCommonException
	 */
	Customer login(String name,String password) throws EstoreCommonException;
	/**
	 * 修改用户信息
	 * @param customer
	 * @throws EstoreCommonException
	 */
	void updateCustomer(Customer customer) throws EstoreCommonException;
	
	/**
	 * 根据名字查找对象
	 * @param name
	 * @return Customer
	 * @throws CustomerException
	 */
	Customer findCustomerName(String name) throws EstoreCommonException;
}
