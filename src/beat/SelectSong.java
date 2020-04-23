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
	public static GamePlay gameplay;
	
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
		trackList.add(new Track(null, "spring.png", null, "introMusic1.mp3", null));

		
		JButton btnEasy = new JButton("Easy");
		btnEasy.setBounds(150, 400, 140, 60);
		add(btnEasy);
		
		JButton btnHard = new JButton("Hard");
		btnHard.setBounds(305, 400, 140, 60);
		add(btnHard);
		
		JButton btnBack = new JButton("로비로 돌아가기");
		btnBack.setBounds(12, 10, 57, 35);
		add(btnBack);
		
		
		btnStart = new JButton("게임 시작");
		btnStart.setBounds(570, 400, 180, 100);
		add(btnStart);
		

		JButton btnNewButton_6 = new JButton("좌");
		btnNewButton_6.setBounds(50, 180, 70, 40);
		add(btnNewButton_6);

		

		JButton btnNewButton_7 = new JButton("우");
		btnNewButton_7.setBounds(680, 180, 70, 40);
		add(btnNewButton_7);

		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(100, 500, 108, 35);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel_2_1.setBounds(243, 500, 108, 35);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("New label");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel_2_2.setBounds(394, 500, 108, 35);
		add(lblNewLabel_2_2);
		
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
}
