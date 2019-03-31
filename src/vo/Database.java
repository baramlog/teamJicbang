package vo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

public class Database {
	private static Database instance;

	private Database() {
	}

	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}

	public ArrayList<AgentVO> tb_agent = new ArrayList<AgentVO>(); // 중개인 테이블
	{
		AgentVO admin = new AgentVO();
		admin.setAgentId("lovelysh24");
		admin.setPassword("1234");
		admin.setName("관리자");
		admin.setPhone("010-2738-8924");
		admin.setEmail("lovelysh24@gmail.com");
		admin.setLevel(9);
		tb_agent.add(admin);
		
		AgentVO agent = new AgentVO();
		agent.setAgentId("asdfg");
		agent.setPassword("asdf");
		agent.setName("해솔중개사");
		agent.setPhone("010-2738-8924");
		agent.setEmail("lovelysh24@gmail.com");
		agent.setLevel(1);
		tb_agent.add(agent);
		
		agent = new AgentVO();
		agent.setAgentId("abcd1234");
		agent.setPassword("1234");
		agent.setName("재권중개사");
		agent.setPhone("010-2738-8924");
		agent.setEmail("lovelysh24@gmail.com");
		agent.setLevel(1);
		tb_agent.add(agent);
		
		agent = new AgentVO();
		agent.setAgentId("abcd12345");
		agent.setPassword("1234");
		agent.setName("서익중개사");
		agent.setPhone("010-2738-8924");
		agent.setEmail("lovelysh24@gmail.com");
		agent.setLevel(1);
		tb_agent.add(agent);
		
		agent = new AgentVO();
		agent.setAgentId("abcd123456");
		agent.setPassword("1234");
		agent.setName("성희중개사");
		agent.setPhone("010-2738-8924");
		agent.setEmail("lovelysh24@gmail.com");
		agent.setLevel(1);
		tb_agent.add(agent);

		agent = new AgentVO();
		agent.setAgentId("admin");
		agent.setPassword("1234");
		agent.setName("관리자");
		agent.setPhone("010-2738-8924");
		agent.setEmail("lovelysh24@gmail.com");
		agent.setLevel(9);
		tb_agent.add(agent);

		agent = new AgentVO();
		agent.setAgentId("agent");
		agent.setPassword("1234");
		agent.setName("test");
		agent.setPhone("010-2738-8924");
		agent.setEmail("lovelysh24@gmail.com");
		agent.setLevel(1);
		tb_agent.add(agent);


	}
	
	public ArrayList<UserVO> tb_user = new ArrayList<UserVO>();// 유저 테이블
	{
		UserVO user = new UserVO();
		user.setId("qwert");
		user.setPassword("1234");
		tb_user.add(user);

		user = new UserVO();
		user.setId("user");
		user.setPassword("1234");
		tb_user.add(user);
	}
	public ArrayList<BangVO> tb_bang = new ArrayList<BangVO>(); // 방 테이블

	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		Date today = new Date();
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = date.format(today);
		String strDate = date.format(cal.getTime());
		
		BangVO bang = new BangVO();
		bang.setPrice(5.2);
		bang.setCategory("매매");
		bang.setArea(134);
		bang.setState("판매중");
		bang.setAddress1("대덕구 송촌동");
		bang.setAddress2("크로바아파트 106동 207호");
		bang.setOption1("방 3개, 화장실 2개");
		bang.setOption2("시청역");
		bang.setId("서익중개사");
		bang.setStartDate("2019-02-20");
		bang.setEndDate("2019-03-31");
//		cal.add(Calendar.DATE, 30); //if문을 사용해 이용권에 따라서 구별 -> 이용권을 추가로 구매했을시도 추가해준다.
		tb_bang.add(bang);
		
//		
		bang = new BangVO();
		bang.setPrice(1.5);
		bang.setCategory("전세");
		bang.setArea(134);
		bang.setState("판매중");
		bang.setAddress1("대덕구 송촌동");
		bang.setAddress2("한가람아파트 308동 1201호");
		bang.setOption1("방 3개, 화장실 2개");
		bang.setOption2("없음");
		bang.setId("해솔중개사");
		bang.setStartDate("2019-03-20");
		bang.setEndDate("2019-04-18");
//		cal.add(Calendar.DATE, 60); 
		bang.setEndDate(strDate);
		tb_bang.add(bang);
		
		bang = new BangVO();
		bang.setPrice(7.5);
		bang.setCategory("전세");
		bang.setArea(112);
		bang.setState("판매중");
		bang.setAddress1("대덕구 송촌동");
		bang.setAddress2("장서익아파트 208동 1201호");
		bang.setOption1("방 13개, 화장실 2개");
		bang.setOption2("없음");
		bang.setId("해솔중개사");
		bang.setStartDate("2019-02-20");
		bang.setEndDate("2019-03-31");
//		cal.add(Calendar.DATE, 60); 
		bang.setEndDate(strDate);
		tb_bang.add(bang);
		
		bang = new BangVO();
		bang.setPrice(3);
		bang.setCategory("매매");
		bang.setArea(134);
		bang.setState("판매중");
		bang.setAddress1("중구 문화동");
		bang.setAddress2("센트럴자이아파트 107동 806호");
		bang.setOption1("방 3개, 화장실 2개");
		bang.setOption2("서대전네거리역 근처");
		bang.setId("재권중개사");
		bang.setStartDate("2019-03-20");
		bang.setEndDate("2019-04-18");
