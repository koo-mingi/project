package beat;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;



import javax.swing.JLabel;
import javax.swing.JTextArea;


import com.sun.glass.ui.Screen;


import java.awt.Color;

public class SelectSong extends JFrame {
	
	
	private Image screenImage;
	private Graphics screenGraphic;
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/spring.png")).getImage();
	private Image background = new ImageIcon(Main.class.getResource("../images/electric_guitar.jpg")).getImage();
	
	private boolean isMainScreen = true;
	
	
	private JButton btnStart ;
	
	public static GamePlay gameplay =  new GamePlay();
	
	
	/**
	 * Create the panel.
	 */
	public SelectSong() {
		setTitle("SelectSong"); //타이틀 이름
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setResizable(false); // 창 사이즈 변경 불가
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 시 스레드 종료
		
		
		
		ImagePanel ImagePanel = new ImagePanel();
		add(ImagePanel);
		
		
		JLabel lblNewLabel = new JLabel("난이도 조절");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(172, 339, 75, 15);
		ImagePanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("속도 조절");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(172, 454, 75, 15);
		ImagePanel.add(lblNewLabel_1);
		
		JButton btnEasy = new JButton("Easy");
		btnEasy.setBounds(56, 390, 97, 23);
		ImagePanel.add(btnEasy);
		
		JButton btnHard = new JButton("Hard");
		btnHard.setBounds(249, 390, 97, 23);
		ImagePanel.add(btnHard);
		
		JButton btnDecrease = new JButton("감소");
		btnDecrease.setBounds(56, 505, 97, 23);
		ImagePanel.add(btnDecrease);
		
		JButton btnIncrease = new JButton("증가");
		btnIncrease.setBounds(249, 505, 97, 23);
		ImagePanel.add(btnIncrease);
		
		JButton btnBack = new JButton("로비로 돌아가기");
		btnBack.setBounds(525, 428, 148, 23);
		ImagePanel.add(btnBack);
		
		
		btnStart = new JButton("게임 시작");
		btnStart.setBounds(525, 505, 148, 23);
		ImagePanel.add(btnStart);
		btnStart.addKeyListener(new KeyListener());
		
		JButton btnNewButton_6 = new JButton("좌");
		btnNewButton_6.setBounds(12, 122, 97, 23);
		ImagePanel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("우");
		btnNewButton_7.setBounds(286, 122, 97, 23);
		ImagePanel.add(btnNewButton_7);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(577, 126, 57, 15);
		ImagePanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(577, 203, 57, 15);
		ImagePanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(577, 279, 57, 15);
		ImagePanel.add(lblNewLabel_4);
		
		//ImagePanel.add(panel);
		repaint();
		
		setVisible(true);
	
	
	// 로비창으로 이동
	btnBack.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Lobby lobby =  new Lobby();
        	
        	lobby.setVisible(true);
        	dispose();
		}
	});
	
	// 게임플레이창으로 이동
	btnStart.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			      	
			gameplay.setVisible(true);
			System.out.println(gameplay);
			setFocusable(true);
        	dispose();
		}
	});
		
	
	}
	class ImagePanel extends JPanel{
		
		ImagePanel(){
			setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
			setLayout(null);
		}
		
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
	
}
