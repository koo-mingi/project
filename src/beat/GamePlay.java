package beat;

import javax.swing.JFrame;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.JLabel;


public class GamePlay extends JPanel{
	
	private JButton btnGameStop,btnGameResult;
	
	private Lobby lobby;
	private ResultScreen resultScreen;
	
	private JPanel contentPane;
	private Image screenImage;
	private Graphics screenGraphic;

	private Image background = new ImageIcon(Main.class.getResource("../images/bluewave.gif")).getImage();
	private boolean isGameScreen = true;
	
	private beat.KeyListener keyListener = new beat.KeyListener();


	public static Game game;
	private GameFinishThread gameFinish;
	

	
	public GamePlay(JPanel contentPane,String titleName, String difficulty, String musicTitle,int trackNo) {
		
		this.contentPane = contentPane;
				
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기

		setLayout(null);

		game= new Game(titleName,difficulty,musicTitle,trackNo);
				

		game.start();

	
		btnGameStop = new JButton("EXIT");
		btnGameStop.setForeground(Color.CYAN);
		btnGameStop.setBorderPainted(false);
		btnGameStop.setContentAreaFilled(false);
		btnGameStop.setFocusPainted(false);
		btnGameStop.setFont(new Font("Jokerman", Font.BOLD, 20));
		btnGameStop.setBounds(584, 470, 171, 23);
		btnGameStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
								
				btnGameStop.setForeground(Color.YELLOW);
				btnGameStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
		       
				btnGameStop.setForeground(Color.CYAN);
				btnGameStop.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    }
		
		});
		add(btnGameStop);
		

		btnGameResult = new JButton("RESULT");
		btnGameResult.setForeground(Color.CYAN);
		btnGameResult.setBorderPainted(false);
		btnGameResult.setContentAreaFilled(false);
		btnGameResult.setFocusPainted(false);
		btnGameResult.setFont(new Font("Jokerman", Font.BOLD, 20));
		btnGameResult.setBounds(610, 396, 123, 23);
		btnGameResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
								
				btnGameResult.setForeground(Color.YELLOW);
				btnGameResult.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
		       
				btnGameResult.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				btnGameResult.setForeground(Color.CYAN);
		    }
		
		});
		add(btnGameResult);



		setVisible(true);
		
			
		
		this.addKeyListener(keyListener);

		// 게임종료 후 로비이동
		btnGameStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				game.close();
				setVisible(false);
				lobby = new Lobby(contentPane);
				contentPane.add(lobby,BorderLayout.CENTER);
				lobby.setVisible(true);
				

			}
		});

		// 결과화면으로 이동
		btnGameResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.close();
				setVisible(false);
				resultScreen = new ResultScreen(contentPane,game.getSongRecodeVO());
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
			
			if(game.musicFinish()) {
				if(gameFinish == null) { 
					System.out.println("음악 종료 및 게임 종료 스레드 생성");
					gameFinish = new GameFinishThread();
					gameFinish.start();
				}
					
					if(gameFinish.state())
					{
						game.close();
						System.out.println("스레드 종료");
						setVisible(false);
						resultScreen = new ResultScreen(contentPane,game.getSongRecodeVO());
						contentPane.add(resultScreen,BorderLayout.CENTER);
						resultScreen.setVisible(true);
					}
			}
			
			
						
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