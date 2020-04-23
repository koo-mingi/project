package beat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Game extends Thread{
	
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
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
		
				g.drawImage(noteRouteImage, 80, 30, null);
				g.drawImage(noteRouteImage, 143, 30, null);
				g.drawImage(noteRouteImage, 205, 30, null);
				g.drawImage(noteRouteImage, 267, 30, null);
				g.drawImage(noteRouteImage, 329, 30, null);
				g.drawImage(noteRouteImage, 391, 30, null);
				
		
				g.drawImage(noteRouteLineImage, 77, 30, null);
				g.drawImage(noteRouteLineImage, 140, 30, null);
				g.drawImage(noteRouteLineImage, 202, 30, null);
				g.drawImage(noteRouteLineImage, 264, 30, null);
				g.drawImage(noteRouteLineImage, 326, 30, null);
				g.drawImage(noteRouteLineImage, 388, 30, null);
				g.drawImage(noteRouteLineImage, 451, 30, null);

				g.drawImage(gameInfoImage, 0, 480, null);
				g.drawImage(judgementLineImage, 0, 410, null);
				g.drawImage(noteBasicImage, 80, 120, null);
				g.drawImage(noteBasicImage, 143, 100, null);
				g.drawImage(noteBasicImage, 205, 500, null);
				g.drawImage(noteBasicImage, 267, 340, null);
				g.drawImage(noteBasicImage, 329, 340, null);
				g.drawImage(noteBasicImage, 391, 325, null);

				g.setColor(Color.white);
//				g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
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

		
		


}
