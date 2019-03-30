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
		int[] sum = new int[]{0, 0, 0};
		for(int i = 0; i < ticketList.size(); i++){
			for(int j = 0; j < ticketInfoList.size(); j++){
				if(agent.getAgentId().equals(ticketList.get(i).getAgentId())
						&& ticketList.get(i).getName().equals(ticketInfoList.get(j).getName())){
					sum[j] += ticketList.get(i).getNumber();
				}
			}
		}
		for(int i = 0; i < ticketList.size(); i++){
			for(int j = 0; j < ticketInfoList.size(); j++){
				if(ticketList.get(i).getAgentId().equals(agent.getAgentId())){
					System.out.println("티켓 이름: " + ticketInfoList.get(j).getName());
					System.out.println("매물 등록 가능 개수: " + sum[j]);
					System.out.println("----------------------------");
				}
			}
			break;
		}
		
	}

	@Override
	public void buyTicket() {
		TicketVO ticket = new TicketVO();
		String id = session.getLoginAgent().getAgentId();
		for(int i = 0; i < ticketInfoList.size(); i++){
			System.out.print((i+1) + ". " + ticketInfoList.get(i).getName() + "\t");
		}
		System.out.println();
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
//					ticket.setNumber(ticketInfoList.get(i).getNumber()*num2);
//					ticket.setAgentId(id);
//					ticket.setPrice(ticketInfoList.get(i).getPrice()*num2);
//					ticket.setName(ticketInfoList.get(i).getName());
//					ticketDao.insertTicket(ticket);
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




















