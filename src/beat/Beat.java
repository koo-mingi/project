package beat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.DropMode;



public class Beat extends JPanel{
	
	private JTextField textField;
	private JPasswordField passwordField;
	
	private JButton btlogin; //로그인 버튼
	private JButton btsign;  //회원가입 버튼
	private JLabel lblBackGroundIMG; // 백그라운드 이미지
	
	private Lobby lobby;
	
	public Beat(JPanel contentPane) {

				setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setLayout(null); 								// 레이아웃 없음
		lobby =  new Lobby(contentPane);
				
			
		Music introMusic = new Music("introMusic1.mp3", true);
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
//		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(passwordField);
		
		// 로그인 버튼  -btlogin
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
	
		//회원가입
		btsign.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SignupPanel frame = new SignupPanel();
			}
			});
		
		//로그인
		btlogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				char[] pass = passwordField.getPassword();
				String password = new String(pass);
				
				  if (id.equals("") || password.equals("")) {
			            // 메시지를 날린다.
			            JOptionPane.showMessageDialog(null, "빈칸이 있네요");
			        } else {
			        	setVisible(false);
			        	contentPane.add(lobby,BorderLayout.CENTER);
			        	introMusic.close();
			        	lobby.setVisible(true);
		        	
			        	// DB 정보 받아서 기록 초기화
//			             로그인 참 거짓 여부를 판단
//			            boolean existLogin = LoginService.loginTest(id, password);
			        	
			        }
			}
		});
		}
}

		 
//		            if (existLogin) {
//		                // 로그인 성공일 경우
//		                JOptionPane.showMessageDialog(null, "로그인 성공");
//		            } else {
//		                // 로그인 실패일 경우
//		                JOptionPane.showMessageDialog(null, "로그인 실패");
//		            }
//		 
//		        }
//		        password = null;
//		 
//		    
//			}
//		});
		
		
	




