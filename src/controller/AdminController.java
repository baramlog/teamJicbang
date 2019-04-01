



package controller;

import java.util.Scanner;

import service.AdminService;
import service.AdminServiceImpl;
import service.AgentService;
import service.AgentServiceImpl;
import service.NoticeService;
import service.NoticeServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import dao.AgentDao;
import dao.AgentDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;

public class AdminController {
	Scanner in = new Scanner(System.in);
//	UserService userService = new UserServiceImpl();
//	AgentService agentService = new AgentServiceImpl();
	AdminService adminService = new AdminServiceImpl();
	NoticeService notice = new NoticeServiceImpl();
//	AgentDao agentDao = new AgentDaoImpl();
//	UserDao userDao = new UserDaoImpl();
	boolean isContinue = true;

	public void adminmenu() {
		while (isContinue) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.print("1. 매물요청리스트" + "\t");
			System.out.print("2. 공지사항관리" + "\t\t");
			System.out.println("3. 로그아웃");

			System.out.print("메뉴에 해당하는 번호 입력>");
			int menu = Integer.parseInt(in.nextLine());

			switch (menu) {
			case 1: // 매물요청리스트
				adminService.AdminOKList();
				break;
			case 2: // 공지사항관리
				notice.adminMenu();
				break;
			case 3: // 로그아웃
				// agentService.agentjoin();
				isContinue = false;
				break;
			}
		}
	}
}
