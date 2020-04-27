package beat;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import domain.RecodeVO;
import domain.UserVO;

public class networkFrame extends JFrame{
	

	//private UserVO vo = new UserVO();
	
	
	public  networkFrame(String mode,UserVO vo,ArrayList<RecodeVO> recordVO) {
		
		setTitle("sign");
		setSize(400, 550);
		setResizable(false); //창 사이즈 변경 불가
        setLocationRelativeTo(null); // 컴퓨터 정 중앙에 화면이 뜰수있게

		if(mode.equals("LOGIN")) {
			vo = Main.client.login(vo);
			Main.client.createUser(vo);
		}
		else if(mode.equals("CREATUSER")) { // 회원가입이 되었다고 연락이 오면.
			Main.client.createUser(vo);
			Main.client.userRecord();
		}    
		        	
		        	
		    
		dispose();
		        	
	}
			       
	
}
