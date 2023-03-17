package me.dingshuai.service.impl;

import me.dingshuai.mapper.MsgMapper;
import me.dingshuai.pojo.Message;
import me.dingshuai.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgServiceImpl implements MsgService {
	@Autowired
	private MsgMapper msgMapper;

	@Override
	public int leaveAMsg(Message msg) {
		return msgMapper.insert(msg);
	}

	@Override
	public int deleteMsg(int msgId) {
		return msgMapper.deleteById(msgId);
	}

	@Override
	public int replyMsg(Message msg) {
		return msgMapper.update(msg);
	}

	@Override
	public Message showOneMsg(int msgId) {
		return msgMapper.findOne(msgId);
	}

	@Override
	public List<Message> showAllMsgs() {
		return msgMapper.findAll();
	}
}
