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
import javax.swing.ImageIcon;

public class ResultScreen extends JPanel{
	
	
	private JButton btnSelectSong;
	
	SelectSong  selectSong;  
	
	public ResultScreen(JPanel contentPane,SongRecodeVO vo) {
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setLayout(null);
		
		btnSelectSong = new JButton("곡 선택으로 이동");
		btnSelectSong.setFont(new Font("굴림", Font.BOLD, 15));
		btnSelectSong.setBounds(40, 33, 149, 23);
		add(btnSelectSong);
		
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
