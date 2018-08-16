package com.briup.estore.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.estore.common.util.ResponseResult;

@Controller
public class PageController {

	@RequestMapping(value="/checkSession/{name}")
	@ResponseBody
	public Object countryprovince(@PathVariable String name) {
		
		if (name.equals("success")) {
			return ResponseResult.build(200, "OK");
		}
		return ResponseResult.build(500, "fail");	
		
	}
}
