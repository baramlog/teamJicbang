package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.AgentService;
import service.AgentServiceImpl;
import service.TicketService;
import service.TicketServiceImpl;
import vo.Session;
import vo.TicketInfoVO;
import vo.TicketVO;
import dao.AgentDao;
import dao.AgentDaoImpl;
import dao.TicketDao;
import dao.TicketDaoImpl;

public class AgentController {
	Scanner in = new Scanner(System.in);
	//   UserService userService = new UserServiceImpl();
	AgentService agentService = new AgentServiceImpl();
	AgentDao agentDao = new AgentDaoImpl();
	//   UserDao userDao = new UserDaoImpl();
	TicketService ticketService = new TicketServiceImpl();
	boolean isContinue = true;
	Session session = new Session();
	Scanner s = new Scanner(System.in);
	TicketDao ticketDao = new TicketDaoImpl();
	ArrayList<TicketInfoVO> ticketInfoList = ticketDao.TicketList();

	public void agentmenu() {
		while (isContinue) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.print("1. 매물등록요청" + "\t");
			System.out.print("2. 티켓구매" + "\t\t");
			System.out.print("3. 내 티켓정보" + "\t\t");
			System.out.print("4. 공지사항" + "\t\t");
			System.out.println("5. 로그아웃");
			System.out.println();

			System.out.print("메뉴에 해당하는 번호 입력>");
			int menu = Integer.parseInt(in.nextLine());
			System.out.println();

			switch (menu) {
				case 1: // 매물등록
					addBang();
					break;
				case 2: // 티켓구매
					buyTicket();
					break;
				case 3: // 내 티켓 정보
					ticketService.ticketInfo();
					break;
				case 4: // 공지사항
					// userService.userjoin();
					break;
				case 5: // 로그아웃
					// agentService.agentjoin();
					isContinue = false;
					break;
			}
		}

	}



	public void buyTicket() {
		for(int i = 0; i < ticketInfoList.size(); i++){
			System.out.print((i+1) + ". " + ticketInfoList.get(i).getName());
			System.out.print(" (가격: " + ticketInfoList.get(i).getPrice() + "원");
			System.out.print("  / 매물등록 가능 개수: " + ticketInfoList.get(i).getNumber()+"개)");
			System.out.println();
		}
		System.out.println();
		System.out.print("어떤 티켓을 구매하시겠습니까? >");
		int num1 = Integer.parseInt(s.nextLine());
		System.out.print("몇 개를 구매하시겠습니까? >");
		int num2 = Integer.parseInt(s.nextLine());

		TicketVO ticket = ticketService.ticketPrint(num1, num2);

		System.out.println("결제하시겠습니까?(y/n) >");
		String yesno = s.nextLine();
		switch(yesno){
			case "y" :
				ticketService.insertTicket(ticket);
				System.out.println("결제가 성공적으로 완료됐습니다.");
				agentmenu();

			case "n" :
				System.out.println("결제가 취소됐습니다.");
				agentmenu();

		}
	}

	public void addBang(){
		System.out.print("매물을 등록하시겠습니까?(y/n) >");
		String yesno = s.nextLine();
		System.out.println();
		switch(yesno){
			case "y":
				System.out.println("신청서 양식을 출력합니다. 작성해주세요.");
				agentService.insertBang();
				break;
			case "n":
				agentmenu();
				break;
			default:
				addBang();
				break;
		}
	}
}