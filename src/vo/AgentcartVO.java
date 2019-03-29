package vo;

public class AgentcartVO {
	
	private String agentId; //선택된 중개사 기본키
	private String userId; //유저 아이디
	
	
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
