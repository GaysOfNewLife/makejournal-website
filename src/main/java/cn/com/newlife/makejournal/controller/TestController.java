package cn.com.newlife.makejournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.newlife.makejournal.dao.ISimpleHibernateDAO;
import cn.com.newlife.makejournal.entity.User;
import cn.com.newlife.makejournal.service.IUserService;
import cn.com.newlife.makejournal.utils.IdUtil;

@Controller
public class TestController {

	@Autowired
	private ISimpleHibernateDAO simpleHibernateDAO;
	
	@Autowired
	private IUserService userService;

	@RequestMapping("/test")
	private ModelAndView toTest() {
		System.out.println("I am in TestController-->test");
		simpleHibernateDAO.deleteAll(simpleHibernateDAO.findByHQL("from User"));
		String id = IdUtil.getUUID();
		User user = new User(id, "test", "test");
		simpleHibernateDAO.saveOrUpdate(user);
		user.setUsername("test1");
		return new ModelAndView("test");
	}

}
