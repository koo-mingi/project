package beat;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Lobby extends JFrame{
	
//	private Image background=new ImageIcon(Main2.class.getResource("../images/electric_guitar.jpg")).getImage();
	
	private JButton btnStart,btnRecord,btnRanking,btnEnd; 
	private SelectSong selectSong;
	
	
	
	private int mouseX, mouseY;
	
	public Lobby() {
		
		setTitle("Lobby"); //타이틀 이름
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setResizable(false); // 창 사이즈 변경 불가
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 시 스레드 종료
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnStart = new JButton("시작하기");
		
		btnStart.setFont(new Font("굴림", Font.BOLD, 26));
		btnStart.setBounds(235, 298, 175, 39);
		panel.add(btnStart);
		
		btnRecord = new JButton("기록");
		btnRecord.setFont(new Font("굴림", Font.BOLD, 26));
		btnRecord.setBounds(235, 363, 175, 39);
		panel.add(btnRecord);
		
		btnRanking = new JButton("랭킹");
		btnRanking.setFont(new Font("굴림", Font.BOLD, 26));
		btnRanking.setBounds(235, 425, 175, 39);
		panel.add(btnRanking);
		
		btnEnd = new JButton("종료");
		btnEnd.setFont(new Font("굴림", Font.BOLD, 26));
		btnEnd.setBounds(235, 493, 175, 39);
		panel.add(btnEnd);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Lobby.class.getResource("/images/electric_guitar.jpg")));
		lblNewLabel.setBounds(-41, -69, 1274, 692);
		panel.add(lblNewLabel);
	
		
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.setVisible(false);
				getContentPane().remove(panel);
				selectSong = new SelectSong();
				getContentPane().add(selectSong, BorderLayout.CENTER);
				
				
				
			}
		});
		
		
		
		
	
	}
}
