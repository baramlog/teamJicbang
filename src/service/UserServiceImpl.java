package service;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vo.AgentVO;
import vo.UserVO;
import dao.AgentDao;
import dao.AgentDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	Scanner in = new Scanner(System.in);

	UserDao userDao = new UserDaoImpl();

	@Override
	public void userjoin() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		UserVO user = new UserVO();
		UserVO userCheck = userDao.selectUser("ID", user.getId());
		ArrayList<UserVO> userList = userDao.selectUserList();
		boolean check = false;
		System.out.print("아이디(5~13자리): ");
		while (true) {
			String id = in.nextLine();
			if (check == false) {
				for (int i = 0; i < userList.size(); i++) {
					if (userList.get(i).getId().equals(id)) {
						System.out.println("중복되었습니다");
						System.out.print("아이디(5~13자리): ");
					} else
						check = true;
				}
			}
			if (check == true) {
				String str1 = id;
				String pattern1 = "\\w\\S{4,13}";
				Pattern p1 = Pattern.compile(pattern1);
				Matcher m1 = p1.matcher(str1);
				if (m1.matches()) {
					user.setId(id);
					break;
				} else {
					System.out.print("아이디를 5~13자 사이로 다시 입력해주세요 >>");
					check = false;
				}
			}

			// else if (user.getId().equals(id)) {
			// System.out.println("중복되었습니다");
			// System.out.print("아이디(5~13자리): ");
		}

		System.out.print("비밀번호(4~6자리): ");
		while (true) {

			String password = in.nextLine();

			String str2 = password;
			String pattern2 = "\\w\\S{3,6}";
			Pattern p2 = Pattern.compile(pattern2);
			Matcher m2 = p2.matcher(str2);

			if (m2.matches()) {
				user.setPassword(password);
				break;
			}
			System.out.print("비밀번호를 4~6자 사이로 다시 입력해주세요 >>");
		}
		if (userCheck == null) {
			userDao.insertUser(user);
		}
	}

	@Override
	public String usercheck() {
		ArrayList<UserVO> userList = userDao.selectUserList();
		for (UserVO user : userList) {
			System.out.println(user.getId());
		}
		System.out.print("아이디 : ");
		String id = in.nextLine();
		System.out.print("비번 : ");
		String password = in.nextLine();
		
		 if(userList.isEmpty()){
	         System.out.println("등록된 정보가 없습니다. 회원가입을 하세요");
	         return null;
	      }else {
	         for(int i = 0; i < userList.size(); i++){
	            if(userList.get(i).getId().equals(id)){
	            	if(userList.get(i).getPassword().equals(password)){
	            		System.out.println("환영합니다 사용자 : " + userList.get(i).getId() + "  " + "로그아웃");
	            	}else{
	            		System.out.println("패스워드 틀리셨습니다.");
	            		return null;
	            	}
	            }
	         }
	         return "";
	      }
	}
}