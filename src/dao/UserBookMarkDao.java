package dao;

import java.util.ArrayList;

import vo.AgentcartVO;

public interface UserBookMarkDao {
	
	void insertBookMark(AgentcartVO bookmark); //에이전트 북마크 등록
	void removeBookMark(AgentcartVO bookmark); //에이전트 북마크 삭제
	ArrayList<AgentcartVO> getList(); // 에이전트 북마크 목록 출력 

}
