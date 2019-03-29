package service;

public interface AgentService {
	void agentjoin(); //중개인 회원가입
	String agentcheck(); //중개인 정보 확인
	void insertBang(); //방 등록 -agent
	void searchBang(); //방 검색 
	void detailBang(); //방 상세보기 -common
}
