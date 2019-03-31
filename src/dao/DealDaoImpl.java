package dao;

import java.util.ArrayList;

import vo.Database;
import vo.DealVO;

public class DealDaoImpl implements DealDao {

	Database database = Database.getInstance();

	@Override
	public ArrayList<DealVO> showDeal() {
		return database.tb_deal;
	}

	@Override
	public void insertDeal(DealVO deal) {
		database.tb_deal.add(deal);

	}



}