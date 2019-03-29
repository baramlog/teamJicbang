


package dao;

import java.util.ArrayList;

import vo.UserVO;

public interface UserDao {
	// 단일회원 조회
	UserVO selectUser(String key, String value);

	// 회원 삽입
	void insertUser(UserVO user);

	ArrayList<UserVO> selectUserList();

	void dealMoney(int price); // 딜 성사시 유저가 송금금액

}
