package vo;

public class CartVO { //찜목록
	
	private int bangNum; //선택된 방 기본키 불러올거
	private String userId; //유저 아이디
	
	public int getNum() {
		return bangNum;
	}
	public void setNum(int num) {
		this.bangNum = num;
	}
	public String getId() {
		return userId;
	}
	public void setId(String id) {
		this.userId = id;
	}
	
}
