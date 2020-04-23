package beat;

import javax.swing.JFrame;

import javax.swing.JPanel;



import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.JLabel;


public class GamePlay extends JPanel{
	
	private JButton btnGameStop,btnGamePause,btnGameResult;
	
	private PauseScreen pauseScreen;

	private Lobby lobby;

	private ResultScreen resultScreen;
	

	private Image screenImage;
	private Graphics screenGraphic;

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

	private Image background = new ImageIcon(Main.class.getResource("../images/mainBackground.png")).getImage();

	private boolean isGameScreen = true;

	public static Game game = new Game();
	
	public GamePlay(JPanel contentPane) {
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기

		setLayout(null);
				
	
		btnGameStop = new JButton("Game 종료");
		btnGameStop.setFont(new Font("굴림", Font.BOLD, 15));
		btnGameStop.setBounds(610, 470, 123, 23);
		add(btnGameStop);
		

		btnGamePause = new JButton("Pause");
		btnGamePause.setFont(new Font("굴림", Font.BOLD, 15));
		btnGamePause.setBounds(610, 410, 123, 23);
    	add(btnGamePause);
		

		btnGameResult = new JButton("결과");
		btnGameResult.setFont(new Font("굴림", Font.BOLD, 15));
		btnGameResult.setBounds(610, 345, 123, 23);
		add(btnGameResult);


		

		setVisible(true);

		// 게임중 중지할떄 중지화면
		btnGamePause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				setVisible(false);
				pauseScreen =  new PauseScreen(contentPane);
				contentPane.add(pauseScreen,BorderLayout.CENTER);
				pauseScreen.setVisible(true);
	
			}
		});

		// 게임종료 후 로비이동
		btnGameStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				setVisible(false);
				lobby = new Lobby(contentPane);
				contentPane.add(lobby,BorderLayout.CENTER);
				lobby.setVisible(true);

			}
		});

		btnGameResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				setVisible(false);
				resultScreen = new ResultScreen(contentPane);
				contentPane.add(resultScreen,BorderLayout.CENTER);
				resultScreen.setVisible(true);
		
			}
		});
		
	}
	
	
		
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		if(isGameScreen) {
			
			game.screenDraw(g);
			
		}
			
		paintComponents(g);
		this.repaint();
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