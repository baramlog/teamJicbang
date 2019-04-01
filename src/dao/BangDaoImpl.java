package dao;

import vo.Database;

import java.util.ArrayList;
import java.util.HashMap;

import vo.BangVO;

public class BangDaoImpl implements BangDao {

	Database database = Database.getInstance();
	
	@Override
	public ArrayList<BangVO> approveList() {
		// TODO Auto-generated method stub
		return database.tb_approve;
	}

	@Override
	public void insertBang(BangVO bang) {
		database.tb_bang.add(bang);
		database.tb_approve.remove(bang);
	}

	@Override
	public void deleteBang(BangVO bang) {
		database.tb_approve.remove(bang);
		
	}
	
	@Override
	public void deleteDealBang(BangVO bang){
//		database.tb_dealbang.add(bang);
		database.tb_bang.remove(bang);
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

	@Override
	public ArrayList<BangVO> myApproveList() {
		// TODO Auto-generated method stub
		return null;
	}
}
