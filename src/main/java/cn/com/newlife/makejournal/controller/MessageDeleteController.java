package cn.com.newlife.makejournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.newlife.makejournal.entity.Message;
import cn.com.newlife.makejournal.service.IMessageBoardService;

@Controller
@RequestMapping("/messageDelete.htm")
public class MessageDeleteController {
	@Autowired
	private IMessageBoardService messageBoardService;

	@RequestMapping(method = RequestMethod.GET)
	// @Secured( { "ROLE_ADMIN" })
	public String messageDelete(@RequestParam(required = true, value = "messageId") Long messageId, Model model) {
		Message message = messageBoardService.findMessageById(messageId);
		messageBoardService.deleteMeesage(message);
		model.addAttribute("messages", messageBoardService.listMessages());
		return "redirect:messageList.htm";
	}
}