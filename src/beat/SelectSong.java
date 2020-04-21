package beat;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;



import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import com.sun.glass.ui.Screen;

public class SelectSong extends JPanel {
	
	
	private Image screenImage;
	private Graphics screenGraphic;
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/city.png")).getImage();

	
	private boolean isMainScreen = true;
	/**
	 * Create the panel.
	 */
	public SelectSong() {
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setLayout(new BorderLayout());
				
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("난이도 조절");
		lblNewLabel.setBounds(172, 339, 75, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("속도 조절");
		lblNewLabel_1.setBounds(172, 454, 75, 15);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Easy");
		btnNewButton.setBounds(56, 390, 97, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Hard");
		btnNewButton_1.setBounds(249, 390, 97, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("감소");
		btnNewButton_2.setBounds(56, 505, 97, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("증가");
		btnNewButton_3.setBounds(249, 505, 97, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("로비로 돌아가기");
		btnNewButton_4.setBounds(525, 428, 148, 23);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("게임 시작");
		btnNewButton_5.setBounds(525, 505, 148, 23);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("좌");
		btnNewButton_6.setBounds(12, 122, 97, 23);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("우");
		btnNewButton_7.setBounds(286, 122, 97, 23);
		panel.add(btnNewButton_7);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(577, 126, 57, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(577, 203, 57, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(577, 279, 57, 15);
		panel.add(lblNewLabel_4);
		
		setVisible(true);
		
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		//super.paintComponent(g);
		g.drawImage(selectedImage, 0, 0, null);
	}

	
	public void screenDraw(Graphics g) {
			if(isMainScreen) {
			
			g.drawImage(selectedImage, 100,100, null);
			
		}
		paintComponents(g);
		this.repaint();
	}
}
