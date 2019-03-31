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
			System.out.println("중개소 이름 : " + bang.getAgentName());
			System.out.println("구, 동 : " + bang.getAddress1());
			System.out.println("상세 주소 : " + bang.getAddress2());
			System.out.println("----------------------------------");
		}

		System.out.println("1.매물등록<승인>   2.매물등록<반려>");
		System.out.print("메뉴에 해당하는 번호 입력 > ");
		int inp = Integer.parseInt(in.nextLine());
		switch(inp){
			case 1 :
				AdminYes();
				break;
			case 2 :
				AdminNo();
				break;
		}

	}

	@Override
	public void AdminYes() {
		System.out.print("승인할 방의 번호를 입력해주세요 > ");
		int inp = Integer.parseInt(in.nextLine());

		ArrayList<BangVO> approveList = bangDao.approveList();

		for(int i = 0; i < approveList.size(); i++){
			if(approveList.get(i).getNum() == inp){
				BangVO bang = new BangVO();
				bang = approveList.get(i);
				bangDao.insertBang(bang);
			}
		}

		System.out.println("매물요청리스트에서 " + inp + "번째 매물이 승인되었습니다.");

	}

	@Override
	public void AdminNo() {
		System.out.println("반려할 방의 번호를 입력해주세요 > ");
		int inp = Integer.parseInt(in.nextLine());

		ArrayList<BangVO> approveList = bangDao.approveList();

		for(int i = 0; i < approveList.size(); i++){
			if(approveList.get(i).getNum() == inp){
				BangVO bang = new BangVO();
				bang = approveList.get(i);
				bangDao.deleteBang(bang);
			}
		}

		System.out.println("매물요청리스트에서 " + inp + "번째 매물이 반려되었습니다.");

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
