package beat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;

public class Ranking extends JPanel{
	
	private JButton btnLOBBY;
	
	Lobby  lobby;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblScore1;
	private JLabel lblScore2;
	private JLabel lblScore3;
	private JLabel lblScore4;
	private JLabel lblScore5;
	private JLabel lblName1;
	private JLabel lblName2;
	private JLabel lblName3;
	private JLabel lblName4;
	private JLabel lblName5;
	private JLabel lblGrade1;
	private JLabel lblGrade2;
	private JLabel lblGrade3;
	private JLabel lblGrade4;
	private JLabel lblGrade5;
	private JLabel lblCombo1;
	private JLabel lblCombo2;
	private JLabel lblCombo3;
	private JLabel lblCombo4;
	private JLabel lblCombo5;
	private JLabel lblRank1;
	private JLabel lblRank2;
	private JLabel lblRank3;
	private JLabel lblRank4;
	private JLabel lblRank5;
	private JLabel lblUserTitle;
	private JLabel lblScoreTitle;
	private JLabel lblGradeTitle;
	private JLabel lblRankTitle;
	private JLabel lblComboTitle;
	private JLabel lblNewLabel_10;
	
	public Ranking(JPanel contentPane) {
		
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setLayout(null);
		
		
		
		btnLOBBY = new JButton("<      LOBBY");
		
		btnLOBBY.setBounds(12, 10, 230, 70);
		
		
		btnLOBBY.setForeground(Color.WHITE);

		btnLOBBY.setBorderPainted(false);
		btnLOBBY.setContentAreaFilled(false);
		btnLOBBY.setFocusPainted(false);
		btnLOBBY.setFont(new Font("Jokerman", Font.BOLD, 30));
		btnLOBBY.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnLOBBY.setForeground(Color.YELLOW);
				btnLOBBY.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {

				btnLOBBY.setForeground(Color.WHITE);
				btnLOBBY.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		add(btnLOBBY);
		
		
		
		
		JComboBox SongList = new JComboBox();
		SongList.setBounds(403, 121, 193, 21);
//		SongList.setBorder(null);
//		SongList.setOpaque(false);
		add(SongList);
		
		JComboBox Difficulty = new JComboBox();
		Difficulty.setBounds(608, 121, 118, 21);
		add(Difficulty);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(Ranking.class.getResource("/images/rowLINE.png")));
		lblNewLabel.setBounds(100, 240, 600, 5);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon(Ranking.class.getResource("/images/rowLINE.png")));
		lblNewLabel_1.setBounds(100, 300, 600, 5);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setIcon(new ImageIcon(Ranking.class.getResource("/images/rowLINE.png")));
		lblNewLabel_2.setBounds(100, 360, 600, 5);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setIcon(new ImageIcon(Ranking.class.getResource("/images/rowLINE.png")));
		lblNewLabel_3.setBounds(100, 420, 600, 5);
		add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setIcon(new ImageIcon(Ranking.class.getResource("/images/rowLINE.png")));
		lblNewLabel_4.setBounds(100, 480, 600, 5);
		add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setIcon(new ImageIcon(Ranking.class.getResource("/images/rowLINE.png")));
		lblNewLabel_5.setBounds(100, 540, 600, 5);
		add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setIcon(new ImageIcon(Ranking.class.getResource("/images/columnLINE.png")));
		lblNewLabel_6.setBounds(311, 195, 5, 350);
		add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel();
		lblNewLabel_7.setIcon(new ImageIcon(Ranking.class.getResource("/images/columnLINE.png")));
		lblNewLabel_7.setBounds(435, 195, 5, 350);
		add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel();
		lblNewLabel_8.setIcon(new ImageIcon(Ranking.class.getResource("/images/columnLINE.png")));
		lblNewLabel_8.setBounds(534, 195, 5, 350);
		add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel();
		lblNewLabel_9.setIcon(new ImageIcon(Ranking.class.getResource("/images/columnLINE.png")));
		lblNewLabel_9.setBounds(641, 195, 5, 350);
		add(lblNewLabel_9);
		
		lblScore1 = new JLabel("800000");
		lblScore1.setForeground(new Color(204, 255, 51));
		lblScore1.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblScore1.setBounds(328, 255, 104, 40);
		add(lblScore1);
		
		lblScore2 = new JLabel("800000");
		lblScore2.setForeground(new Color(0, 255, 153));
		lblScore2.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblScore2.setBounds(328, 315, 104, 40);
		add(lblScore2);
		
		lblScore3 = new JLabel("800000");
		lblScore3.setForeground(new Color(204, 255, 51));
		lblScore3.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblScore3.setBounds(328, 375, 104, 40);
		add(lblScore3);
		
		lblScore4 = new JLabel("800000");
		lblScore4.setForeground(new Color(0, 255, 153));
		lblScore4.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblScore4.setBounds(328, 435, 104, 40);
		add(lblScore4);
		
		lblScore5 = new JLabel("800000");
		lblScore5.setForeground(new Color(204, 255, 51));
		lblScore5.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblScore5.setBounds(328, 495, 104, 40);
		add(lblScore5);
		
		lblName1 = new JLabel("AAAAAAAAAAAA");
		lblName1.setForeground(new Color(204, 255, 51));
		lblName1.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblName1.setBounds(100, 255, 209, 40);
		add(lblName1);
		
		lblName2 = new JLabel("AAAAAAAAAAAA");
		lblName2.setForeground(new Color(0, 255, 153));
		lblName2.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblName2.setBounds(100, 315, 209, 40);
		add(lblName2);
		
		lblName3 = new JLabel("AAAAAAAAAAAA");
		lblName3.setForeground(new Color(204, 255, 51));
		lblName3.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblName3.setBounds(100, 375, 209, 40);
		add(lblName3);
		
