package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.NoticeService;
import service.NoticeServiceImpl;
import service.TicketService;
import service.TicketServiceImpl;
import vo.Session;
import vo.TicketVO;
import dao.AgentDao;
import dao.AgentDaoImpl;
import dao.TicketDao;
import dao.TicketDaoImpl;

public class AgentController {
	Scanner in = new Scanner(System.in);
//	UserService userService = new UserServiceImpl();
//	AgentService agentService = new AgentServiceImpl();
	AgentDao agentDao = new AgentDaoImpl();
//	UserDao userDao = new UserDaoImpl();
	TicketService ticketService = new TicketServiceImpl();
	TicketDao ticketDao = new TicketDaoImpl();
	ArrayList<TicketVO> ticketList = ticketDao.showTicket();
	NoticeService notice = new NoticeServiceImpl();
	Session session = new Session();
	boolean isContinue = true;

	public void agentmenu() {
		while (isContinue) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.print("1. 매물등록요청" + "\t");
			System.out.print("2. 티켓구매" + "\t\t");
			System.out.print("3. 공지사항" + "\t\t");
			System.out.println("4. 로그아웃");

			System.out.print("메뉴에 해당하는 번호 입력>");
			int menu = Integer.parseInt(in.nextLine());

			switch (menu) {
			case 1: // 매물등록
				// adminService.answer();
				break;
			case 2: // 티켓구매
				// userService.userjoin();
				break;
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
}
