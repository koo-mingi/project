package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.RecodeVO;
import domain.SongVO;
import domain.UserVO;

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
	public int insertUserTbl(UserVO vo) {
		int result = 0;
		
		String sql = "insert into UserTBL value(seqgaro.nextval, ?, ?, ?, ?)";
					// SQL문을 연결된 OracleDB에 PreparedStatement를 통해서 보낸다
					// 실행하는 과정에서 오라클과 동일해야된다
		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
//	끝 ----------------------------------------------------------------------------------------------------------------------------------------------
	
//	User DB select
//	입력된 DB정보를 오라클에서 ID, PW를 조회해서 일치하는지 확인, 맞거나 아니거나 할 경우 정보 전달
	public UserVO getUserTbl(String userId) {
		
		String sql="select * from userTBL where userno = ?";
		UserVO vo=null;
		try(Connection con=getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql)) {
			
			pstmt.setString(1, userId);
			
			//select
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				vo=new UserVO();
				vo.setUserNo(rs.getInt("userno"));
				vo.setUserId(rs.getString("userid"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
//	끝 ----------------------------------------------------------------------------------------------------------------------------------------------
	
//	Song DB select
	public SongVO getSongTbl(int songId) {
		
		String sql = "select * from SongTBL where songid = ?";
					// SQL문을 연결된 OracleDB에 PreparedStatement를 통해서 보낸다
					// 실행하는 과정에서 오라클과 동일해야된다
		SongVO vo = null;
		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, songId);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				vo=new SongVO();
				vo.setSongId(rs.getInt("songId"));
				vo.setSongName(rs.getString("songName"));
				vo.setDifficulty(rs.getString("difficulty"));
				vo.setSpeed(rs.getString("speed"));
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
//	끝 ----------------------------------------------------------------------------------------------------------------------------------------------

//	Recode DB Insert
	//vo
	public int insertRecodeTbl(RecodeVO vo) {
		int result = 0;
		
		String sql = "insert into RecodeTBL value(seqgaro.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, vo.getUserno());
			pstmt.setInt(2, vo.getSongid());
			pstmt.setString(3, vo.getUserid());
			pstmt.setInt(4, vo.getScore());
			pstmt.setInt(4, vo.getAcPerfect());
			pstmt.setInt(6, vo.getAcGreat());
			pstmt.setInt(7, vo.getAcBad());
			pstmt.setInt(8, vo.getAcMiss());
			pstmt.setInt(9, vo.getCombo());
			pstmt.setString(10, vo.getGrade());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
//	끝 ----------------------------------------------------------------------------------------------------------------------------------------------

//	Recode DB Select
	public RecodeVO getRecodeTbl(int userno, int songid) {
		RecodeVO vo = null;
		
		String sql = "select * from RecodeTBL where userno= ? and songid= ?";
		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql)){
			
			
			pstmt.setInt(1, userno);
			pstmt.setInt(2, songid);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				vo=new RecodeVO();
				vo.setUserno(rs.getInt("userno"));
				vo.setSongid(rs.getInt("songid"));
				vo.setUserid(rs.getString("userid"));
				vo.setScore(rs.getInt("score"));
				vo.setAcPerfect(rs.getInt("AcPerfect"));
				vo.setAcGreat(rs.getInt("AcGreat"));
				vo.setAcGood(rs.getInt("AcGood"));
				vo.setAcBad(rs.getInt("AcBad"));
				vo.setAcMiss(rs.getInt("AcMiss"));
				vo.setAcMiss(rs.getInt("combo"));
				vo.setGrade(rs.getString("grade"));
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
//	where절 들어가는 유저정보
//	전체리스트 가져오는게 있고
//	유저별로 가져오는게 있고
	
//	회원 아이디랑 비번이 맞으면 로그인을 하는거지 / 세션으로 로그인 유지하고
	
}