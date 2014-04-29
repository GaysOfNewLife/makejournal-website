package cn.com.newlife.makejournal.service;

import java.util.List;

import cn.com.newlife.makejournal.entity.Message;

public interface IMessageBoardService {
	public List<Message> listMessages();

	public void postMessage(Message message);

	public void deleteMeesage(Message message);

	public Message findMessageById(Long messageId);
}
