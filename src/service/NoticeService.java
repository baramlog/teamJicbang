package service;

import vo.NoticeVO;

import java.util.ArrayList;

public interface NoticeService {
    void viewList();
    void printList(ArrayList<NoticeVO> noticeList);
    void printDetail(NoticeVO notice);
    void nextAction();
    void adminMenu();
    void writeNotice();
    void removeNotice();
    void printLine();
    void printError();

}
