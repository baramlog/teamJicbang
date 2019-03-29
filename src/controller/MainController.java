package controller;

import service.*;
import vo.Session;

import java.util.Scanner;

public class MainController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Controller : 메뉴 선택 Service : 메뉴 기능 수행 Dao : 데이터 베이스 접속 VO : 데이터를 담는 클래스
		 *
		 * VO와 HashMap은 선택사항
		 */

		Scanner in = new Scanner(System.in);
		boolean isContinue = true;

		while (isContinue) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.print("1. 로그인" + "\t");
			System.out.print("2. 회원가입(사용자)" + "\t");
			System.out.print("3. 회원가입(중개인)" + "\t");
			System.out.print("4. 매물검색" + "\t");
			System.out.print("5. 공지사항" + "\t");
			System.out.println("6. 프로그램 종료");
			System.out.print("메뉴에 해당하는 번호 입력>");

			int menu = Integer.parseInt(in.nextLine());

			UserService userService = new UserServiceImpl();
			AgentService agentService = new AgentServiceImpl();
			AdminService adminService = new AdminServiceImpl();
			BangService bangService = new BangServiceImpl();
			BangController bcon = new BangController();
			NoticeService noticeService = new NoticeServiceImpl();
			Session session = new Session();

			switch (menu) {
				case 1: //로그인
					adminService.answer();
					break;
				case 2: //회원가입(사용자)
					userService.userjoin();
					break;
				case 3: //회원가입(중개인)
					agentService.agentjoin();
					break;
				case 4: //매물검색
					bcon.bangSelect();
					break;
				case 5: //공지사항
					if(session.getLoginAgent() != null)
						noticeService.adminMenu();
					else
						noticeService.viewList();
					break;
				case 6: //프로그램종료
					isContinue = false;
					System.out.println("직방이 종료되었습니다.");
					break;
			}
		}
	}

}
