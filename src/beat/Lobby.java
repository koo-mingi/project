package beat;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.glass.ui.Timer;


public class Lobby extends JPanel{
	
	
	private JButton btnStart,btnRecord,btnRanking,btnEnd; 
	// 패널
	private SelectSong selectSong;
	private Record  record;
	private Ranking  ranking;
	
	private JPanel contentPane;
	
	
	// private int mouseX, mouseY;
	
	public Lobby(JPanel contentPane) {
		this.contentPane = contentPane; 		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setLayout(null);
				
		btnStart = new JButton("시작하기");
		
		btnStart.setFont(new Font("굴림", Font.BOLD, 26));
		btnStart.setBounds(133, 298, 175, 39);
		add(btnStart);
		
		btnRecord = new JButton("기록");
		btnRecord.setFont(new Font("굴림", Font.BOLD, 26));
		btnRecord.setBounds(133, 363, 175, 39);
		add(btnRecord);
		
		btnRanking = new JButton("랭킹");
		btnRanking.setFont(new Font("굴림", Font.BOLD, 26));
		btnRanking.setBounds(133, 425, 175, 39);
		add(btnRanking);
		
		btnEnd = new JButton("종료");
		btnEnd.setFont(new Font("굴림", Font.BOLD, 26));
		btnEnd.setBounds(133, 488, 175, 39);
		add(btnEnd);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Lobby.class.getResource("/images/ezgif.com-resize (4).gif")));
		lblNewLabel.setBounds(0, 0, 794, 572);
		add(lblNewLabel);
	
		
		// 노래 선택창으로 이동
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				selectSong = new SelectSong(contentPane);
				contentPane.add(selectSong,BorderLayout.CENTER);
				selectSong.setVisible(true);
				        				
				
			}
		});
		
		// 기록창으로 이동
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				record =  new Record(contentPane);
	        	contentPane.add(record,BorderLayout.CENTER);
	        	record.setVisible(true);
	        				
			}
		});
		
		//랭킹창으로 이동
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				setVisible(false);
				ranking =  new Ranking(contentPane);
	        	contentPane.add(ranking,BorderLayout.CENTER);
				ranking.setVisible(true);
	        	
			}
		});
		
		// 게임종료
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	        	System.exit(0);
			}
	
	});
		
		}
}
