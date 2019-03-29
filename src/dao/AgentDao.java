package dao;

import java.util.ArrayList;

import vo.AgentVO;
import vo.DealVO;
import vo.TicketInfoVO;
import vo.TicketVO;

public interface AgentDao {
	
	void insertAgent(AgentVO agent); //회원 삽입
	AgentVO selectAgent(String key, String value); //단일중개인 조회
	ArrayList<AgentVO> selectAgentList(); //전체중개인 조회
//	void deleteBang(int key); //방삭제
	void updateBang(int key); //방 승인요청
	ArrayList<TicketInfoVO> selectTicketShop(); //티켓샵 보기
	void buyTicket(int num); //티켓구입
	ArrayList<TicketVO> selectBuyTicket(); //구매한 티켓 이력 출력
	ArrayList<DealVO> selectDeal(); //거래 요청 매물 목록 출력
	void approveDeal(int key); //딜이 들어온 매물 승인
	void moneyUp(int dealPrice); //딜 성사시 금액과 수수료 처리
	
	
}
