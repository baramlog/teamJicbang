package service;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vo.AgentVO;
import vo.BangVO;
import vo.Session;
import dao.AgentDao;
import dao.AgentDaoImpl;

public class AgentServiceImpl implements AgentService {
	AgentDao agentDao = new AgentDaoImpl();
	Scanner s = new Scanner(System.in);
	Session session = new Session();
	
	@Override
	public void agentjoin() {
		
		AgentVO agent = new AgentVO();
	
		System.out.println("아이디(5~13자리) : ");
		while(true){
			String id = s.nextLine();
			String pattern1 = "\\w\\S{4,13}";
			Pattern p1 = Pattern.compile(pattern1);
			Matcher m1 = p1.matcher(id);
			if(m1.matches()){
				agent.setAgentId(id);
				break;
			}else{
				System.out.println("아이디를 5~13자 사이로 다시 입력해주세요 >> ");
			}
		}
		
		System.out.println("비밀번호(4~6자리) : ");
		while(true){
			String password = s.nextLine();
			String pattern1 = "\\w\\S{4,6}";
			Pattern p1 = Pattern.compile(pattern1);
			Matcher m1 = p1.matcher(password);
			if(m1.matches()){
				agent.setPassword(password);
				break;
			}else{
				System.out.println("비밀번호를 4~6자 사이로 다시 입력해주세요 >> ");
			}
		}
		
		System.out.println("중개사 이름 : ");
		String name = s.nextLine();
		agent.setName(name);
		
		System.out.println("핸드폰번호('-'없이 작성) : ");
		while(true){
			String phone = s.nextLine();
			String pattern1 = "^0\\d{1,3}\\d{3,4}\\d{4}";
			Pattern p1 = Pattern.compile(pattern1);
			Matcher m1 = p1.matcher(phone);
			if(m1.matches()){
				agent.setPhone(phone);
				break;
			}else{
				System.out.println("핸드폰번호('-'없이 작성)를 다시 입력해주세요 >> ");
			}
		}
		
		System.out.println("이메일(5~13자리) : ");
		while(true){
			String email = s.nextLine();
			String pattern1 = "\\w\\S{4,13}@[a-zA-Z]+\\.(?i)(com|net|org|([a-z]{2}\\.kr))$";
			Pattern p1 = Pattern.compile(pattern1);
			Matcher m1 = p1.matcher(email);
			if(m1.matches()){
				agent.setEmail(email);
				break;
			}else{
				System.out.println("이메일을 형식에 맞춰 다시 입력해주세요 >> ");
			}
		}
		
		AgentVO agentCheck1 = agentDao.selectAgent("ID", agent.getAgentId());
	    AgentVO agentCheck2 = agentDao.selectAgent("PHONE", agent.getPhone());
	    
	      if(agentCheck1 == null) {
	    	  if(agentCheck2 == null){
	    		  agentDao.insertAgent(agent);
	    	  }else{
	    		  System.out.println("핸드폰번호 중복입니다.");
	    	  }
	      }else{
	    	  System.out.println("아이디 중복입니다");
	      }
	}

	
	@Override
	public void insertBang(){ //방 등록 -agent
		Scanner s = new Scanner(System.in);
		
		System.out.print("면적 : ");
		int area = Integer.parseInt(s.nextLine());
		System.out.print("주소(구동) : ");
		String address1 = s.nextLine();
		System.out.print("상세주소 : ");
		String address2 = s.nextLine();
		System.out.print("방, 화장실 개수 : ");
		String option1 = s.nextLine();
		System.out.print("역세권 : ");
		String option2 = s.nextLine();
		System.out.print("전월세, 매매 : ");
		String category = s.nextLine();
		System.out.print("준공일자(YYYY-MM-DD) : ");
		String workDate = s.nextLine();
		System.out.print("가격(단위 : 억) : ");
		double price = Float.parseFloat(s.nextLine());
		
		BangVO bang = new BangVO();
		
		bang.setAgentId(session.getLoginAgent().getAgentId());
		bang.setArea(area);
		bang.setAddress1(address1);
		bang.setAddress2(address2);
		bang.setOption1(option1);
		bang.setOption1(option2);
		bang.setCategory(category);
		bang.setWorkDate(workDate);
		bang.setPrice(price);
		
		agentDao.updateBang(bang);
		
//		BangVO userCheck = bangDao.selectUser("POST", bang.getAddress1().trim() + bang.getAddress2().trim());
		
	}
	@Override
	public void searchBang(){ //방 검색
		 
	}
	public void detailBang(){ //방 상세보기 -common
		
	}
}
