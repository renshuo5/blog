package com.blog.manage.menu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.blog.menu.entity.Menu;

public interface MenuDao extends PagingAndSortingRepository<Menu, Long>,
	JpaSpecificationExecutor<Menu> {
	
	public List<Menu> findByName(String name);
	
	public List<Menu> findAll();

}
