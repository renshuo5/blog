package com.blog.manage.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.blog.manage.menu.dao.MenuDao;
import com.blog.menu.entity.Menu;
import com.rensframework.core.service.BaseService;

public class MenuService extends BaseService<Menu> {

	@Autowired
	private MenuDao menuDao;
	@Override
	protected PagingAndSortingRepository<Menu, Long> getDao() {
		return menuDao;
	}
	public List<Menu> findByName(String name){
		return menuDao.findByName(name);
	}
	
	public List<Menu> findAll(){
		return menuDao.findAll();
	}

}
