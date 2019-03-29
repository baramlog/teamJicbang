package service;

import java.util.Scanner;


public class AdminServiceImpl implements AdminService {
	Scanner s = new Scanner(System.in);
	UserService userService = new UserServiceImpl();
	AgentService agentService = new AgentServiceImpl();
	
	@Override
	public void AdminOKList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void AdminYes() {
		// TODO Auto-generated method stub

	}

	@Override
	public void AdminNo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void NoticeAddList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void NoticeDeleteList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void answer() {
		// TODO Auto-generated method stub
			System.out.println("1. 사용자");
			System.out.println("2. 중개인");
			System.out.print("해당하는 사용자 입력>>");
			int who = Integer.parseInt(s.nextLine());
			switch(who){
			case 1 : 
				userService.usercheck();
				break;
			case 2 :
				agentService.agentcheck();
				break;
			}
		}
		
	}
	

/*	@Override
	public void userList() {
		ArrayList<UserVO> userList = userDao.selectUserList();

		System.out.println("---------------------------------");
		for (UserVO user : userList) {
			System.out.println("아이디 : " + user.getId());
			System.out.println("---------------------------------");
		}

	}
	
	@Override
	public void agentList() {
		ArrayList<AgentVO> agentList = agentDao.selectAgentList();

		System.out.println("---------------------------------");
		for (AgentVO agent : agentList) {
			System.out.println("아이디 : " + agent.getAgentId());
			System.out.println("공인중개사 이름 : " + agent.getName());
			System.out.println("핸드폰번호 : " + agent.getPhone());
			System.out.println("이메일 : " + agent.getEmail());
			System.out.println("---------------------------------");
		}
	}
*/
	
