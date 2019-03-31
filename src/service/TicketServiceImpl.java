package service;

import java.util.ArrayList;
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
		System.out.println("----------------------------");
		for(int i = 0; i < ticketInfoList.size(); i++){
			System.out.println("티켓 이름:" + ticketInfoList.get(i).getName());
			System.out.println("매물 등록 가능 개수: " + sum[i]);
			System.out.println("----------------------------");
		}

	}

	@Override
	public TicketVO ticketPrint(int num1, int num2) {
		String id = session.getLoginAgent().getAgentId();
		TicketVO ticket = new TicketVO();
		String name = null;
		int number = 0;
		int price = 0;

		for(int j = 0; j < ticketInfoList.size(); j++){
			if(num1 == ticketInfoList.get(j).getTnum()){
				name = ticketInfoList.get(j).getName();
				number = ticketInfoList.get(j).getNumber() * num2;
				price = ticketInfoList.get(j).getPrice() * num2;
				System.out.println("----------------------------");
				System.out.println("티켓 이름: " + ticketInfoList.get(j).getName());
				System.out.println("티켓 개수: " + num2);
				System.out.println("매물 등록 가능 개수: " + ticketInfoList.get(j).getNumber() * num2);
				System.out.println("총 가격: " + ticketInfoList.get(j).getPrice() * num2 + "원");
				System.out.println("----------------------------");
			}
		}

		ticket.setAgentId(id);
		ticket.setName(name);
		ticket.setNumber(number);
		ticket.setPrice(price);
		return ticket;
	}

	@Override
	public void insertTicket(TicketVO ticket){
		ticketDao.insertTicket(ticket);
	}

}



















