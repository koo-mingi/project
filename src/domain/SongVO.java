package domain;

import java.io.Serializable;

public class SongVO implements Serializable{
	
	// SongTBL Table
	private int songId;
	private String songName;
	private String difficulty;
	private String speed;

	// 기본(default) 생성자
	public SongVO() {
		super();
	}

	// 매개변수를 인자로 받는 생성자
	public SongVO(int songId, String songName, String difficulty, String speed) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.difficulty = difficulty;
		this.speed = speed;
	}

	// Getter & Setter
	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
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

	// toString
	@Override
	public String toString() {
		return "SongVO [songId= " + songId + ", songName= " + songName + 
			   ", difficulty= " + difficulty + ", speed= " + speed + "]";
	}
}
