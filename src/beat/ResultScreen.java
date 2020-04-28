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
	
	public ResultScreen(JPanel contentPane,SongRecodeVO vo) {
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setLayout(null);

		
		btnSelectSong = new JButton("곡 선택으로 이동");
		btnSelectSong.setFont(new Font("굴림", Font.BOLD, 15));
		btnSelectSong.setBounds(40, 33, 149, 23);

			
		
		
		JLabel lblGrade = new JLabel(vo.getGrade());
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
		

		JLabel lblScore = new JLabel(String.valueOf(vo.getScore()));
		lblScore.setForeground(new Color(0, 204, 255));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("Jokerman", Font.BOLD, 40));
		lblScore.setBounds(115, 360, 200, 60);
		add(lblScore);
		
		JLabel lblPerfect = new JLabel("Perfect");
		lblPerfect.setForeground(new Color(0, 51, 255));
		lblPerfect.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfect.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblPerfect.setBounds(350, 200, 160, 40);
		add(lblPerfect);
		
		JLabel lbltitleName = new JLabel(vo.getTitleName());
		lbltitleName.setForeground(new Color(255, 255, 51));
		lbltitleName.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitleName.setFont(new Font("Jokerman", Font.BOLD, 40));
		lbltitleName.setBounds(50, 100, 450, 60);
		add(lbltitleName);
		
		JLabel lblDifficulty = new JLabel(vo.getDifficulty());
		lblDifficulty.setForeground(new Color(255, 255, 51));
		lblDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		lblDifficulty.setFont(new Font("Jokerman", Font.BOLD, 40));
		lblDifficulty.setBounds(500, 100, 200, 60);
		add(lblDifficulty);
		
		JLabel lblGreat = new JLabel("Great");
		lblGreat.setForeground(new Color(51, 153, 204));
		lblGreat.setHorizontalAlignment(SwingConstants.CENTER);
		lblGreat.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblGreat.setBounds(350, 250, 160, 40);
		add(lblGreat);
		
		JLabel lblNormal = new JLabel("Normal");
		lblNormal.setForeground(new Color(51, 255, 153));
		lblNormal.setHorizontalAlignment(SwingConstants.CENTER);
		lblNormal.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblNormal.setBounds(350, 300, 160, 40);
		add(lblNormal);
		
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
		
		JLabel lblPerfectScore = new JLabel(String.valueOf(vo.getAcPerfect()));
		lblPerfectScore.setForeground(new Color(0, 51, 255));
		lblPerfectScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfectScore.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblPerfectScore.setBounds(540, 200, 160, 40);
		add(lblPerfectScore);
		
		JLabel lblGreateScore = new JLabel(String.valueOf(vo.getAcGreat()));
		lblGreateScore.setForeground(new Color(51, 153, 204));
		lblGreateScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblGreateScore.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblGreateScore.setBounds(540, 250, 160, 40);
		add(lblGreateScore);
		
		JLabel lblNormalScore = new JLabel(String.valueOf(vo.getacNormal()));
		lblNormalScore.setForeground(new Color(51, 255, 153));
		lblNormalScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblNormalScore.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblNormalScore.setBounds(540, 300, 160, 40);
		add(lblNormalScore);
		
		JLabel lblBadScore = new JLabel(String.valueOf(vo.getAcBad()));
		lblBadScore.setForeground(new Color(255, 204, 0));
		lblBadScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblBadScore.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblBadScore.setBounds(540, 350, 160, 40);
		add(lblBadScore);
		
		JLabel lblMisScore = new JLabel(String.valueOf(vo.getAcMiss()));
		lblMisScore.setForeground(new Color(255, 204, 204));
		lblMisScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblMisScore.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblMisScore.setBounds(540, 400, 160, 40);
		add(lblMisScore);
		
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
