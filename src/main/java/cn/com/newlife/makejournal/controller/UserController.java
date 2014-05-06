package cn.com.newlife.makejournal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/reg")
	private String reg(){
		
		return "redirect:index.jsp";
	}
	
}
