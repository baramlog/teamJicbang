package controller;

import java.util.Scanner;

import service.AdminService;
import service.AdminServiceImpl;
import service.AgentService;
import service.AgentServiceImpl;
import service.BangService;
import service.BangServiceImpl;
import service.NoticeService;
import service.NoticeServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import vo.Session;

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
				System.out.println("                                         ");
				System.out.println("			┌────────────────────────────┐");
				System.out.println("			│            직방            │");
				System.out.println("			└────────────────────────────┘");
				System.out.println();
			System.out.print("1. 로그인" + "\t");
			System.out.print("2. 회원가입" + "\t");
//			System.out.print("3. 회원가입(중개인)" + "\t");
			System.out.print("3. 매물검색" + "\t");
			System.out.print("4. 공지사항" + "\t");
			System.out.println("5. 프로그램 종료");
			System.out.println("----------------------------------------------------------------------------------▶");
			System.out.print("메뉴에 해당하는 번호 입력>");

			int menu = Integer.parseInt(in.nextLine());
			
			UserService userService = new UserServiceImpl();
			AgentService agentService = new AgentServiceImpl();
			AdminService adminService = new AdminServiceImpl();
			BangService bangService = new BangServiceImpl();
			BangController bcon = new BangController();
			NoticeService notice = new NoticeServiceImpl();
			Session session = new Session();
			
			switch (menu) {
			case 1: //로그인
				login();
				break;
			case 2: //회원가입
				join();
				break;
			case 3: //매물검색
				bcon.bangSelect();
				break;
			case 4: //공지사항
				if(session.getLoginAdmin() != null)
					notice.adminMenu();
				else
					notice.viewList();
				break;
			case 5: //프로그램
//				userService.userList();
				isContinue = false;
				break;
			}
		}	
		
	}
	
	public static void login() {	//로그인
		
		String result = null;
		Scanner in = new Scanner(System.in);
		UserService userService = new UserServiceImpl();
		AgentService agentService = new AgentServiceImpl();
		AdminService adminService = new AdminServiceImpl();
		AdminController adminController = new AdminController();
		AgentController agentController = new AgentController();
		UserController userController = new UserController();

		result = userService.usercheck();
		if(result == "user"){
			userController.usermenu();
		}else if(result == "agent"){
			agentController.agentmenu();
		}else if(result == "admin"){
			adminController.adminmenu();
		}
	}
	
	
	public static void join() { //회원가입
		String result;
		Scanner in = new Scanner(System.in);
		UserService userService = new UserServiceImpl();
		AgentService agentService = new AgentServiceImpl();
		AdminService adminService = new AdminServiceImpl();
		AdminController adminController = new AdminController();
		AgentController agentController = new AgentController();
		UserController userController = new UserController();
		
		System.out.println("1. 사용자");
		System.out.println("2. 중개인");
		System.out.print("해당하는 사용자 입력>>");
		int who = Integer.parseInt(in.nextLine());
		switch (who) {
		case 1:
			userService.userjoin();
			break;
		case 2:
			agentService.agentjoin();
			break;
		}
	}
	
	

}
