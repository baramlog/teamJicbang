package dao;

import java.util.ArrayList;

import vo.AgentVO;
import vo.BangVO;
import vo.Database;
import vo.DealVO;
import vo.TicketInfoVO;
import vo.TicketVO;

public class AgentDaoImpl implements AgentDao {

	Database database = Database.getInstance();
	
	@Override
	public AgentVO selectAgent(String key, String value) {
		for(int i = 0; i < database.tb_agent.size(); i++){
			AgentVO agent = database.tb_agent.get(i);
			if(key.equals("ID")){
				if(agent.getAgentId().equals(value)){
					if(key.equals("PHONE")){
						if(agent.getPhone().equals(value)){
							return agent;
						}
					}
				}
			}
		}
		return null;
	}
	
	
	
	@Override
	public void insertAgent(AgentVO agent) {
		// TODO Auto-generated method stub
		database.tb_agent.add(agent);
	}

	@Override
	public ArrayList<AgentVO> selectAgentList() {
		
		return database.tb_agent;
	}


	@Override
	public void updateBang(BangVO bang) {
		database.tb_approve.add(bang);
		
	}



	@Override
	public ArrayList<TicketInfoVO> selectTicketShop() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void buyTicket(int num) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public ArrayList<TicketVO> selectBuyTicket() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ArrayList<DealVO> selectDeal() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void approveDeal(int key) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void moneyUp(int dealPrice) {
		// TODO Auto-generated method stub
		
	}

}
