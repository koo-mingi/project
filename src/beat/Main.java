package beat;

import java.util.ArrayList;

import domain.RecodeVO;

public class Main {
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;

	public static int NOTE_SPEED = 5;		//노트 떨어지는 속도 조절
	public static final int SLEEP_TIME = 10;
	public static final int REACH_TIME = 2;
	public static ArrayList<RecodeVO> MYRECODE= new ArrayList<RecodeVO>(); // 개인 기록 저장
	public static void main(String[] args) {
		 
				
		 new MainFrame();	
	}

}
