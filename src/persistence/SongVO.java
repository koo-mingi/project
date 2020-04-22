package persistence;

public class SongVO {
	// SongTBL
	private int songid;
	private String songname;
	private String difficulty;
	private String speed;

	// 기본(default) 생성자
	public SongVO() {
		super();
	}

	// 매개변수를 인자로 받는 생성자
	public SongVO(int songid, String songname, String difficulty, String speed) {
		super();
		this.songid = songid;
		this.songname = songname;
		this.difficulty = difficulty;
		this.speed = speed;
	}

	// Getter & Setter
	public int getSongid() {
		return songid;
	}

	public void setSongid(int songid) {
		this.songid = songid;
	}

	public String getSongname() {
		return songname;
	}

	public void setSongname(String songname) {
		this.songname = songname;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}
}
