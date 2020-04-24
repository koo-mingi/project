package beat;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private Image noteBasic1Image = new ImageIcon(Main.class.getResource("../images/noteBasic1.png")).getImage();
	private Image noteBasic2Image = new ImageIcon(Main.class.getResource("../images/noteBasic2.png")).getImage();
	private String noteType;
	private int x,y = 0;
	//	580- (1000 / Main.SLEEP_TIME*Main.NOTE_SPEED) * Main.REACH_TIME; 
	// y 값 지정
	private boolean proceeded = true; //현재 노트의 진행 여부
	
	private int noteHeight; //노트 이미지의 길이

	
	
	public Note(String noteType) {
		if(noteType.equals("S")) {
			x=80;
		}
		else if(noteType.equals("D")) {
			x=143;
		}
		else if(noteType.equals("F")) {
			x=205;
		}
		else if(noteType.equals("J")) {
			x=267;
		}
		else if(noteType.equals("K")) {
			x=329;
		}
		else if(noteType.equals("L")) {
			x=391;
		}
		
		this.noteType = noteType;
		
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	public String getNoteType() {
		return noteType;
	}
	
	public void close() {
		proceeded = false;
	}
	
	public void screenDraw(Graphics2D g) {
		if(noteType.equals("S")) {
			g.drawImage(noteBasicImage, x, y, null);
			noteHeight = noteBasicImage.getHeight(null);
		}
		else if(noteType.equals("D")) {
			g.drawImage(noteBasic1Image, x, y, null);
			noteHeight = noteBasic1Image.getHeight(null);
		}
		else if(noteType.equals("F")) {
			g.drawImage(noteBasic2Image, x, y, null);
			noteHeight = noteBasic2Image.getHeight(null);
		}
		else if(noteType.equals("J")) {
			g.drawImage(noteBasic2Image, x, y, null);
			noteHeight = noteBasic2Image.getHeight(null);
		}
		else if(noteType.equals("K")) {
			g.drawImage(noteBasic1Image, x, y, null);
			noteHeight = noteBasic1Image.getHeight(null);
		}
		else if(noteType.equals("L")) {
			g.drawImage(noteBasicImage, x, y, null);
			noteHeight = noteBasicImage.getHeight(null);
		}
		
	}

	public void drop() {
		y += Main.NOTE_SPEED;
		if(y > Game.GAME_INFO_Y - (noteHeight /2)) 
		{
			// 게임화면의 끝에 도달하면 miss
			// note자체의 크기도 확인해야 할 듯
			Game.combo=0;
			System.out.println("miss");
			close();
		}
	}
	
	public int judge() {
		int score = 0;
	
		if( y > Game.JUDGE_BAR_Y && y < Game.JUDGE_BAR_Y+5) {
			System.out.println("Perfect");
			score = 50;
			Game.combo += 1;
			close();
		}
		else if( y >= Game.JUDGE_BAR_Y - 10) {
			System.out.println("Great");
			score =40;
			Game.combo += 1;
			close();
		}
		else if( y >= Game.JUDGE_BAR_Y-30) {
			System.out.println("Nomal");
			score = 30;
			Game.combo += 1;
			close();
		}
		else if( y >= Game.JUDGE_BAR_Y - 50) {
			System.out.println("Bad");
			score = 11;
			Game.combo += 1;
			close();
		}
		return score;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
					//스레드 정지하도록 걸어줌
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
