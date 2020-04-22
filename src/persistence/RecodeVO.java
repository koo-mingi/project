package persistence;

public class RecodeVO {
	// RecodeTBL
	private int userno;
	private int songid;
	private String userid;
	private int score;
	private int AcPerfect;
	private int AcGreat;
	private int AcBad;
	private int AcMiss;
	private int combo;
	private int grade;

	// 기본(default) 생성자
	public RecodeVO() {
		super();
	}

	// 매개변수를 인자로 받는 생성자
	public RecodeVO(int userno, int songid, String userid, int score, int acPerfect, 
					int acGreat, int acBad, int acMiss, int combo, int grade) {
		super();
		this.userno = userno;
		this.songid = songid;
		this.userid = userid;
		this.score = score;
		AcPerfect = acPerfect;
		AcGreat = acGreat;
		AcBad = acBad;
		AcMiss = acMiss;
		this.combo = combo;
		this.grade = grade;
	}

	// Getter & Setter
	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public int getSongid() {
		return songid;
	}

	public void setSongid(int songid) {
		this.songid = songid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getAcPerfect() {
		return AcPerfect;
	}

	public void setAcPerfect(int acPerfect) {
		AcPerfect = acPerfect;
	}

	public int getAcGreat() {
		return AcGreat;
	}

	public void setAcGreat(int acGreat) {
		AcGreat = acGreat;
	}

	public int getAcBad() {
		return AcBad;
	}

	public void setAcBad(int acBad) {
		AcBad = acBad;
	}

	public int getAcMiss() {
		return AcMiss;
	}

	public void setAcMiss(int acMiss) {
		AcMiss = acMiss;
	}

	public int getCombo() {
		return combo;
	}

	public void setCombo(int combo) {
		this.combo = combo;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
