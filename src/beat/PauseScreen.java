package beat;

import javax.swing.JFrame;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseScreen  extends JPanel{
	
	private JButton btnGameRestart,btnGameStop;
	private Lobby lobby;
	private GamePlay gameplay;
	
	public PauseScreen(JPanel contentPane) {
		
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setLayout(null);
		
		
		
		btnGameRestart = new JButton("Game 재시작");
		btnGameRestart.setFont(new Font("굴림", Font.BOLD, 15));
		btnGameRestart.setBounds(610, 410, 133, 23);
		add(btnGameRestart);
		
		btnGameStop = new JButton("Game 종료");
		btnGameStop.setFont(new Font("굴림", Font.BOLD, 15));
		btnGameStop.setBounds(610, 470, 133, 23);
		add(btnGameStop);
		
		// 로비 화면으로 이동
		btnGameStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				lobby =  new Lobby(contentPane);
				contentPane.add(lobby,BorderLayout.CENTER);
				lobby.setVisible(true);
							
			}
		});
		
		// 게임플레이 창으로 이동
		btnGameRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
//				gameplay =  new GamePlay(contentPane);
	        	contentPane.add(gameplay,BorderLayout.CENTER);
				gameplay.setVisible(true);
			
				
			}
		});
		
		
	}
	
	
}
