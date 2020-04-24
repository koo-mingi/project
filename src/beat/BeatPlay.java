package beat;

public class BeatPlay {

	private int time;
	private String noteName;
	
	public BeatPlay(int time, String noteName) {
		this.time = time;
		this.noteName = noteName;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time=time;
	}
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	

}
