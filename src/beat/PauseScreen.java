package beat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseScreen  extends JFrame{
	
	private JButton btnGameRestart,btnGameStop;
	private Lobby lobby;
	private GamePlay gameplay;
	
	public PauseScreen() {
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setResizable(false); // 창 사이즈 변경 불가
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 시 스레드 종료
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnGameRestart = new JButton("Game 재시작");
		btnGameRestart.setFont(new Font("굴림", Font.BOLD, 15));
		btnGameRestart.setBounds(610, 410, 133, 23);
		panel.add(btnGameRestart);
		
		btnGameStop = new JButton("Game 종료");
		btnGameStop.setFont(new Font("굴림", Font.BOLD, 15));
		btnGameStop.setBounds(610, 470, 133, 23);
		panel.add(btnGameStop);
		
		// 로비 화면으로 이동
		btnGameStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Lobby  lobby =  new Lobby();
				
				lobby.setVisible(true);
				dispose();
				
			}
		});
		
		// 게임플레이 창으로 이동
		btnGameRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				GamePlay  gameplay =  new GamePlay();
				
				gameplay.setVisible(true);
				dispose();
				
			}
		});
		
		
	}
	
	
}
