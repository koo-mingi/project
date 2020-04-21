package beat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Record extends JFrame {
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
	private JTextField textField_20;
	
	
	private Lobby lobby;
	private JLabel lblNewLabel_1;
	

	/**
	 * Create the panel.
	 */
	public Record() {
		
		setTitle("Record");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("로비로 돌아가기");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton.setBounds(38, 30, 195, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("곡명");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(57, 218, 45, 18);
		panel.add(lblNewLabel);
		
		JLabel lblNomal = new JLabel("난이도 nomal");
		lblNomal.setForeground(Color.WHITE);
		lblNomal.setFont(new Font("굴림", Font.BOLD, 15));
		lblNomal.setBounds(136, 218, 97, 18);
		panel.add(lblNomal);
		
		JLabel lblNormal = new JLabel("normal 점수");
		lblNormal.setForeground(Color.WHITE);
		lblNormal.setFont(new Font("굴림", Font.BOLD, 15));
		lblNormal.setBounds(260, 218, 87, 18);
		panel.add(lblNormal);
		
		JLabel lblNormalGrade = new JLabel("normal Grade");
		lblNormalGrade.setForeground(Color.WHITE);
		lblNormalGrade.setFont(new Font("굴림", Font.BOLD, 15));
		lblNormalGrade.setBounds(359, 218, 105, 18);
		panel.add(lblNormalGrade);
		
		JLabel lblHard = new JLabel("난이도 hard");
		lblHard.setForeground(Color.WHITE);
		lblHard.setFont(new Font("굴림", Font.BOLD, 15));
		lblHard.setBounds(486, 218, 87, 18);
		panel.add(lblHard);
		
		JLabel lblHard_1 = new JLabel("hard 점수");
		lblHard_1.setForeground(Color.WHITE);
		lblHard_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblHard_1.setBounds(598, 218, 84, 18);
		panel.add(lblHard_1);
		
		JLabel lblHardGrade = new JLabel("hard Grade");
		lblHardGrade.setForeground(Color.WHITE);
		lblHardGrade.setFont(new Font("굴림", Font.BOLD, 15));
		lblHardGrade.setBounds(694, 218, 94, 18);
		panel.add(lblHardGrade);
		
		textField = new JTextField();
		textField.setBounds(38, 283, 73, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(149, 283, 73, 21);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(260, 283, 73, 21);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(377, 283, 73, 21);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(488, 283, 73, 21);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(598, 283, 73, 21);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(704, 283, 73, 21);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(38, 352, 73, 21);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(149, 352, 73, 21);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(260, 352, 73, 21);
		panel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(377, 352, 73, 21);
		panel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(488, 352, 73, 21);
		panel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(598, 352, 73, 21);
		panel.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(704, 352, 73, 21);
		panel.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(38, 421, 73, 21);
		panel.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(149, 421, 73, 21);
		panel.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(260, 421, 73, 21);
		panel.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(377, 421, 73, 21);
		panel.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(488, 421, 73, 21);
		panel.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(598, 421, 73, 21);
		panel.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(704, 421, 73, 21);
		panel.add(textField_20);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setIcon(new ImageIcon(Record.class.getResource("/images/mainBackground.png")));
		lblNewLabel_1.setBounds(0, 0, 788, 561);
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
