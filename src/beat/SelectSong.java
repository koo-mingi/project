package beat;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.sun.glass.ui.Screen;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

public class SelectSong extends JPanel {
	
	
	private Image screenImage;
	private Graphics screenGraphic;
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/spring.png")).getImage();
	private Image background = new ImageIcon(Main.class.getResource("../images/electric_guitar.jpg")).getImage();
	
	private boolean isMainScreen = true;
	
	
	private JButton btnStart, btnEasy, btnHard, btnLeft, btnRight, btnBack;
	

	private Lobby lobby;
	private GamePlay gameplay;
	
	private ArrayList<Track> trackList = new ArrayList<Track>();
	private Music selectedMusic;
	private int trackNo = 0;
	
	private String titleName = "Spring";  // 선택된 곡의 이름
	private String difficulty = "Easy"; // 선택된 곡의 난이도
	private String musicTitle; // 선택된 곡 파일이름

	
	/**
	 * Create the panel.
	 */
	public SelectSong(JPanel contentPane) {
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setLayout(null);

		
	
		// 타이틀이미지,게임선택 창 표지이미지, 해당곡을 실행했을때 이미지 ,게임선택창 음악, 해당곡을 선택했을때 음악
		trackList.add(new Track(null, "spring.png", null, "introMusic1.mp3", "introMusic1.mp3","Spring"));
		trackList.add(new Track(null, "city.png", null, "introMusic1.mp3", "introMusic1.mp3","titlename"));
		
		selectTrack(0);
			
		
		btnEasy = new JButton("Easy");
		btnEasy.setForeground(new Color(255, 255, 240));
		btnEasy.setFont(new Font("Jokerman", Font.BOLD, 40));
		btnEasy.setContentAreaFilled(false);
		btnEasy.setFocusPainted(false);
		btnEasy.setBorderPainted(false);
		btnEasy.setBounds(150, 400, 140, 60);
		add(btnEasy);
		
		btnHard = new JButton("Hard");
		btnHard.setForeground(new Color(255, 255, 240));
		btnHard.setBackground(new Color(255, 255, 240));
		btnHard.setFont(new Font("Jokerman", Font.BOLD, 40));
		btnHard.setContentAreaFilled(false);
		btnHard.setFocusPainted(false);
		btnHard.setBorderPainted(false);
		btnHard.setBounds(305, 400, 140, 60);
		add(btnHard);
		
		
		btnStart = new JButton("Start");
		btnStart.setForeground(new Color(255, 215, 0));
		btnStart.setFont(new Font("Jokerman", Font.BOLD, 50));
		btnStart.setBounds(519, 400, 231, 100);
		btnStart.setContentAreaFilled(false);
		btnStart.setFocusPainted(false);
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
								
				btnStart.setForeground(Color.GREEN);
				btnStart.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
		       
				btnStart.setForeground(new Color(255, 215, 0));
				btnStart.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    }
			@Override
			public void mousePressed(MouseEvent e) {
				selectedMusic.close();
			}
				
				
		});
		add(btnStart);
		

		btnLeft = new JButton("<");
		btnLeft.setForeground(new Color(240, 255, 240));
		btnLeft.setContentAreaFilled(false);
		btnLeft.setFocusPainted(false);
		btnLeft.setBorderPainted(false);
		btnLeft.setFont(new Font("Jokerman", Font.BOLD, 78));
		btnLeft.setBounds(50, 180, 90, 90);
		btnLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
								
				btnLeft.setForeground(Color.YELLOW);
				btnLeft.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
		       
				btnLeft.setForeground(new Color(240, 255, 240));
				btnLeft.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    }
		
		});
		add(btnLeft);

		
		JLabel lblMyBestScore = new JLabel("MyBestScore");
		lblMyBestScore.setFont(new Font("Jokerman", Font.BOLD, 24));
		lblMyBestScore.setForeground(Color.WHITE);
		lblMyBestScore.setBounds(100, 500, 108, 35);
		add(lblMyBestScore);
		
		JLabel lblMyBestGrade = new JLabel("MyBestGrade");
		lblMyBestGrade.setForeground(Color.WHITE);
		lblMyBestGrade.setFont(new Font("Jokerman", Font.BOLD, 24));
		lblMyBestGrade.setBounds(243, 500, 108, 35);
		add(lblMyBestGrade);
		
		JLabel lblMyMaxCombo = new JLabel("MyMaxCombo");
		lblMyMaxCombo.setBackground(new Color(255, 255, 240));
		lblMyMaxCombo.setForeground(Color.WHITE);
		lblMyMaxCombo.setFont(new Font("Jokerman", Font.BOLD, 24));
		lblMyMaxCombo.setBounds(394, 500, 108, 35);
		add(lblMyMaxCombo);
		
		btnRight = new JButton(">");
		btnRight.setForeground(new Color(240, 255, 240));
		btnRight.setContentAreaFilled(false);
		btnRight.setFocusPainted(false);
		btnRight.setBorderPainted(false);
		btnRight.setFont(new Font("Jokerman", Font.BOLD, 78));
		btnRight.setBounds(660, 180, 90, 90);
		btnRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
								
				btnRight.setForeground(Color.YELLOW);
				btnRight.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
		       
				btnRight.setForeground(new Color(240, 255, 240));
				btnRight.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    }
		
		});
		add(btnRight);
		
		btnBack = new JButton("<");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Jokerman", Font.BOLD, 78));
		btnBack.setFocusPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setBounds(0, 0, 81, 84);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
								
				btnBack.setForeground(Color.YELLOW);
				btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
		       
				btnBack.setForeground(new Color(255, 255, 255));
				btnBack.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    }
			@Override
			public void mousePressed(MouseEvent e) {
				selectedMusic.close();
			}
		
		});
		add(btnBack);
		
		repaint();
		
		setVisible(true);
	
		
	// 로비창으로 이동
	btnBack.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			lobby =  new Lobby(contentPane);
			contentPane.add(lobby,BorderLayout.CENTER);
        	lobby.setVisible(true);
        	
		}
	});
	
	
	// 게임플레이창으로 이동
	btnStart.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(selectedMusic!= null) {
				selectedMusic.close();
			}
			setVisible(false);
			gameplay =  new GamePlay(contentPane,titleName,difficulty,musicTitle);
			contentPane.add(gameplay,BorderLayout.CENTER);
        	gameplay.setVisible(true);
        	  	
        	
		}
	});
	

	// 곡 선택 왼쪽 버튼 클릭
	btnLeft.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			selectLeft();
			// 곡에 해당하는 내 기록 가져와서 화면에 출력
			
		}
	});
	
	// 곡 선택 오른쪽 버튼 클릭
		btnRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectRight();
				// 곡에 해당하는 내 기록 가져와서 화면에 출력
				
			}
		});
	
	// 난이도 이지 선택
		btnEasy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
								
				btnEasy.setForeground(Color.YELLOW);
				btnEasy.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
		       
				btnEasy.setForeground(new Color(255, 255, 240));
				btnEasy.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				difficulty = "Easy";
			}
		
		});
		
	// 난이도 하드 선택
		btnHard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
								
				btnHard.setForeground(Color.YELLOW);
				btnHard.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
		       
				btnHard.setForeground(new Color(255, 255, 240));
				btnHard.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				difficulty = "Hard";
			}
		
		});
	

	}
		// 이미지 그리기
				
		@Override
		public void paintComponent(Graphics g) {

		
			super.paintComponent(g);
			g.drawImage(selectedImage, 0, 0, null);
			screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
			screenGraphic = screenImage.getGraphics();
			screenDraw(screenGraphic);
			g.drawImage(screenImage, 0, 0, null);
			
		}

		public void screenDraw(Graphics g) {
			g.drawImage(background, 0, 0, null);	
			if(isMainScreen) {
				
				g.drawImage(selectedImage, 150,70, null);
				
			}
			paintComponents(g);
			this.repaint();
			
			}
	
		public void selectTrack(int trackNo) {
			if(selectedMusic!= null) {
				selectedMusic.close();
			}
			selectedImage = new ImageIcon(Main.class.getResource("../images/"+trackList.get(trackNo).getStartImage())).getImage();
			selectedMusic = new Music(trackList.get(trackNo).getStartMusic(), true);
			titleName = trackList.get(trackNo).getTitleName();
			musicTitle = trackList.get(trackNo).getGameMusic();
			selectedMusic.start();
						
		}
		
		public void selectLeft() {
			if(trackNo == 0) {
				trackNo = trackList.size() - 1;
			}else {
				trackNo--;
			}
			selectTrack(trackNo);
		}
		
		public void selectRight() {
			if(trackNo == (trackList.size() - 1)) {
				trackNo = 0;
			}else {
				trackNo++;
			}
			selectTrack(trackNo);
		}
	
}