package com.briup.estore.service.interfaces;

import java.util.Collection;
import java.util.Set;

import com.briup.estore.common.bean.*;
import com.briup.estore.common.exception.EstoreCommonException;

public interface IOrderService {
	void confirmOrder(Customer customer,Order order,Collection<Line> lines) throws EstoreCommonException;
	void deleteOrder(Long id) throws EstoreCommonException;
	Order findById(Long id) throws EstoreCommonException;
	Set<Order> findorder(Long id) throws EstoreCommonException;
}
