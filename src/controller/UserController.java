package controller;

import java.util.Scanner;

import service.AgentService;
import service.AgentServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import dao.AgentDao;
import dao.AgentDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;

public class UserController {

	Scanner in = new Scanner(System.in);
//	UserService userService = new UserServiceImpl();
//	AgentService agentService = new AgentServiceImpl();
//	AgentDao agentDao = new AgentDaoImpl();
	UserDao userDao = new UserDaoImpl();
	boolean isContinue = true;

	public void usermenu() {

		while (isContinue) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.print("1. 매물검색" + "\t");
			System.out.print("2. 찜목록" + "\t\t");
			System.out.print("3. 공지사항" + "\t\t");
			System.out.println("4. 로그아웃");

			System.out.print("메뉴에 해당하는 번호 입력>");
			int menu = Integer.parseInt(in.nextLine());

			switch (menu) {
			case 1: // 매물검색
				// adminService.answer();
				break;
			case 2: // 찜목록
				// userService.userjoin();
				break;
			case 3: // 공지사항
				// userService.userjoin();
				break;
			case 4: // 로그아웃
				isContinue = false;
				break;
			}
		}
	}
}
