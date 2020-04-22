package beat;

import javax.swing.JFrame;
import javax.swing.JPanel;

import beat.SelectSong.ImagePanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.JLabel;

public class GamePlay extends JFrame {

	private JButton btnGameStop, btnGamePause, btnGameResult;

	private PauseScreen pausescreen;
	private Lobby lobby;
	private ResultScreen resultscreen;

	private Image screenImage;
	private Graphics screenGraphic;

	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	private Image background = new ImageIcon(Main.class.getResource("../images/mainBackground.png")).getImage();

	private boolean isGameScreen = true;

	public GamePlay() {

		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setResizable(false); // 창 사이즈 변경 불가
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 시 스레드 종료
		getContentPane().setLayout(null);

		ImagePanel ImagePanel = new ImagePanel();
		getContentPane().add(ImagePanel);

		btnGameStop = new JButton("Game 종료");
		btnGameStop.setFont(new Font("굴림", Font.BOLD, 15));
		btnGameStop.setBounds(610, 470, 123, 23);
		ImagePanel.add(btnGameStop);

		btnGamePause = new JButton("Pause");
		btnGamePause.setFont(new Font("굴림", Font.BOLD, 15));
		btnGamePause.setBounds(610, 410, 123, 23);
		ImagePanel.add(btnGamePause);

		btnGameResult = new JButton("결과");
		btnGameResult.setFont(new Font("굴림", Font.BOLD, 15));
		btnGameResult.setBounds(610, 345, 123, 23);
		ImagePanel.add(btnGameResult);

		repaint();

		setVisible(true);

		// 게임중 중지할떄 중지화면
		btnGamePause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PauseScreen pauseScreen = new PauseScreen();

				pauseScreen.setVisible(true);
				dispose();

			}
		});

		// 게임종료 후 로비이동
		btnGameStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Lobby lobby = new Lobby();

				lobby.setVisible(true);
				dispose();

			}
		});

		btnGameResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ResultScreen resultscreen = new ResultScreen();

				resultscreen.setVisible(true);
				dispose();

			}
		});

	}

	class ImagePanel extends JPanel {

		ImagePanel() {
			setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
			setLayout(null);
		}

		public void paint(Graphics g) {
			super.paintComponent(g);
			g.drawImage(gameInfoImage, 0, 0, null);
			screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
			screenGraphic = screenImage.getGraphics();
			screenDraw(screenGraphic);
			g.drawImage(screenImage, 0, 0, null);
		}

		public void screenDraw(Graphics g) {
			g.drawImage(background, 0, 0, null);
			if (isGameScreen) {
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
			paintComponents(g);
			this.repaint();

		}
		
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
