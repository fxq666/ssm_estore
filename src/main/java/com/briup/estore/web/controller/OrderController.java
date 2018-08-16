package com.briup.estore.web.controller;


import java.util.Date;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.bean.Line;
import com.briup.estore.common.bean.Order;
import com.briup.estore.common.bean.ShoppingCar;
import com.briup.estore.common.exception.EstoreCommonException;
import com.briup.estore.service.interfaces.ILineService;
import com.briup.estore.service.interfaces.IOrderService;

/**
 * 订单处理（支付完成生成物流信息？？？？）
 * 拦截器拦截未登录页面，但是ajax请求不能被拦截
 * @author ying
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	@Autowired
	private ILineService lineService;
	
	/**
	 * 保存订单
	 * @param session
	 * @param payway
	 * @param order
	 * @param cart
	 * @return
	 */
	@RequestMapping("/saveOrder")
	public String saveOrder(HttpSession session,@RequestParam String payway,Order order,ShoppingCar cart) {
		cart=(ShoppingCar) session.getAttribute("cart2");
		//System.out.println(cart.getCost());
		order.setId(new Date().getTime());
		 order.setCost(cart.getCost());
		 order.setPayway(payway);
		 order.setOrderDate(new Date());
		 Customer customer=(Customer) session.getAttribute("customer");
		 order.setCustomer(customer);
			Map<Long, Line> map=cart.getLines();
			Set<Line> lines =new HashSet<>();
			lines.addAll(map.values());
			try {
				orderService.confirmOrder(customer, order, lines);
				Set<Order> set=orderService.findorder(customer.getId());
				session.setAttribute("orderMap",set);
		        session.removeAttribute("cart2");
				return "redirect:/user/order";
			} catch (EstoreCommonException e) {
				e.printStackTrace();
				session.setAttribute("msg","保存订单出错"+e.getMessage());
				return "error";
			}
		
	}
	
	/**
	 * 删除订单
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping("/removeOrder")
	public String deleteOrder(HttpSession session,@RequestParam("orderid") Long id) {
		try {
			orderService .deleteOrder(id);
			@SuppressWarnings("unchecked")
			Set<Order> set = (Set<Order>) session.getAttribute("orderMap");
			Iterator<Order> it=set.iterator();
			while(it.hasNext()) {
				Order order2 = it.next();
				if (order2.getId().equals(id)) {
					it.remove();}			            
				}
			session.setAttribute("orderMap", set);
			return "redirect:/user/order";
		} catch (EstoreCommonException e) {
			session.setAttribute("msg", "删除订单"+e.getMessage());
			return "error";	
		}
	
		
	}
	
	/**
	 * 删除订单
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteOrder")
	public String deleteOrderById(HttpSession session,@RequestParam("orderid") Long orderid) {
		try {
			Order order = orderService.findById(orderid);
			orderService .deleteOrder(orderid);
			@SuppressWarnings("unchecked")
			Set<Order> set = (Set<Order>) session.getAttribute("orderMap");
			Iterator<Order> it=set.iterator();
			while(it.hasNext()) {
				Order order2 = it.next();
				if (order2.getId().equals(orderid)) {
					it.remove();
					}			            
				}
			session.setAttribute("orderMap", set);
			session.setAttribute("order", order);
			return "redirect:/user/alipay.index";
		} catch (EstoreCommonException e) {
			session.setAttribute("msg", "支付报错"+e.getMessage());	
			return "redirect:/error";
		}
	
		
	}
	
	
	/**
	 * 显示订单详细
	 * @param session
	 * @param id
	 * @param order
	 * @param line
	 * @return
	 */
	@RequestMapping("/orderinfo")
	public String showOrderLine(HttpSession session,@RequestParam("orderid") Long id,Order order,Line line) {
		Customer customer=(Customer) session.getAttribute("customer");
		order.setId(id);
		order.setCustomer(customer);
		line.setOrder(order);
		try {
			Set<Line> findLine = lineService.findorderLine(id);
			session.setAttribute("setLine", findLine);
			Order order2 = orderService.findById(id);
			session.setAttribute("order2", order2);
		  return "redirect:/user/orderinfo";
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", "显示订单页面"+e.getMessage());
			return "error";
		}		
	}
	
	/**
	 * 展示订单
	 * @param session
	 * @return
	 * @throws EstoreCommonException 
	 */
	@RequestMapping("/show")
	public String showOrder(HttpSession session) throws EstoreCommonException {
		Customer customer = (Customer) session.getAttribute("customer");
		Set<Order> set = orderService.findorder(customer.getId());
		session.setAttribute("orderMap",set);
		return "redirect:/user/order";
	}


}
