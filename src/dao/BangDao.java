package dao;

import vo.BangVO;

import java.util.ArrayList;
import java.util.HashMap;

public interface BangDao {

	ArrayList<BangVO> selectApproveList(); //매물등록 승인요청 목록 출력
	ArrayList<BangVO> selectList(); //방 목록 출력
	void approve(int key); //매물등록 승인 후 삽입
	void back(int key); //매물등록 반려후 삭제

	/*ram*/
	/*add method*/
	HashMap<String, ArrayList<String>> searchKeyList(); //분류 검색에 쓰일 구,동 이름 목록

}
