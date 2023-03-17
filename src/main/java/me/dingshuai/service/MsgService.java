package me.dingshuai.service;

import me.dingshuai.pojo.Message;

import java.util.List;

public interface MsgService {
	int leaveAMsg(Message msg);

	int deleteMsg(int msgId);

	int replyMsg(Message msg);

	Message showOneMsg(int msgId);

	List<Message> showAllMsgs();
}