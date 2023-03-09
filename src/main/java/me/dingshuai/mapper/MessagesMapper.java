package me.dingshuai.mapper;

import me.dingshuai.pojo.Messages;

import java.util.List;

public interface MessagesMapper {
	List<Messages> findAll();

	int addMsg(Messages msg);

	int deleteById(int msgId);

	int updateMsg(Messages msg);

	Messages findById(int msgId);
}
