package vo;

import java.util.Date;

public class DealVO {
	private int bangNum; //방 기본키
	private Date dealDate; //거래 일자
	private String userId; //유저 아이디
	private String agentId; //중개사 아이디
	private double dealMoney; //제시 가격
	private boolean check; //가격 확인
	
	
	private float area; //면적
	private String address1; //구
	private String address2; //상세주소
	private double price; //가격
	private String option1; //방, 화장실 개수
	private String option2; //역이 근처에 있는지
	private String state; //판매상태
	private String category; //전월세, 매매
	private String agentName; //중개인 이름
	private String startDate; //등록일자
	private String workDate; //준공일자
	private String endDate;
	
	public int getBangNum() {
		return bangNum;
	}
	public void setBangNum(int bangNum) {
		this.bangNum = bangNum;
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
	public double getDealMoney() {
		return dealMoney;
	}
	public void setDealMoney(double dealMoney) {
		this.dealMoney = dealMoney;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	} //등록이 끝나는 날짜
	
}
	