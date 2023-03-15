package me.dingshuai.pojo;

import org.springframework.stereotype.Component;

@Component
public class Message {
	private int msgId;
	private String msgSender;

	private String msgTitle;

	private String msgContent;
	private String msgStatus;

	private String msgReplyContent;

	public String getMsgReplyContent() {
		return msgReplyContent;
	}

	public void setMsgReplyContent(String msgReplyContent) {
		this.msgReplyContent = msgReplyContent;
	}

	public Message() {
	}

	public Message(String msgSender, String msgTitle, String msgContent) {
		this.msgSender = msgSender;
		this.msgTitle = msgTitle;
		this.msgContent = msgContent;
	}

	public Message(int msgId, String msgSender, String msgContent, String msgStatus, String msgReplyContent) {
		this.msgId = msgId;
		this.msgSender = msgSender;
		this.msgContent = msgContent;
		this.msgStatus = msgStatus;
		this.msgReplyContent = msgReplyContent;
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

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
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

	@Override
	public String toString() {
		return "Message{" +
				"msgId=" + msgId +
				", msgSender='" + msgSender + '\'' +
				", msgTitle='" + msgTitle + '\'' +
				", msgContent='" + msgContent + '\'' +
				", msgStatus='" + msgStatus + '\'' +
				", msgReplyContent='" + msgReplyContent + '\'' +
				'}';
	}
}
