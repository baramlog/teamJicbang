package service;

import vo.BangVO;

public interface BangService {

	void selectList(); //출력
	void searchList(); //검색
	void printList();
	void purchase();
	void JJimList();
	void JJimLoginCheck();
	void setDate(BangVO bang, int plusDay);
	
}


