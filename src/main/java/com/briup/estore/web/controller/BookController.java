package com.briup.estore.web.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.exception.EstoreCommonException;
import com.briup.estore.service.interfaces.IBookService;
import com.github.pagehelper.PageInfo;

/**
 * 索引
 * @author ying
 *
 */
@Controller
public class BookController {
	
	@Autowired
	private IBookService bookService;

	/**
	 * 分页展示首页
	 * @param session
	 * @param page
	 * @return
	 */
	@RequestMapping(value= {"/","index"})
	public String showIndexPage(HttpSession session,@RequestParam(value="page",required=false,defaultValue="1") int page) {
		PageInfo<Book> pageInfo;
		try {
			pageInfo = bookService.listBookWithPage(page, 3);
			session.setAttribute("pageinfo",pageInfo); 
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", "查询失败"+e.getMessage());
			return "error";
		}
		return "index";
		
	}
	
	@RequestMapping("/queryBook")
	public String queryBook(@RequestParam(value="name") String name,HttpSession session) {
		try {
			List<Book> pageInfo = bookService.findById(name);
			session.setAttribute("pageinfo",pageInfo); 
			
		} catch (EstoreCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute("msg", "搜索出错!"+e.getMessage());
			return "error";
		}
		return "index1";
	}
}