		lblName4 = new JLabel("AAAAAAAAAAAA");
		lblName4.setForeground(new Color(0, 255, 153));
		lblName4.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblName4.setBounds(100, 435, 209, 40);
		add(lblName4);
		
		lblName5 = new JLabel("AAAAAAAAAAAA");
		lblName5.setForeground(new Color(204, 255, 51));
		lblName5.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblName5.setBounds(100, 495, 209, 40);
		add(lblName5);
		
		lblGrade1 = new JLabel("A");
		lblGrade1.setForeground(new Color(204, 255, 51));
		lblGrade1.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblGrade1.setBounds(475, 255, 38, 40);
		add(lblGrade1);
		
		lblGrade2 = new JLabel("A");
		lblGrade2.setForeground(new Color(0, 255, 153));
		lblGrade2.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblGrade2.setBounds(475, 315, 38, 40);
		add(lblGrade2);
		
		lblGrade3 = new JLabel("A");
		lblGrade3.setForeground(new Color(204, 255, 51));
		lblGrade3.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblGrade3.setBounds(475, 375, 38, 40);
		add(lblGrade3);
		
		lblGrade4 = new JLabel("A");
		lblGrade4.setForeground(new Color(0, 255, 153));
		lblGrade4.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblGrade4.setBounds(475, 435, 38, 40);
		add(lblGrade4);
		
		lblGrade5 = new JLabel("A");
		lblGrade5.setForeground(new Color(204, 255, 51));
		lblGrade5.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblGrade5.setBounds(475, 495, 38, 40);
		add(lblGrade5);
		
		lblCombo1 = new JLabel("000");
		lblCombo1.setForeground(new Color(204, 255, 51));
		lblCombo1.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblCombo1.setBounds(566, 255, 63, 40);
		add(lblCombo1);
		
		lblCombo2 = new JLabel("000");
		lblCombo2.setForeground(new Color(0, 255, 153));
		lblCombo2.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblCombo2.setBounds(566, 315, 63, 40);
		add(lblCombo2);
		
		lblCombo3 = new JLabel("000");
		lblCombo3.setForeground(new Color(204, 255, 51));
		lblCombo3.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblCombo3.setBounds(566, 375, 63, 40);
		add(lblCombo3);
		
		lblCombo4 = new JLabel("000");
		lblCombo4.setForeground(new Color(0, 255, 153));
		lblCombo4.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblCombo4.setBounds(566, 435, 63, 40);
		add(lblCombo4);
		
		lblCombo5 = new JLabel("000");
		lblCombo5.setForeground(new Color(204, 255, 51));
		lblCombo5.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblCombo5.setBounds(566, 495, 63, 40);
		add(lblCombo5);
		
		lblRank1 = new JLabel("1");
		lblRank1.setForeground(new Color(204, 255, 51));
		lblRank1.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblRank1.setBounds(670, 255, 38, 40);
		add(lblRank1);
		
		lblRank2 = new JLabel("2");
		lblRank2.setForeground(new Color(0, 255, 153));
		lblRank2.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblRank2.setBounds(670, 315, 38, 40);
		add(lblRank2);
		
		lblRank3 = new JLabel("3");
		lblRank3.setForeground(new Color(204, 255, 51));
		lblRank3.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblRank3.setBounds(670, 375, 38, 40);
		add(lblRank3);
		
		lblRank4 = new JLabel("4");
		lblRank4.setForeground(new Color(0, 255, 153));
		lblRank4.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblRank4.setBounds(670, 435, 38, 40);
		add(lblRank4);
		
		lblRank5 = new JLabel("5");
		lblRank5.setForeground(new Color(204, 255, 51));
		lblRank5.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblRank5.setBounds(670, 495, 38, 40);
		add(lblRank5);
		
		lblUserTitle = new JLabel("USER");
		lblUserTitle.setForeground(new Color(0, 255, 255));
		lblUserTitle.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblUserTitle.setBounds(176, 195, 66, 40);
		add(lblUserTitle);
		
		lblScoreTitle = new JLabel("SCORE");
		lblScoreTitle.setForeground(new Color(0, 255, 255));
		lblScoreTitle.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblScoreTitle.setBounds(336, 195, 87, 40);
		add(lblScoreTitle);
		
		lblGradeTitle = new JLabel("GRADE");
		lblGradeTitle.setForeground(new Color(0, 255, 255));
		lblGradeTitle.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblGradeTitle.setBounds(450, 195, 87, 40);
		add(lblGradeTitle);
		
		lblRankTitle = new JLabel("RANK");
		lblRankTitle.setForeground(new Color(0, 255, 255));
		lblRankTitle.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblRankTitle.setBounds(650, 195, 104, 40);
		add(lblRankTitle);
		
		lblComboTitle = new JLabel("COMBO");
		lblComboTitle.setForeground(new Color(0, 255, 255));
		lblComboTitle.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblComboTitle.setBounds(550, 195, 104, 40);
		add(lblComboTitle);
		
		lblNewLabel_10 = new JLabel();
		lblNewLabel_10.setIcon(new ImageIcon(Ranking.class.getResource("/images/ezgif.com-resize.gif")));
		lblNewLabel_10.setBounds(0, 0, 800, 600);
		add(lblNewLabel_10);
		
		
		
		// 로비창으로 이동
		btnLOBBY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
	        	setVisible(false);
	        	lobby =  new Lobby(contentPane);
	        	contentPane.add(lobby,BorderLayout.CENTER);
	        	lobby.setVisible(true);
	        	
	        	
			}
		});
	}
	
	
}










