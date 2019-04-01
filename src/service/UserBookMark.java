package service;

import java.util.ArrayList;

import vo.AgentcartVO;


public interface UserBookMark {
	//즐겨찾기 추가
	void addBookMark(String agentId);
	
	//즐겨찾기 삭제
	void removeBookMark(AgentcartVO agent);
	
	//즐겨찾기 리스트 가져오기
	void getAgentList();
}
