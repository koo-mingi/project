package beat;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import domain.RecodeVO;
import network.ClientThread;


public class Main {
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;
	public static int NOTE_SPEED = 6;		//노트 떨어지는 속도 조절
	public static final int SLEEP_TIME = 10;
	public static final int REACH_TIME = 2;
	public static ArrayList<RecodeVO> MYRECODE= new ArrayList<RecodeVO>(); // 개인 기록 저장
	public static File file;
	public static ClientThread client;
	public static boolean serverConnection = false;
	public static void main(String[] args) {
	
		MYRECODE.add(new RecodeVO(0, 1, "", 0, 0, 0, 0, 0, 0, 0, "Grade")); //1번 노래 easy
		MYRECODE.add(new RecodeVO(0, 2, "", 0, 0, 0, 0, 0, 0, 0, "Grade")); //1번 노래 hard
		MYRECODE.add(new RecodeVO(0, 3, "", 0, 0, 0, 0, 0, 0, 0, "Grade")); //2번 노래 easy
		MYRECODE.add(new RecodeVO(0, 4, "", 0, 0, 0, 0, 0, 0, 0, "Grade")); //2번 노래 hard
		MYRECODE.add(new RecodeVO(0, 5, "", 0, 0, 0, 0, 0, 0, 0, "Grade")); //3번 노래 easy
		MYRECODE.add(new RecodeVO(0, 6, "", 0, 0, 0, 0, 0, 0, 0, "Grade")); //3번 노래 hard
		
		// 저장된 내용을 읽어 오기
		file =  new File("myrecode.ser");
		
				
		// 파일이 없으면 파일 생성
		if(!file.exists())
		{
			try {
				file.createNewFile();
				try (FileOutputStream fos= new FileOutputStream(file.getPath());
						ObjectOutputStream oos = new ObjectOutputStream(fos)){
						
						for(int i =0 ; i<MYRECODE.size();i++) {
							oos.writeObject(MYRECODE.get(i));
						}
						
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
			
		}
		try(

			FileInputStream fis = new FileInputStream(file.getPath());
			ObjectInputStream ois = new ObjectInputStream(fis)){
						
			for(int i =0 ; i<MYRECODE.size();i++) {
				MYRECODE.set(i, (RecodeVO) ois.readObject()); //readObject()를 호출하면 그 스트림의 다음 객체를 받아올 수 있다. 
				System.out.println(MYRECODE.get(i));
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		// 네트워크 연결
		//String ServerIp = "127.0.0.1";
		String ServerIp = "192.168.0.4";
		try {
			System.out.println("서버에 접속 요청 중...");
			Socket socket = new Socket(ServerIp, 7777);
			System.out.println("서버 접속..");
			serverConnection = true;
			client = new ClientThread(socket);
			client.start();
			
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("서버연결에 실패했습니다. 연결없이 실행합니다.");
			JOptionPane.showMessageDialog(null, "서버 연결에 실패했습니다. 연결없이 실행합니다");
		}finally {
			//client.interrupt();
		}
		
		 new MainFrame();
		 
		
	}
	
	

}
