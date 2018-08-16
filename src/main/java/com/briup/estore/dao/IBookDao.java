package com.briup.estore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.estore.common.bean.Book;

public interface IBookDao  {
	/**
	 * 查询所有
	 * @return
	 */
	 List<Book> queryAll();
	 List<Book> queryByName(@Param("name")String name);
}
