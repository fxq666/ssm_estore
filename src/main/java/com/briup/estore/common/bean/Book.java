package com.briup.estore.common.bean;

import java.io.Serializable;
/**
 * 书
 * oracle导出数据库
 * exp envir/envir@127.0.0.1:1521/XE file=C:\test.dmp log=C:\test.log owner=envir
 * */
public class Book implements Serializable {
	
	/**
	 * java中serialVersionUID的解释
serialVersionUID作用：
相当于java类的身份证。主要用于版本控制。
serialVersionUID作用是序列化时保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。
序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Double price;
	
	public Book(){}
	
	public Book(Long id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}
