package dao;

import java.util.ArrayList;
import vo.TicketInfoVO;
import vo.TicketVO;

public interface TicketDao {

	ArrayList<TicketInfoVO> showTicketShop(); // 티켓샵 보기

	void buyTicket(int key, String agentId); // 티켓구입

	ArrayList<TicketVO> showTicket(); // 구매한 티켓 이력 출력
	ArrayList<TicketInfoVO> TicketList();
}
