package dao;

import vo.BangVO;
import vo.UserVO;

import java.util.ArrayList;
import java.util.HashMap;

public interface BangDao {


	ArrayList<BangVO> approveList(); //매물등록 승인요청 목록 출력

	ArrayList<BangVO> selectList(); // 방 목록 출력
	
	BangVO selectBang(String key, String value);

	void insertBang(BangVO bang);
	
	void deleteBang(BangVO bang);
	
	void deleteDealBang(BangVO bang);
	
	ArrayList<BangVO> myApproveList(); //나의 승인요청 목록

	HashMap<String, ArrayList<String>> searchKeyList();
	
}
