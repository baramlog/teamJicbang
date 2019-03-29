package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.AgentDao;
import dao.AgentDaoImpl;
import vo.AgentVO;
import vo.UserVO;

public class AdminServiceImpl implements AdminService {
	Scanner in = new Scanner(System.in);
	UserService userService = new UserServiceImpl();
	AgentService agentService = new AgentServiceImpl();

	AgentDao agentDao = new AgentDaoImpl();

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
	public void login() {
		// TODO Auto-generated method stub
		System.out.println("1. 사용자");
		System.out.println("2. 중개인");
		System.out.println("3. 관리자");
		System.out.print("해당하는 사용자 입력>>");
		int who = Integer.parseInt(in.nextLine());
		switch (who) {
		case 1:
			userService.usercheck();
			break;
		case 2:
			agentService.agentcheck();
			break;
		case 3:
			agentService.agentcheck();
			break;
		}
	}

	@Override
	public void join() {
		// TODO Auto-generated method stub
		System.out.println("1. 사용자");
		System.out.println("2. 중개인");
		System.out.print("해당하는 사용자 입력>>");
		int who = Integer.parseInt(in.nextLine());
		switch (who) {
		case 1:
			userService.userjoin();
			break;
		case 2:
			agentService.agentjoin();
			break;
		}
	}

	/*public void admincheck() {
		// AgentVO userCheck = agentDao.selectUser("ID", agent.getId());
		ArrayList<AgentVO> agentList = agentDao.selectAgentList();
		for (AgentVO ag : agentList) {
			System.out.println(ag.getAgentId());
		}
		System.out.print("아이디 : ");
		String id = in.nextLine();
		System.out.print("비번 : ");
		String password = in.nextLine();

		// AgentVO adminCheck = agentDao.selectAgent("ID", agent.getAgentId());

		for (int i = 0; i < agentList.size(); i++) {
			if (agentList.get(i).getAgentId().equals(id)) {
				System.out.println("환영합니다 관리자님 : "
						+ agentList.get(i).getAgentId() + "  " + "로그아웃");
			}else
				break;
		}
		System.out.println("나가세요");
	}*/
}

/*
 * @Override public void userList() { ArrayList<UserVO> userList =
 * userDao.selectUserList();
 * 
 * System.out.println("---------------------------------"); for (UserVO user :
 * userList) { System.out.println("아이디 : " + user.getId());
 * System.out.println("---------------------------------"); }
 * 
 * }
 * 
 * @Override public void agentList() { ArrayList<AgentVO> agentList =
 * agentDao.selectAgentList();
 * 
 * System.out.println("---------------------------------"); for (AgentVO agent :
 * agentList) { System.out.println("아이디 : " + agent.getAgentId());
 * System.out.println("공인중개사 이름 : " + agent.getName());
 * System.out.println("핸드폰번호 : " + agent.getPhone());
 * System.out.println("이메일 : " + agent.getEmail());
 * System.out.println("---------------------------------"); } }
 */

