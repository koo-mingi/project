package beat;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private String noteType;
	private int x,y = 0;
//	580- (1000 / Main.SLEEP_TIME*Main.NOTE_SPEED) * Main.REACH_TIME; 
	// y 값 지정
	private boolean proceeded = true; //현재 노트의 진행 여부
	private int judgeBar = 410;
	
	

	
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
			g.drawImage(noteBasicImage, x, y, null);
	}

	public void drop() {
		y += Main.NOTE_SPEED;
		if(y > judgeBar+50) //판정바의 y축 넣기
		{
			System.out.println("miss");
			close();
		}
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
	
	public void judge() {
		if( y >= judgeBar) {
			System.out.println("Perfect");
			close();
		}
		else if( y >= judgeBar - 10) {
			System.out.println("Great");
			close();
		}
		else if( y >= judgeBar-30) {
			System.out.println("Nomal");
			close();
		}
		else if( y >= judgeBar - 50) {
			System.out.println("Bad");
			close();
			
		}
	}

	
}
