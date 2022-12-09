package me.dingshuai.pojo;

public class Tmessages {
	private int msgId;
	private String msgSender;
	private String msgContent;
	private String msgStatus;

	public Tmessages() {
	}

	public int getMsgId() {
		return msgId;
	}

	public String getMsgSender() {
		return msgSender;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public String getMsgStatus() {
		return msgStatus;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public void setMsgSender(String msgSender) {
		this.msgSender = msgSender;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public void setMsgStatus(String msgStatus) {
		this.msgStatus = msgStatus;
	}
}
