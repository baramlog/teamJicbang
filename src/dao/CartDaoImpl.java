package dao;

import java.util.ArrayList;

import vo.AgentVO;
import vo.BangVO;
import vo.CartVO;
import vo.Database;

public class CartDaoImpl implements CartDao {
	Database database = Database.getInstance();

	@Override
	public BangVO selectBang(int key) {
		for (int i = 0; i < database.tb_cart.size(); i++) {
			BangVO bang = database.tb_cart.get(i);

			if (key == database.tb_cart.get(i).getBangkey()) {
				return bang;
			}
		}
		return null;
	}

	@Override
	public ArrayList<BangVO> selectCart() {
		/*
		 * for (int i = 0; i < database.tb_cart.size(); i++) { BangVO bang =
		 * database.tb_cart.get(i); }
		 */
		return database.tb_cart;
	}

	@Override
	public void insertCart(BangVO bang) {
		// TODO Auto-generated method stub
		database.tb_cart.add(bang);
	}

	@Override
	public void deleteCart(BangVO bang) {
		database.tb_cart.remove(bang);
	}
}
