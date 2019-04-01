package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.BangService;
import service.BangServiceImpl;
import service.NoticeService;
import service.NoticeServiceImpl;
import vo.Session;
import vo.UserVO;
import dao.UserDao;
import dao.UserDaoImpl;

public class UserController {

	Scanner in = new Scanner(System.in);
	// UserService userService = new UserServiceImpl();
	// AgentService agentService = new AgentServiceImpl();
	// AgentDao agentDao = new AgentDaoImpl();
	NoticeService notice = new NoticeServiceImpl();
	UserDao userDao = new UserDaoImpl();
	BangService bangService = new BangServiceImpl();
	ArrayList<UserVO> userList = userDao.selectUserList();	
	MainController maincon = new MainController();
	boolean isContinue = true;

	public void usermenu() {
		Session session = new Session();
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
				new BangController().bangSelect();
				break;
			case 2: // 찜목록
				bangService.JJimList();
				break;
			case 3: // 공지사항
				notice.viewList();
				break;
			case 4: // 로그아웃
				System.out.println(session.getLoginUser().getId());
				maincon.main(null);
//				session.setLoginUser(null);
				isContinue = false;
				break;
			}
		}
	}
}
