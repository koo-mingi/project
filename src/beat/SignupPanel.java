package beat;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import domain.RecodeVO;
import domain.UserVO;

public class SignupPanel extends JFrame{
	private JTextField txtname;
	private JTextField txtid;
	private JTextField txtpw;
	private JTextField txtrpw;
	private JTextField txtmail;

	private UserVO vo;
	

	private  JLabel lblsingUpTitle;

	private JButton btncreate,btncancle;
	
	public  SignupPanel() {
		
		setTitle("sign");
		setSize(400, 550);
		setResizable(false); //창 사이즈 변경 불가
        setLocationRelativeTo(null); // 컴퓨터 정 중앙에 화면이 뜰수있게
//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // -있을시 창 모두 닫힘
       
        getContentPane().setLayout(null);

        
        
        lblsingUpTitle = new JLabel("Sign Up");
        lblsingUpTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblsingUpTitle.setForeground(Color.WHITE);
        lblsingUpTitle.setFont(new Font("Jokerman", Font.BOLD, 45));
        lblsingUpTitle.setBounds(110, 60, 180, 60);
        getContentPane().add(lblsingUpTitle);
        
        
        JLabel lblName = new JLabel("이름");
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("HY목판L", Font.BOLD, 12));
        lblName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblName.setBounds(84, 160, 80, 15);
        getContentPane().add(lblName);
        
        // 이름 입력 - txtname
        txtname = new JTextField();
        txtname.setBounds(200, 160, 116, 21);
        txtname.setForeground(Color.WHITE);
        txtname.setOpaque(false);
        getContentPane().add(txtname);
        txtname.setColumns(10);
        
        JLabel lblId = new JLabel("아이디");
        lblId.setForeground(Color.WHITE);
        lblId.setFont(new Font("HY목판L", Font.BOLD, 12));
        lblId.setHorizontalAlignment(SwingConstants.RIGHT);
        lblId.setBounds(84, 200, 79, 15);
        getContentPane().add(lblId);
        
        // 아이디 입력 - txtid
        txtid = new JTextField();
        txtid.setBounds(200, 200, 116, 21);
        txtid.setForeground(Color.WHITE);
        txtid.setOpaque(false);
        getContentPane().add(txtid);
        txtid.setColumns(10);
        
        JLabel lblPassword = new JLabel("비밀번호");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("HY목판L", Font.BOLD, 12));
        lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPassword.setBounds(84, 240, 79, 15);
        getContentPane().add(lblPassword);
        
        // 비밀번호 입력 - txtpw
        txtpw = new JTextField();
        txtpw.setBounds(200, 240, 116, 21);
        txtpw.setForeground(Color.WHITE);
        txtpw.setOpaque(false);
        getContentPane().add(txtpw);
        txtpw.setColumns(10);
        
        JLabel lblPasswordAgain = new JLabel("비밀번호 확인");
        lblPasswordAgain.setForeground(Color.WHITE);
        lblPasswordAgain.setFont(new Font("HY목판L", Font.BOLD, 12));
        lblPasswordAgain.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPasswordAgain.setBounds(66, 280, 97, 15);
        getContentPane().add(lblPasswordAgain);
        
        // 비밀번호 재입력 - txtrpw
        txtrpw = new JTextField();
        txtrpw.setBounds(200, 280, 116, 21);
        txtrpw.setForeground(Color.WHITE);
        txtrpw.setOpaque(false);
        getContentPane().add(txtrpw);
        txtrpw.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("이메일");
        lblNewLabel_5.setForeground(Color.WHITE);
        lblNewLabel_5.setFont(new Font("HY목판L", Font.BOLD, 12));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_5.setBounds(106, 320, 57, 15);
        getContentPane().add(lblNewLabel_5);
        
        // 이메일 입력 - txtmail
        txtmail = new JTextField();
        txtmail.setBounds(200, 320, 116, 21);
        txtmail.setForeground(Color.WHITE);
        txtmail.setOpaque(false);
        getContentPane().add(txtmail);
        txtmail.setColumns(10);
        
        // 회원가입 완료 버튼 - btncreate
        btncreate = new JButton("완료");
        btncreate.setForeground(Color.WHITE);
        btncreate.setFont(new Font("HY목판L", Font.BOLD, 12));
        btncreate.setBounds(85, 400, 100, 25);
        getContentPane().add(btncreate);
        btncreate.setContentAreaFilled(false);
        btncreate.setFocusPainted(false);
        btncreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
							
				btncreate.setForeground(Color.YELLOW);
				btncreate.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
		        
				btncreate.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				btncreate.setForeground(Color.WHITE);
		    }
		
		});
		getContentPane().add(btncreate);
        
        
        // 회원가입 취소 버튼 = btncancle
        btncancle = new JButton("취소");
        btncancle.setForeground(Color.WHITE);
        btncancle.setFont(new Font("HY목판L", Font.BOLD, 12));
        btncancle.setBounds(215, 400, 100, 25);
        getContentPane().add(btncancle);
        btncancle.setContentAreaFilled(false);
        btncancle.setFocusPainted(false);
        btncancle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
							
				btncancle.setForeground(Color.YELLOW);
				btncancle.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
		        
				btncancle.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				btncancle.setForeground(Color.WHITE);
		    }
		
		});
		getContentPane().add(btncancle);
		
		JLabel lblSignupBackground = new JLabel("");
		lblSignupBackground.setIcon(new ImageIcon(SignupPanel.class.getResource("/images/SignupBackground.gif")));
		lblSignupBackground.setBounds(0, 0, 394, 522);
		getContentPane().add(lblSignupBackground);
        
        
        setVisible(true);
        
        	
        btncreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 빈칸 있을 시 경고창 띄우기
				String name = txtname.getText();
				String id = txtid.getText();
		        String pass = txtpw.getText();
		        String pass1 = txtrpw.getText();
		        String mail = txtmail.getText();
