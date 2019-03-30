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
	public void buyTicket(int key, String agentId) {
		
	}

	@Override
	public ArrayList<TicketVO> showTicket() {
		return database.tb_ticket;
	}

	@Override
	public ArrayList<TicketInfoVO> TicketList() {
		
		return database.tb_ticketinfo;
	}

}
