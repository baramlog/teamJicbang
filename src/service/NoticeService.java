package service;

import vo.NoticeVO;

import java.util.ArrayList;

public interface NoticeService {
    void viewList();
    void viewDetail(NoticeVO notice);
    void writeNotice();
    void adminMenu();
    void printList(ArrayList<NoticeVO> noticeList);
    void removeNotice();

}
