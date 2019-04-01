package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.AgentService;
import service.AgentServiceImpl;
import service.BangService;
import service.BangServiceImpl;
import service.NoticeService;
import service.NoticeServiceImpl;
import service.TicketService;
import service.TicketServiceImpl;
import vo.AgentVO;
import vo.BangVO;
import vo.DealVO;
import vo.Session;
import vo.TicketInfoVO;
import vo.TicketVO;
import dao.AgentDao;
import dao.AgentDaoImpl;
import dao.BangDao;
import dao.BangDaoImpl;
import dao.DealDao;
import dao.DealDaoImpl;
import dao.TicketDao;
import dao.TicketDaoImpl;

public class AgentController {
	Scanner in = new Scanner(System.in);
    AgentService agentService = new AgentServiceImpl();
	TicketService ticketService = new TicketServiceImpl();
	BangService bangService = new BangServiceImpl(); //++
	boolean isContinue = true;
	Scanner s = new Scanner(System.in);
	TicketDao ticketDao = new TicketDaoImpl();
	AgentDao agentDao = new AgentDaoImpl();
	BangDao bangDao = new BangDaoImpl();
	ArrayList<TicketInfoVO> ticketInfoList = ticketDao.TicketList();
	
	NoticeService notice = new NoticeServiceImpl();
	DealDao dealDao = new DealDaoImpl();
	ArrayList<DealVO> dealList = dealDao.showDeal();
	ArrayList<AgentVO> agentList = agentDao.selectAgentList();
	Session session = new Session();

	public void agentmenu() {
		while (isContinue) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.print("1. 매물등록요청" + "\t");
			System.out.print("2. 내가 등록한 매물확인" + "\t");
			System.out.print("3. 티켓구매" + "\t");
			System.out.print("4. 내 티켓정보" + "\t");
			System.out.print("5. 거래내역" + "\t");
			System.out.print("6. 공지사항" + "\t");
			System.out.println("7. 로그아웃");
			System.out.println();

			System.out.print("메뉴에 해당하는 번호 입력 >");
			int menu = Integer.parseInt(in.nextLine());
			System.out.println();

			switch (menu) {
				case 1: // 매물등록요청
					addBang();
					break;
				case 2: //내가 등록한 매물확인
					myApprove();
					break;
				case 3: // 티켓구매
					buyTicket();
					break;
				case 4: // 내 티켓 정보
					ticketService.ticketInfo();
					break;
				case 5: // 거래내역
					dealList();
					break;
				case 6: // 공지사항
					notice.adminMenu();
					break;
				case 7: // 로그아웃
					// agentService.agentjoin();
					isContinue = false;
					break;
				default:
					System.out.println("*** 해당 값만 입력해주세요. ***");
					agentmenu();
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
		
		buyTicketok(ticket);
	}
	
	public void buyTicketok(TicketVO ticket){
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
			default:
				System.out.println("*** 해당 값만 입력해주세요. ***");
				buyTicketok(ticket);
			

		}
	}
	
	public void addBang(){
		System.out.print("매물을 등록하시겠습니까?(y/n) >");
		String yesno = s.nextLine();
		System.out.println();
		switch(yesno){
		case "y":
			System.out.println("신청서 양식을 출력합니다. 작성해주세요.");
			agentService.writeBang();
			break;
		case "n":
			agentmenu();
			break;
		default:
			System.out.println("*** 해당 값만 입력해주세요. ***");
			addBang();
			break;
		}
	}
	
