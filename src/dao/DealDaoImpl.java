package dao;

import java.util.ArrayList;

import vo.Database;
import vo.DealVO;
import vo.Session;

public class DealDaoImpl implements DealDao {

	Database database = Database.getInstance();
	Session session = new Session();

	@Override
	public ArrayList<DealVO> showDeal() {
		return database.tb_deal;
	}

	@Override
	public void insertDeal(DealVO deal) {
		database.tb_deal.add(deal);
//		database.tb_dealbang1.add(deal);
		
	}

	@Override
	public ArrayList<DealVO> dealList() {
		ArrayList<DealVO> result = new ArrayList<DealVO>();
		for(int i = 0; i < database.tb_deal.size(); i++){
			DealVO bang = database.tb_deal.get(i);
			
			if(session.getLoginAgent().getAgentId().equals(bang.getAgentId())){
				result.add(bang);
			}
		}
		return result;
	}
	
	@Override
	public void deleteDealList(DealVO deal){
		database.tb_deal.remove(deal);
	}
	

}
