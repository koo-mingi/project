package ui;

import domain.UserVO;
import persistence.UserDAO;

public class MainTest {
	public static void main(String[] args) {
		
		// Test User
		UserDAO dao = new UserDAO();
		
		UserVO vo = dao.getUserTbl("1");
		
		System.out.println(vo);
		
	}
}
