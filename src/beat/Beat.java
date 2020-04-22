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



public class Beat extends JFrame{
	
	private JTextField textField;
	private JPasswordField passwordField;
	
	private JButton btlogin; //로그인 버튼
	private JButton btsign;  //회원가입 버튼
	private JLabel lblBackGroundIMG; // 백그라운드 이미지
	
	
	public Beat() {
		setTitle("Beat"); //타이틀 이름
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setResizable(false); // 창 사이즈 변경 불가
		setLocationRelativeTo(null); // 컴퓨터 정 중앙에 화면이 뜰수있게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임 종료시 프로그램 전체 종료 
		
		
		
		Music introMusic = new Music("introMusic1.mp3", true);
		introMusic.start();
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("  아이디 :");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(75, 180, 97, 15);
		panel.add(lblNewLabel);
		
		// 아이디 입력 필드
		textField = new JTextField();
		textField.setBounds(231, 177, 116, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호 :");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(75, 253, 97, 18);
		panel.add(lblNewLabel_1);
		
		// 비밀번호 입력 필드
		passwordField = new JPasswordField();
		passwordField.setBounds(231, 252, 116, 21);
		panel.add(passwordField);
		
		// 로그인 버튼  -btlogin
		btlogin = new JButton("로그인");
		btlogin.setBounds(89, 369, 97, 23);
		panel.add(btlogin);
		
		
		// 회원가입 버튼 -btsign
		btsign = new JButton("회원가입");
		btsign.setBounds(250, 369, 97, 23);
		panel.add(btsign);
		
		lblBackGroundIMG = new JLabel("New label");
		lblBackGroundIMG.setIcon(new ImageIcon(Beat.class.getResource("/images/ezgif.com-resize (4).gif")));
		lblBackGroundIMG.setBounds(0, 0, 794, 571);
		panel.add(lblBackGroundIMG);
		
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
			        	Lobby  frame =  new Lobby();
			        	introMusic.close();
			        	frame.setVisible(true);
			        	dispose();
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
		
		
	




