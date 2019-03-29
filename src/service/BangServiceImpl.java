package service;

import java.util.ArrayList;

import dao.BangDao;
import dao.BangDaoImpl;
import vo.BangVO;

public class BangServiceImpl implements BangService {
	
	BangDao bangDao = new BangDaoImpl();
	ArrayList<BangVO> bangList = bangDao.selectList();
	
	@Override
	public void selectList() {
		for(int i = 0; i < bangList.size(); i++){
			BangVO bang = bangList.get(i);
			String[] dong = new String[]{"송촌동", "중리동", "법동", "홍도동", "용운동", "용전동", "문화동" ,"대흥동", "선화동"};
			
			String str = bang.getAddress1().substring(bang.getAddress1().length()-3, bang.getAddress1().length());
			System.out.println(str);

			
			/*else if(str.equals("중리동")){
				System.out.println(bang.getPrice() + "     " + bang.getCategory() + "     " + bang.getState());
				System.out.println(bang.getAddress1() + " " + bang.getAddress2());
				System.out.println("옵션: " + bang.getOption1() + "   /  " + bang.getOption2() + " 근처");
				System.out.println("            " + bang.getId());
				System.out.println("-----------------------------------");
			}
				else if(str.equals("법동")){
				System.out.println(bang.getPrice() + "     " + bang.getCategory() + "     " + bang.getState());
				System.out.println(bang.getAddress1() + " " + bang.getAddress2());
				System.out.println("옵션: " + bang.getOption1() + "   /  " + bang.getOption2() + " 근처");
				System.out.println("            " + bang.getId());
				System.out.println("-----------------------------------");
			}
			else if(str.equals("홍도동")){
				System.out.println(bang.getPrice() + "     " + bang.getCategory() + "     " + bang.getState());
				System.out.println(bang.getAddress1() + " " + bang.getAddress2());
				System.out.println("옵션: " + bang.getOption1() + "   /  " + bang.getOption2() + " 근처");
				System.out.println("            " + bang.getId());
				System.out.println("-----------------------------------");
			}
				else if(str.equals("용운동")){
				System.out.println(bang.getPrice() + "     " + bang.getCategory() + "     " + bang.getState());
				System.out.println(bang.getAddress1() + " " + bang.getAddress2());
				System.out.println("옵션: " + bang.getOption1() + "   /  " + bang.getOption2() + " 근처");
				System.out.println("            " + bang.getId());
				System.out.println("-----------------------------------");
			}else if(str.equals("용전동")){
				System.out.println(bang.getPrice() + "     " + bang.getCategory() + "     " + bang.getState());
				System.out.println(bang.getAddress1() + " " + bang.getAddress2());
				System.out.println("옵션: " + bang.getOption1() + "   /  " + bang.getOption2() + " 근처");
				System.out.println("            " + bang.getId());
				System.out.println("-----------------------------------");
			}else if(str.equals("문화동")){
				System.out.println(bang.getPrice() + "     " + bang.getCategory() + "     " + bang.getState());
				System.out.println(bang.getAddress1() + " " + bang.getAddress2());
				System.out.println("옵션: " + bang.getOption1() + "   /  " + bang.getOption2() + " 근처");
				System.out.println("            " + bang.getId());
				System.out.println("-----------------------------------");
			}else if(str.equals("대흥동")){
				System.out.println(bang.getPrice() + "     " + bang.getCategory() + "     " + bang.getState());
				System.out.println(bang.getAddress1() + " " + bang.getAddress2());
				System.out.println("옵션: " + bang.getOption1() + "   /  " + bang.getOption2() + " 근처");
				System.out.println("            " + bang.getId());
				System.out.println("-----------------------------------");
			}else if(str.equals("선화동")){
				System.out.println(bang.getPrice() + "     " + bang.getCategory() + "     " + bang.getState());
				System.out.println(bang.getAddress1() + " " + bang.getAddress2());
				System.out.println("옵션: " + bang.getOption1() + "   /  " + bang.getOption2() + " 근처");
				System.out.println("            " + bang.getId());
				System.out.println("-----------------------------------");
			}*/
			
		}
	}
	
	
	
	
	
}
