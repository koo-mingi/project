package beat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultScreen extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	
	
	private JButton btnSelectSong;
	
	public ResultScreen() {
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setResizable(false); // 창 사이즈 변경 불가
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 시 스레드 종료
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(40, 152, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(40, 232, 57, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(40, 305, 57, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(40, 385, 57, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(40, 472, 57, 15);
		panel.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(164, 149, 116, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(164, 229, 116, 21);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(164, 302, 116, 21);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(164, 382, 116, 21);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(164, 469, 116, 21);
		panel.add(textField_4);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(393, 152, 57, 15);
		panel.add(lblNewLabel_1);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(393, 232, 57, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setBounds(393, 305, 57, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("New label");
		label_6.setBounds(393, 385, 57, 15);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("New label");
		label_7.setBounds(393, 472, 57, 15);
		panel.add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(547, 149, 116, 21);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(547, 229, 116, 21);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(547, 302, 116, 21);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(547, 382, 116, 21);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(547, 469, 116, 21);
		panel.add(textField_9);
		
		btnSelectSong = new JButton("곡 선택으로 이동");
		btnSelectSong.setFont(new Font("굴림", Font.BOLD, 15));
		btnSelectSong.setBounds(40, 33, 149, 23);
		panel.add(btnSelectSong);
		
		//노래 선택창으로 이동
		btnSelectSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				SelectSong  selectSong =  new SelectSong();
	        	
				selectSong.setVisible(true);
			
	        	dispose();
				
				
			}
		});
		
		
		
		
		
		
	}
}
