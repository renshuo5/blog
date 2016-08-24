package com.blog.manage.menu.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.manage.menu.service.MenuService;
import com.blog.menu.entity.Menu;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rensframework.core.model.AjaxResult;


@Controller
@RequestMapping("/manage/menu/")
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
		List<Menu> list = menuService.findByParentIdNull();
		for(Menu parent:list){
			List<Menu> child = menuService.findByParentId(parent.getId());
			Set<Menu> childSet = new HashSet<Menu>(child);
			parent.setChildren(childSet);
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("menuList", list);
		
		ObjectMapper mapper = new ObjectMapper();
		String content ="";
		try {
			content = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		AjaxResult ajax = new AjaxResult(map);
		return content;
	}
	
}
