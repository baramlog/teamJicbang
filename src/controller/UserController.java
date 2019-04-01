package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.AgentService;
import service.AgentServiceImpl;
import service.NoticeService;
import service.NoticeServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import vo.AgentVO;
import vo.BangVO;
import vo.DealVO;
import vo.NoticeVO;
import vo.Session;
import dao.AgentDao;
import dao.AgentDaoImpl;
import dao.DealDao;
import dao.DealDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;

public class UserController {

	Scanner in = new Scanner(System.in);
//	UserService userService = new UserServiceImpl();
//	AgentService agentService = new AgentServiceImpl();
//	AgentDao agentDao = new AgentDaoImpl();
	NoticeService notice = new NoticeServiceImpl();
	BangController bcon = new BangController();
	UserDao userDao = new UserDaoImpl();
	DealDao dealDao = new DealDaoImpl();
	boolean isContinue = true;
	Session session = new Session();

	public void usermenu() {

		while (isContinue) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.print("1. 매물검색" + "\t");
			System.out.print("2. 찜목록" + "\t");
//			System.out.print("3. 거래내역" + "\t\t");
			System.out.print("3. 공지사항" + "\t\t");
			System.out.println("4. 로그아웃");

			System.out.print("메뉴에 해당하는 번호 입력>");
			int menu = Integer.parseInt(in.nextLine());

			switch (menu) {
			case 1: // 매물검색
				bcon.bangSelect();
				break;
			case 2: // 찜목록
				// userService.userjoin();
				break;
//			case 3: // 거래내역
//				dealList();
//				break;
			case 3: // 공지사항
				notice.viewList();
				break;
			case 4: // 로그아웃
				// agentService.agentjoin();
				isContinue = false;
				break;
			}
		}
	}
	public void dealList(){
//		ArrayList<DealVO> deal = dealDao.dealList();
//		
//		System.out.println("---------구입 내역---------");
//		for(DealVO de : deal){
//			System.out.println("중개사 : " + de.getAgentName());
//			System.out.println("동, 구 : " + de.getAddress1());
//			System.out.println("상세주소 : " + de.getAddress2());
//			System.out.println("종류 : " + de.getCategory());
//			System.out.println("가격 : " + de.getPrice());
//			System.out.println("----------------------");
//		}
	}
}
