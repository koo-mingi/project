package ui;

import domain.RecodeVO;
import domain.SongVO;
import domain.UserVO;
import persistence.UserDAO;

public class MainTest {
	public static void main(String[] args) {
		
		// Test User
		UserDAO dao = new UserDAO();
		UserVO vo = dao.getUserTbl("1");
		System.out.println(vo);
		
		// Test Song
		SongVO vo1 = dao.getSongTbl(1);
		System.out.println(vo1);
		
		// Test Recode
		RecodeVO vo3 = dao.getRecodeTbl(1,1);
		System.out.println(vo3);
	}
}
