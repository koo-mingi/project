package beat;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

public class Game extends Thread {
	
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	
	
	
	
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

		g.drawImage(gameInfoImage, 77, 475, null);
		g.drawImage(judgementLineImage, 77, 415, null);
		g.drawImage(noteBasicImage, 80, 120, null);
		g.drawImage(noteBasicImage, 143, 100, null);
		g.drawImage(noteBasicImage, 205, 500, null);
		g.drawImage(noteBasicImage, 267, 340, null);
		g.drawImage(noteBasicImage, 329, 340, null);
		g.drawImage(noteBasicImage, 391, 325, null);

		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,26));
		g.drawString("titleName", 20, 550);
		g.drawString("Easy", 700, 550);
		g.setFont(new Font("Arial",Font.PLAIN,22));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 105, 435);
		g.drawString("D", 168, 435);
		g.drawString("F", 231, 435);
		g.drawString("J", 294, 435);
		g.drawString("K", 357, 435);
		g.drawString("L", 420, 435);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 26));
		g.drawString("00000", 360, 550);
		
		
		
		
	}
	
	public void pressS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}
	public void pressD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}
	public void pressF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}
	public void pressJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}
	public void pressK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}
	public void pressL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
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
		
		
		
	}

}
