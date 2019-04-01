



package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.AdminService;
import service.AdminServiceImpl;
import service.NoticeService;
import service.NoticeServiceImpl;
import vo.BangVO;
import vo.Session;
import dao.BangDao;
import dao.BangDaoImpl;

public class AdminController {
	Scanner in = new Scanner(System.in);
//	UserService userService = new UserServiceImpl();
//	AgentService agentService = new AgentServiceImpl();
	AdminService adminService = new AdminServiceImpl();
	NoticeService notice = new NoticeServiceImpl();
//	AgentDao agentDao = new AgentDaoImpl();
//	UserDao userDao = new UserDaoImpl();
	BangDao bangDao = new BangDaoImpl();
	boolean isContinue = true;

	public void adminmenu() {
		while (isContinue) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.print("1. 매물요청리스트" + "\t");
			System.out.print("2. 공지사항관리" + "\t\t");
			System.out.println("3. 로그아웃");

			System.out.print("메뉴에 해당하는 번호 입력>");
			int menu = Integer.parseInt(in.nextLine());

			switch (menu) {
			case 1: // 매물요청리스트
				AdminOKList();
				break;
			case 2: // 공지사항관리
				notice.adminMenu();
				break;
			case 3: // 로그아웃
				// agentService.agentjoin();
				new Session().setLoginAdmin(null);
				isContinue = false;
				break;
			default:
				System.out.println("*** 해당 값만 입력해주세요. ***");
				adminmenu();
				break;
			}
		}
	}

	 public void AdminOKList() {
	      ArrayList<BangVO> approveList = bangDao.approveList();
	      int idx = 1;
	      if(approveList.isEmpty()){
	         System.out.println("!!!!!!!!매물승인요청이 없습니다.!!!!!!!!");
	      }else{
	         System.out.println("------------승인요청리스트--------------");
	         for(BangVO bang : approveList){
	            bang.setNum(idx++);
	            System.out.println("No. " + bang.getNum());
	            System.out.println("중개소 이름 : " + bang.getAgentName());
	            System.out.println("구, 동 : " + bang.getAddress1());
	            System.out.println("상세 주소 : " + bang.getAddress2());
	            System.out.println("----------------------------------");
	         }
	         AdminListOK();
	     }
	 }

	 public void AdminListOK(){
		 System.out.println("1.매물등록<승인>   2.매물등록<반려>   3.홈");
         System.out.print("메뉴에 해당하는 번호 입력 > ");
         int inp = Integer.parseInt(in.nextLine());
         switch(inp){
         case 1 :
            adminService.AdminYes();
            break;
         case 2 :
            adminService.AdminNo();
            break;
         case 3:
        	adminmenu();
        	break;
         default:
        	System.out.println("*** 해당 값만 입력해주세요. ***");
        	AdminListOK();
        	break;
         }
	 }
}
