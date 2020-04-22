package persistence;

public class UserVO {
	private int userno;
	private String userid;
	private String password;
	private String email;
	
	public UserVO() {
		super();
	}

	public UserVO(int userno, String userid, String password, String email) {
		super();
		this.userno = userno;
		this.userid = userid;
		this.password = password;
		this.email = email;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}