package beat;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.glass.ui.Timer;


public class Lobby extends JFrame{
	
	
	private JButton btnStart,btnRecord,btnRanking,btnEnd; 
	
	private SelectSong selectSong;
	private Record record;
	private Ranking ranking;
	
	// private int mouseX, mouseY;
	
	public Lobby() {
		
		setTitle("Lobby"); //타이틀 이름
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setResizable(false); // 창 사이즈 변경 불가
		setLocationRelativeTo(null); //화면 중앙 위치시켜줌
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 시 스레드 종료
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnStart = new JButton("시작하기");
		
		btnStart.setFont(new Font("굴림", Font.BOLD, 26));
		btnStart.setBounds(133, 298, 175, 39);
		panel.add(btnStart);
		
		btnRecord = new JButton("기록");
		btnRecord.setFont(new Font("굴림", Font.BOLD, 26));
		btnRecord.setBounds(133, 363, 175, 39);
		panel.add(btnRecord);
		
		btnRanking = new JButton("랭킹");
		btnRanking.setFont(new Font("굴림", Font.BOLD, 26));
		btnRanking.setBounds(133, 425, 175, 39);
		panel.add(btnRanking);
		
		btnEnd = new JButton("종료");
		btnEnd.setFont(new Font("굴림", Font.BOLD, 26));
		btnEnd.setBounds(133, 488, 175, 39);
		panel.add(btnEnd);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Lobby.class.getResource("/images/ezgif.com-resize (4).gif")));
		lblNewLabel.setBounds(0, 0, 794, 572);
		panel.add(lblNewLabel);
	
		
		// 노래 선택창으로 이동
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				SelectSong  selectSong =  new SelectSong();
	        	
				selectSong.setVisible(true);
			
	        	dispose();
				
				
			}
		});
		
		// 기록창으로 이동
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Record  record =  new Record();
	        	
	        	record.setVisible(true);
	        	dispose();
				
				
				
			}
		});
		
		//랭킹창으로 이동
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				Ranking  ranking =  new Ranking();
	        	
				ranking.setVisible(true);
	        	dispose();
			

			}
		});
		
		// 게임종료
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	        	dispose();
			}
	
	});
		
		}
}