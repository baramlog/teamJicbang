 package dao;

import java.util.ArrayList;

import vo.Database;
import vo.TicketInfoVO;
import vo.TicketVO;

public class TicketDaoImpl implements TicketDao {
	
	Database database = Database.getInstance();

	@Override
	public ArrayList<TicketInfoVO> showTicketShop() {
		
		return null;
	}
	
	@Override
	public void insertTicket(TicketVO ticket){
		database.tb_ticket.add(ticket);
	}

	@Override
	public ArrayList<TicketVO> showTicket() {
		return database.tb_ticket;
	}

	@Override
	public ArrayList<TicketInfoVO> TicketList() {
		
		return database.tb_ticketinfo;
	}

	@Override
	public void updateTicket(TicketVO ticket, int index) {
		database.tb_ticket.set(index, ticket);
	}
}
