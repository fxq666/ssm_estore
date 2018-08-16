package com.briup.estore.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.bean.Province;
import com.briup.estore.common.exception.EstoreCommonException;
import com.briup.estore.common.util.ResponseResult;
import com.briup.estore.service.interfaces.ICustomerService;
import com.briup.estore.service.interfaces.IProvinceService;





@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IProvinceService provinceService;
	
	    /**
	     * 注册
	     * @param c
	     * @param session
	     * @return
	     */
		@RequestMapping(value="/register")
		public String register(Customer c,HttpSession session) {
			try {
				customerService.register(c);
				session.setAttribute("msg", "注册成功请登录！");
				return "redirect:/login";
			} catch (EstoreCommonException e) {
					e.printStackTrace();
					session.setAttribute("error", "注册失败"+e.getMessage());
					return "redirect:/register";
				}
		}
		
		/**
		 * 登录
		 * @param c
		 * @param session
		 * @return
		 */
		@RequestMapping("/login")
		public String login(Customer c,HttpSession session) {
			try {
				
				Customer customer = customerService.login(c.getName(), c.getPassword());
				
					session.setAttribute("customer", customer);
					session.setAttribute("loginmsg", "登录成功，您可以买书了！");
				return "redirect:/index";
			} catch (EstoreCommonException e) {
				session.setAttribute("loginError", "登录失败，请重新登录！"+e.getMessage());
				return "redirect:/login";
			}
		}
		
		/**
		 * 注册检查用户名是否存在
		 * @param username
		 * @return
		 */
		@RequestMapping("/checkUsername/{username}")
		@ResponseBody
		public Object check(@PathVariable String username) {
			try {
				Customer customer = customerService.findCustomerName(username);
				if(customer == null) {
					return ResponseResult.build(200, "OK");
				}
				return ResponseResult.build(500, "fail");
			} catch (EstoreCommonException e) {
				e.printStackTrace();
				return ResponseResult.build(500, "fail");
			}
			
		}
		
		/**
		 * 修改用户信息
		 * @param session
		 * @return
		 */
		@RequestMapping("/modify")
		public String modifyCustomer(HttpSession session) {
			Customer customer=(Customer) session.getAttribute("customer");
			try {
				customerService.updateCustomer(customer);
				return "/index";
			} catch (EstoreCommonException e) {
				e.printStackTrace();
				session.setAttribute("msg", "修改用户报错"+e.getMessage());
				return "error";
			}	
		}
		
		/**
		 * 用户退出登录
		 * @param session
		 * @return
		 */
		@RequestMapping("/logout")
		public String logoutCustomer(HttpSession session) {
			if (session!=null) {
				session.removeAttribute("customer");
				session.removeAttribute("cart2");
				session.removeAttribute("order");
				session.removeAttribute("payway");
				session.removeAttribute("map2");
				return "redirect:/login";
			}
			
			return "error";
		}
	    
		/**
		 * 验证验证码
		 * @param session
		 * @param checkcode
		 * @return
		 */
		@RequestMapping("/checkcode/{checkcode}")
		@ResponseBody
		public Object checkCode(HttpSession session,@PathVariable String checkcode) {
			String str = (String) session.getAttribute("CHECKNUM");
			if (checkcode.equals(str)) {
				return ResponseResult.build(200, "OK");
			}
			return ResponseResult.build(500, "fail");	
		}
		
		/**
		 * 注意 此处编写map文件表的属性名和类的字段要一一对应
		 * 对所在地区作的二级联动
		 * @return
		 */
		@RequestMapping(value="/countryprovince/{country}")
		@ResponseBody
		public  List<Province> countryprovince(@PathVariable Integer country) {
			List<Province> provinces = null;
			try {
				if (country == 1 ) {
				provinces = provinceService.findByCountry(country);
				}
               if (country == 2) {
            	  provinces = provinceService.findByCountry1(country);
				}
               if (country == 3) {
            	 provinces = provinceService.findByCountry2(country);
				}
               return provinces;
			} catch (EstoreCommonException e) {
				e.printStackTrace();
				 return null;
			}
			
			
			
		}
}
