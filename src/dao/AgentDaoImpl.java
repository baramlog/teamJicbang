package dao;

import java.util.ArrayList;

import vo.AgentVO;
import vo.BangVO;
import vo.Database;
import vo.DealVO;
import vo.Session;
import vo.TicketInfoVO;
import vo.TicketVO;

public class AgentDaoImpl implements AgentDao {

	Database database = Database.getInstance();
	Session session = new Session();
	
	@Override
	public AgentVO selectAgent(String key, String value) {
		for(int i = 0; i < database.tb_agent.size(); i++){
			AgentVO agent = database.tb_agent.get(i);
			if(key.equals("PHONE")){
				if(agent.getPhone().equals(value)){
					return agent;
				}
			}
			if(key.equals("ID")){
				if(agent.getAgentId().equals(value)){
					return agent;
				}
			}
		}
		return null;
	}
	
	@Override
	public ArrayList<BangVO> myApprove(boolean check) {
		if(check == true){
			ArrayList<BangVO> result = new ArrayList<BangVO>();
			for(int i = 0; i < database.tb_bang.size(); i++){
				BangVO bang = database.tb_bang.get(i);
				
				if(session.getLoginAgent().getAgentId().equals(bang.getAgentId())){
					result.add(bang);
				}
			}
			return result;
		}else{
			ArrayList<BangVO> result = new ArrayList<BangVO>();
			for(int i = 0; i < database.tb_myapprove.size(); i++){
				BangVO bang = database.tb_myapprove.get(i);
				
				if(session.getLoginAgent().getAgentId().equals(bang.getAgentId())){
					result.add(bang);
				}
			}
			return result;			
		}
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
