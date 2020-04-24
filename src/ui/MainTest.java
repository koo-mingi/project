package ui;

import java.sql.SQLException;

import beat.Beat;
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
		RecodeVO vo3 = dao.getRecodeTbl(1, 1);
		System.out.println(vo3);

	}

	// 로그인 테스트
	public boolean loginCheck(String userid, String password) {
		// Beat클래스에서 로그인 버튼이 눌리면 ID와 PW를 읽어서 가져 온다.

		UserDAO dao2 = new UserDAO();
		UserVO vo = dao2.getUserTbl(userid);
		// 가져온 ID를 가지고 getUserTbl로 보내서 ID에 맞는 유저의 정보를 가져온다.
		// --->return UserVO객체.

		// 이 객체에서 pw가 있을테니 UserVO에 있는 pw와 Beat클래스에서 가져온 pw가 일치하는지 확인
		// DB password // 사용자가 입력한 password
		if (vo.getUserId().equals(userid) && vo.getPassword().equals(password)) {
			// 만약 일치한다면, id와 pw가 모두 맞는 것이므로 로그인.
			System.out.println("성공");
			return true;
		} else {
			// 만약 pw가 일치하지 않거나, id가 없는 경우는 로그인 불가!
			System.out.println("실패");
			return false;
		}
	}
	
	
	public boolean join (String userid, String password, String name, String email) {
		
		// DAO를 불러와서 dao3 담고
		UserDAO dao3 = new UserDAO();
		// 담은 dao3를 vo에 담는다
		UserVO vo = dao3.getUserTbl(userId);
		
		if (vo.) {
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
