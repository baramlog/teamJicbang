package service;

import vo.TicketVO;

public interface TicketService {
   void ticketInfo();
   TicketVO ticketPrint(int num1, int num2);
   void insertTicket(TicketVO ticket);
   void applyTicket(int num1, int num2, int num3);
}