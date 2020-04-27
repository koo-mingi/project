package beat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import domain.RecodeVO;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Ranking extends JPanel {

	private JButton btnLOBBY;
	private JComboBox<String> songList;
	private JComboBox<String> difficultyList;
	private ArrayList<RecodeVO> recodeVO =  new ArrayList<RecodeVO>(); // DB에서 songid,score순으로 정렬되어 보내주어야 함.

	Lobby lobby;
	private JLabel lblScore[] = new JLabel[5];
	private JLabel lblName[] = new JLabel[5];
	private JLabel lblGrade[] = new JLabel[5];
	private JLabel lblCombo[] = new JLabel[5];
	private JLabel lblRank[] = new JLabel[5];
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblUserTitle;
	private JLabel lblScoreTitle;
	private JLabel lblGradeTitle;
	private JLabel lblRankTitle;
	private JLabel lblComboTitle;
	private JLabel lblNewLabel_10;

	public Ranking(JPanel contentPane, ArrayList<RecodeVO> recodeVO) {
		
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setLayout(null);

		Music introMusic = new Music("Fools_Rancking_Record_BGM.mp3", true);
		introMusic.start();
		
		// 실험용으로 만들어 놓은 랭킹 객체
//		recodeVO.add(new RecodeVO(0, 0, "user1", 5000, 0, 0, 0, 0, 0, 0, ""));
//		recodeVO.add(new RecodeVO(0, 0, "user2", 4000, 0, 0, 0, 0, 0, 0, ""));
//		recodeVO.add(new RecodeVO(0, 0, "user3", 3000, 0, 0, 0, 0, 0, 0, ""));
//		recodeVO.add(new RecodeVO(0, 0, "user4", 2000, 0, 0, 0, 0, 0, 0, ""));
//		recodeVO.add(new RecodeVO(0, 0, "user5", 1000, 0, 0, 0, 0, 0, 0, ""));
		// DB로부터 받은 정보를 객체에 저장.
		if(recodeVO != null) this.recodeVO = recodeVO;
		
		
		btnLOBBY = new JButton("<      LOBBY");
		btnLOBBY.setBounds(12, 10, 230, 70);
		btnLOBBY.setForeground(Color.WHITE);
		btnLOBBY.setBorderPainted(false);
		btnLOBBY.setContentAreaFilled(false);
		btnLOBBY.setFocusPainted(false);
		btnLOBBY.setFont(new Font("Jokerman", Font.BOLD, 30));
		btnLOBBY.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnLOBBY.setForeground(Color.YELLOW);
				btnLOBBY.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {

				btnLOBBY.setForeground(Color.WHITE);
				btnLOBBY.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		add(btnLOBBY);
		
		String songNames[] = {"Happy Life","Chilling","Harmony"};
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(songNames);
		songList = new JComboBox<String>(model);
		songList.setSelectedIndex(0); // 기본은 0번 곡으로 설정
		songList.setBounds(403, 121, 193, 21);
		add(songList);
//		SongList.getSelectedIndex(); 콤보박스에서 선택된  인덱스 가져오기.
		
		String songDifficulty[] = {"Easy","Hard"};
		difficultyList = new JComboBox<>(songDifficulty);
		difficultyList.setSelectedIndex(0); // 기본은 Easy로 설정
		difficultyList.setBounds(608, 121, 118, 21);
		add(difficultyList);

		lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(Ranking.class.getResource("/images/rowLINE.png")));
		lblNewLabel.setBounds(100, 240, 600, 5);
		add(lblNewLabel);

		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon(Ranking.class.getResource("/images/rowLINE.png")));
		lblNewLabel_1.setBounds(100, 300, 600, 5);
		add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setIcon(new ImageIcon(Ranking.class.getResource("/images/rowLINE.png")));
		lblNewLabel_2.setBounds(100, 360, 600, 5);
		add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setIcon(new ImageIcon(Ranking.class.getResource("/images/rowLINE.png")));
		lblNewLabel_3.setBounds(100, 420, 600, 5);
		add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setIcon(new ImageIcon(Ranking.class.getResource("/images/rowLINE.png")));
		lblNewLabel_4.setBounds(100, 480, 600, 5);
		add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setIcon(new ImageIcon(Ranking.class.getResource("/images/rowLINE.png")));
		lblNewLabel_5.setBounds(100, 540, 600, 5);
		add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setIcon(new ImageIcon(Ranking.class.getResource("/images/columnLINE.png")));
		lblNewLabel_6.setBounds(311, 195, 5, 350);
		add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel();
		lblNewLabel_7.setIcon(new ImageIcon(Ranking.class.getResource("/images/columnLINE.png")));
		lblNewLabel_7.setBounds(435, 195, 5, 350);
		add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel();
		lblNewLabel_8.setIcon(new ImageIcon(Ranking.class.getResource("/images/columnLINE.png")));
		lblNewLabel_8.setBounds(534, 195, 5, 350);
		add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel();
		lblNewLabel_9.setIcon(new ImageIcon(Ranking.class.getResource("/images/columnLINE.png")));
		lblNewLabel_9.setBounds(641, 195, 5, 350);
		add(lblNewLabel_9);

		lblScore[0] = new JLabel("800000");
		lblScore[0].setForeground(new Color(204, 255, 51));
		lblScore[0].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblScore[0].setBounds(328, 255, 104, 40);
		add(lblScore[0]);

		lblScore[1] = new JLabel("800000");
		lblScore[1].setForeground(new Color(0, 255, 153));
		lblScore[1].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblScore[1].setBounds(328, 315, 104, 40);
		add(lblScore[1]);

		lblScore[2] = new JLabel("800000");
		lblScore[2].setForeground(new Color(204, 255, 51));
		lblScore[2].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblScore[2].setBounds(328, 375, 104, 40);
		add(lblScore[2]);

		lblScore[3] = new JLabel("800000");
		lblScore[3].setForeground(new Color(0, 255, 153));
		lblScore[3].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblScore[3].setBounds(328, 435, 104, 40);
		add(lblScore[3]);

		lblScore[4] = new JLabel("800000");
		lblScore[4].setForeground(new Color(204, 255, 51));
		lblScore[4].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblScore[4].setBounds(328, 495, 104, 40);
		add(lblScore[4]);

		lblName[0] = new JLabel("AAAAAAAAAAAA");
		lblName[0].setForeground(new Color(204, 255, 51));
		lblName[0].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblName[0].setBounds(100, 255, 209, 40);
		add(lblName[0]);

		lblName[1] = new JLabel("AAAAAAAAAAAA");
		lblName[1].setForeground(new Color(0, 255, 153));
		lblName[1].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblName[1].setBounds(100, 315, 209, 40);
		add(lblName[1]);

		lblName[2] = new JLabel("AAAAAAAAAAAA");
		lblName[2].setForeground(new Color(204, 255, 51));
		lblName[2].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblName[2].setBounds(100, 375, 209, 40);
		add(lblName[2]);

		lblName[3] = new JLabel("AAAAAAAAAAAA");
		lblName[3].setForeground(new Color(0, 255, 153));
		lblName[3].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblName[3].setBounds(100, 435, 209, 40);
		add(lblName[3]);

		lblName[4] = new JLabel("AAAAAAAAAAAA");
		lblName[4].setForeground(new Color(204, 255, 51));
		lblName[4].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblName[4].setBounds(100, 495, 209, 40);
		add(lblName[4]);

		lblGrade[0] = new JLabel("A");
		lblGrade[0].setForeground(new Color(204, 255, 51));
		lblGrade[0].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblGrade[0].setBounds(475, 255, 38, 40);
		add(lblGrade[0]);

		lblGrade[1] = new JLabel("A");
		lblGrade[1].setForeground(new Color(0, 255, 153));
		lblGrade[1].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblGrade[1].setBounds(475, 315, 38, 40);
		add(lblGrade[1]);

		lblGrade[2] = new JLabel("A");
		lblGrade[2].setForeground(new Color(204, 255, 51));
		lblGrade[2].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblGrade[2].setBounds(475, 375, 38, 40);
		add(lblGrade[2]);

		lblGrade[3] = new JLabel("A");
		lblGrade[3].setForeground(new Color(0, 255, 153));
		lblGrade[3].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblGrade[3].setBounds(475, 435, 38, 40);
		add(lblGrade[3]);

		lblGrade[4] = new JLabel("A");
		lblGrade[4].setForeground(new Color(204, 255, 51));
		lblGrade[4].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblGrade[4].setBounds(475, 495, 38, 40);
		add(lblGrade[4]);

		lblCombo[0] = new JLabel("000");
		lblCombo[0].setForeground(new Color(204, 255, 51));
		lblCombo[0].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblCombo[0].setBounds(566, 255, 63, 40);
		add(lblCombo[0]);

		lblCombo[1] = new JLabel("000");
		lblCombo[1].setForeground(new Color(0, 255, 153));
		lblCombo[1].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblCombo[1].setBounds(566, 315, 63, 40);
		add(lblCombo[1]);

		lblCombo[2] = new JLabel("000");
		lblCombo[2].setForeground(new Color(204, 255, 51));
		lblCombo[2].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblCombo[2].setBounds(566, 375, 63, 40);
		add(lblCombo[2]);

		lblCombo[3] = new JLabel("000");
		lblCombo[3].setForeground(new Color(0, 255, 153));
		lblCombo[3].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblCombo[3].setBounds(566, 435, 63, 40);
		add(lblCombo[3]);

		lblCombo[4] = new JLabel("000");
		lblCombo[4].setForeground(new Color(204, 255, 51));
		lblCombo[4].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblCombo[4].setBounds(566, 495, 63, 40);
		add(lblCombo[4]);

		lblRank[0] = new JLabel("1");
		lblRank[0].setForeground(new Color(204, 255, 51));
		lblRank[0].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblRank[0].setBounds(670, 255, 38, 40);
		add(lblRank[0]);

		lblRank[1] = new JLabel("2");
		lblRank[1].setForeground(new Color(0, 255, 153));
		lblRank[1].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblRank[1].setBounds(670, 315, 38, 40);
		add(lblRank[1]);

		lblRank[2] = new JLabel("3");
		lblRank[2].setForeground(new Color(204, 255, 51));
		lblRank[2].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblRank[2].setBounds(670, 375, 38, 40);
		add(lblRank[2]);

		lblRank[3] = new JLabel("4");
		lblRank[3].setForeground(new Color(0, 255, 153));
		lblRank[3].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblRank[3].setBounds(670, 435, 38, 40);
		add(lblRank[3]);

		lblRank[4] = new JLabel("5");
		lblRank[4].setForeground(new Color(204, 255, 51));
		lblRank[4].setFont(new Font("Jokerman", Font.BOLD, 20));
		lblRank[4].setBounds(670, 495, 38, 40);
		add(lblRank[4]);

		lblUserTitle = new JLabel("USER");
		lblUserTitle.setForeground(new Color(0, 255, 255));
		lblUserTitle.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblUserTitle.setBounds(176, 195, 66, 40);
		add(lblUserTitle);

		lblScoreTitle = new JLabel("SCORE");
		lblScoreTitle.setForeground(new Color(0, 255, 255));
		lblScoreTitle.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblScoreTitle.setBounds(336, 195, 87, 40);
		add(lblScoreTitle);

		lblGradeTitle = new JLabel("GRADE");
		lblGradeTitle.setForeground(new Color(0, 255, 255));
		lblGradeTitle.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblGradeTitle.setBounds(450, 195, 87, 40);
		add(lblGradeTitle);

		lblRankTitle = new JLabel("RANK");
		lblRankTitle.setForeground(new Color(0, 255, 255));
		lblRankTitle.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblRankTitle.setBounds(650, 195, 104, 40);
		add(lblRankTitle);

		lblComboTitle = new JLabel("COMBO");
		lblComboTitle.setForeground(new Color(0, 255, 255));
		lblComboTitle.setFont(new Font("Jokerman", Font.BOLD, 20));
		lblComboTitle.setBounds(550, 195, 104, 40);
		add(lblComboTitle);

		lblNewLabel_10 = new JLabel();
		lblNewLabel_10.setIcon(new ImageIcon(Ranking.class.getResource("/images/ezgif.com-resize.gif")));
		lblNewLabel_10.setBounds(0, 0, 800, 600);
		add(lblNewLabel_10);
		
		setRanking();
		// 콤보 상자 선택 이벤트
		songList.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				setRanking();
				
			}
		});
		
		difficultyList.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				setRanking();
				
			}
		});

		// 로비창으로 이동
		btnLOBBY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				lobby = new Lobby(contentPane);
				contentPane.add(lobby, BorderLayout.CENTER);
				lobby.setVisible(true);
				introMusic.close();

			}
		});
	}
	
	public void setRanking() {
		
		int index = 1; //songid 번호
		int i=0;
		if(difficultyList.getSelectedIndex() == 0) { // Easy 선택 시.
			index = songList.getSelectedIndex()*2 + 1;
		}else {										 // Hard 선택 시.
			index = songList.getSelectedIndex()*2 + 2;
		}
		// 값이 비어있을 경우에 대비해 기본값으로 초기화.
		for(int j=0;j<5;j++) {
			lblName[j].setText("user"+j);
			lblScore[j].setText("11111");
			lblGrade[j].setText("D");
			lblCombo[j].setText("9999");
		}
		
		for(RecodeVO vo : recodeVO) {
			if(i > 4) break;
			// 같은 곡에 대해서만 랭킹정보 입력
			if(vo.getSongid() == index) {
				lblName[i].setText(vo.getUserid());
				lblScore[i].setText(String.valueOf(vo.getScore()));
				lblGrade[i].setText(vo.getGrade());
				lblCombo[i].setText(String.valueOf(vo.getCombo()));
				i++;
			}
			
		}
		
		
	}

}
