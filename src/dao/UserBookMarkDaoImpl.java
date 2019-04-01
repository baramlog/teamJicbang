package dao;

import java.util.ArrayList;

import vo.AgentcartVO;
import vo.Database;
import vo.Session;

public class UserBookMarkDaoImpl implements UserBookMarkDao {

	Database db = Database.getInstance();

	@Override
	public void insertBookMark(AgentcartVO bookmark) {
		db.tb_agentcart.add(bookmark);
	}

	@Override
	public void removeBookMark(AgentcartVO bookmark) {
		db.tb_agentcart.remove(bookmark);
	}

	@Override
	public ArrayList<AgentcartVO> getList() {		
		return db.tb_agentcart;
	}

}
