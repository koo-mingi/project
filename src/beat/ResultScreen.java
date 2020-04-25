package beat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;

public class ResultScreen extends JPanel{
	
	
	private JButton btnSelectSong;
	
	SelectSong  selectSong;  
	
	public ResultScreen(JPanel contentPane) {
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setLayout(null);
			
		
		
		JLabel lblGrade = new JLabel("A");
		lblGrade.setForeground(new Color(0, 255, 255));
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrade.setFont(new Font("Jokerman", Font.BOLD, 99));
		lblGrade.setBounds(120, 150, 200, 200);
		add(lblGrade);
		
		btnSelectSong = new JButton("< Select Song");
		btnSelectSong.setBorderPainted(false);
		btnSelectSong.setContentAreaFilled(false);
		btnSelectSong.setFocusPainted(false);
		btnSelectSong.setForeground(new Color(255, 255, 255));
		btnSelectSong.setHorizontalAlignment(SwingConstants.LEFT);
		btnSelectSong.setFont(new Font("Jokerman", Font.BOLD, 30));
		btnSelectSong.setBounds(30, 30, 260, 45);
		btnSelectSong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnSelectSong.setForeground(Color.YELLOW);
				btnSelectSong.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {

				btnSelectSong.setForeground(Color.WHITE);
				btnSelectSong.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		setLayout(null);
		add(btnSelectSong);
		
		JLabel lblNewLabel = new JLabel("800000");
		lblNewLabel.setForeground(new Color(0, 204, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Jokerman", Font.BOLD, 40));
		lblNewLabel.setBounds(115, 360, 200, 60);
		add(lblNewLabel);
		
		JLabel lblPerfect = new JLabel("Perfect");
		lblPerfect.setForeground(new Color(0, 51, 255));
		lblPerfect.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfect.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblPerfect.setBounds(350, 200, 160, 40);
		add(lblPerfect);
		
		JLabel lblHappyLife = new JLabel("Happy Life");
		lblHappyLife.setForeground(new Color(255, 255, 51));
		lblHappyLife.setHorizontalAlignment(SwingConstants.CENTER);
		lblHappyLife.setFont(new Font("Jokerman", Font.BOLD, 40));
		lblHappyLife.setBounds(220, 100, 300, 60);
		add(lblHappyLife);
		
		JLabel lblHard = new JLabel("HARD");
		lblHard.setForeground(new Color(255, 255, 51));
		lblHard.setHorizontalAlignment(SwingConstants.CENTER);
		lblHard.setFont(new Font("Jokerman", Font.BOLD, 40));
		lblHard.setBounds(500, 100, 160, 60);
		add(lblHard);
		
		JLabel lblGreat = new JLabel("Great");
		lblGreat.setForeground(new Color(51, 153, 204));
		lblGreat.setHorizontalAlignment(SwingConstants.CENTER);
		lblGreat.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblGreat.setBounds(350, 250, 160, 40);
		add(lblGreat);
		
		JLabel lblGood = new JLabel("Good");
		lblGood.setForeground(new Color(51, 255, 153));
		lblGood.setHorizontalAlignment(SwingConstants.CENTER);
		lblGood.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblGood.setBounds(350, 300, 160, 40);
		add(lblGood);
		
		JLabel lblBad = new JLabel("Bad");
		lblBad.setForeground(new Color(255, 204, 0));
		lblBad.setHorizontalAlignment(SwingConstants.CENTER);
		lblBad.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblBad.setBounds(350, 350, 160, 40);
		add(lblBad);
		
		JLabel lblMiss = new JLabel("Miss");
		lblMiss.setForeground(new Color(255, 204, 204));
		lblMiss.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiss.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblMiss.setBounds(350, 400, 160, 40);
		add(lblMiss);
		
		JLabel lblPerfect_5 = new JLabel("0000");
		lblPerfect_5.setForeground(new Color(0, 51, 255));
		lblPerfect_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfect_5.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblPerfect_5.setBounds(540, 200, 160, 40);
		add(lblPerfect_5);
		
		JLabel lblPerfect_6 = new JLabel("0000");
		lblPerfect_6.setForeground(new Color(51, 153, 204));
		lblPerfect_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfect_6.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblPerfect_6.setBounds(540, 250, 160, 40);
		add(lblPerfect_6);
		
		JLabel lblPerfect_7 = new JLabel("0000");
		lblPerfect_7.setForeground(new Color(51, 255, 153));
		lblPerfect_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfect_7.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblPerfect_7.setBounds(540, 300, 160, 40);
		add(lblPerfect_7);
		
		JLabel lblPerfect_8 = new JLabel("0000");
		lblPerfect_8.setForeground(new Color(255, 204, 0));
		lblPerfect_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfect_8.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblPerfect_8.setBounds(540, 350, 160, 40);
		add(lblPerfect_8);
		
		JLabel lblPerfect_9 = new JLabel("0000");
		lblPerfect_9.setForeground(new Color(255, 204, 204));
		lblPerfect_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfect_9.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblPerfect_9.setBounds(540, 400, 160, 40);
		add(lblPerfect_9);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ResultScreen.class.getResource("/images/ezgif.com-resize (7).gif")));
		lblNewLabel_1.setBounds(0, 0, 800, 600);
		add(lblNewLabel_1);
		
		//노래 선택창으로 이동
		btnSelectSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				selectSong = new SelectSong(contentPane);
				contentPane.add(selectSong,BorderLayout.CENTER);
				selectSong.setVisible(true);
			     
				
				
			}
		});
		
		
		
		
		
		
	}
}
