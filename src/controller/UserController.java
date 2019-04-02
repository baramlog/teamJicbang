package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.BangService;
import service.BangServiceImpl;
import service.NoticeService;
import service.NoticeServiceImpl;
import service.UserBookMark;
import service.UserBookMarkImpl;
import vo.Session;
import vo.UserVO;
import dao.UserDao;
import dao.UserDaoImpl;

public class UserController {

	Scanner in = new Scanner(System.in);
	MainController maincon = new MainController();
	
	UserDao userDao = new UserDaoImpl();
	
	NoticeService notice = new NoticeServiceImpl();
	UserBookMark userbookmark = new UserBookMarkImpl();
	BangService bangService = new BangServiceImpl();
	
	ArrayList<UserVO> userList = userDao.selectUserList();	
	
	boolean isContinue = true;

	public void usermenu() {
		Session session = new Session();
		while (isContinue) {


			System.out.println("메뉴를 선택해주세요.");
			System.out.print("1. 매물검색" + "\t");
			System.out.print("2. 방찜목록" + "\t\t");
			System.out.print("3. 중개인 찜목록" + "\t\t");
			System.out.print("4. 공지사항" + "\t\t");
			System.out.println("5. 로그아웃");

			System.out.print("메뉴에 해당하는 번호 입력>");
			int menu = Integer.parseInt(in.nextLine());

			switch (menu) {
			case 1: // 매물검색
				new BangController().bangSelect();
				break;
			case 2: // 방찜목록
				bangService.JJimList();
				break;
			case 3: //중개인 찜목록
				userbookmark.getAgentList();
				break;
			case 4: // 공지사항
				notice.viewList();
				break;
			case 5: // 로그아웃
				session.setLoginUser(null);
				maincon.main(null);
				isContinue = false;
				break;
			}
		}
	}
}
