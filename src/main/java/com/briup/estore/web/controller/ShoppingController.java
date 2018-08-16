package com.briup.estore.web.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.bean.Line;
import com.briup.estore.common.bean.ShoppingCar;


/**
 * 购物车处理
 * @author ying
 *
 */
@Controller
@RequestMapping("/shopping")
public class ShoppingController {
    /**
     * 添加购物车
     * @param name
     * @param price
     * @param session
     * @param line
     * @param book
     * @param car
     * @return
     */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addShop(HttpSession session,Line line,Book book,ShoppingCar car) {
        ShoppingCar cart = (ShoppingCar) session.getAttribute("cart2");
        Customer customer = (Customer) session.getAttribute("customer");
        if(customer == null) {
        	
        	return "redirect:/login";
        }
        if (cart == null) {
			cart = car;
		}
		line.setBook(book);
		line.setNum(1);
		cart.add(line);
		session.setAttribute("cart2", cart);
		Map<Long, Line> map=cart.getLines();
		session.setAttribute("map", map);
		return "redirect:/shopcart";	
	}
	
    /**
     * 清空购物车
     * @param session
     * @return
     */
	@RequestMapping("/removeAll")
	public String clearCart(HttpSession session) {
		ShoppingCar cart = (ShoppingCar) session.getAttribute("cart2");
		if (cart!=null) {
			cart.getLines().clear();
			return "redirect:/shopcart.jsp";
		}
		session.setAttribute("msg","清空报错！！！！");
		return "error";	
	}
	
	/**
	 * 删除订单项
	 * @param book
	 * @param session
	 * @param id
	 * @return 逻辑视图
	 */
	@RequestMapping("/remove")
	public String delOrderLine(Book book,HttpSession session,@RequestParam Long id) {
		book.setId(id);
		ShoppingCar cart = (ShoppingCar) session.getAttribute("cart2");
		cart.delete(id);
		return "redirect:/shopcart";
	}
	
	/**
	 * 修改订单项数量
	 * @param session
	 * @param id
	 * @param num
	 * @return
	 */
	@RequestMapping("/update")
	public String updateOrderLine(HttpSession session,@RequestParam Long id,@RequestParam Integer num) {
		ShoppingCar cart=(ShoppingCar) session.getAttribute("cart2");
		if (cart != null) {
			cart.update(id, num);
			return "redirect:/shopcart";
		}
		return "error";
	}
	
}
