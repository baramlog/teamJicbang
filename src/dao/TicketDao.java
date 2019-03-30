package dao;

import java.util.ArrayList;
import vo.TicketInfoVO;
import vo.TicketVO;

public interface TicketDao {

	ArrayList<TicketInfoVO> showTicketShop();

	void buyTicket(int key, String agentId);

	ArrayList<TicketVO> showTicket();

	ArrayList<TicketInfoVO> TicketList();
}
