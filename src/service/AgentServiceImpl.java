package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vo.AgentVO;
import vo.BangVO;
import vo.Session;
import vo.UserVO;
import dao.AgentDao;
import dao.AgentDaoImpl;
import dao.BangDao;
import dao.BangDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;

public class AgentServiceImpl implements AgentService {
	AgentDao agentDao = new AgentDaoImpl();
	BangDao bangDao = new BangDaoImpl();
	UserDao userDao = new UserDaoImpl();
	Scanner s = new Scanner(System.in);
	Session session = new Session();

	@Override
	public void agentjoin() {
		
		AgentVO agent = new AgentVO();
		UserVO user = new UserVO();
		
		System.out.print("아이디(5~13자리): ");
		while (true) {
			String id = s.nextLine();
			
			user.setId(id);
			agent.setAgentId(id);
			UserVO userCheck = userDao.selectUser("ID", user.getId());
			AgentVO agentCheck = agentDao.selectAgent("ID", agent.getAgentId());
			if(userCheck == null && agentCheck == null){
				String str1 = id;
				String pattern1 = "\\w\\S{4,13}";
				Pattern p1 = Pattern.compile(pattern1);
				Matcher m1 = p1.matcher(str1);
				if (m1.matches()) {
					agent.setAgentId(id);
					break;
				}else{
					System.out.println("주어진 조건에 맞게 입력해주세요");
					System.out.print("아이디를 5~13자 사이로 다시 입력해주세요 >>");
				}
			}else{
				System.out.println("!!!!!!!!아이디 중복!!!!!!!!");
				System.out.print("아이디를 5~13자 사이로 다시 입력해주세요 >> ");
			}
		}
		
		System.out.print("비밀번호(4~6자리) : ");
		while(true){
			String password = s.nextLine();
			String pattern1 = "\\w\\S{3,6}";
			Pattern p1 = Pattern.compile(pattern1);
			Matcher m1 = p1.matcher(password);
			if(m1.matches()){
				agent.setPassword(password);
				break;
			}else{
				System.out.println("비밀번호를 4~6자 사이로 다시 입력해주세요 >> ");
			}
		}
		
		System.out.print("중개사 이름 : ");
		String name = s.nextLine();
		agent.setName(name);
		
		System.out.print("핸드폰번호('-'없이 작성) : ");
		while(true){
			String phone = s.nextLine();
			agent.setPhone(phone);
			AgentVO agentCheck = agentDao.selectAgent("PHONE", agent.getPhone());
			if(agentCheck == null){
				String pattern1 = "^0\\d{1,3}\\d{3,4}\\d{4}";
				Pattern p1 = Pattern.compile(pattern1);
				Matcher m1 = p1.matcher(phone);
				if(m1.matches()){
//					agent.setPhone(phone);
					break;
				}else{
					System.out.print("핸드폰번호('-'없이 작성)를 다시 입력해주세요 >> ");
				}
			}else{
				System.out.println("!!!!!!!핸드폰 번호 중복!!!!!!!");
				System.out.print("핸드폰번호('-'없이 작성)를 다시 입력해주세요 >> ");
			}
		}
		
		System.out.print("이메일(5~13자리) : ");
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
		
	    System.out.println("정상적으로 가입 되었습니다.");
	    agentDao.insertAgent(agent);
	}

	
	@Override
	   public void writeBang(){ //방 등록 -agent
	      Scanner s = new Scanner(System.in);
	      Date today = new Date(); //현재 날짜 저장
	      SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	      
	      System.out.println();
	      System.out.print("면적 : ");
	      int area = Integer.parseInt(s.nextLine());
	      System.out.print("주소(ㅇㅇ구 ㅇㅇ동) : ");
	      String address1 = s.nextLine();
	      System.out.print("상세주소 : ");
	      String address2 = s.nextLine();
	      System.out.print("방, 화장실 개수(방 ㅇ개, 화장실 ㅇ개 ): ");
	      String option1 = s.nextLine();
	      System.out.print("역세권 (ㅇㅇ역 근처, 없으면 '없음'): ");
	      String option2 = s.nextLine();
	      System.out.print("전세/월세/매매 : ");
	      String category = s.nextLine();
	      System.out.print("준공일자(YYYY-MM-DD) : ");
	      String workDate = s.nextLine();
	      System.out.print("가격(단위 : 억) : ");
	      double price = Double.parseDouble(s.nextLine());
	      System.out.println();
	      
	      System.out.println("작성하신 신청서 내용이 맞습니까?");
	      System.out.println();
	      System.out.println("면적: " + area);
	      System.out.println("주소(구동): " + address1);
	      System.out.println("상세주소: " + address2);
	      System.out.println("방, 화장실 개수: " + option1);
	      System.out.println("역세권: " + option2);
	      System.out.println("전세/월세/매매: " + category);
	      System.out.println("준공일자: " + workDate);
	      System.out.println("가격: " + price + "억 원");
	      System.out.println();
	      
	      BangVO bang = new BangVO();
	      bang.setAgentId(session.getLoginAgent().getAgentId());
	      bang.setArea(area);
	      bang.setAddress1(address1);
	      bang.setAddress2(address2);
	      bang.setOption1(option1);
	      bang.setOption2(option2);
	      bang.setCategory(category);
	      bang.setWorkDate(workDate); 
	      bang.setPrice(price);
	      bang.setStartDate(sdf1.format(today));
	      
	      ArrayList<AgentVO> agentList = agentDao.selectAgentList();
	      for(int i = 0; i < agentList.size(); i++){
	         if(agentList.get(i).getAgentId().equals(session.getLoginAgent().getAgentId())){
	            bang.setAgentName(agentList.get(i).getName());
	         }
	      }
	      checkInsertBang(bang);
	      
	   }
	
	@Override
	public void checkInsertBang(BangVO bang){
		System.out.print("작성한 내용이 맞으시면 'y', 틀리면 'n'을 적어주세요. >");
		String yesno = s.nextLine();
		switch(yesno){
			case "y":
				agentDao.updateBang(bang);
				System.out.println("등록이 완료되었습니다. 관리자 승인시 등록됩니다.");
				break;
			case "n":
				writeBang();
				break;
			default:
				checkInsertBang(bang);
				break;
		}
	}
	
	@Override
	public void insertBang(BangVO bang){
		bangDao.insertBang(bang);
	}
	@Override
	public void searchBang(){ //방 검색
		 
	}
	public void detailBang(){ //방 상세보기 -common
		
	}
}
