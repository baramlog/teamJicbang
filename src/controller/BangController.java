package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import service.BangService;
import service.BangServiceImpl;
import vo.BangVO;
import dao.BangDao;
import dao.BangDaoImpl;

public class BangController {

	Scanner s = new Scanner(System.in);
	BangDao bangDao = new BangDaoImpl();
	// ArrayList<BangVO> bangVO = bangDao.selectList();
	BangService bangService = new BangServiceImpl();

	public void bangSelect() {
		System.out.println("1. 매물 선택");
		System.out.println("2. 매물 검색");
		System.out.print("원하는 번호를 선택하세요. > ");
		int num = Integer.parseInt(s.nextLine());
		switch (num) {
		case 1:
			bangService.selectList();
		case 2: // 스트링 검색
			bangService.searchList();
		}
	}

}