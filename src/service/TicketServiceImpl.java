package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import vo.AgentVO;
import vo.Session;
import vo.TicketInfoVO;
import vo.TicketVO;
import dao.TicketDao;
import dao.TicketDaoImpl;


public class TicketServiceImpl implements TicketService {
	Scanner s = new Scanner(System.in);
	TicketDao ticketDao = new TicketDaoImpl();
	ArrayList<TicketVO> ticketList = ticketDao.showTicket();
	ArrayList<TicketInfoVO> ticketInfoList = ticketDao.TicketList();
	Session session = new Session();
	
	@Override
	public void ticketInfo() {
		AgentVO agent = session.getLoginAgent();
		System.out.println(agent.getAgentId());
		int[] sum = new int[]{0, 0, 0};
		for(int i = 0; i < ticketList.size(); i++){
			for(int j = 0; j < ticketInfoList.size(); j++){
				if(agent.getAgentId().equals(ticketList.get(i).getAgentId())
						&& ticketList.get(i).getName().equals(ticketInfoList.get(j).getName())){
					sum[j] += ticketList.get(i).getNumber();
				}
			}
		}
		
		System.out.println(Arrays.toString(sum));
		
//		for(int i = 0; i < ticketList.size(); i++){
//			if(ticketList.get(i).equals(agent.getAgentId())){
//				System.out.println("티켓 이름: " + ticketList.get(i).getName());
//				System.out.println("매물 등록 가능 개수: " + sum);
//			}
//		}
	}

	@Override
	public void buyTicket() {
		String id = session.getLoginAgent().getAgentId();
		System.out.println("1. 30일 이용권\t\t 2. 60일 이용권\t\t 3. 90일 이용권");
		System.out.println("어떤 티켓을 구매하시겠습니까?");
		int num = Integer.parseInt(s.nextLine());
		System.out.println("몇 개를 구매하시겠습니까?");
		int num2 = Integer.parseInt(s.nextLine());
		for(int i = 0; i < ticketInfoList.size(); i++){
			for(int j = 0; j < ticketList.size(); j++){
				if(num == ticketInfoList.get(i).getTnum()){
					ticketList.get(j).setNumber(ticketInfoList.get(i).getNumber()*num2);
					ticketList.get(j).setPrice(ticketInfoList.get(i).getPrice()*num2);
					ticketList.get(j).setAgentId(id);
				}
			}
		}
		for(int i = 0; i < ticketList.size(); i++){
			for(int j = 0; j < ticketInfoList.size(); j++){
				if(id.equals(ticketList.get(i).getAgentId()) && num == ticketInfoList.get(j).getTnum()){
						System.out.println("----------------------------");
						System.out.println("티켓 이름: " + ticketInfoList.get(j).getName());
						System.out.println("티켓 개수: " + num2);
						System.out.println("매물 가능 개수: " + ticketInfoList.get(j).getNumber() * num2);
						System.out.println("총 가격: " + ticketInfoList.get(j).getPrice() * num2);
						System.out.println("----------------------------");
				}
			}
			break;
		}
		System.out.println("결제하기");
		System.out.println("결제가 성공적으로 완료됐습니다.");
	}

}




















