package controller;

import java.util.Scanner;

import service.BangService;
import service.BangServiceImpl;
import dao.BangDao;
import dao.BangDaoImpl;

public class BangController {

	Scanner s = new Scanner(System.in);
	BangService bangService = new BangServiceImpl();
	MainController maincon = new MainController();

	public void bangSelect() {
		System.out.println("1. 매물 선택");
		System.out.println("2. 매물 검색");
		System.out.println("3. 홈");
		System.out.print("원하는 번호를 선택하세요. > ");
		int num = Integer.parseInt(s.nextLine());
		switch (num) {
		case 1:
			bangService.selectList();
			break;
		case 2: // 스트링 검색
			bangService.searchList();
			break;
		case 3: // 홈으로 가기
			maincon.main(null);
			break;
		}
	}

}
