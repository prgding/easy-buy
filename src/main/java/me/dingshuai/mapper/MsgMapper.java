package me.dingshuai.mapper;

import me.dingshuai.pojo.Message;

import java.util.List;

public interface MsgMapper {
	List<Message> findAll();

	int addMsg(Message msg);

	int deleteById(int msgId);

	int updateMsg(Message msg);

	Message findById(int msgId);
}
