package vo;

import java.util.Date;

public class TicketVO {
	
	private int ticketNum; //티켓 키 값
	private String agentId; //중개인 아이디
	private String name; //티켓 이름
	private int price; //티켓 가격
	private Date startDate; //티켓 산 날짜
	private Date endDate; //티켓 끝나는 날짜
	private int number; //매물 등록 가능 개수
	
	
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public int getNum() {
		return ticketNum;
	}
	public void setNum(int num) {
		this.ticketNum = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
