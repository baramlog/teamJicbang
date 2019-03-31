/*
package login;

import dao.NoticeDao;
import dao.NoticeDaoImpl;
import service.InputValueCheck;
import service.InputValueCheckImpl;
import service.NoticeService;
import service.NoticeServiceImpl;
import vo.NoticeVO;
import vo.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NoticeController {
    NoticeDao noticeDao = new NoticeDaoImpl();
    Scanner s = new Scanner(System.in);
    InputValueCheck checkValue = new InputValueCheckImpl();
    NoticeService service = new NoticeServiceImpl();

    public void menu(){
        if(Session.getLoginAdmin() != null)
        {
            System.out.println("\n다음 동작을 선택하세요.");
            System.out.println("1. 공지사항 등록   2.공지사항 삭제");
            System.out.println("> ");

        }
        else{
            service.printList();
            System.out.print("\n게시글 중 하나를 선택하여 보시겠습니까?(y/n) > ");
            String cmd = s.nextLine();
        }



        switch (cmd) {
            case "y":
                System.out.print("\n자세히 볼 글의 번호를 입력하세요. > ");
                String cmd2 = s.nextLine();
                if(!checkValue.checkNumber(cmd2, 1, idx-1)) {
                    printError();
                    break;
                }
                //출력되는 목록 번호와 해당객체 매칭
                NoticeVO notice = matchIndexList.get(Integer.parseInt(cmd2));

                printLine();
                System.out.println("제목: " + notice.getTitle());
                System.out.println("작성자: 관리자");
                System.out.println("등록일: " + notice.getDate());
                System.out.println(notice.getContents());
                printLine();

                boolean isContinue2 = true;
                while(isContinue2){
                    System.out.println("\n다음 동작을 선택하세요.");
                    System.out.println("1. 목록 다시보기  2. 홈");
                    System.out.print("> ");

                    String cmd3 = s.nextLine();
                    switch (cmd3) {
                        case "1":
                            isContinue2 = false;
                            break;
                        case "2":
                            //홈
                            isContinue = false;
                            break;
                        default:
                            printError();
                    }
                }

                break;
            case "n":
                isContinue = false;
                break;
            default:
                printError();

        }

    }

    public void insert(){

    }

    public void viewList() {
        ArrayList<NoticeVO> noticeList = noticeDao.getList();

        //목록상 출력되는 번호와 게시글이 가지는 키값이 일치하지 않기 때문에 게시글번호-게시글객체를 매치하여 저장하는 해시맵 생성
        HashMap<Integer, NoticeVO> matchIndexList = new HashMap<Integer, NoticeVO>();
        boolean isContinue = true;

        while (isContinue) {

            if(noticeList.size() > 0)
                System.out.println("\n총 "+noticeList.size()+"건의 글이 있습니다.");
            else{
                System.out.println("\n등록된 글이 없습니다.");
                isContinue = false;
                continue;
            }
            printLine();
            int idx = 1;
            for(NoticeVO item : noticeList){
                matchIndexList.put(idx, item);
                System.out.print(idx++ + ".");
                System.out.println("\t"+item.getTitle());
                printLine();
            }

            System.out.print("\n게시글 중 하나를 선택하여 보시겠습니까?(y/n) > ");
            String cmd = s.nextLine();
            switch (cmd) {
                case "y":
                    System.out.print("\n자세히 볼 글의 번호를 입력하세요. > ");
                    String cmd2 = s.nextLine();
                    if(!checkValue.checkNumber(cmd2, 1, idx-1)) {
                        printError();
                        break;
                    }
                    //출력되는 목록 번호와 해당객체 매칭
                    NoticeVO notice = matchIndexList.get(Integer.parseInt(cmd2));

                    printLine();
                    System.out.println("제목: " + notice.getTitle());
                    System.out.println("작성자: 관리자");
                    System.out.println("등록일: " + notice.getDate());
                    System.out.println(notice.getContents());
                    printLine();

                    boolean isContinue2 = true;
                    while(isContinue2){
                        System.out.println("\n다음 동작을 선택하세요.");
                        System.out.println("1. 목록 다시보기  2. 홈");
                        System.out.print("> ");

                        String cmd3 = s.nextLine();
                        switch (cmd3) {
                            case "1":
                                isContinue2 = false;
                                break;
                            case "2":
                                //홈
                                isContinue = false;
                                break;
                            default:
                                printError();
                        }
                    }

                    break;
                case "n":
                    isContinue = false;
                    break;
                default:
                    printError();

            }
        }
        System.out.println();
    }

    public void viewDetail(HashMap<Integer, NoticeVO> printedList, int startNum, int endNum) {

    }

    public void removeNotice(HashMap<Integer, NoticeVO> printedList, int startNum, int endNum) {
        System.out.print("\n게시글 중 하나를 삭제하시겠습니까?(y/n) > ");
        String cmd = s.nextLine();
        switch (cmd){
            case "y":
                System.out.print("\n삭제할 글의 번호를 입력하세요. > ");
                String cmd2 = s.nextLine();
                if(!checkValue.checkNumber(cmd2, startNum, endNum)) {
                    printError();
                    removeNotice(printedList, startNum, endNum);
                }
                NoticeVO selectedNotice = printedList.get(Integer.parseInt(cmd2));
                noticeDao.removeNotice(selectedNotice);
                break;
            case "n":
                break;

        }

    }

    public void writeNotice() {
        NoticeVO notice = new NoticeVO();
        String title, context;
        System.out.print("제목을 입력하세요. > ");
        title = s.nextLine();
        System.out.println("내용을 입력하세요. > ");
        context = s.nextLine();

        notice.setTitle(title);
        notice.setContents(context);

        //등록
        noticeDao.insertNotice(notice);

        System.out.println("등록되었습니다.");

    }
    public void printLine(){
        System.out.println("-------------------------------------------------------------");
    }
    public void printError(){
        System.out.println("\n잘못 입력하셨습니다.");
    }
}
*/