//		cal.add(Calendar.DATE, 60); 
		tb_bang.add(bang);
		
		bang = new BangVO();
		bang.setPrice(0.6);
		bang.setCategory("월세");
		bang.setArea(51);
		bang.setState("판매중");
		bang.setAddress1("동구 용전동");
		bang.setAddress2("한숲아파트 308동 1201호");
		bang.setOption1("방 1개, 화장실 1개");
		bang.setOption2("없음");
		bang.setId("재권중개사");
		bang.setStartDate("2019-03-20");
		bang.setEndDate("2019-04-18");
//		cal.add(Calendar.DATE, 60); 
		tb_bang.add(bang);
		
		bang = new BangVO();
		bang.setPrice(2.5);
		bang.setCategory("전세");
		bang.setArea(134);
		bang.setState("판매중");
		bang.setAddress1("동구 홍도동");
		bang.setAddress2("신동아파밀리에아파트 608동 504호");
		bang.setOption1("방 4개, 화장실 2개");
		bang.setOption2("없음");
		bang.setId("서익중개사");
		bang.setStartDate("2019-03-20");
		bang.setEndDate("2019-04-18");
//		cal.add(Calendar.DATE, 60); 
		bang.setEndDate(strDate);
		tb_bang.add(bang);
		
	}
	public ArrayList<BangVO> tb_approve = new ArrayList<BangVO>(); //매물 승인신청 대기 테이블
	{
		BangVO bang = new BangVO();
		bang.setAddress1("동구 홍도동");
		bang.setAddress2("신동아파밀리에아파트 608동 504호");
		bang.setWorkDate("2015.09.11");
//		bang.setStartDate(startDate);
//		cal.add(Calendar.DATE, 60); 
//		bang.setEndDate(strDate);
		bang.setPrice(2.5);
		bang.setAgentId("서익중개사");
		bang.setOption1("방 4개, 화장실 2개");
		bang.setOption2("없음");
		bang.setState("판매중");
		bang.setCategory("전세");
		bang.setArea(134);
		tb_approve.add(bang);
		
		bang = new BangVO();
		bang.setAddress1("동구 용전동");
		bang.setAddress2("한숲아파트 308동 1201호");
		bang.setWorkDate("2015.09.11");
//		bang.setStartDate(startDate);
//		cal.add(Calendar.DATE, 60); 
//		bang.setEndDate(strDate);
		bang.setPrice(2.5);
		bang.setAgentId("서익중개사");
		bang.setOption1("방 4개, 화장실 2개");
		bang.setOption2("없음");
		bang.setState("판매중");
		bang.setCategory("전세");
		bang.setArea(134);
		tb_approve.add(bang);
	}
	public ArrayList<CartVO> tb_cart = new ArrayList<CartVO>(); // 유저 찜목록 테이블
	public ArrayList<AgentcartVO> tb_agentcart = new ArrayList<AgentcartVO>(); // 중개인찜목록테이블																		
	public ArrayList<DealVO> tb_deal = new ArrayList<DealVO>(); // 거래 테이블
	public ArrayList<NoticeVO> tb_notice = new ArrayList<NoticeVO>(); // 공지 테이블
	{
		
		NoticeVO notice = new NoticeVO();
		notice.setNum(1);
		notice.setAgentId("lovelysh24");
		notice.setTitle("급매물 올라왔습니다.");
//		notice.setDate(strDate);
		notice.setContents("둔산동 크로바아파트 매매가가 상승하였습니다.");
		tb_notice.add(notice);
		
		notice = new NoticeVO();
		notice.setNum(2);
		notice.setAgentId("lovelysh24");
		notice.setTitle("개인정보처리방침 개정 안내");
//		notice.setDate(strDate);
		notice.setContents("새로운 '개인정보처리방침'적용에 대한 사전 안내 말씀드립니다.");
		tb_notice.add(notice);
		
	}
	public ArrayList<TicketInfoVO> tb_ticketinfo = new ArrayList<TicketInfoVO>(); // 티켓정보테이블	
	{	
		
		TicketInfoVO ticketInfo = new TicketInfoVO();
		ticketInfo.setTnum(1);
		ticketInfo.setName("30일 이용권");
		ticketInfo.setPrice(15900);
		ticketInfo.setPeriod(30);
		ticketInfo.setNumber(3);
		tb_ticketinfo.add(ticketInfo);
		
		ticketInfo = new TicketInfoVO();
		ticketInfo.setTnum(2);
		ticketInfo.setName("60일 이용권");
		ticketInfo.setPrice(25900);
		ticketInfo.setPeriod(60);
		ticketInfo.setNumber(6);
		tb_ticketinfo.add(ticketInfo);
		
		ticketInfo = new TicketInfoVO();
		ticketInfo.setTnum(3);
		ticketInfo.setName("90일 이용권");
		ticketInfo.setPrice(39900);
		ticketInfo.setPeriod(90);
		ticketInfo.setNumber(9);
		tb_ticketinfo.add(ticketInfo);
	}
	public ArrayList<TicketVO> tb_ticket = new ArrayList<TicketVO>(); // 티켓 테이블
	{
		TicketVO ticket = new TicketVO();
		ticket.setAgentId("asdfg");
		ticket.setNumber(6);
		ticket.setName("30일 이용권");
		tb_ticket.add(ticket);
		
		ticket = new TicketVO();
		ticket.setAgentId("abcd1234");
		ticket.setNumber(12);
		ticket.setName("90일 이용권");
		tb_ticket.add(ticket);
		
		ticket = new TicketVO();
		ticket.setAgentId("asdfg");
		ticket.setNumber(12);
		ticket.setName("60일 이용권");
		tb_ticket.add(ticket);
		
		ticket = new TicketVO();
		ticket.setAgentId("asdfg");
		ticket.setNumber(12);
		ticket.setName("30일 이용권");
		tb_ticket.add(ticket);
	}
}












