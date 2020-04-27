package ui;

import domain.SongVO;
import domain.UserVO;
import persistence.UserDAO;

public class MainTest {
	private UserDAO dao = new UserDAO();
//	private String id;
	
	public static void main(String[] args) {
//		// testRecode
//		MainTest test = new MainTest();
//		SongVO vo = test.dao.getSongTbl("song1");
//		System.out.println(vo);
		
	}

	// 로그인 테스트
	public boolean loginCheck(String userid, String password) {
		// Beat클래스에서 로그인 버튼이 눌리면 ID와 PW를 읽어서 가져 온다.

		UserVO vo = dao.getUserTbl(userid);
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

	// 회원가입
	public boolean signup(UserVO vo) {
		// 유저가 회원가입 창에서 입력한 정보를 일단 들고옵니다.
		UserVO dbvo = dao.getUserTbl(vo.getUserId());
		//최신 기록
		if (dbvo == null) {
			// 유저 id 없음
			// UserDAO에 있는 insert문으로 넘겨서 DB저장
			dao.insertUserTbl(dbvo);

			// 회원가입 ㄱㄱ
			return true;
		} else {
			// 유저id가 이미 있음

			return false;
		}
	}

	
	// 유저 점수 기록?
//	public boolean userRecord (UserVO vo, String songName) {
//		//1. userid를 가져와서(현재 유저의) RecordTBL에 이 userid를 가지고 기록 뽑아서 넘겨 줌.
//		//2. userid를 이용하여 userno을 뽑아오고, 이걸로 RecordTBL에 기록 뽑아 옴.
//		UserVO dbvo = dao.getUserTbl(vo.getUserId());
//		int userno = vo.getUserNo();
//		dao.getSongFindTbl(songName);
//		
//		//songid....이거 
//		if(dbvo != null) {
//			//UserDAO에서 레코드 뽑아오는 메소드 호출
//			dao.getRecodeTbl(userno, songid);
//		}
//		return false;
//	}
	
	
	// 레코드 기록
//	기록 가져와야 되고, 기록되는게 있어야한다
	
//	}
	
	
}
