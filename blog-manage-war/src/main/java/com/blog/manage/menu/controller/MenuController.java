package com.blog.manage.menu.controller;

import java.util.HashMap;
import java.util.HashSet;
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


@Controller
@RequestMapping("/manage/menu")
public class MenuController {

	
	@Autowired
	private MenuService menuService;
	
	
//	@InitBinder(Presentation.KEY_ENTITY)
//	private void initBinder(ServletRequestDataBinder binder, HttpServletRequest req) {
//		String[] fields = new String[] { "campaign", "name", "type", "video", "app", "priority", "beginDate", "endDate",
//				"limit.totalBudget", "limit.dailyBudget", "limit.impTotalLimit", "limit.clickTotalLimit", "limit.impDailyLimit",
//				"limit.clickDailyLimit", "indvdLimit.*", "audience.audiences", "area.code", "excludeArea.code", "dayParting",
//				"whiteDomainGroup.domainsCode", "blackDomainGroup.domainsCode", "browsers", "antiCheating", "adLocations", "cpmBidPrice",
//				"exchanges", "dayPacing", "pacingRate", "retargetSite", "retargetProduct", "ctIncludeGroup.ctCode",
//				"ctExcludeGroup.ctCode", "rcIncludeGroup.rcCode", "rcExcludeGroup.rcCode", "os", "mobileModel", "mobileConnectionTypes", "mobileNetwork",
//				"deviceType", "whiteAppList", "blackAppList", "algoRemark", "remark", "targetUrl", "clickUrl", "trackingUrls", "geoPoints",
//				"lbsOrientation.lbsTypeId", "lbsOrientation.lbsIds", "youkuChannel.*", "youkuSecondChannel.*", "tanxMediaType.*",
//				"mogoMediaType.*", "miaozhenMediaType.*", "allyesCategory.*", "allyesPageForm.*", "allyesAdForm.*", "allyesMediaType.*",
//				"exclusiveConf.*", "adSlotBlackList", "adSlotWhiteList", "selfMedia.*","defaultAdStrategy","cookieIds","deviceIds",
//				"cookieSetIds","settleType","audiencePrecision","ips","innerSetup","videoFlow" };
//		switch (RequestUtils.getMethod(req)) {
//		case POST: // 新增
//			binder.setAllowedFields(fields);
//			break;
//		case PUT: // 修改
//			fields = ArrayUtils.removeElement(fields, "campaign");
//			binder.setAllowedFields(fields);
//			break;
//		default:
//			break;
//		}
//	}

	/**
	 * 预处理，一般用于新增和修改表单提交后的预处理
	 * 
	 * @param id
	 * @param req
	 * @return
	 */
//	@ModelAttribute("entity")
//	public Menu prepare(@RequestParam(value = "id", required = false) Long id, HttpServletRequest req) {
//		RequestMethod method = RequestUtils.getMethod(req);
//		if (id != null && id > 0 && RequestMethod.PUT.equals(method)) {// 修改表单提交后数据绑定之前执行
//			return strategyService.getForUpdate(id);
//		} else if (RequestMethod.POST.equals(method)) {// 新增表单提交后数据绑定之前执行
//			return new Menu();
//		} else {
//			return null;
//		}
//	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model){
		List<Menu> list = menuService.findAll();
		model.addAttribute("list", list);
		return "menu/list";
	}
	
	@RequestMapping(value="/form" ,method=RequestMethod.GET)
	public String form(Menu menu,Model model){
		if(menu==null){
			menu = new Menu();
		}
		
		model.addAttribute("entity", menu);
		return "menu/form";
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
			e.printStackTrace();
		} 
//		AjaxResult ajax = new AjaxResult(map);
		return content;
	}
	
}
