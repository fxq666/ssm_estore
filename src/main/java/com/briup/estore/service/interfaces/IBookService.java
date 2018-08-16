package com.briup.estore.service.interfaces;

import java.util.List;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.exception.EstoreCommonException;
import com.github.pagehelper.PageInfo;

public interface IBookService {
	/**
	 * 当前是第几页，分页查询
	 */
	PageInfo<Book> listBookWithPage(int page,int row) throws EstoreCommonException;
	 List<Book> findById(String name) throws EstoreCommonException;
}
