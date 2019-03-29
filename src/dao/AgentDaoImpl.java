package dao;

import java.util.ArrayList;

import vo.AgentVO;
import vo.Database;
import vo.DealVO;
import vo.TicketInfoVO;
import vo.TicketVO;

public class AgentDaoImpl implements AgentDao {

	Database database = Database.getInstance();
	@Override
	public void insertAgent(AgentVO agent) {
		database.tb_agent.add(agent);
	}

	@Override
	public AgentVO selectAgent(String key, String value) {
		for(int i = 0; i < database.tb_agent.size(); i++){
			AgentVO agent = database.tb_agent.get(i);
			
			if(key.equals(key)){
				if(agent.getPassword().equals(value)){
					return agent;
				}
			}
		}
		return null;
	}

	@Override
	public ArrayList<AgentVO> selectAgentList() {
		return database.tb_agent;
	}

	@Override
	public void updateBang(int key) {
		
	}

	@Override
	public ArrayList<TicketInfoVO> selectTicketShop() {
		return database.tb_ticketinfo;
	}

	@Override
	public void buyTicket(int num) {

	}

	@Override
	public ArrayList<TicketVO> selectBuyTicket() {
		return database.tb_ticket;
	}

	@Override
	public ArrayList<DealVO> selectDeal() {
//		return database.tb_deal.get();
		return null;
	}

	@Override
	public void approveDeal(int key) {

	}

	@Override
	public void moneyUp(int dealPrice) {
		
	}

}
