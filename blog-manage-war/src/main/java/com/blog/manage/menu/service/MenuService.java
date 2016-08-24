package com.blog.manage.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.manage.menu.dao.MenuDao;
import com.blog.menu.entity.Menu;
import com.rensframework.core.service.BaseService;

@Service
@Transactional(readOnly=true)
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
	
	public List<Menu> findByParentIdNull(){
		return menuDao.findByParentIdNull();
	}
	
	public List<Menu> findByParentId(Long parentId){
		return menuDao.findByParentId(parentId);
	}

}
