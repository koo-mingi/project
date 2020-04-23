package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
//	Oracle 주소 연결 
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
//  끝 ----------------------------------------------------------------------------------------------------------------------------------------------
	
//	계정 연결
	public Connection getConnection() {
		Connection con = null;
		
		String url		= "jdbc:oracle:thin:@localhost:1521:orcl";
		
		String user		= "garo";
		String password	= "12341234";
		
		try {
			con =  DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
//	끝 ----------------------------------------------------------------------------------------------------------------------------------------------
	
//	User DB Insert (회원가입 할 때 받아오는 정보)
//	user 정보 추가 / 유저 아이디가 없으면 가입, 있으면 중복으로 불가입
	public int insertUserTBL(String UserID, String password, String name, String Email) {
		int result = 0;
		
		String sql = "insert into UserTBL value(seqgaro.nextval,?, ?, ?, ?)";
					// SQL문을 연결된 OracleDB에 PreparedStatement를 통해서 보낸다
					// 실행하는 과정에서 오라클과 동일해야된다
		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1, UserID);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, Email);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
//	끝 ----------------------------------------------------------------------------------------------------------------------------------------------
	

//	User DB select
//	입력된 DB정보를 오라클에서 ID, PW를 조회해서 일치하는지 확인, 맞거나 아니거나 할 경우 정보 전달
	public UserVO getUserTBL(String id) {
		
		String sql="select * from userTBL where no=?";
		UserVO vo=null;
		try(Connection con=getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql)) {
			
			pstmt.setString(1, id);
			
			//select
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				vo=new UserVO();
				vo.setUserno(rs.getInt("no"));
				vo.setUserid(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setEmail(rs.getString("email"));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
//	끝 ----------------------------------------------------------------------------------------------------------------------------------------------
	
//	Song DB select
	public int getSongTBL(int songID, String songname, int difficulty, int speed) {
		int result = 0;
		
		String sql = "select * from SongTBL where songid";
					// SQL문을 연결된 OracleDB에 PreparedStatement를 통해서 보낸다
					// 실행하는 과정에서 오라클과 동일해야된다
		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, songID);
			pstmt.setString(2, songname);
			pstmt.setInt(3, difficulty);
			pstmt.setInt(4, speed);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
//	끝 ----------------------------------------------------------------------------------------------------------------------------------------------

//	Recode DB
	public int getRecodeTBL(int userno, int songid, String userid, int score, 
							int acPerfect, int acGreat, int acBad, int acMiss, int combo, String grade) {
		int result = 0;
		
		String sql = "select * from RecodeTBL where songid";
		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, userno);
			pstmt.setInt(2, songid);
			pstmt.setString(3, userid);
			pstmt.setInt(4, score);
			pstmt.setInt(4, acPerfect);
			pstmt.setInt(6, acGreat);
			pstmt.setInt(7, acBad);
			pstmt.setInt(8, acMiss);
			pstmt.setInt(9, combo);
			pstmt.setString(10, grade);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}	
}