package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import controller.BangController;
import vo.BangVO;
import dao.BangDao;
import dao.BangDaoImpl;

public class BangServiceImpl implements BangService {

	BangDao bangDao = new BangDaoImpl();
	ArrayList<BangVO> bangList = bangDao.selectList();
	Scanner s = new Scanner(System.in);
	ArrayList<BangVO> searchResult = new ArrayList<BangVO>();

	@Override
	public void selectList() {
		// 지역을 세분화하여 제시하기 위해 자동으로 생성한 searchKeyList를 가져온다.
		// key: String. 구
		// value: 구에 해당된 동을 담은 ArrayList<String>
		HashMap<String, ArrayList<String>> searchKey = bangDao.searchKeyList();
		Set keySet = searchKey.keySet();
		// 번호로 입력받기 때문에 String으로 이루어진 keySet을 배열로 변환하여 사용
		Object[] keyArray = keySet.toArray();

		System.out.print("원하는 구를 선택하세요. > ");
		for (int i = 0; i < keyArray.length; i++)
			System.out.print((i + 1) + "." + keyArray[i] + "  ");
		String cmd = s.nextLine();

		/*
		 *
		 * <해야할 것>
		 *
		 * 모든 입력값은 숫자만 입력한 것인지, 또는 문자만 입력한 것인지 정규식체크를 한후 진행해야 할듯 정해진 형식이 아닌 값을
		 * 입력할 경우 에러가 남. 정규식 체크하는 공통 메서드 필요
		 */

		if (cmd.length() > 0 && Integer.parseInt(cmd) <= keyArray.length) {
			// 입력받은 숫자를 바로 해당되는 값의 구 문자열로 치환한다.
			cmd = (String) keyArray[Integer.parseInt(cmd) - 1];
		} else
			return;

		System.out.print("원하는 동을 선택하세요. > ");

		// 키값에 해당되는 ArrayList를 배열에 담아둔다.
		ArrayList<String> menu = searchKey.get(cmd);

		for (int i = 0; i < menu.size(); i++)
			System.out.print((i + 1) + "." + menu.get(i) + "  ");
		String cmd2 = s.nextLine();

		// 입력받은 숫자를 바로 해당되는 값의 동 문자열로 치환한다.
		cmd2 = menu.get(Integer.parseInt(cmd2) - 1);

		// 입력 결과를 종합하여 전체방리스트의 주소1(형식: oo구 oo동)과 비교하여 결과배열리스트에 저장
		for (BangVO item : bangDao.selectList()) {
			if (item.getAddress1().equals(cmd + " " + cmd2))
				searchResult.add(item);
		}

		// 목록상 출력되는 번호와 방이 가지는 키값이 일치하지 않기 때문에 방번호-방객체를 매치하여 저장하는 해시맵 생성


		// 출력
		printList();
	}

	@Override
	public void searchList() {
		System.out.print("원하는 동을 입력하세요.(예시: 선화동) > ");
		String cmd6 = s.nextLine();

		// 입력 결과를 전체방리스트의 주소1(형식: oo구 oo동)과 비교하여 결과배열리스트에 저장
		searchResult = new ArrayList<BangVO>();
		for (BangVO item : bangDao.selectList()) {
			// 띄어쓰기를 기준으로 쪼개서 뒷쪽값을 사용
			String[] splitAddr = item.getAddress1().split(" ");
			if (splitAddr[1].equals(cmd6))
				searchResult.add(item);
		}

		printList();


	}

	@Override
	public void printList() {
		HashMap<Integer, BangVO> matchIndexList = new HashMap<Integer, BangVO>();
		boolean isContinue = true;
		while (isContinue) {
			if (searchResult.size() > 0)
				System.out.println("총 " + searchResult.size() + "건이 검색되었습니다.");
			else {
				System.out.println("검색결과가 없습니다.");
				isContinue = false;
				continue;
			}
			System.out.println("-------------------------------------");
			int idx = 1;
			for (BangVO item : searchResult) {
				matchIndexList.put(idx, item);
				System.out.println("번호: " + idx++);
				System.out.println("주소: " + item.getAddress1() + " "
						+ item.getAddress2());
				String price;
				if((int)item.getPrice() == 0){
					price = (int)(item.getPrice()*10) + "천만원";
				}else{
					if((int)(item.getPrice()*10 - (int)item.getPrice()*10)==0){
						price = (int)item.getPrice() + "억원";
					}else{
						price = (int)item.getPrice() + "억 " + (int)(item.getPrice()*10 - (int)item.getPrice()*10) + "천만원";
					}
				}
				System.out.println("가격: " + price);
				System.out.println("등록일자: " + item.getStartDate());
				System.out.println("-------------------------------------");
			}

			System.out.print("검색 결과 중 하나를 선택하여 보시겠습니까?(y/n) > ");
			String cmd3 = s.nextLine();
			switch (cmd3) {
				case "y":
					System.out.print("자세히 볼 방의 번호를 입력하세요. > ");
					String cmd4 = s.nextLine();
					BangVO bang = matchIndexList.get(Integer.parseInt(cmd4));

					String price;
					if((int)bang.getPrice() == 0){
						price = (int)(bang.getPrice()*10) + "천만원";
					}else{
						if((int)(bang.getPrice()*10 - (int)bang.getPrice()*10)==0){
							price = (int)bang.getPrice() + "억원";
						}else{
							price = (int)bang.getPrice() + "억 " + (int)(bang.getPrice()*10 - (int)bang.getPrice()*10) + "천만원";
						}
					}
					System.out.println("-------------------------------------");
					System.out.println("\t" + price + "\t   /     " + bang.getCategory() + "(" + bang.getState() + ")");
					System.out.println("주소: " + bang.getAddress1() + " "
							+ bang.getAddress2());
					System.out.println("면적: " + bang.getArea());
					System.out.println("옵션: " + bang.getOption1() + "    /    " + bang.getOption2());
					System.out.println("준공일자: " + bang.getWorkDate());
					System.out.println("\t\t\t" + bang.getAgentName());
					System.out.println("등록일자: " + bang.getStartDate());
					System.out.println("-------------------------------------");
					System.out.println("1. 찜   2. 중개인을 찜   3.구매   4. 검색결과 다시보기  5. 홈");
					System.out.print("메뉴에 해당하는 번호 입력>");
					BangController bcon = new BangController();

					String cmd5 = s.nextLine();
					switch (Integer.parseInt(cmd5)) {
						case 1:
							// 찜하는 메서드 호출하여 처리
							break;
						case 2:

							break;
						case 3:
							// 방 사는 메서드 호출하여 처리
							break;
						case 4:

							break;
						case 5:
							isContinue = false;
							break;
					}
					break;
				case "n":
					isContinue = false;
					break;
				default :
					System.out.println();
					System.out.println("y/n 중 하나를 선택해주세요.");
					System.out.println();
					break;
			}

		}

	}

}