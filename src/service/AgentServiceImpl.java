package service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.AgentDao;
import dao.AgentDaoImpl;
import vo.AgentVO;
import vo.BangVO;

public class AgentServiceImpl implements AgentService {

	Scanner s = new Scanner(System.in);
	AgentDao agentDao = new AgentDaoImpl();

	@Override
	public void agentjoin() {
		// TODO Auto-generated method stub
		System.out.print("아이디(5~13자리): ");
		String id = s.nextLine();
		System.out.print("비밀번호(4~6자리): ");
		String password = s.nextLine();
		System.out.print("공인중개사 이름: ");
		String name = s.nextLine();
		System.out.print("핸드폰번호('-'없이 작성): ");
		String phone = s.nextLine();
		System.out.print("이메일: ");
		String email = s.nextLine();
		
		
		
		AgentVO agent = new AgentVO();
		
		agent.setAgentId(id);
		agent.setPassword(password);
		agent.setName(name);
		agent.setPhone(phone);
		agent.setEmail(email);
		
		//아이디 중복 확인
		AgentVO userCheck = agentDao.selectAgent("ID", agent.getAgentId());
		AgentVO userCheck1 = agentDao.selectAgent("phone", agent.getPhone());
		AgentVO userCheck2 = agentDao.selectAgent("email", agent.getName());
		
		//아이디랑 비밀번호 체크
		if(userCheck == null){
			String str1 = id;
			String pattern1 = "\\w\\S{5,13}";
			Pattern p1 = Pattern.compile(pattern1);
			Matcher m1 = p1.matcher(str1);
			if(m1.matches()){
				String str2 = password;
				String pattern2 = "\\w\\S{4,6}";
				Pattern p2 = Pattern.compile(pattern2);
				Matcher m2 = p1.matcher(str2);
				if(m2.matches()){
					if(userCheck1 == null){
						String str3 = phone;
						String pattern3 = "^0\\d{1,3}\\d{3,4}\\d{4}";
						Pattern p3 = Pattern.compile(pattern3);
						Matcher m3 = p3.matcher(str3);
						if(m1.matches()){
							if(userCheck2 == null){
								String str4 = email;
								String pattern4 = "\\w\\S{4,13}@[a-zA-Z]+\\.(?i)(com|net|org|([a-z]{2}\\.kr))$";
								Pattern p4 = Pattern.compile(pattern4);
								Matcher m4 = p1.matcher(str4);
								if(m1.matches()){
									agentDao.insertAgent(agent);
								}else{
									System.out.println("이메일을 다시 입력해주세요.");
								}
							}else{
								System.out.println("이메일이 중복입니다. 다시 입력해주세요.");
							}
							
						}else{
							System.out.println("핸드폰 번호를 다시 입력해주세요.");
						}
					}else{
						System.out.println("핸드폰번호가 중복입니다. 다시 입력해주세요.");
					}
					
				}else{
					System.out.println("비밀번호를 4~6자 사이로 다시 입력해주세요.");
				}
			}else{
				System.out.println("아이디를 5~13자 사이로 다시 입력해주세요.");
			}
		}else{
			System.out.println("아이디가 중복입니다. 다시 입력해주세요.");
		}	
	}

	@Override
	public void agentcheck() {
		// TODO Auto-generated method stub
		System.out.print("아이디 : ");
		String id = s.nextLine();
		System.out.print("비번 : ");
		String password = s.nextLine();

		AgentVO agent = new AgentVO();
		agent.setAgentId(id);
		agent.setPassword(password);

		AgentVO agentCheck = agentDao.selectAgent("ID", agent.getAgentId());

		if (agentCheck == null) {
			System.out.println("등록된 정보가 없습니다. 회원가입을 하세요");
		} else {
			System.out.println("환영합니다 중개인님" + "\t" + "로그아웃");
		}
	}
	
	@Override
	public void insertBang(){ //방 등록 -agent
		
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
		System.out.print("관리비(단위 : 만원) : ");
		int mprice = Integer.parseInt(s.nextLine());
		System.out.println("가격(단위 : 억) : ");
		float price = Float.parseFloat(s.nextLine());
		
		BangVO bang = new BangVO();
		
		bang.setArea(area);
		bang.setAddress1(address1);
		bang.setAddress2(address2);
		bang.setOption1(option1);
		bang.setOption1(option2);
		bang.setCategory(category);
		bang.setWorkDate(workDate);
		bang.setPrice(price);
		
//		BangVO userCheck = bangDao.selectUser("POST", bang.getAddress1().trim() + bang.getAddress2().trim());
		
	}
	
	@Override
	public void searchBang(){ //방 검색
		 
	}
	public void detailBang(){ //방 상세보기 -common
		
	}
}
