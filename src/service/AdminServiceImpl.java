package service;

import java.util.ArrayList;
import java.util.Scanner;

import controller.AdminController;
import controller.AgentController;
import controller.UserController;
import dao.AgentDao;
import dao.AgentDaoImpl;
import dao.BangDao;
import dao.BangDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import vo.AgentVO;
import vo.BangVO;
import vo.UserVO;

public class AdminServiceImpl implements AdminService {
	Scanner in = new Scanner(System.in);
	UserService userService = new UserServiceImpl();
	AgentService agentService = new AgentServiceImpl();
	BangDao bangDao = new BangDaoImpl();
	UserDao userDao = new UserDaoImpl();
	AgentDao agentDao = new AgentDaoImpl();
//	AdminController adminController = new AdminController();
//	AgentController agentController = new AgentController();
//	UserController userController = new UserController();
	boolean isContinue = true;

	@Override
	public void AdminOKList() {
		ArrayList<BangVO> approveList = bangDao.approveList();
		int idx = 1;
		System.out.println("------------승인요청리스트--------------");
		for(BangVO bang : approveList){
			bang.setNum(idx++);
			System.out.println("No. " + bang.getNum());
			System.out.println("구, 동 : " + bang.getAddress1());
			System.out.println("상세 주소 : " + bang.getAddress2());
			System.out.println("----------------------------------");
		}

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

}
