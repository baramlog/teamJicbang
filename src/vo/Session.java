package vo;

public class Session {
	/* 3.28 20:19 - ram */
	/*로그인유저와 에이전트를 구별하기 위해 변수 추가*/
	private static AgentVO loginAgent; //agent 로그인상태를 저장
	private static UserVO loginUser; //user 로그인상태를 저장
	private static AgentVO loginAdmin; //admin 로그인상태를 저장

	public static AgentVO getLoginAdmin() {
		return loginAdmin;
	}

	public static void setLoginAdmin(AgentVO loginAdmin) {
		Session.loginAdmin = loginAdmin;
	}



	public AgentVO getLoginAgent() {
		return loginAgent;
	}

	public void setLoginAgent(AgentVO loginAgent) {
		this.loginAgent = loginAgent;
	}

	public UserVO getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(UserVO loginUser) {
		this.loginUser = loginUser;
	}
}
