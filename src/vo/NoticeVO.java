package vo;

import java.util.Date;

public class NoticeVO {
	
	private int noticeNum; //기본키
	private String agentId; //관리자 아이디
	private String title; //제목
	private Date date; //날짜
	private String contents; //내용
	
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String id) {
		this.agentId = id;
	}
	public int getNum() {
		return noticeNum;
	}
	public void setNum(int num) {
		this.noticeNum = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
}
