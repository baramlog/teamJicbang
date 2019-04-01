package dao;

import java.util.ArrayList;

import vo.BangVO;
import vo.CartVO;


public interface CartDao {
	ArrayList<BangVO> selectCart(); // 방 목록 출력

	BangVO selectBang(int key);
	
	void insertCart(BangVO bang);
	
	
	
	void deleteCart(BangVO bang);

	
}
