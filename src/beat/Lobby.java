package beat;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.RecodeVO;
import domain.UserVO;

import java.awt.Color;
import java.awt.Cursor;

public class Lobby extends JPanel {

	private JButton btnStart, btnRecord, btnRanking, btnEnd;
	// 패널
	private SelectSong selectSong;
	private Record record;
	private Ranking ranking;

	private JPanel contentPane;

	// START이미지
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/START_PRESS.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/START_BASIC.png"));

	// END이미지
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/END_PRESS.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/END_BASIC.png"));

	// private int mouseX, mouseY;
	private ArrayList<RecodeVO> recodeVO = new ArrayList<RecodeVO>();
	
	public Lobby(JPanel contentPane) {
		this.contentPane = contentPane;
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setLayout(null);
		
		
		Music introMusic = new Music("introMusic1.mp3", true);
		introMusic.start();

		btnStart = new JButton("");
		btnStart.setIcon(new ImageIcon(Lobby.class.getResource("../images/START_BASIC.png")));
		btnStart.setBackground(new Color(240, 248, 255));
		btnStart.setBorderPainted(false);
		btnStart.setContentAreaFilled(false);
		btnStart.setFocusPainted(false);
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnStart.setIcon(startButtonEnteredImage);
				btnStart.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {

				btnStart.setIcon(startButtonBasicImage);
				btnStart.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

		});
		add(btnStart);

		btnStart.setFont(new Font("굴림", Font.BOLD, 26));
		btnStart.setBounds(291, 49, 225, 208);
		add(btnStart);

		btnRecord = new JButton("MyRECORD");
		btnRecord.setForeground(new Color(64, 224, 208));
		btnRecord.setBorderPainted(false);
		btnRecord.setContentAreaFilled(false);
		btnRecord.setFocusPainted(false);
		btnRecord.setFont(new Font("Jokerman", Font.BOLD, 26));
		btnRecord.setBounds(25, 490, 203, 50);
		btnRecord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnRecord.setForeground(Color.YELLOW);
				btnRecord.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {

				btnRecord.setForeground(new Color(64, 224, 208));
				btnRecord.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		add(btnRecord);

		btnRanking = new JButton("RANKING");
		btnRanking.setForeground(new Color(64, 224, 208));
		btnRanking.setBorderPainted(false);
		btnRanking.setContentAreaFilled(false);
		btnRanking.setFocusPainted(false);
		btnRanking.setFont(new Font("Jokerman", Font.BOLD, 26));
		btnRanking.setBounds(230, 490, 180, 50);
		btnRanking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnRanking.setForeground(Color.YELLOW);
				btnRanking.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {

				btnRanking.setForeground(new Color(64, 224, 208));
				btnRanking.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		add(btnRanking);

		btnEnd = new JButton();
		btnEnd.setBorderPainted(false);
		btnEnd.setContentAreaFilled(false);
		btnEnd.setFocusPainted(false);
		btnEnd.setIcon(new ImageIcon(Lobby.class.getResource("/images/END_BASIC.PNG")));
		btnEnd.setFont(new Font("굴림", Font.BOLD, 26));
		btnEnd.setBounds(687, 20, 92, 92);
		btnEnd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnEnd.setIcon(exitButtonEnteredImage);
				btnEnd.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {

				btnEnd.setIcon(exitButtonBasicImage);
				btnEnd.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		add(btnEnd);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Lobby.class.getResource("/images/ezgif.com-resize (4).gif")));
		lblNewLabel.setBounds(0, 0, 794, 572);
		add(lblNewLabel);

		// 노래 선택창으로 이동
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				selectSong = new SelectSong(contentPane);
				contentPane.add(selectSong, BorderLayout.CENTER);
				selectSong.setVisible(true);
				introMusic.close();

			}
		});

		// 기록창으로 이동
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				record = new Record(contentPane);
				contentPane.add(record, BorderLayout.CENTER);
				record.setVisible(true);
				introMusic.close();

			}
		});

		// 랭킹창으로 이동
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				recodeVO = Main.client.getAllRankingInfo();
				
				setVisible(false);
				ranking = new Ranking(contentPane,recodeVO);
				contentPane.add(ranking, BorderLayout.CENTER);
				ranking.setVisible(true);
				introMusic.close();
				

			}
		});

		// 게임종료
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveRecodeVO();
				System.exit(0);
			}

		});

	}
	
	//기록을 저장파일에 저장
	public void saveRecodeVO() {
		try(FileOutputStream fos = new FileOutputStream(Main.file.getPath());
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			for(int i =0 ; i<Main.MYRECODE.size();i++) {
				oos.writeObject(Main.MYRECODE.get(i));
						
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
