package cn.com.newlife.makejournal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.newlife.makejournal.entity.Message;
import cn.com.newlife.makejournal.service.IMessageBoardService;

@Controller
@RequestMapping("/messagePost.htm")
public class MessagePostController {
	@Autowired
	private IMessageBoardService messageBoardService;

	@RequestMapping(method = RequestMethod.GET)
	// @Secured( { "ROLE_USER" })
	public String setupForm(Model model) {
		Message message = new Message();
		model.addAttribute("message", message);
		return "messagePost";
	}

	@RequestMapping(method = RequestMethod.POST)
	// @Secured( { "ROLE_USER" })
	public String onSubmit(@ModelAttribute("message") Message message, BindingResult result, HttpServletRequest request) {
		message.setAuthor(request.getRemoteUser());
		if (result.hasErrors()) {
			return "messagePost";
		} else {
			messageBoardService.postMessage(message);
			return "redirect:messageList.htm";
		}
	}
}