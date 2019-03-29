package dao;

import java.util.ArrayList;
import vo.NoticeVO;

public interface NoticeDao {
	
	void insertNotice(NoticeVO notice); //공지사항 등록
	void removeNotice(NoticeVO notice); //공지사항 삭제
	ArrayList<NoticeVO> getList(); // 공지사항 목록 출력
}
