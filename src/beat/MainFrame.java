package beat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

// 패널들을 붙일 메인 프레임

public class MainFrame extends JFrame{
	
	private JTextField textField;
	private JPasswordField passwordField;
	
	private JButton btlogin; //로그인 버튼
	private JButton btsign;  //회원가입 버튼
	private JLabel lblBackGroundIMG; // 백그라운드 이미지
	
	private JPanel contentPane; // 패널을 붙일 메인 패널
	private Beat beat;
	
	
	
	public MainFrame() {
		setTitle("Beat"); //타이틀 이름
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setResizable(false); // 창 사이즈 변경 불가
		setLocationRelativeTo(null); // 컴퓨터 정 중앙에 화면이 뜰수있게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임 종료시 프로그램 전체 종료 
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		beat = new Beat(contentPane);
		contentPane.add(beat,BorderLayout.CENTER);
		setVisible(true);
				


	}
		
}	
		
	




