package com.briup.estore.dao;


import java.util.Set;

import com.briup.estore.common.bean.Order;

public interface IOrderDao  {
	public void saveOrder(Order order);
	public Order findOrderById(Long id);
	public void deleteOrder(Long id);
	public Set<Order> findorderByCustomerId(Long id);
}
