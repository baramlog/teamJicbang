package service;

public interface AdminService {
	void AdminOKList(); //승인 요청 목록
	void AdminYes(); //승인
	void AdminNo(); //반려
	void NoticeAddList(); //공지사항 추가
	void NoticeDeleteList(); //공지사항 삭제
//	void userlist(); //회원 전체 목록 출력
//	void agentList(); //중개인 전체 목록 출력
	void answer(); //사용자인지 중개인이지 물어보기
	
}
