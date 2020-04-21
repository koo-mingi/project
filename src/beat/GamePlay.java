package beat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class GamePlay extends JFrame{
	
	private JButton btnGameStop,btnGamePause;
	
	private PauseScreen pausescreen;
	private Lobby lobby;
	
	
	public GamePlay() {
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setResizable(false); // 창 사이즈 변경 불가
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 시 스레드 종료
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnGameStop = new JButton("Game 종료");
		btnGameStop.setFont(new Font("굴림", Font.BOLD, 15));
		btnGameStop.setBounds(610, 470, 123, 23);
		panel.add(btnGameStop);
		
		btnGamePause = new JButton("Pause");
		btnGamePause.setFont(new Font("굴림", Font.BOLD, 15));
		btnGamePause.setBounds(610, 410, 123, 23);
		panel.add(btnGamePause);
		
		
		btnGamePause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				PauseScreen  pauseScreen =  new PauseScreen();
				
				pauseScreen.setVisible(true);
				dispose();
				
			}
		});
		
		btnGameStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Lobby  lobby =  new Lobby();
				
				lobby.setVisible(true);
				dispose();
				
			}
		});
	
	}
	
	
}
