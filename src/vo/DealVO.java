package vo;

import java.util.Date;

public class DealVO {
	private int bangNum; //방 기본키
	private Date dealDate; //거래 일자
	private String userId; //유저 아이디
	private String agentId; //중개사 아이디
	private int dealMoney; //제시 가격
	private boolean check; //가격 확인
	
	public int getDealMoney() {
		return dealMoney;
	}
	public void setDealMoney(int dealMoney) {
		this.dealMoney = dealMoney;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public int getNum() {
		return bangNum;
	}
	public void setNum(int num) {
		this.bangNum = num;
	}
	public Date getDealDate() {
		return dealDate;
	}
	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	
}
