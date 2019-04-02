package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import vo.AgentVO;
import vo.BangVO;
import vo.Session;
import vo.TicketInfoVO;
import vo.TicketVO;
import dao.AgentDao;
import dao.AgentDaoImpl;
import dao.BangDao;
import dao.BangDaoImpl;
import dao.TicketDao;
import dao.TicketDaoImpl;


public class TicketServiceImpl implements TicketService {
   Scanner s = new Scanner(System.in);
   TicketDao ticketDao = new TicketDaoImpl();
   ArrayList<TicketVO> ticketList = ticketDao.showTicket();
   ArrayList<TicketInfoVO> ticketInfoList = ticketDao.TicketList();
   BangDao bangDao = new BangDaoImpl();
   AgentDao agentDao = new AgentDaoImpl();
   BangService bangService = new BangServiceImpl();
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
         System.out.println(ticketInfoList.get(i).getTnum() + ". 티켓 이름: " + ticketInfoList.get(i).getName());
         System.out.println("매물 등록 가능 개수: " + sum[i]);
         System.out.println("----------------------------");
      }
      
   }

   @Override
   public TicketVO ticketPrint(int num1, int num2) {
      String id = session.getLoginAgent().getAgentId();
      TicketDao ticketDao = new TicketDaoImpl();      TicketVO ticket = new TicketVO();
      String name = null;
      ArrayList<TicketVO> ticketlist = ticketDao.showTicket();

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
      ticket.setNum(ticketList.get(ticketList.size()-1).getNum() + 1);
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
   
   @Override
   public void applyTicket(int num1, int num2, int num3){
      ArrayList<BangVO> approveList = agentDao.myApprove(true);
      TicketService ticketService = new TicketServiceImpl();
      TicketInfoVO ticketInfo = new TicketInfoVO();
      TicketDao ticketDao = new TicketDaoImpl();
      TicketVO ticket = new TicketVO();
      
      
      String id = session.getLoginAgent().getAgentId();
      
      HashMap<String, ArrayList<TicketVO>> count = new HashMap<String, ArrayList<TicketVO>>();
      count.put("30일 등록권", new ArrayList<TicketVO>());
      count.put("60일 등록권", new ArrayList<TicketVO>());
      count.put("90일 등록권", new ArrayList<TicketVO>());
      for(TicketVO tic : ticketList){
//         for(int i = 0; i < ticketInfoList.size(); i++){
            if(id.equals(tic.getAgentId())){
//               System.out.println(tic.getName());
               count.get(tic.getName()).add(tic);               
//               count.put(tic.getName(), tic);
            }
//         }
      }
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
      
      for(TicketInfoVO item : ticketInfoList){
         if(num1 == item.getTnum()){
            /*if(ticketInfo.getName().equals(ticket.getName()) && id.equals(ticket.getAgentId())){
               ticket.setNumber(ticket.getNumber() - num2);
               ticketDao.updateTicket(ticket, count.get(ticket.getName()).getNum());
            }*/
            if(sum[num1-1] < num2){
               System.out.println("값이 초과되었습니다. 다시 입력해주세요.");
               break;
            }
            for(TicketVO i : count.get(item.getName())){
               if(i.getNumber()-num2 >= 0){
                  i.setNumber(i.getNumber() - num2);
                  int idx = 0;
                  for(int j=0; j<ticketList.size(); j++)
                     if(i.getNum() == ticketList.get(j).getNum()){
                        idx = j;
                        break;
                     }
                  ticketDao.updateTicket(i, idx);
                  System.out.println("< 적용 완료 >");
                  
                  for(BangVO bang : approveList){
                     if(bang.getBangNum() == num3){
                        bangService.setDate(bang, item.getPeriod()*num2);
                     }
                  }
                  System.out.println();
                  yesno();
                  break;
               }else{
                  num2 = num2 - i.getNumber();
                  i.setNumber(0);
                  int idx = 0;
                  for(int j=0; j<ticketList.size(); j++)
                     if(i.getNum() == ticketList.get(j).getNum()){
                        idx = j;
                        break;
                     }
                  ticketDao.updateTicket(i, idx);
               }
               
            }
         }
      }
   }
   
   public void yesno(){
      System.out.print("변경된 티켓정보를 확인하시겠습니까?(y/n) >");
      String yesno = s.nextLine();
      switch(yesno){
      case "y":
         ticketInfo();
         break;
      case "n":
         break;
      default:
         yesno();
      }
   }

   
}