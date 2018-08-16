package com.briup.estore.common.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 订单
 * */
public class Order implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	/**
	 * 价钱（总价）
	 * */
	private Double cost;
	private Date orderDate;
	private String payway;
	
	/**
	 * 关联关系 - 一对多 : 对应多个订单项
	 * */
	private Set<Line> lines = new HashSet<>();
	/**
	 * 关联关系 - 多对一 : 对应一个顾客
	 * */
	private Customer customer;
	
	public Order(){
		
	}
	
	
	public Order(Long id, Double cost, Date orderDate, String payway, Set<Line> lines, Customer customer) {
		this.id = id;
		this.cost = cost;
		this.orderDate = orderDate;
		this.payway = payway;
		this.lines = lines;
		this.customer = customer;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Set<Line> getLines() {
		return lines;
	}
	public void setLines(Set<Line> lines) {
		this.lines = lines;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getPayway() {
		return payway;
	}
	public void setPayway(String payway) {
		this.payway = payway;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", cost=" + cost + ", orderDate=" + orderDate + ", payway=" + payway + ", lines="
				+ lines + ", customer=" + customer + "]";
	}
	
	
}
