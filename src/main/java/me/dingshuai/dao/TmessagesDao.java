package me.dingshuai.dao;

import me.dingshuai.pojo.Tmessages;

import java.util.List;

public interface TmessagesDao {
	List<Tmessages> findAll();

	int addMsg(Tmessages msg);

	int deleteById(int msgId);

	int updateMsg(Tmessages msg);

	Tmessages findById(int msgId);
}