//		        String password = new String(pass);
		 
		        if (name.equals("") || id.equals("") || pass.equals("") || pass1.equals("") || mail.equals("") ) {
		            // 메시지를 날린다.
		            JOptionPane.showMessageDialog(null, "빈칸이 있네요");
		        } else if(pass.equals(pass1)){
		        	vo = new UserVO();
		        	vo.setUserId(id);
		        	vo.setName(name);
		        	vo.setPassword(pass);
		        	vo.setEmail(mail);
		        	if((vo = Main.client.createUser(vo)) != null) { // 회원가입이 되었다고 연락이 오면.
		        		
		        		setUserInfo(vo);
		        		JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
		        		Main.client.setUserRecord(Main.MYRECODE);     // 개인 유저 기록을 DB에 초기화.
		        		dispose();
		        	}else {
		        		JOptionPane.showMessageDialog(null, "회원가입이 실패했습니다.");
		        		
		        	}
		        			        	
		        	
		        }else {
		        	 JOptionPane.showMessageDialog(null, "비번을 다시 입력하세요.");
		        }
				}
			});
				// 빈칸 값이 다 맞을 시 각 입력정보가 원하는 형태가 맞는지 확인하고
				// 정확하면 생성
				// 아니면 경고(입력된 정보 다시 확인 부탁)
//				User member = new user();
//				member.setUsername(txtname.getText());
//				member.setPassword(txtid.getText());
//				member.setName(txtpw.getText());
//				member.setEmail(txtrpw.getText());
//				member.setPhone(txtmail.getText());
//				
//				User dao = UserDao.getInstance();
//				int result = dao.save(member);



//				if(result == 1) {
					
//					dispose();					
//				}else {
//					JOptionPane.showMessageDialog(null, "회원가입이 실패하였습니다.");
//					dispose();
					
//				}
	
		
		//로그인 액션
		
        //취소
        btncancle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
	}
	public void setUserInfo(UserVO vo) {
		//System.out.println(vo); 서버로부터 넘겨 받은 정보가 제대로 담겨 있는지 확인.
		for(RecodeVO rvo : Main.MYRECODE) {
			rvo.setUserid(vo.getUserId());
			rvo.setUserno(vo.getUserNo());
		}
		System.out.println("회원가입 정보: "+vo);
	}
}

