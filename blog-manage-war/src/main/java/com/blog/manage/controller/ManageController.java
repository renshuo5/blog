package com.blog.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/manage")
public class ManageController {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String manage(Model model){
		//判断user是否登录
		
		
		return "index";
	}

}
