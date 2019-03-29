package controller;

import java.util.*;

import dao.BangDao;
import dao.BangDaoImpl;
import service.BangService;
import service.BangServiceImpl;
import vo.BangVO;

public class BangController {
    Scanner s = new Scanner(System.in);
    BangDao bangDao = new BangDaoImpl();
    //	ArrayList<BangVO> bangVO = bangDao.selectList();
    BangService bangService = new BangServiceImpl();

    public void bangSelect() {
        System.out.println("1. 매물 선택");
        System.out.println("2. 매물 검색");
        System.out.print("원하는 번호를 선택하세요. > ");
        int num = Integer.parseInt(s.nextLine());
        switch (num) {
            case 1:
                //지역을 세분화하여 제시하기 위해 자동으로 생성한 searchKeyList를 가져온다.
                // key: String. 구
                //value: 구에 해당된 동을 담은 ArrayList<String>
                HashMap<String, ArrayList<String>> searchKey = bangDao.searchKeyList();
                Set keySet = searchKey.keySet();

                //번호로 입력받기 때문에 String으로 이루어진 keySet을 배열로 변환하여 사용
                Object[] keyArray = keySet.toArray();

                System.out.print("원하는 구를 입력하세요.(예시: 서구) > ");
                for(int i=0; i<keyArray.length; i++)
                    System.out.print((i+1)+"."+keyArray[i]+"  ");
                String cmd = s.nextLine();

                /*
                *
                * <해야할 것>
                *
                * 모든 입력값은 숫자만 입력한 것인지, 또는 문자만 입력한 것인지 정규식체크를 한후 진행해야 할듯
                * 정해진 형식이 아닌 값을 입력할 경우 에러가 남.
                * 정규식 체크하는 공통 메서드 필요
                *
                * */

                if(cmd.length() > 0 && Integer.parseInt(cmd) <= keyArray.length){
                    //입력받은 숫자를 바로 해당되는 값의 구 문자열로 치환한다.
                    cmd = (String)keyArray[Integer.parseInt(cmd)-1];
                }
                else
                    return;

                System.out.print("원하는 동을 입력하세요.(예시: 선화동) > ");

                //키값에 해당되는 ArrayList를 배열에 담아둔다.
                ArrayList<String> menu = searchKey.get(cmd);

                for(int i=0; i<menu.size(); i++)
                    System.out.print((i+1)+"."+ menu.get(i) +"  ");
                String cmd2 = s.nextLine();

                //입력받은 숫자를 바로 해당되는 값의 동 문자열로 치환한다.
                cmd2 = menu.get(Integer.parseInt(cmd2) - 1);

                //입력 결과를 종합하여 전체방리스트의 주소1(형식: oo구 oo동)과 비교하여 결과배열리스트에 저장
                ArrayList<BangVO> searchResult = new ArrayList<BangVO>();
                for (BangVO item : bangDao.selectList()) {
                    if (item.getAddress1().equals(cmd + " " + cmd2))
                        searchResult.add(item);
                }


                //목록상 출력되는 번호와 방이 가지는 키값이 일치하지 않기 때문에 방번호-방객체를 매치하여 저장하는 해시맵 생성
                HashMap<Integer, BangVO> matchIndexList = new HashMap<Integer, BangVO>();

                //출력
                boolean isContinue = true;
                while (isContinue) {
                    if(searchResult.size() > 0)
                        System.out.println("총 " + searchResult.size() + "건이 검색되었습니다.");
                    else{
                        System.out.println("검색결과가 없습니다.");
                        isContinue = false;
                        continue;
                    }
                    System.out.println("-------------------------------------");
                    int idx = 1;
                    for (BangVO item : searchResult) {
                        matchIndexList.put(idx, item);
                        System.out.println("번호: " + idx++);
                        System.out.println("주소: " + item.getAddress1() + " " + item.getAddress2());
                        System.out.println("가격: " + item.getPrice());
                        System.out.println("날짜: " + item.getStartDate());
                        System.out.println("-------------------------------------");
                    }

                    System.out.println("검색 결과 중 하나를 선택하여 보시겠습니까?(Y/N) > ");
                    String cmd3 = s.nextLine();
                    switch (cmd3) {
                        case "Y":
                            System.out.println("자세히 볼 방의 번호를 입력하세요. > ");
                            String cmd4 = s.nextLine();
                            BangVO bang = matchIndexList.get(Integer.parseInt(cmd4));
                            System.out.println("주소: " + bang.getAddress1() + bang.getAddress2());
                            System.out.println("가격: " + bang.getPrice());
                            System.out.println("등록일: " + bang.getStartDate());
                            System.out.println("기타 모든 정보..어쩌고저쩌고..다 출력");
                            System.out.println("-------------------------------------");
                            System.out.println("1. 찜   2. 사기   3. 검색결과 다시보기  4. 홈");

                            String cmd5 = s.nextLine();
                            switch (Integer.parseInt(cmd5)) {
                                case 1:
                                    //찜하는 메서드 호출하여 처리
                                    break;
                                case 2:
                                    //방 사는 메서드 호출하여 처리
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    isContinue = false;
                                    break;
                            }
                            break;
                        case "N":
                            isContinue = false;
                            break;

                    }
                }
                break;

            case 2: //스트링 검색
                System.out.print("원하는 동을 입력하세요.(예시: 선화동) > ");
                String cmd6 = s.nextLine();

                //입력 결과를 전체방리스트의 주소1(형식: oo구 oo동)과 비교하여 결과배열리스트에 저장
                searchResult = new ArrayList<BangVO>();
                for (BangVO item : bangDao.selectList()) {
                    //띄어쓰기를 기준으로 쪼개서 뒷쪽값을 사용
                    String[] splitAddr = item.getAddress1().split(" ");
                    if (splitAddr[1].equals(cmd6))
                        searchResult.add(item);
                }

                if(searchResult.size() > 0)
                    System.out.println("총 " + searchResult.size() + "건이 검색되었습니다.");
                else
                    System.out.println("검색결과가 없습니다.");

                System.out.println("결과처리는 위와 같기 때문에 프린트 이하부분을 메서드로 만들어 호출하는 것이 좋을듯");
                break;
        }
    }

}
