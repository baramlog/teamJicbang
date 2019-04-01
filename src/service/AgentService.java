package service;

import vo.BangVO;

public interface AgentService {
	void agentjoin(); //중개인 회원가입
	void writeBang(); //방 등록 -agent
	void checkInsertBang(BangVO bang);
	void insertBang(BangVO bang);
	void searchBang(); //방 검색 
	void detailBang(); //방 상세보기 -common
}
