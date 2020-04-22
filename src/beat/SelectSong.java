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
	
	/**
	 * Create the panel.
	 */
	public SelectSong(JPanel contentPane) {
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setLayout(null);
				
		
		
		
		JLabel lblNewLabel = new JLabel("난이도 조절");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(172, 339, 75, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("속도 조절");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(172, 454, 75, 15);
		add(lblNewLabel_1);
		
		JButton btnEasy = new JButton("Easy");
		btnEasy.setBounds(56, 390, 97, 23);
		add(btnEasy);
		
		JButton btnHard = new JButton("Hard");
		btnHard.setBounds(249, 390, 97, 23);
		add(btnHard);
		
		JButton btnDecrease = new JButton("감소");
		btnDecrease.setBounds(56, 505, 97, 23);
		add(btnDecrease);
		
		JButton btnIncrease = new JButton("증가");
		btnIncrease.setBounds(249, 505, 97, 23);
		add(btnIncrease);
		
		JButton btnBack = new JButton("로비로 돌아가기");
		btnBack.setBounds(525, 428, 148, 23);
		add(btnBack);
		
		
		btnStart = new JButton("게임 시작");
		btnStart.setBounds(525, 505, 148, 23);
		add(btnStart);
		
		JButton btnNewButton_6 = new JButton("좌");
		btnNewButton_6.setBounds(12, 122, 97, 23);
		add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("우");
		btnNewButton_7.setBounds(286, 122, 97, 23);
		add(btnNewButton_7);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(577, 126, 57, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(577, 203, 57, 15);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(577, 279, 57, 15);
		add(lblNewLabel_4);
		
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
				
				g.drawImage(selectedImage, 25,25, null);
				
			}
			paintComponents(g);
			this.repaint();
			
			}
	
					
	
}
