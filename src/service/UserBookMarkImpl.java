package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import vo.AgentcartVO;
import vo.BangVO;
import vo.Session;
import dao.AgentDao;
import dao.AgentDaoImpl;
import dao.BangDao;
import dao.BangDaoImpl;
import dao.UserBookMarkDao;
import dao.UserBookMarkDaoImpl;

public class UserBookMarkImpl implements UserBookMark {

	UserBookMarkDao dao = new UserBookMarkDaoImpl();
	AgentDao aDao = new AgentDaoImpl();
	Session session = new Session();
	Scanner s = new Scanner(System.in);
	int startNum, endNum;

	@Override
	public void addBookMark(String agentId) {
		AgentcartVO bookmark = new AgentcartVO();
		bookmark.setAgentId(agentId);
		bookmark.setUserId(session.getLoginUser().getId());

		for (AgentcartVO item : dao.getList()) {
			if (item.getAgentId().equals(agentId)) {
				System.out.printf("****중개인(%s)은 즐겨찾기 목록에 존재합니다.****\n\n",
						agentId);
				return;
			}
		}
		dao.insertBookMark(bookmark);
		System.out.printf("****중개인(%s)를 즐겨찾기 하였습니다.****\n\n", agentId);
	}

	@Override
	public void removeBookMark(AgentcartVO agent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAgentList() {
		ArrayList<AgentcartVO> result = new ArrayList<AgentcartVO>();
		HashMap<Integer, AgentcartVO> matchIndexList = new HashMap<Integer, AgentcartVO>();
		InputValueCheck checkValue = new InputValueCheckImpl();

		for (AgentcartVO item : dao.getList()) {
			if (item.getUserId().equals(session.getLoginUser().getId()))
				result.add(item);
		}
		System.out.println("\n총 " + result.size() + "건의 즐겨찾기 결과가 있습니다.");
		int idx = 1;
		startNum = idx;
		for (AgentcartVO item : result) {
			matchIndexList.put(idx, item);
			endNum = idx;
			System.out
					.println("----------------------------------------------");
			System.out.printf("%d. %s(%s)\n", idx++,
					aDao.selectAgent("ID", item.getAgentId()).getName(),
					item.getAgentId());
		}
		System.out.println("----------------------------------------------");
		System.out.println();
		System.out.print("즐겨찾기 된 공인중개사가 올린 매물을 보시겠습니까?(y/n) > ");
		String cmd = s.nextLine();
		switch (cmd) {
			case "y":
				System.out.print("목록에 표시된 공인중개사의 번호를 입력하세요. > ");
				String cmd2 = s.nextLine();
				if (!checkValue.checkNumber(cmd2, startNum, endNum)) {
					printError();
					getAgentList();
					break;
				}
				BangDao bangDao = new BangDaoImpl();
				ArrayList<BangVO> bangList = bangDao.selectList();
				BangServiceImpl bangService = new BangServiceImpl();
				for(BangVO item : bangList){
					if(matchIndexList.get(Integer.parseInt(cmd2)).getAgentId().equals(item.getAgentId()))
						bangService.searchResult.add(item);
				}
				bangService.printList();				
				break;
	
			case "n":
				break;
	
			default:
				printError();
				getAgentList();
		}

	}

	public void printError() {
		System.out.println("\n잘못 입력하셨습니다.");
	}

}
