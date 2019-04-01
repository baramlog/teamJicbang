package service;

import dao.NoticeDao;
import dao.NoticeDaoImpl;
import vo.NoticeVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NoticeServiceImpl implements NoticeService {

	    NoticeDao noticeDao = new NoticeDaoImpl();
	    Scanner s = new Scanner(System.in);
	    InputValueCheck checkValue = new InputValueCheckImpl();
	    //목록상 출력되는 번호와 게시글이 가지는 키값이 일치하지 않기 때문에 게시글번호-게시글객체를 매치하여 저장하는 해시맵 생성
	    HashMap<Integer, NoticeVO> matchIndexList = new HashMap<Integer, NoticeVO>();
	    int startNum, endNum;

	    @Override
	    public void printList(ArrayList<NoticeVO> noticeList) {
	        //db에서 가져온 게시글 목록을 출력함.

	        if (noticeList.size() > 0)
	            System.out.println("\n총 " + noticeList.size() + "건의 글이 있습니다.");
	        else {
	            System.out.println("\n등록된 글이 없습니다.");
	            return;
	        }
	        printLine();
	        int idx = 1;
	        startNum = idx;
	        for (NoticeVO item : noticeList) {
	            matchIndexList.put(idx, item);
	            System.out.print(idx + ".");
	            System.out.println("\t" + item.getTitle());
	            printLine();
	            endNum = idx;
	            idx++;
	        }
	    }

	    @Override
	    public void viewList() {
	        System.out.println();
	        printList(noticeDao.getList());

	        System.out.print("\n게시글 중 하나를 선택하여 보시겠습니까?(y/n) > ");
	        String cmd = s.nextLine();
	        switch (cmd) {
	            case "y":
	                System.out.print("\n자세히 볼 글의 번호를 입력하세요. > ");
	                String cmd2 = s.nextLine();
	                if (!checkValue.checkNumber(cmd2, startNum, endNum)) {
	                    printError();
	                    viewList();
	                    break;
	                }
	                printDetail(matchIndexList.get(Integer.parseInt(cmd2)));
	                nextAction();
	                break;
	            case "n":
	                break;
	            default:
	                printError();
	                viewList();
	        }
	    }

	    @Override
	    public void nextAction() {
	        System.out.println("\n다음 동작을 선택하세요.");
	        System.out.println("1. 목록 다시보기  2. 홈");
	        System.out.print("> ");

	        String cmd = s.nextLine();
	        switch (cmd) {
	            case "1":
	                viewList();
	                break;
	            case "2":
	                //홈
	                break;
	            default:
	                printError();
	                nextAction();
	        }
	    }

	    @Override
	    public void printDetail(NoticeVO notice) {
	        printLine();
	        System.out.println("제목: " + notice.getTitle());
	        System.out.println("작성자: 관리자");
	        System.out.println("등록일: " + notice.getDate());
	        System.out.println("");
	        System.out.println(notice.getContents());
	        printLine();
	    }

	    @Override
	    public void removeNotice() {
	        System.out.print("\n삭제할 글의 번호를 입력하세요. (취소: 0)> ");
	        String cmd = s.nextLine();
	        switch (cmd) {
	            case "0":
	                break;
	            default:
	                if (!checkValue.checkNumber(cmd, startNum, endNum)) {
	                    printError();
	                    removeNotice();
	                    return;
	                }
	                NoticeVO selectedNotice = matchIndexList.get(Integer.parseInt(cmd));
	                noticeDao.removeNotice(selectedNotice);
	                System.out.println("*****삭제하였습니다.*****");
	        }
	    }


	    @Override
	    public void writeNotice() {
	        NoticeVO notice = new NoticeVO();
	        String title, context;
	        System.out.print("제목을 입력하세요. > ");
	        title = s.nextLine();
	        System.out.print("내용을 입력하세요. > ");
	        context = s.nextLine();

	        notice.setTitle(title);
	        notice.setContents(context);
	        //등록
	        noticeDao.insertNotice(notice);

	        System.out.println("*****등록되었습니다.*****");

	    }

	    @Override
	    public void adminMenu() {
	        System.out.println("\n다음 동작을 선택하세요.");
	        System.out.println("1. 공지사항 등록  2. 공지사항 삭제  3. 홈");
	        System.out.print("> ");

	        String cmd = s.nextLine();
	        switch (cmd) {
	            case "1":
	                writeNotice();
	                adminMenu();
	                break;
	            case "2":
	                printList(noticeDao.getList());
	                if(noticeDao.getList().size() > 0)
	                    removeNotice();
	                adminMenu();
	                break;
	            case "3":
	                break;
	            default:
	                printError();
	                adminMenu();
	        }
	    }
	    @Override
	    public void printLine() {
	        System.out.println("————————————————————————————————————————");
	    }
	    @Override
	    public void printError() {
	        System.out.println("\n잘못 입력하셨습니다.");
	    }

		@Override
		public void viewDetail(NoticeVO notice) {
			// TODO Auto-generated method stub
			
		}
}

