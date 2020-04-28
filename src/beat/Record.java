package beat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;

public class Record extends JPanel {

	private JButton btnLobby;

	private Lobby lobby;

	/**
	 * Create the panel.
	 */
	public Record(JPanel contentPane) {

		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		
		Music introMusic = new Music("Fools_Rancking_Record_BGM.mp3", true);
		introMusic.start();

		btnLobby = new JButton("<      LOBBY");
		btnLobby.setHorizontalAlignment(SwingConstants.LEFT);
		btnLobby.setBounds(0, 0, 800, 54);
		btnLobby.setForeground(Color.WHITE);

		btnLobby.setBorderPainted(false);
		btnLobby.setContentAreaFilled(false);
		btnLobby.setFocusPainted(false);
		btnLobby.setFont(new Font("Jokerman", Font.BOLD, 30));
		btnLobby.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnLobby.setForeground(Color.YELLOW);
				btnLobby.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {

				btnLobby.setForeground(Color.WHITE);
				btnLobby.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		setLayout(null);
		add(btnLobby);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Record.class.getResource("/images/rowLINE.png")));
		lblNewLabel.setBounds(100, 250, 631, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Record.class.getResource("/images/rowLINE.png")));
		lblNewLabel_1.setBounds(100, 320, 631, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Record.class.getResource("/images/rowLINE.png")));
		lblNewLabel_1_1.setBounds(100, 390, 631, 15);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Record.class.getResource("/images/rowLINE.png")));
		lblNewLabel_1_1_1.setBounds(100, 460, 631, 15);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Record.class.getResource("/images/columnLINE.png")));
		lblNewLabel_2.setBounds(351, 200, 5, 270);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Record.class.getResource("/images/columnLINE.png")));
		lblNewLabel_2_1.setBounds(531, 200, 5, 270);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("EASY");
		lblNewLabel_3.setForeground(new Color(255, 153, 153));
		lblNewLabel_3.setFont(new Font("Jokerman", Font.BOLD, 42));
		lblNewLabel_3.setBounds(379, 200, 140, 40);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("HARD");
		lblNewLabel_3_1.setForeground(new Color(255, 153, 153));
		lblNewLabel_3_1.setFont(new Font("Jokerman", Font.BOLD, 42));
		lblNewLabel_3_1.setBounds(561, 200, 140, 40);
		add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Happy Life");
		lblNewLabel_3_2.setForeground(Color.YELLOW);
		lblNewLabel_3_2.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblNewLabel_3_2.setBounds(100, 275, 214, 40);
		add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Chilling");
		lblNewLabel_3_2_1.setForeground(Color.YELLOW);
		lblNewLabel_3_2_1.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblNewLabel_3_2_1.setBounds(100, 345, 240, 40);
		add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("Harmony");
		lblNewLabel_3_2_2.setForeground(Color.YELLOW);
		lblNewLabel_3_2_2.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblNewLabel_3_2_2.setBounds(100, 415, 239, 40);
		add(lblNewLabel_3_2_2);
		
		JLabel lblHappyEasyGrade = new JLabel(Main.MYRECODE.get(0).getGrade());
		lblHappyEasyGrade.setForeground(new Color(153, 255, 204));
		lblHappyEasyGrade.setFont(new Font("Jokerman", Font.BOLD, 27));
		lblHappyEasyGrade.setBounds(363, 275, 36, 40);
		add(lblHappyEasyGrade);
		
		JLabel lblHappyEasyScore = new JLabel(String.valueOf(Main.MYRECODE.get(0).getScore()));
		lblHappyEasyScore.setForeground(new Color(255, 255, 153));
		lblHappyEasyScore.setFont(new Font("Jokerman", Font.BOLD, 27));
		lblHappyEasyScore.setBounds(408, 275, 119, 40);
		add(lblHappyEasyScore);
		
		JLabel lblChillingEasyGrade = new JLabel(Main.MYRECODE.get(2).getGrade());
		lblChillingEasyGrade.setForeground(new Color(153, 255, 204));
		lblChillingEasyGrade.setFont(new Font("Jokerman", Font.BOLD, 27));
		lblChillingEasyGrade.setBounds(363, 345, 36, 40);
		add(lblChillingEasyGrade);
		
		JLabel lblHarmonyEasyGrade = new JLabel(Main.MYRECODE.get(4).getGrade());
		lblHarmonyEasyGrade.setForeground(new Color(153, 255, 204));
		lblHarmonyEasyGrade.setFont(new Font("Jokerman", Font.BOLD, 27));
		lblHarmonyEasyGrade.setBounds(363, 415, 36, 40);
		add(lblHarmonyEasyGrade);
		
		JLabel lblChillingEasyScore = new JLabel(String.valueOf(Main.MYRECODE.get(2).getScore()));
		lblChillingEasyScore.setForeground(new Color(255, 255, 153));
		lblChillingEasyScore.setFont(new Font("Jokerman", Font.BOLD, 27));
		lblChillingEasyScore.setBounds(408, 345, 119, 40);
		add(lblChillingEasyScore);
		
		JLabel lblHarmonyEasyScore = new JLabel(String.valueOf(Main.MYRECODE.get(4).getScore()));
		lblHarmonyEasyScore.setForeground(new Color(255, 255, 153));
		lblHarmonyEasyScore.setFont(new Font("Jokerman", Font.BOLD, 27));
		lblHarmonyEasyScore.setBounds(408, 415, 119, 40);
		add(lblHarmonyEasyScore);
		
		JLabel lblHappyHardGrade = new JLabel(Main.MYRECODE.get(1).getGrade());
		lblHappyHardGrade.setForeground(new Color(153, 255, 204));
		lblHappyHardGrade.setFont(new Font("Jokerman", Font.BOLD, 27));
		lblHappyHardGrade.setBounds(548, 275, 36, 40);
		add(lblHappyHardGrade);
		
		JLabel lblChillingHardGrade = new JLabel(Main.MYRECODE.get(3).getGrade());
		lblChillingHardGrade.setForeground(new Color(153, 255, 204));
		lblChillingHardGrade.setFont(new Font("Jokerman", Font.BOLD, 27));
		lblChillingHardGrade.setBounds(548, 345, 36, 40);
		add(lblChillingHardGrade);
		
		JLabel lblHarmonyHardGrade = new JLabel(Main.MYRECODE.get(5).getGrade());
		lblHarmonyHardGrade.setForeground(new Color(153, 255, 204));
		lblHarmonyHardGrade.setFont(new Font("Jokerman", Font.BOLD, 27));
		lblHarmonyHardGrade.setBounds(548, 415, 36, 40);
		add(lblHarmonyHardGrade);
		
		JLabel lblHappyHardScore = new JLabel(String.valueOf(Main.MYRECODE.get(1).getScore()));
		lblHappyHardScore.setForeground(new Color(255, 255, 153));
		lblHappyHardScore.setFont(new Font("Jokerman", Font.BOLD, 27));
		lblHappyHardScore.setBounds(585, 275, 119, 40);
		add(lblHappyHardScore);
		
		JLabel lblChillingHardScore = new JLabel(String.valueOf(Main.MYRECODE.get(3).getScore()));
		lblChillingHardScore.setForeground(new Color(255, 255, 153));
		lblChillingHardScore.setFont(new Font("Jokerman", Font.BOLD, 27));
		lblChillingHardScore.setBounds(585, 345, 119, 40);
		add(lblChillingHardScore);
		
		JLabel lblHarmonyHardScore = new JLabel(String.valueOf(Main.MYRECODE.get(5).getScore()));
		lblHarmonyHardScore.setForeground(new Color(255, 255, 153));
		lblHarmonyHardScore.setFont(new Font("Jokerman", Font.BOLD, 27));
		lblHarmonyHardScore.setBounds(585, 415, 119, 40);
		add(lblHarmonyHardScore);
		
		JLabel lblNewLabel_3_3 = new JLabel("MyBest");
		lblNewLabel_3_3.setForeground(new Color(204, 255, 255));
		lblNewLabel_3_3.setFont(new Font("Jokerman", Font.BOLD, 50));
		lblNewLabel_3_3.setBounds(66, 111, 208, 73);
		add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Record");
		lblNewLabel_3_3_1.setForeground(new Color(204, 255, 255));
		lblNewLabel_3_3_1.setFont(new Font("Jokerman", Font.BOLD, 50));
		lblNewLabel_3_3_1.setBounds(125, 181, 214, 73);
		add(lblNewLabel_3_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(Record.class.getResource("/images/particles.gif")));
		lblNewLabel_4.setBounds(0, 0, 800, 600);
		add(lblNewLabel_4);

		// 로비창으로 이동
		btnLobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				lobby = new Lobby(contentPane);
				contentPane.add(lobby, BorderLayout.CENTER);
				lobby.setVisible(true);
				introMusic.close();

			}
		});
		

	}
}
