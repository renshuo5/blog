package com.blog.manage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice("com.blog.manage")
public class CommonController {
	
	protected transient final Logger logger = LoggerFactory.getLogger(this
			.getClass());
	@Autowired
//	private UserService userService;
	
	public static final String ATTR_LOGIN_USER = "loginUser";

//	@ModelAttribute(ATTR_LOGIN_USER)
//	public User loginUser(HttpServletRequest req) {
//		LoginInfo login = null;
//		if(!ClientInfoHolder.isHealthCheck(req)){
//			login = (LoginInfo) SecurityUtils.getSubject().getPrincipal();
//		}
//		if (login != null) {
//			return userService.findOne(login.getUserId());
//		} else {
//			return null;
//		}
//	}

}
