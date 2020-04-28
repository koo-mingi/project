package domain;

import java.io.Serializable;

public class RecodeVO implements Serializable{
	
	//private static final long seralVersionUID = 1L;
	// RecodeTBL Table
	private int userno;
	private int songid;
	private String userid;
	private int score;
	private int acPerfect;
	private int acGreat;
	private int acGood;
	private int acBad;
	private int acMiss;
	private int combo;
	private String grade;

	// 기본(default) 생성자
	public RecodeVO() {
		super();
	}

	// 매개변수를 인자로 받는 생성자
	public RecodeVO(int userno, int songid, String userid, int score, int acPerfect, 
					int acGreat, int acGood, int acBad, int acMiss, int combo, String grade) {
		super();
		this.userno = userno;
		this.songid = songid;
		this.userid = userid;
		this.score = score;
		this.acPerfect = acPerfect;
		this.acGreat = acGreat;
		this.acGood = acGood;
		this.acBad = acBad;
		this.acMiss = acMiss;
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
		return acPerfect;
	}

	public void setAcPerfect(int acPerfect) {
		this.acPerfect = acPerfect;
	}

	public int getAcGreat() {
		return acGreat;
	}

	public void setAcGreat(int acGreat) {
		this.acGreat = acGreat;
	}

	public int getAcGood() {
		return acGood;
	}

	public void setAcGood(int acGood) {
		this.acGood = acGood;
	}

	public int getAcBad() {
		return acBad;
	}

	public void setAcBad(int acBad) {
		this.acBad = acBad;
	}

	public int getAcMiss() {
		return acMiss;
	}

	public void setAcMiss(int acMiss) {
		this.acMiss = acMiss;
	}

	public int getCombo() {
		return combo;
	}

	public void setCombo(int combo) {
		this.combo = combo;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	// toString
	@Override
	public String toString() {
		return "RecodeVO [userno= " + userno + ", songid= " + songid + ", userid= " + userid + ", score= " + score
				+ ", acPerfect= " + acPerfect + ", acGreat= " + acGreat + ", acBad= " + acBad + ", acMiss= " + acMiss
				+ ", combo= " + combo + ", grade= " + grade + "]";
	}
}
