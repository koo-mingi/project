package beat;

import javax.swing.JFrame;

import javax.swing.JPanel;




import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory.Default;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

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

	private Image background = new ImageIcon(Main.class.getResource("../images/mainBackground.png")).getImage();
	private boolean isGameScreen = true;
	
	private beat.KeyListener keyListener = new beat.KeyListener();



	private Music gameMusic;

	public static Game game;
	

	
	public GamePlay(JPanel contentPane,String titleName, String difficulty,String musicTitle) {

	//public GamePlay(JPanel contentPane, String musicName, String imageName) {

		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기

		setLayout(null);

		game= new Game(titleName,difficulty,musicTitle);
			

	
//		gameMusic = new Music(musicName, true);
//		System.out.println(musicName + "gamePlay");
//		game = new Game(gameMusic, musicName);
		game.start();

	
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
		
			
		
		this.addKeyListener(keyListener);

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
				game.close();

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
						
			// 포커스를 그림 그리는 곳에 주어야 제대로 들어옴.
			// 생성자에서 포커스를 주고 그림을 그리면 포커스가 없는 그림이 다시 생겨서 인식이 안됨.
			requestFocus();
			setFocusable(true);	
			paintComponents(g);
			this.repaint();

		}

			
		paintComponents(g);
		this.repaint();
	}
		

	
}