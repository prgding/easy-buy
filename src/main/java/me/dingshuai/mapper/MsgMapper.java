package me.dingshuai.mapper;

import me.dingshuai.pojo.Message;

import java.util.List;

public interface MsgMapper {
	int insert(Message msg);

	int deleteById(int msgId);

	// update 不能 ById, 因为容易全部赋值 id
	int update(Message msg);

	Message findOne(int msgId);

	List<Message> findAll();
}
