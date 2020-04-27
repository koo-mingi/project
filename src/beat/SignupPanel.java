package beat;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import domain.UserVO;

public class SignupPanel extends JFrame{
	private JTextField txtname;
	private JTextField txtid;
	private JTextField txtpw;
	private JTextField txtrpw;
	private JTextField txtmail;
	private UserVO vo = new UserVO();
	
	private JButton btncreate,btncancle;
	
	public  SignupPanel() {
		
		setTitle("sign");
		setSize(400, 550);
		setResizable(false); //창 사이즈 변경 불가
        setLocationRelativeTo(null); // 컴퓨터 정 중앙에 화면이 뜰수있게
//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // -있을시 창 모두 닫힘
       
        getContentPane().setLayout(null);

        
        
        JLabel lblNewLabel = new JLabel("회원가입");
        lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 40));
        lblNewLabel.setBounds(130, 61, 183, 53);
        getContentPane().add(lblNewLabel);
        
        
        JLabel lblNewLabel_1 = new JLabel("이름");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1.setBounds(84, 160, 79, 15);
        getContentPane().add(lblNewLabel_1);
        
        // 이름 입력 - txtname
        txtname = new JTextField();
        txtname.setBounds(197, 157, 116, 21);
        getContentPane().add(txtname);
        txtname.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("아이디");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2.setBounds(84, 212, 79, 15);
        getContentPane().add(lblNewLabel_2);
        
        // 아이디 입력 - txtid
        txtid = new JTextField();
        txtid.setBounds(197, 209, 116, 21);
        getContentPane().add(txtid);
        txtid.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("비밀번호");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_3.setBounds(84, 258, 79, 15);
        getContentPane().add(lblNewLabel_3);
        
        // 비밀번호 입력 - txtpw
        txtpw = new JTextField();
        txtpw.setBounds(197, 255, 116, 21);
        getContentPane().add(txtpw);
        txtpw.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("비밀번호 확인");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_4.setBounds(66, 301, 97, 15);
        getContentPane().add(lblNewLabel_4);
        
        // 비밀번호 재입력 - txtrpw
        txtrpw = new JTextField();
        txtrpw.setBounds(197, 298, 116, 21);
        getContentPane().add(txtrpw);
        txtrpw.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("이메일");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_5.setBounds(106, 338, 57, 15);
        getContentPane().add(lblNewLabel_5);
        
        // 이메일 입력 - txtmail
        txtmail = new JTextField();
        txtmail.setBounds(197, 338, 116, 21);
        getContentPane().add(txtmail);
        txtmail.setColumns(10);
        
        // 회원가입 완료 버튼 - btncreate
        btncreate = new JButton("완료");
        btncreate.setBounds(66, 427, 97, 23);
        getContentPane().add(btncreate);
        
        // 회원가입 취소 버튼 = btncancle
        btncancle = new JButton("취소");
        btncancle.setBounds(216, 427, 97, 23);
        getContentPane().add(btncancle);
        
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
		        	
		        	vo.setUserId(id);
		        	vo.setName(name);
		        	vo.setPassword(pass);
		        	vo.setEmail(mail);
		        	if(Main.client.createUser(vo)) { // 회원가입이 되었다고 연락이 오면.
		        		JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
		        		Main.client.userRecord();
		        		dispose();
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
	
}

