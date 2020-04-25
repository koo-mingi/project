package beat;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Game extends Thread {

	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
//	private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();

//	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();

	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	private String titleName;
	private String difficulty;
	private String musicTitle; // 이름 실행 이름
	private int score = 0;
	public static int combo = 0;
	private String judgeString = ""; // 판정 글자

	private MusicBeat musicBeat = new MusicBeat();
	private Music gameMusic;

	// Note 판정을 위해 끌어 쓰려고 여기 선언 --> static final로
	public static final int JUDGE_BAR_Y = 415;
	public static final int GAME_INFO_Y = 475;
	
	private final int PERFECT = 50;
	private final int GREAT = 40;
	private final int NOMAL = 30;
	private final int BAD = 11;

	
	
	List<Note> noteList = new ArrayList<Note>();
//	private Music music;
//	private String musicName;
//	
//	public Game(Music music, String musicName) {
//		
//		this.music = music;
//		this.musicName = musicName;
//		System.out.println(musicName);
//	}

	public Game(String titleName, String difficulty, String musicTitle) {
		super();
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);

	}

	public void screenDraw(Graphics2D g) {

		// 키 입력에 대한 이미지 처리
		g.drawImage(noteRouteSImage, 80, 30, null);
		g.drawImage(noteRouteDImage, 143, 30, null);
		g.drawImage(noteRouteFImage, 205, 30, null);
		g.drawImage(noteRouteJImage, 267, 30, null);
		g.drawImage(noteRouteKImage, 329, 30, null);
		g.drawImage(noteRouteLImage, 391, 30, null);

		g.drawImage(noteRouteLineImage, 77, 30, null);
		g.drawImage(noteRouteLineImage, 140, 30, null);
		g.drawImage(noteRouteLineImage, 202, 30, null);
		g.drawImage(noteRouteLineImage, 264, 30, null);
		g.drawImage(noteRouteLineImage, 326, 30, null);
		g.drawImage(noteRouteLineImage, 388, 30, null);
		g.drawImage(noteRouteLineImage, 451, 30, null);

		g.drawImage(gameInfoImage, 77, GAME_INFO_Y, null);
		g.drawImage(judgementLineImage, 77, JUDGE_BAR_Y, null);

//		g.drawImage(noteBasicImage, 80, 120, null);
//		g.drawImage(noteBasicImage, 143, 100, null);
//		g.drawImage(noteBasicImage, 205, 500, null);
//		g.drawImage(noteBasicImage, 267, 340, null);
//		g.drawImage(noteBasicImage, 329, 340, null);
//		g.drawImage(noteBasicImage, 391, 325, null);

		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.setFont(new Font("Jokerman", Font.BOLD, 26));
		g.drawString(titleName, 20, 550);
		g.drawString(difficulty, 700, 550);
		g.setFont(new Font("Jokerman", Font.PLAIN, 22));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 105, 435);
		g.drawString("D", 168, 435);
		g.drawString("F", 231, 435);
		g.drawString("J", 294, 435);
		g.drawString("K", 357, 435);
		g.drawString("L", 420, 435);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Elephant", Font.BOLD, 26));
		g.drawString(intCasting(score,0), 360, 550);

		g.setColor(Color.CYAN);
		g.setFont(new Font("Elephant", Font.BOLD, 26));
		g.drawString(intCasting(combo,1), 230, 200);
		
		g.setColor(Color.CYAN);
		g.setFont(new Font("Elephant", Font.BOLD, 24));
		g.drawString(judgeString, 230, 380);

		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
					
			if(note.noteMiss(note.position())) {
				judgeString = "miss";
			}
			
			if (!note.isProceeded()) {
				noteList.remove(i);
				i--;
			} else {
				note.screenDraw(g);
			}
		}

	}

	public void pressS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed2.png")).getImage();
		judge("S");
	}

	public void pressD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed3.png")).getImage();
		judge("D");
	}

	public void pressF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed4.png")).getImage();
		judge("F");
	}

	public void pressJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed4.png")).getImage();
		judge("J");
	}

	public void pressK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed3.png")).getImage();
		judge("K");
	}

	public void pressL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed2.png")).getImage();
		judge("L");
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	@Override
	public void run() {
		dropNotes();

	}

	public void close() {

		if (gameMusic != null)
			gameMusic.close();
		interrupt();

	}

	public boolean musicFinish() {
		boolean result = false;
		if (gameMusic.getState() == gameMusic.getState().TERMINATED) {
			result = true;
		}
		return result;
	}

	public void judge(String input) {
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);

			if (input.equals(note.getNoteType())) {

				judgeString(note.judge());
				score += note.judge();
				break;
			}
		}
	}

	// score 점수 앞에 0 붙이기 : 002124,000123
	public String intCasting(int score, int type) {
		
		int scoreLength  = (int) (Math.log10(score) + 1);
		String result = "000000";
		if(type == 0) { // 점수
				
						
			if (scoreLength == 1) {
				result = "00000" + String.valueOf(score);
			}
			if (scoreLength == 2) {
				result = "0000" + String.valueOf(score);
			}
			if (scoreLength == 3) {
				result = "000" + String.valueOf(score);
			}
			if (scoreLength == 4) {
				result = "00" + String.valueOf(score);
			}
			if (scoreLength == 5) {
				result = "0" + String.valueOf(score);
			}
			if (scoreLength == 6) {
				result = "" + String.valueOf(score);
			}
		}
		else if(type == 1) { // 콤보
			result = "0000";
			
			if (scoreLength == 1) {
				result = "000" + String.valueOf(score);
			}
			if (scoreLength == 2) {
				result = "00" + String.valueOf(score);
			}
			if (scoreLength == 3) {
				result = "0" + String.valueOf(score);
			}
			if (scoreLength == 4) {
				result = "" + String.valueOf(score);
			}
			
		}
		return result;
	}

	public void judgeString(int judge) {
		if(judge == PERFECT) {
			judgeString ="Perfect";
		}else if(judge == GREAT) {
			judgeString ="Great";
		}else if(judge == NOMAL) {
			judgeString ="Nomal";
		}else if(judge == BAD) {
			judgeString ="Bad";
		}else {
			judgeString ="";
		}
		
		
	}
	
	public void dropNotes() {
		BeatPlay[] beats = null;
		// difficult 변수 선언하고 이걸 &&로 해서 easy hard 구분
		if (titleName.equals("Happy Life - Fredji")) {
			beats = musicBeat.happy_Life(difficulty);
			// all = beats.length * 50; // ?? 이게 뭘까요?
		} 
		else if (titleName.equals("Chilling - Oshova")) {
			beats = musicBeat.chilling(difficulty);
		}
		else if (titleName.equals("Harmony - Ikson")) {
			beats = musicBeat.harmony(difficulty);
		}

		if (beats != null) {
			int i = 0;
			gameMusic.start();
			while (i < beats.length && !isInterrupted()) {
				boolean dropped = false;

				if (beats[i].getTime() <= gameMusic.getTime()) {
					Note note = new Note(beats[i].getNoteName());
					note.start();
					noteList.add(note);
					i++;
					dropped = true;
				}
				if (!dropped) {
					try {
						Thread.sleep(5);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				// 텀 두면서 떨구기 -> 계속 스레드 실행상태가 아니라 좀 쉬다가 하게끔
			}
		}
		else {
			//흠...필요할진 모르겠는데 혹시 beats가 null일 때 처리
			System.out.println("beats값이 null임");
		}
	}

}
