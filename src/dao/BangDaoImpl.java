package dao;

import vo.Database;

import java.util.ArrayList;
import java.util.HashMap;

import vo.BangVO;

public class BangDaoImpl implements BangDao {

	Database database = Database.getInstance();
	
	@Override
	public ArrayList<BangVO> selectApproveList() {
		return database.tb_approve;
	}

	@Override
	public void approve(int key) {
		database.tb_bang.add(database.tb_approve.get(key));
		database.tb_approve.remove(key);
	}

	@Override
	public void back(int key) {
		database.tb_approve.remove(key);
	}

	@Override
	public ArrayList<BangVO> selectList() {
		
		return database.tb_bang;
	}

	@Override
	public HashMap<String, ArrayList<String>> searchKeyList() {
//		지역분류로 검색할 때 메뉴에 제시할 구/동 데이터 생성
		HashMap<String, ArrayList<String>> searchKey = new HashMap<String, ArrayList<String>>();
		String[] addr1 = {"중구","동구","대덕구"};
		String[][] addr2 = {
				{"문화동","대흥동","선화동"},
				{"홍도동","용운동","용전동"},
				{"송촌동","중리동","법동"}
		};

		for(int i=0; i<addr1.length; i++){
			searchKey.put(addr1[i], new ArrayList<String>());
			for(int j=0; j<addr2[i].length; j++)
				searchKey.get(addr1[i]).add(addr2[i][j]);
		}
		return searchKey;
	}

}
