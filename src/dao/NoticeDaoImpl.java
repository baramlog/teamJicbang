package dao;

import vo.Database;
import vo.NoticeVO;

import java.util.ArrayList;

public class NoticeDaoImpl implements NoticeDao {

    Database db = Database.getInstance();

    @Override
    public void insertNotice(NoticeVO notice) {
        db.tb_notice.add(notice);
    }

    @Override
    public void removeNotice(NoticeVO notice) {
        db.tb_notice.remove(notice);
    }

    @Override
    public ArrayList<NoticeVO> getList() {
        return db.tb_notice;
    }
}
