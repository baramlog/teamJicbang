package dao;

import java.util.ArrayList;
import vo.TicketInfoVO;
import vo.TicketVO;

public interface TicketDao {

	ArrayList<TicketInfoVO> showTicketShop(); // 티켓샵 보기

	void insertTicket(TicketVO ticket); //티켓구입이력 넣기
	void updateTicket(TicketVO ticket, int index);

	ArrayList<TicketVO> showTicket(); // 구매한 티켓 이력 출력
	ArrayList<TicketInfoVO> TicketList();
	
}
