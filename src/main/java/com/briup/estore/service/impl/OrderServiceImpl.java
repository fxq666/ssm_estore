package com.briup.estore.service.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.bean.Line;
import com.briup.estore.common.bean.Order;
import com.briup.estore.common.exception.EstoreCommonException;
import com.briup.estore.dao.ILineDao;
import com.briup.estore.dao.IOrderDao;
import com.briup.estore.service.interfaces.IOrderService;

/**
 * 订单处理
 * @author ying
 *2018-7-31
 */
@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private IOrderDao orderDao;
	@Autowired
	private ILineDao lineDao;
	
    /**
     * 保存订单
     */
	@Override
	public void confirmOrder(Customer customer, Order order, Collection<Line> lines) throws EstoreCommonException {
//		Order order2=new Order();
//		order2.setId(order.getId());
//		order2.setCost(order.getCost());
//		order2.setCustomer(customer);
//		order2.setOrderDate(new Date());
//		order2.setPayway(order.getPayway());
		orderDao.saveOrder(order);
		if(order!=null){
		Iterator<Line> iterator=lines.iterator();
		while (iterator.hasNext()) {
			Line line = (Line) iterator.next();
			line.setOrder(order);
			lineDao.saveLine(line);
		}
		}
	}

	/**
	 * 删除订单
	 */
	@Override
	public void deleteOrder(Long id) throws EstoreCommonException {
//		Order order=new Order();
//		order.setId(id);
//		Line line=new Line();
//		line.setOrder(order);
		Set<Line> lines= lineDao.findorderLine(id);
		if (lines == null) {
			throw EstoreCommonException.getException(404);
			
		}	
			lineDao.deleteOrderLine(id);
			Order order2 = orderDao.findOrderById(id);
			if (order2 == null) {
				throw EstoreCommonException.getException(404);	
			}
			orderDao.deleteOrder(id);
		
	}

	/**
	 * 查询订单
	 */
	@Override
	public Order findById(Long id) throws EstoreCommonException {
		Order order = orderDao.findOrderById(id);
		if (order == null) {
			throw EstoreCommonException.getException(404);
			
		}
		return order;
	}

	/**
	 * 查询所有订单
	 */
	@Override
	public Set<Order> findorder(Long id) throws EstoreCommonException {
		if (id==null) {
			throw EstoreCommonException.getException(401);
		}
			Set<Order> set= orderDao.findorderByCustomerId(id);
			return set;
		
	}

}
