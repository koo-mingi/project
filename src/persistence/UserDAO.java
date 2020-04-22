package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
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
	
//	user 정보 추가 / 유저 아이디가 없으면 가입, 있으면 중복으로 불가입
	public int insertUser(String UserID, String password, String name, String Email) {
		int result = 0;
		
		String sql = "insert into UserTBL value(seqgaro.nextval,?, ?, ?, ?)";
		
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
}



