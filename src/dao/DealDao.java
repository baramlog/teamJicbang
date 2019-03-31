package dao;

import java.util.ArrayList;

import vo.BangVO;
import vo.DealVO;

public interface DealDao {

	ArrayList<DealVO> showDeal(); // 딜 내역 출력
	void insertDeal(DealVO deal);
}