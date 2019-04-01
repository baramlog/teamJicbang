package dao;

import java.util.ArrayList;

import vo.BangVO;
import vo.DealVO;

public interface DealDao {
	
	ArrayList<DealVO> showDeal(); // 딜 내역 출력
	void insertDeal(DealVO deal);
	void deleteDealList(DealVO deal);
	ArrayList<DealVO> dealList(); //거래성사 내역 출력
}
