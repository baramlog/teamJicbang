package dao;

import java.util.ArrayList;
import vo.TicketInfoVO;
import vo.TicketVO;

public interface TicketDao {
	
	ArrayList<TicketInfoVO> method1(); //티켓샵 보기
	void method2(int key, String agentId); //티켓구입
	ArrayList<TicketVO> method3(); //구매한 티켓 이력 출력
}
