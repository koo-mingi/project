package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import domain.UserVO;
import sun.misc.Contended;

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
	

//	로그인
	// 입력된 DB정보를 오라클에서 ID, PW를 조회해서 일치하는지 확인, 맞거나 아니거나 할 경우 정보 전달
	public UserVO getUser(int no) {
		
		String sql="select * from userTBL where no=?";
		UserVO vo=null;
		try(Connection con=getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql)) {
			
			pstmt.setInt(1, no);
			
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
	
}