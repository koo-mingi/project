package beat;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Ranking extends JFrame{
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
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JLabel label;
	private JLabel lblGrade;
	private JLabel lblCombo;
	private JLabel label_3;
	private JLabel lblNewLabel_1;
	
	public Ranking() {
		
		setTitle("Ranking");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("로비로 돌아가기");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton.setBounds(39, 31, 157, 23);
		panel.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(69, 121, 30, 21);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(216, 121, 30, 21);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("유저이름");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(60, 218, 60, 15);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(39, 284, 97, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(39, 347, 97, 21);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(39, 407, 97, 21);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(39, 468, 97, 21);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(192, 284, 97, 21);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(192, 347, 97, 21);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(192, 407, 97, 21);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(192, 468, 97, 21);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(342, 284, 97, 21);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(342, 347, 97, 21);
		panel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(342, 407, 97, 21);
		panel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(342, 468, 97, 21);
		panel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(494, 284, 97, 21);
		panel.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(494, 347, 97, 21);
		panel.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(494, 407, 97, 21);
		panel.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(494, 468, 97, 21);
		panel.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(647, 284, 97, 21);
		panel.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(647, 347, 97, 21);
		panel.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(647, 407, 97, 21);
		panel.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(647, 468, 97, 21);
		panel.add(textField_19);
		
		label = new JLabel("점수");
		label.setFont(new Font("굴림", Font.BOLD, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(212, 218, 57, 15);
		panel.add(label);
		
		lblGrade = new JLabel("Grade");
		lblGrade.setFont(new Font("굴림", Font.BOLD, 15));
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrade.setBounds(362, 218, 57, 15);
		panel.add(lblGrade);
		
		lblCombo = new JLabel("Combo");
		lblCombo.setFont(new Font("굴림", Font.BOLD, 15));
		lblCombo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCombo.setBounds(514, 218, 57, 15);
		panel.add(lblCombo);
		
		label_3 = new JLabel("순위");
		label_3.setFont(new Font("굴림", Font.BOLD, 15));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(663, 218, 57, 15);
		panel.add(label_3);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Ranking.class.getResource("/images/ezgif.com-resize (6).gif")));
		lblNewLabel_1.setBounds(0, 0, 784, 561);
		panel.add(lblNewLabel_1);
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lobby  frame =  new Lobby();
				
	        	frame.setVisible(true);
	        	
	        	
	        	dispose();
	        	
			}
		});
	}
	
	
}