	public void myApprove() {
		System.out.println("-------------내가 올린 매물-------------");
		ArrayList<BangVO> approveList1 = agentDao.myApprove(true);
		ArrayList<BangVO> approveList2 = agentDao.myApprove(false);
		ArrayList<BangVO> approveList = bangDao.myApproveList();
		
		int idx = 1;
		int num = 0;
		int num1 = 0;
		int num2 = 0;
		if(!approveList.isEmpty()){
			for(BangVO bang : approveList){
				bang.setBangNum(idx++);
				System.out.println("No. " + bang.getBangNum());
				System.out.println("Id : " + bang.getAgentId());
				System.out.println("구, 동 : " + bang.getAddress1());
				System.out.println("상세 주소 : " + bang.getAddress2());
				System.out.println("(승인 대기중)");
				System.out.println("----------------------------------");
				num++;
			}
		}else{
			if(approveList1.isEmpty()){
				if(approveList2.isEmpty()){
					System.out.println("등록된 매물이 없습니다.");				
				}
			}
		}
		for(BangVO bang : approveList1){
			bang.setBangNum(idx++);
			System.out.println("No. " + bang.getBangNum());
			System.out.println("Id : " + bang.getAgentId());
			System.out.println("구, 동 : " + bang.getAddress1());
			System.out.println("상세 주소 : " + bang.getAddress2());
			System.out.println("(승인)");
			System.out.println("----------------------------------");
			num1++;
		}
		for(BangVO approve : approveList2){
			approve.setBangNum(idx++);
			System.out.println("No. " + approve.getBangNum());
			System.out.println("Id : " + approve.getAgentId());
			System.out.println("구, 동 : " + approve.getAddress1());
			System.out.println("상세 주소 : " + approve.getAddress2());
			System.out.println("(반려)");
			System.out.println("----------------------------------");
			num2++;
		}
		System.out.println("승인대기 : " + num + " 개 / 승인완료 : " + num1 + " 개 / 반려 : " + num2 + " 개");
		
		askTicket();
	}
	
	public void askTicket(){
		System.out.print("티켓을 적용시키시겠습니까?(y/n) >");
		String yesno = s.nextLine();
		switch(yesno){
			case "y":
				ansYTicket();
				break;
			case "n":
				agentmenu();
				break;
			default:
				System.out.println("*** 해당 값만 입력해주세요. ***");
				askTicket();
				break;
		}
	}
	
	public void ansYTicket(){
		System.out.println("가지고 있는 티켓을 출력합니다.");
		ticketService.ticketInfo();
		System.out.println();
		System.out.print("어떤 티켓을 등록시키시겠습니까? >");
		int num1 = Integer.parseInt(s.nextLine());
		System.out.print("몇 개를 적용시키겠습니까? >");
		int num2 = Integer.parseInt(s.nextLine());
		
		ticketService.applyTicket(num1, num2);
	}

	public void dealList(){
		AgentVO agent = session.getLoginAgent();
		System.out.println("----------------------------"); //리스트 ++
		for(int i = 0; i < dealList.size(); i++){
			DealVO dealInfo = dealList.get(i);
			if(session.getLoginAgent().getAgentId().equals(dealInfo.getAgentId())){
				System.out.println("중개사 : " + dealInfo.getAgentName());
				System.out.println("사용자 아이디 : " + dealInfo.getUserId());
				System.out.println("매물정보 : " + dealInfo.getAddress2());
				System.out.println("매매금액 : " + dealInfo.getDealMoney() + "억원");
				System.out.println("----------------------------");
				System.out.print("해당 건에 대한 중개수수료를 처리하시겠습니까? (y/n)");
				String yesno = s.nextLine();
				
				System.out.println();
				switch(yesno){
				case "y":
					commission();
					break;
				case "n":
					agentmenu();
					break;
				default:
					agentmenu();
					break;
				}
				
			}else{
				System.out.println("거래 내역이 없습니다.");
			}
		
		System.out.println("----------------------------");
//		System.out.println(dealList.get(0).toString());
	
		}
	}
	
	public void commission(){
		AgentVO agent = session.getLoginAgent();
		System.out.println("----------------------------"); 
		
//		for(DealVO dealInfo : dealList) {
			for(int i = 0; i < dealList.size(); i++){
				DealVO dealInfo = dealList.get(i);			
				System.out.println(dealInfo.getUserId() + "님의 거래건에 대한");
				System.out.println("중개수수료 0.5%를 가져갑니다.");
				System.out.println("중개수수료 : " + ((int)((dealInfo.getDealMoney() * 0.005 * 10000)+ 0.005) * 1000.0) / 1000.0 + "만원");
				System.out.println("");
				System.out.println("직방수수료 10%를 전달합니다.");
				System.out.println("직방수수료 : " + ((int)((dealInfo.getDealMoney() * 0.005 * 10000)+ 0.005) * 1000.0) / 1000.0  * 0.1 + "만원");
				System.out.println("");
				System.out.println("해당 거래가 완료되었습니다.");
				dealDao.deleteDealList(dealInfo);
				break;
				
			}
		
			/*if(dealInfo == null){
				System.out.println("거래 내역이 없습니다.");
			}*/
		
		System.out.println("----------------------------"); 
	}
	
	
}