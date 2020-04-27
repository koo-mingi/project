package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import domain.RecodeVO;
import domain.UserVO;

public class ServerThread extends Thread {
	// 접속중인 클라이언트 정보 담기
	private HashMap<String, DataOutputStream> clients;
	// key밸류 형태로 값을 저장해서 중복값을 비교.
	
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	
	public ServerThread() {
		clients = new HashMap<String, DataOutputStream>();
		// 누군가가 접속하면 다른사람이 접근하지 못하게 동기화.
		Collections.synchronizedMap(clients);
	}
	
	@Override
	public void run() {
		
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작..");
			
			while(true) {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress()+"가 접속");
				
				// 스레드 생성
				ServerReceiver sReceiver = new ServerReceiver(socket);
				sReceiver.start();
			}
		} catch (IOException e) {
			 e.printStackTrace();
		}
	}
	
	class ServerReceiver extends Thread{
		private Socket socket;
		private DataOutputStream dos;
		private DataInputStream dis;
		private ObjectOutputStream oos;
		private ObjectInputStream ois;
		private UserVO vo;
		private ArrayList<RecodeVO> recodeVO;
		private int mode = 0; // 기본 상태
		private final int LOGIN = 1; // 로그인 모드.
		private final int USERRECORD = 2; //개인 유저 정보 모드
		private final int CREATUSER = 3; // 유저 생성 모드
		private final int RANKING = 4; // 랭킹 조회 모드
		
		
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			
			try {
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				oos = new ObjectOutputStream(socket.getOutputStream());
				ois = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		@Override
		public void run() {
			String name = "";
			
			name = socket.getInetAddress() +"]";
			clients.put(name, dos);
			System.out.println("접속자 수 : "+clients.size());
			
			 
			try {
				while(true) {
					String modeStr = dis.readUTF();
					System.out.println("받은 문자"+modeStr);
					if(modeStr.equals("LOGIN")) mode = LOGIN;
					else if(modeStr.equals("USERRECORD")) mode = USERRECORD;
					else if(modeStr.equals("CREATUSER")) mode = CREATUSER;
					else if(modeStr.equals("RANKING")) mode = RANKING;
					switch (mode) {
					case LOGIN:
						vo = new UserVO(1, "관리자", "1111", "나", "ㅁㅁ");
						name = vo.getUserId();
						dos.writeUTF("LOGINSUCCESS");
						oos.writeObject(vo);
						break;
					case USERRECORD:
						
						dos.writeUTF("USERRECORDSUCCESS");
						oos.writeObject(recodeVO);
						System.out.println("성공");
						break;
					case CREATUSER:
						vo = new UserVO();
						try {
							vo = (UserVO)ois.readObject();
							System.out.println(vo);
							if("성공"=="성공") {
								dos.writeUTF("CREATUSERSUCCESS");
							}else {
								dos.writeUTF("CREATUSERFAIL");
							}
							
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						break;
					case RANKING:
						recodeVO = new ArrayList<RecodeVO>();
						recodeVO.add(new RecodeVO());
						if(true) {
							dos.writeUTF("RANKINGSUCCESS");
							oos.writeObject(recodeVO);
						}else
							dos.writeUTF("RANKINGFAIL");
						
						break;
					default:
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				clients.remove(name);
				System.out.println(name + " 접속 종료");
			}
			
		}
	}
	
}
