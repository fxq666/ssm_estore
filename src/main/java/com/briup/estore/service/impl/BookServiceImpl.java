package com.briup.estore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.exception.EstoreCommonException;
import com.briup.estore.dao.IBookDao;
import com.briup.estore.service.interfaces.IBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookDao bookDao;

	@Override
	public PageInfo<Book> listBookWithPage(int page, int row) throws EstoreCommonException {
		PageHelper.startPage(page, row);
		List<Book> list = bookDao.queryAll();
		if (list == null) {
			throw EstoreCommonException.getException(404);
		}
		return new PageInfo<>(list);
	}



	@Override
	public List<Book> findById(String name) throws EstoreCommonException {
		if (name == null) {
			throw EstoreCommonException.getException(401);
		}
		List<Book> list = bookDao.queryByName(name);
		if (list == null) {
			throw EstoreCommonException.getException(404);
		}
		
		return list;
	}
     
	

}
