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

import domain.RecodeVO;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

public class SelectSong extends JPanel {
	
	
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon(Main.class.getResource("../images/electric_guitar.jpg")).getImage();
	
	private boolean isMainScreen = true;
	
	
	private JButton btnStart, btnEasy, btnHard, btnLeft, btnRight, btnBack;
	

	private Lobby lobby;
	private GamePlay gameplay;
	
	private ArrayList<Track> trackList = new ArrayList<Track>();
	private Music selectedMusic;
	private int trackNo = 0;
	
	private String titleName; // = "Spring";  // 선택된 곡의 이름
	private String difficulty = "Easy"; // 선택된 곡의 난이도
	private String musicTitle; // 선택된 곡 파일이름
	private Image selectedImage; //= new ImageIcon(Main.class.getResource("../images/spring.png")).getImage();
	private int index=0; // 저장된 곡의 Index. easy = track *2, hard = track *2 +1
	private JLabel lblMyBestScore,lblMyBestGrade,lblMyMaxCombo;
	

	private int easy_hard_select = 1; //어떤 버튼이 선택 됐는지 확인하는 것 - 0이면 선택 X, 1이면 easy, 2면 hard
	/**
	 * Create the panel.
	 */
	public SelectSong(JPanel contentPane) {
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setLayout(null);

		
	
		// 타이틀이미지,게임선택 창 표지이미지, 해당곡을 실행했을때 이미지 ,게임선택창 음악, 해당곡을 선택했을때 음악, 해당곡 이름
		trackList.add(new Track(null, "Happy Life start image.jpg", "Aurora.gif", "Fredji_Happy Life_Selected.mp3", "Fredji_Happy Life_Play.mp3","Happy Life - Fredji"));
		trackList.add(new Track(null, "Chilling start image.jpg", "Wolf.gif", "Oshova_Chilling.mp3", "Oshova_Chilling.mp3","Chilling - Oshova"));
		trackList.add(new Track(null, "Harmony start image.jpg", "particles.gif", "Ikson_Harmony_Selected.mp3", "Ikson_Harmony_Play.mp3","Harmony - Ikson"));
		
		selectTrack(0);

			
		
		btnEasy = new JButton("Easy");
		btnEasy.setForeground(Color.YELLOW);
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
		btnStart.setBorderPainted(false);
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
//				selectedMusic.close();

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
				btnLeft.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 버튼위에 마우스 올려놓으면 손 모양으로 커서 모양 변함
			}
			public void mouseExited(MouseEvent e) {
		       
				btnLeft.setForeground(new Color(240, 255, 240));
				btnLeft.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    }
		
		});
		add(btnLeft);

		
		lblMyBestScore = new JLabel(String.valueOf(Main.MYRECODE.get(index).getScore()));
		lblMyBestScore.setFont(new Font("Jokerman", Font.BOLD, 24));
		lblMyBestScore.setForeground(Color.WHITE);
		lblMyBestScore.setBounds(100, 500, 108, 35);
		add(lblMyBestScore);
		
		lblMyBestGrade = new JLabel(Main.MYRECODE.get(index).getGrade());
		lblMyBestGrade.setForeground(Color.WHITE);
		lblMyBestGrade.setFont(new Font("Jokerman", Font.BOLD, 24));
		lblMyBestGrade.setBounds(243, 500, 108, 35);
		add(lblMyBestGrade);
		
		lblMyMaxCombo = new JLabel(String.valueOf(Main.MYRECODE.get(index).getCombo()));
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
        	selectedMusic.close();
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
			Game.game_State = true;
			Game.COMBO = 0;
			gameplay =  new GamePlay(contentPane,titleName,difficulty,musicTitle,trackNo);

			
			contentPane.add(gameplay,BorderLayout.CENTER);
        	gameplay.setVisible(true);
        	selectedMusic.close();
       	
		}
	});
	

	// 곡 선택 왼쪽 버튼 클릭
	btnLeft.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			selectLeft();
			// 곡에 해당하는 내 기록 가져와서 화면에 출력
			setRecode();
			
		}
	});
	
	// 곡 선택 오른쪽 버튼 클릭
		btnRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectRight();
				// 곡에 해당하는 내 기록 가져와서 화면에 출력
				setRecode();
				
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
		       if(easy_hard_select == 0 || easy_hard_select == 2) {
				btnEasy.setForeground(new Color(255, 255, 240));
				btnEasy.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		       }
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				easy_hard_select = 1; //easy 선택시
				difficulty = "Easy";
				btnEasy.setForeground(Color.YELLOW);
				btnHard.setForeground(new Color(255, 255, 240));
				setRecode();
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
		       if(easy_hard_select == 0 || easy_hard_select == 1) {
				btnHard.setForeground(new Color(255, 255, 240));
				btnHard.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		       }
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				easy_hard_select = 2;
				difficulty = "Hard";
				btnHard.setForeground(Color.YELLOW);
				btnEasy.setForeground(new Color(255, 255, 240));
				setRecode();
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
		
		public void setRecode() {
			if(difficulty.equals("Hard")) {
				index = trackNo*2 + 1;
			}else {
				index = trackNo*2;
			}
			lblMyBestScore.setText(String.valueOf(Main.MYRECODE.get(index).getScore()));
			lblMyBestGrade.setText(Main.MYRECODE.get(index).getGrade());
			lblMyMaxCombo.setText(String.valueOf(Main.MYRECODE.get(index).getCombo()));
		}
	
}