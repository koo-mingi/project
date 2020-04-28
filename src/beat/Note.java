package beat;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private Image noteBasic1Image = new ImageIcon(Main.class.getResource("../images/noteBasic1.png")).getImage();
	private Image noteBasic2Image = new ImageIcon(Main.class.getResource("../images/noteBasic2.png")).getImage();
	
	private String noteType;
	private int x, y = 0;
	// 580- (1000 / Main.SLEEP_TIME*Main.NOTE_SPEED) * Main.REACH_TIME;
	// y 값 지정
	private boolean proceeded = true; // 현재 노트의 진행 여부

	private int noteHeight; // 노트 이미지의 길이

	public Note(String noteType) {
		if (noteType.equals("S")) {
			x = 80;
		} else if (noteType.equals("D")) {
			x = 143;
		} else if (noteType.equals("F")) {
			x = 205;
		} else if (noteType.equals("J")) {
			x = 267;
		} else if (noteType.equals("K")) {
			x = 329;
		} else if (noteType.equals("L")) {
			x = 391;
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
		if (noteType.equals("S")) {
			g.drawImage(noteBasicImage, x, y, null);
			noteHeight = noteBasicImage.getHeight(null);
		} else if (noteType.equals("D")) {
			g.drawImage(noteBasic1Image, x, y, null);
			noteHeight = noteBasic1Image.getHeight(null);
		} else if (noteType.equals("F")) {
			g.drawImage(noteBasic2Image, x, y, null);
			noteHeight = noteBasic2Image.getHeight(null);
		} else if (noteType.equals("J")) {
			g.drawImage(noteBasic2Image, x, y, null);
			noteHeight = noteBasic2Image.getHeight(null);
		} else if (noteType.equals("K")) {
			g.drawImage(noteBasic1Image, x, y, null);
			noteHeight = noteBasic1Image.getHeight(null);
		} else if (noteType.equals("L")) {
			g.drawImage(noteBasicImage, x, y, null);
			noteHeight = noteBasicImage.getHeight(null);
		}

	}

	public void drop() {
		y += Main.NOTE_SPEED;
		if (y > Game.GAME_INFO_Y - (noteHeight / 2)) {
			// 게임화면 끝의 절반? 정도가 되면 노트 miss뜨면서 삭제
			Game.COMBO = 0;
//			System.out.println("miss");
			close();
		}
	}

	/*
	 * 노트 판정 기준(judge) 판정바의 Y축 시작점을 기준으로 노트의 y 값이 판정바 안에 얼만큼 들어갔는지를 기준으로 판정. 그 전에
	 * 찍혀도 어느정도 인정. 그래도 미리 찍히는건 좀 넉넉하게 줘야 할 듯 싶어서 넉넉하게 줌.
	 * 
	 * 일단 판정식은 계속 플레이 하면서 맞춰야 할 듯
	 * 
	 */

	

	
	public int getY() {
		return y;
	}
	
	

	public int judge() {
		int score = 0;

		if (y < Game.JUDGE_BAR_Y + 9 && y > Game.JUDGE_BAR_Y - 12) {
			score = 50;
			Game.COMBO += 1;			
			close();
		} else if (y < Game.JUDGE_BAR_Y + 15 && y > Game.JUDGE_BAR_Y - 20) {
			score = 40;
			Game.COMBO += 1;
			close();
		} else if (y < Game.JUDGE_BAR_Y + 25 && y >= Game.JUDGE_BAR_Y - 28) {
			score = 30;
			Game.COMBO += 1;
			close();
		} else if (y < Game.JUDGE_BAR_Y + 30 && y >= Game.JUDGE_BAR_Y - 40) {
			score = 11;
			Game.COMBO += 1;
			close();
		}
		return score;
	}

	public int position() {

		return y;
	}

	public boolean noteMiss(int position) {

		if (position > Game.GAME_INFO_Y - (noteHeight / 2)) {
			return true;
		}
		return false;
	}

	@Override
	public void run() {
		try {
			//이걸로 게임이 끝나도 노트가 남아있으면 한 개가 더 떨어지던 현상 없앰
			while (Game.game_State) {
				drop();
				if (proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				} else {
					interrupt();
					break;
					// 스레드 정지하도록 걸어줌
				}
			}
//			System.out.println("끝");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
