package beat;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.awt.Font;

public class SelectSong extends JPanel {
	
	
	private Image screenImage;
	private Graphics screenGraphic;
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/spring.png")).getImage();
	private Image background = new ImageIcon(Main.class.getResource("../images/electric_guitar.jpg")).getImage();
	
	private boolean isMainScreen = true;
	
	
	private JButton btnStart ;
	

	private Lobby lobby;
	private GamePlay gameplay;
	
	private ArrayList<Track> trackList = new ArrayList<Track>();
	private Music selectedMusic;
	private int trackNo = 0;

	
	/**
	 * Create the panel.
	 */
	public SelectSong(JPanel contentPane) {
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setLayout(null);

				
		trackList.add(new Track(null, "spring.png", null, "introMusic1.mp3", null));
		trackList.add(new Track(null, "city.png", null, "introMusic1.mp3", null));

		
		JButton btnEasy = new JButton("Easy");
		btnEasy.setForeground(new Color(255, 255, 240));
		btnEasy.setFont(new Font("Jokerman", Font.BOLD, 40));
		btnEasy.setContentAreaFilled(false);
		btnEasy.setFocusPainted(false);
		btnEasy.setBorderPainted(false);
		btnEasy.setBounds(150, 400, 140, 60);
		add(btnEasy);
		
		JButton btnHard = new JButton("Hard");
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
		add(btnStart);
		

		JButton btnLeft = new JButton("<");
		btnLeft.setForeground(new Color(240, 255, 240));
		btnLeft.setContentAreaFilled(false);
		btnLeft.setFocusPainted(false);
		btnLeft.setBorderPainted(false);
		btnLeft.setFont(new Font("Jokerman", Font.BOLD, 78));
		btnLeft.setBounds(50, 180, 90, 90);
		add(btnLeft);

		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Jokerman", Font.BOLD, 24));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(100, 500, 108, 35);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Jokerman", Font.BOLD, 24));
		lblNewLabel_2_1.setBounds(243, 500, 108, 35);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("New label");
		lblNewLabel_2_2.setBackground(new Color(255, 255, 240));
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Jokerman", Font.BOLD, 24));
		lblNewLabel_2_2.setBounds(394, 500, 108, 35);
		add(lblNewLabel_2_2);
		
		JButton btnRight = new JButton(">");
		btnRight.setForeground(new Color(240, 255, 240));
		btnRight.setContentAreaFilled(false);
		btnRight.setFocusPainted(false);
		btnRight.setBorderPainted(false);
		btnRight.setFont(new Font("Jokerman", Font.BOLD, 78));
		btnRight.setBounds(660, 180, 90, 90);
		add(btnRight);
		
		JButton btnBack = new JButton("<");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Jokerman", Font.BOLD, 78));
		btnBack.setFocusPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setBounds(0, 0, 81, 84);
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
			
			setVisible(false);
			gameplay =  new GamePlay(contentPane);
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