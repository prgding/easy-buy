package me.dingshuai.service;

import me.dingshuai.pojo.Message;

import java.util.List;

public interface ShopService {
	void addMsg();

	List<Message> showMsg();

	void manageMsg();

	void deleteMsg();

	void showDetail();

	void reply();

	void updateMsg();
}
