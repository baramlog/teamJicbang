package controller;

import java.util.Scanner;

import service.NoticeService;
import service.NoticeServiceImpl;
import service.UserBookMark;
import service.UserBookMarkImpl;
import vo.Session;
import dao.UserDao;
import dao.UserDaoImpl;

public class UserController {

	Scanner in = new Scanner(System.in);
//	UserService userService = new UserServiceImpl();
//	AgentService agentService = new AgentServiceImpl();
//	AgentDao agentDao = new AgentDaoImpl();
	NoticeService notice = new NoticeServiceImpl();
	UserDao userDao = new UserDaoImpl();
	BangController bcon = new BangController();
	UserBookMark bookmark = new UserBookMarkImpl();
	boolean isContinue = true;
	Session session = new Session();

	public void usermenu() {

		while (isContinue) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.print("1. 매물검색" + "\t");
			System.out.print("2. 찜목록" + "\t\t");
			System.out.print("3. 공지사항" + "\t\t");
			System.out.println("4. 로그아웃");
			System.out.println();

			System.out.print("메뉴에 해당하는 번호 입력>");
			int menu = Integer.parseInt(in.nextLine());
			System.out.println();

			switch (menu) {
			case 1: // 매물검색
				bcon.bangSelect();
				break;
			case 2: // 찜목록
				bookmark.getAgentList();
				break;
			case 3: // 공지사항
				notice.viewList();
				break;
			case 4: // 로그아웃
				// agentService.agentjoin();
				new Session().setLoginUser(null);
				isContinue = false;
				break;
			default:
				System.out.println("*** 해당 값만 입력해주세요. ***");
				usermenu();
				break;
			}
		}
	}
}
