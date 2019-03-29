package dao;

import java.util.ArrayList;

import vo.Database;
import vo.UserVO;

public class UserDaoImpl implements UserDao {
	
	Database database = Database.getInstance();
	
	@Override
	public UserVO selectUser(String key, String value) {
		for(int i = 0 ; i < database.tb_user.size(); i++){
			UserVO user = database.tb_user.get(i);
			
			if(key.equals("ID")){
				if(user.getId().equals(value)){
					return user;
				}
			}
		}
		return null;
	}
	
	
	
	@Override
	public void insertUser(UserVO user) {
		database.tb_user.add(user);
	}

	@Override
	public ArrayList<UserVO> selectUserList() {
		
		return database.tb_user;
	}



	@Override
	public void dealMoney(int price) {

		
	}




}
