package com.briup.estore.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.exception.EstoreCommonException;
import com.briup.estore.common.util.MD5;
import com.briup.estore.dao.ICustomerDao;
import com.briup.estore.service.interfaces.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerDao customerDao;
	/**
	 * 用户注册
	 */
	@Override
	public void register(Customer customer) throws EstoreCommonException {
        if (customer == null) {
			throw EstoreCommonException.getException(401);
		}
        customer.setPassword(MD5.getMD5Str(customer.getPassword()));//密码加密
		customerDao.saveCustomer(customer);
		
		
	}
	/**
	 * 用户登录
	 */
	@Override
	public Customer login(String name, String password) throws EstoreCommonException {
		if (StringUtils.isBlank(name) || StringUtils.isBlank(password)) {
			throw EstoreCommonException.getException(401);
		}
		Customer findByName = customerDao.findByName(name);
		String pwd = findByName.getPassword();
		if (findByName.getName()==null) {
			throw EstoreCommonException.getException(404);
			}
		if (!pwd.equals(MD5.getMD5Str(password))) {
			throw EstoreCommonException.getException(402);
		}
		return findByName;
	}

	/**
	 * 修改用户信息
	 */
	@Override
	public void updateCustomer(Customer customer) throws EstoreCommonException {
    	 Customer customer2 = customerDao.findByName(customer.getName());
    	 if(customer2 == null) {
    		 throw EstoreCommonException.getException(404);
    	 }
    	 customer2.setAddress(customer.getAddress());
    	 customer2.setEmail(customer.getEmail());
    	 customer2.setPassword(customer.getPassword());
    	 customer2.setTelephone(customer.getTelephone());
    	 customer2.setZip(customer.getZip());
		 customerDao.updateCustomer(customer);
		
	}
    
	/**
	 * 根据用户名查找用户
	 */
	@Override
	public Customer findCustomerName(String name) throws EstoreCommonException {
		if(StringUtils.isBlank(name)) {
			throw EstoreCommonException.getException(401);
		}
		return customerDao.findByName(name);
	}

}
