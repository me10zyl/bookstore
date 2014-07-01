package net.vicp.zyl_me.model;

public class FeedBackBean {
	private long feedid;
	private String name;

	private String subject;

	private String msg;

	private String email;

	private String ip;



	public FeedBackBean(String name, String subject, String msg, String email, String ip) {
		super();
		this.name = name;
		this.subject = subject;
		this.msg = msg;
		this.email = email;
		this.ip = ip;
	}

	public FeedBackBean(long feedid, String name, String subject, String msg, String email, String ip) {
		super();
		this.feedid = feedid;
		this.name = name;
		this.subject = subject;
		this.msg = msg;
		this.email = email;
		this.ip = ip;
	}

	public String getEmail() {
		return email;
	}

	public long getFeedid() {
		return feedid;
	}

	public String getIp() {
		return ip;
	}

	public String getMsg() {
		return msg;
	}

	public String getName() {
		return name;
	}

	public String getSubject() {
		return subject;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFeedid(long feedid) {
		this.feedid = feedid;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
