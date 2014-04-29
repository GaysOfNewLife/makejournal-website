package cn.com.newlife.makejournal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.newlife.makejournal.entity.Message;
import cn.com.newlife.makejournal.service.IMessageBoardService;

@Controller
@RequestMapping("/messageList.htm")
public class MessageListController {
	@Autowired
	private IMessageBoardService messageBoardService;

	@RequestMapping(method = RequestMethod.GET)
	// @Secured( { "ROLE_USER" })
	public String generateList(Model model) {
		List<Message> messages = java.util.Collections.emptyList();
		messages = messageBoardService.listMessages();
		model.addAttribute("messages", messages);
		return "messageList";
	}
}
