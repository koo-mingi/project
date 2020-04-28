package beat;

public class SongRecodeVO {

	private String titleName;
	private String difficulty;
	private int score;
	private int acPerfect;
	private int acGreat;
	private int acNormal;
	private int acBad;
	private int acMiss;
	private int combo;
	private String grade;
	
	public SongRecodeVO(String titleName, String difficulty, int score, int acPerfect, int acGreat, int acNormal,
			int acBad, int acMiss, int combo, String grade) {
		super();
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.score = score;
		this.acPerfect = acPerfect;
		this.acGreat = acGreat;
		this.acNormal = acNormal;
		this.acBad = acBad;
		this.acMiss = acMiss;
		this.combo = combo;
		this.grade = grade;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
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

	public int getacNormal() {
		return acNormal;
	}

	public void setacNormal(int acNormal) {
		this.acNormal = acNormal;
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

	@Override
	public String toString() {
		return "SongRecodeVO [titleName=" + titleName + ", difficulty=" + difficulty + ", score=" + score
				+ ", acPerfect=" + acPerfect + ", acGreat=" + acGreat + ", acNormal=" + acNormal + ", acBad=" + acBad
				+ ", acMiss=" + acMiss + ", combo=" + combo + ", grade=" + grade + "]";
	}
	
	
}
