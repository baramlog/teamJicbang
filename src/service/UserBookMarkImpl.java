package service;

import java.util.ArrayList;

import vo.AgentcartVO;
import vo.Session;
import dao.AgentDao;
import dao.AgentDaoImpl;
import dao.UserBookMarkDao;
import dao.UserBookMarkDaoImpl;


public class UserBookMarkImpl implements UserBookMark {
	
	UserBookMarkDao dao = new UserBookMarkDaoImpl();
	AgentDao aDao = new AgentDaoImpl();
	Session session = new Session();
	@Override
	public void addBookMark(String agentId) {
		AgentcartVO bookmark = new AgentcartVO();
		bookmark.setAgentId(agentId);
		bookmark.setUserId(session.getLoginUser().getId());
		
		for(AgentcartVO item : dao.getList()){
			if(item.getAgentId().equals(agentId)){
				System.out.printf("****중개인(%s)은 즐겨찾기 목록에 존재합니다.****\n\n",agentId);
				return;
			}
		}			
		dao.insertBookMark(bookmark);
		System.out.printf("****중개인(%s)를 즐겨찾기 하였습니다.****\n\n",agentId);
	}

	@Override
	public void removeBookMark(AgentcartVO agent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAgentList() {
		ArrayList<AgentcartVO> result = new ArrayList<AgentcartVO>();
		
		for(AgentcartVO item : dao.getList()){
			if(item.getUserId().equals(session.getLoginUser().getId()))
					result.add(item);
		}
		System.out.println("\n총 " + result.size() + "건의 즐겨찾기 결과가 있습니다.");
		int idx = 1;
		for(AgentcartVO item : result){			
			System.out.println("----------------------------------------------");
			System.out.printf("%d. %s(%s)\n",idx++,aDao.selectAgent("ID", item.getAgentId()).getName(),item.getAgentId());
		}
		System.out.println("----------------------------------------------");
		System.out.println();
			
	}

}
