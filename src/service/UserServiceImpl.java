package service;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vo.AgentVO;
import vo.Session;
import vo.UserVO;
import dao.AgentDao;
import dao.AgentDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	Scanner s = new Scanner(System.in);
	UserDao userDao = new UserDaoImpl();
	AgentDao agentDao = new AgentDaoImpl();
	Session session = new Session();

	@Override
	public void userjoin() {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		UserVO user = new UserVO();
		UserVO userCheck = userDao.selectUser("ID", user.getId());
		ArrayList<UserVO> userList = userDao.selectUserList();
		boolean check = false;
		System.out.print("아이디(5~13자리): ");
		while (true) {
			String id = s.nextLine();
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
		}

		System.out.print("비밀번호(4~6자리): ");
		while (true) {

			String password = s.nextLine();

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
	      ArrayList<AgentVO> agentList = agentDao.selectAgentList();
	      AgentVO agent = new AgentVO();
	      UserVO user = new UserVO();
	      boolean check = true;
	      String str = null;
	      
	      while(check){
	         System.out.print("아이디 : ");
	         String id = s.nextLine();
	         System.out.print("비번 : ");
	         String password = s.nextLine();
	      
	         for(int i = 0; i < userList.size(); i++){
	            if(userList.get(i).getId().equals(id)){
	               if(userList.get(i).getPassword().equals(password)){
	                  user.setId(id);
	                  System.out.println("   ┌─────────────────────────────────┐");
	                  System.out.println("   │  환영합니다. 사용자 : " + userList.get(i).getId() + "님   │");
	                  System.out.println("   └─────────────────────────────────┘");
	                  session.setLoginUser(user);
	                  str = "user";
	                  check = false;
	               }else{
	                  //패스워드 틀림
	                  str = null;
	                  check = true;
	               }
	            }else{
	               //아이디 틀림
	               str = null;
	               check = true;
	            }
	            if(str != null){
	               check = false;
	               return str;
	            }
	         }
	         for(int i = 0; i < agentList.size(); i++){
	            if(agentList.get(i).getAgentId().equals(id)){
	               if(agentList.get(i).getPassword().equals(password)){
	                  if(agentList.get(i).getLevel() == 9){
	                     System.out.println("   ┌─────────────────────────────────┐");
	                     System.out.println("   │  관리자님께서 로그인하셨습니다                           │");
	                     System.out.println("   └─────────────────────────────────┘");
	                     str = "admin";
	                     check = false;
	                  }else{
	                     agent.setAgentId(id);
	                     System.out.println("   ┌─────────────────────────────────┐");
	                     System.out.println("   │ 환영합니다. 중개인 : " + agentList.get(i).getAgentId() + "님  │");
	                     System.out.println("   └─────────────────────────────────┘");
	                     session.setLoginAgent(agent);
	                     str = "agent";
	                     check = false;
	                  }
	               }else{
	                  //패스워드 틀림
	                  str = null;
	                  check = true;
	               }
	            }else{
	               //아이디 틀림
	               str = null;
	               check = true;
	            }
	            if(str != null){
	               check = false;
	               return str;
	            }
	         }
	         System.out.println("!!!!등록된 정보가 없습니다. 회원가입을 하세요!!!!");
	         check = false;
	      }
	      return str;
	   }
	
	
}
