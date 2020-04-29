package beat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import domain.RecodeVO;
import domain.UserVO;
import persistence.UserDAO;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.DropMode;

public class Beat extends JPanel implements ActionListener {

	private JTextField textField;
	private JPasswordField passwordField;

	private JButton btlogin; // 로그인 버튼
	private JButton btsign; // 회원가입 버튼
	private JLabel lblBackGroundIMG; // 백그라운드 이미지
	private UserVO vo = new UserVO();
	
	private JPanel contentPane;
	private Music introMusic;

	private Lobby lobby;

	public Beat(JPanel contentPane) {
		this.contentPane = contentPane;
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setLayout(null); // 레이아웃 없음
		lobby = new Lobby(contentPane);

		introMusic = new Music("introMusic1.mp3", true);
		introMusic.start();

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Jokerman", Font.BOLD, 15));
		lblId.setForeground(Color.WHITE);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(60, 473, 100, 20);
		add(lblId);

		// 아이디 입력 필드
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setOpaque(false);
		textField.setBounds(140, 470, 120, 20);
		add(textField);
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("PW");
		lblPassword.setFont(new Font("Jokerman", Font.BOLD, 15));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(60, 509, 100, 20);
		add(lblPassword);

		// 비밀번호 입력 필드
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setOpaque(false);
		passwordField.setBounds(140, 510, 120, 20);
		passwordField.registerKeyboardAction(this, "btlogin",
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_FOCUSED);

//		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(passwordField);

		// 로그인 버튼 -btlogin
//		btlogin = new JButton(new ImageIcon(Beat.class.getResource("../images/login-button.png")));
		btlogin = new JButton("LOGIN");
		btlogin.setFont(new Font("Jokerman", Font.BOLD, 20));
		btlogin.setForeground(Color.WHITE);
		btlogin.setOpaque(false);
		btlogin.setBorderPainted(false);
		btlogin.setContentAreaFilled(false);
		btlogin.setFocusPainted(false);
		btlogin.setBounds(260, 460, 120, 40);
		btlogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btlogin.setForeground(Color.YELLOW);
				btlogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {

				btlogin.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				btlogin.setForeground(Color.WHITE);
			}

		});
		add(btlogin);

		// 회원가입 버튼 -btsign
		btsign = new JButton("Sign Up");
		btsign.setFont(new Font("Jokerman", Font.PLAIN, 20));
		btsign.setForeground(Color.WHITE);
		btsign.setBorderPainted(false);
		btsign.setContentAreaFilled(false);
		btsign.setFocusPainted(false);
		btsign.setBounds(270, 510, 110, 20);

		btsign.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btsign.setForeground(Color.YELLOW);
				btsign.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {

				btsign.setForeground(Color.WHITE);
				btsign.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		add(btsign);

		lblBackGroundIMG = new JLabel();
		lblBackGroundIMG.setIcon(new ImageIcon(Beat.class.getResource("/images/ezgif.com-resize (4).gif")));
		lblBackGroundIMG.setBounds(0, 0, 794, 571);
		add(lblBackGroundIMG);

		
		setVisible(true); //게임이 정상적으로 출력
	
//		//회원가입
//		btsign.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				SignupPanel frame = new SignupPanel();
//			}
//			});
		
		//로그인
//		btlogin.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String id = textField.getText();
//				char[] pass = passwordField.getPassword();
//				String password = new String(pass);
//				vo.setUserId(id);
//				vo.setPassword(password);
//				  if (id.equals("") || password.equals("")) {
//			            // 메시지를 날린다.
//			            JOptionPane.showMessageDialog(null, "빈칸이 있네요.");
//			        } else {
////			        	
//			        	
//			        	if(Main.serverConnection) {
//			        		vo = Main.client.login(vo); // DB에서 유저 정보 가져옴
//			          		setUserInfo(vo);            // DB 유저정보를 로컬과 동기화.
//			          									
//			          		Main.client.getUserRecord(vo);	// DB의 개인 기록을 로컬에 동기화.
//			          		
//			        		setVisible(false);
//		        			contentPane.add(lobby,BorderLayout.CENTER);
//		        			introMusic.close();
//		        			lobby.setVisible(true);
//		        			
//			        	} else if(id.equals("admin")){
//			        		JOptionPane.showMessageDialog(null, "관리자로 접속합니다.","접속",JOptionPane.INFORMATION_MESSAGE,null);
//			        		setVisible(false);
//		        			contentPane.add(lobby,BorderLayout.CENTER);
//		        			introMusic.close();
//		        			lobby.setVisible(true);
//			        		
//			        		
//			        	} else {
//			        		JOptionPane.showMessageDialog(null, "서버가 끊겼네요. 관리자로 접속하세요.","끊김",JOptionPane.WARNING_MESSAGE);
//			        	}
//			        	


		setVisible(true); // 게임이 정상적으로 출력

		// 회원가입
		btsign.addActionListener(this);
		// 로그인
		btlogin.addActionListener(this);
	}

	public void setUserInfo(UserVO vo) {
		// System.out.println(vo); 서버로부터 넘겨 받은 정보가 제대로 담겨 있는지 확인.
		for (RecodeVO rvo : Main.MYRECODE) {
			rvo.setUserid(vo.getUserId());
			rvo.setUserno(vo.getUserNo());
		}
		System.out.println(vo);
	}

	public void setRecord(ArrayList<RecodeVO> voList) {
		
		ArrayList<RecodeVO> recordVO = voList;
		for(int i = 0 ;i<recordVO.size();i++) {
  			recordVO.get(i);
  			
  		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("btlogin") || e.getSource() == btlogin) 
			{
				String id = textField.getText();
				char[] pass = passwordField.getPassword();
				String password = new String(pass);
				vo.setUserId(id);
				vo.setPassword(password);
				if (id.equals("") || password.equals("")) {
					// 메시지를 날린다.
					JOptionPane.showMessageDialog(null, "빈칸이 있네요.");
				} 
				else {
					if (Main.serverConnection) {
						vo = Main.client.login(vo); // DB에서 유저 정보 가져옴
		          		setUserInfo(vo);            // DB 유저정보를 로컬과 동기화.
		          									
		          		Main.MYRECODE =Main.client.getUserRecord(vo);	// DB의 개인 기록을 로컬에 동기화.

						setVisible(false);
						contentPane.add(lobby, BorderLayout.CENTER);
						introMusic.close();
						lobby.setVisible(true);

					} else if (id.equals("admin")) {
						JOptionPane.showMessageDialog(null, "관리자로 접속합니다.", "접속", JOptionPane.INFORMATION_MESSAGE, null);
						setVisible(false);
						contentPane.add(lobby, BorderLayout.CENTER);
						introMusic.close();
						lobby.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "서버가 끊겼네요. 관리자로 접속하세요.", "끊김", JOptionPane.WARNING_MESSAGE);
					}

				}
			}
			else if(e.getActionCommand().equals("btsign") || e.getSource() == btsign) {
				if(Main.serverConnection) {
					SignupPanel frame = new SignupPanel();
				}else {
					JOptionPane.showMessageDialog(null, "서버가 끊겼네요. 회원가입이 불가능 합니다.", "끊김", JOptionPane.WARNING_MESSAGE);
				}
			}
	}


}
