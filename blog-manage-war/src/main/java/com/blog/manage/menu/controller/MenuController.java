package com.blog.manage.menu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.manage.menu.service.MenuService;
import com.blog.menu.entity.Menu;


@Controller
@RequestMapping("/manage/menu")
public class MenuController {

	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model){
		List<Menu> list = menuService.findAll();
		model.addAttribute("list", list);
		return "menu/list";
	}
	
	@RequestMapping(value="/navigation",method=RequestMethod.GET)
	@ResponseBody
	public Object getMenu(Model model){
		List<Menu> list = menuService.findAll();
		model.addAttribute("list", list);
		Map<String,Object> map = new HashMap<String,Object>();
		
		
		return "";
	}
	
}
