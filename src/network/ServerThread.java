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
import ui.MainTest;

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
		private ArrayList<RecodeVO> recordList;
		private int mode = 0; // 기본 상태
		private final int LOGIN = 1; // 로그인 모드.
		private final int GETUSERRECORD = 2; //개인 유저 기록 획득 모드
		private final int CREATUSER = 3; // 유저 생성 모드
		private final int RANKING = 4; // 랭킹 조회 모드
		private final int SETUSERRECORD = 5; // 새로운 개인 유저 기록 DB에 저장 모드.
		private final int UPDATEUSERRECORD = 6; // 기존 개인 유저의 기록을 DB에 저장.
		private MainTest service = new MainTest();
		
		
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
					else if(modeStr.equals("GETUSERRECORD")) mode = GETUSERRECORD;
					else if(modeStr.equals("CREATUSER")) mode = CREATUSER;
					else if(modeStr.equals("RANKING")) mode = RANKING;
					else if(modeStr.equals("SETUSERRECORD")) mode = SETUSERRECORD;
					else if(modeStr.equals("UPDATEUSERRECORD")) mode = UPDATEUSERRECORD;
					switch (mode) {
					case LOGIN:
						try {
							vo = (UserVO) ois.readObject();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						name = vo.getUserId();
						
						// DB 연동 시 사용가능.
//----------------------------------------------------------------------------------------------------------------
						if(service.loginCheck(vo.getUserId(), vo.getPassword()) == true) {
							vo = service.getUserinfo(vo.getUserId());
							dos.writeUTF("LOGINSUCCESS");
							oos.writeObject(vo);
						}else {
							dos.writeUTF("LOGINFAIL");
							
						}
//----------------------------------------------------------------------------------------------------------------
//						dos.writeUTF("LOGINSUCCESS");
//						oos.writeObject(vo);
//						
						break;
					case GETUSERRECORD:
						
						
						//DB 연동 시 사용.
//----------------------------------------------------------------------------------------------------------------
						try {
							vo = (UserVO)ois.readObject();
							recordList=new ArrayList<RecodeVO>();
							recordList = service.getUserRecord(vo.getUserNo());
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						}
//----------------------------------------------------------------------------------------------------------------						
						// DB 연동 안할 떄 사용.
						
//						try {
//							vo = (UserVO)ois.readObject();
//							//recordList.add(new RecodeVO(vo.getUserNo(), 0, vo.getUserId(), 111, 11, 11, 11, 11, 11, 11, "D"));
//						} catch (ClassNotFoundException e1) {
//							e1.printStackTrace();
//						}
//						
						
						if(!recordList.isEmpty()) {
							dos.writeUTF("GETUSERRECORDSUCCESS");
							oos.writeObject(recordList);
							System.out.println("개인 기록 조회 성공");
						}else {
							dos.writeUTF("GETUSERRECORDFAIL");
							System.out.println("개인 기록 조회 실패");
						}
						//recordList.removeAll(recordList);
						System.out.println(recordList);
						break;
					case CREATUSER:
						vo = new UserVO();
						try {
							vo = (UserVO)ois.readObject();
							System.out.println(vo);
							
							//DB 연동되었을 떄.
//----------------------------------------------------------------------------------------------------------------
							if(service.isUser(vo)) { // 유저가 있으면
								dos.writeUTF("USEREXIST");
							}else {					 // 유저가 없으면
								vo = service.signup(vo);
								if(vo != null) {// DB에 입력을 성공했으면
								
									dos.writeUTF("CREATUSERSUCCESS");
									oos.writeObject(vo);
								}else {
									dos.writeUTF("CREATUSERFAIL");
								}
							}
//----------------------------------------------------------------------------------------------------------------			
							// DB 연동 안되었을 떄.
//							if("성공"=="성공") {
//								dos.writeUTF("CREATUSERSUCCESS");
//								oos.writeObject(vo);
//							}else {
//								dos.writeUTF("CREATUSERFAIL");
//							}
							
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						break;
					case RANKING:
						// DB 연동 되었을 때
//----------------------------------------------------------------------------------------------------------------	
						recordList=new ArrayList<RecodeVO>();
						recordList = service.getAllUserRecord();
						System.out.println("DB 랭킹 확인용");
						for(RecodeVO vo :recordList) {
							System.out.println(vo);
						}
						
						if(!recordList.isEmpty()) {
							dos.writeUTF("RANKINGSUCCESS");
							oos.writeObject(recordList);
						}else {
							dos.writeUTF("RANKINGFAIL");
						}
//----------------------------------------------------------------------------------------------------------------	
						
						// DB 연동 안되었을 때
//						recordList.add(new RecodeVO());
//						for(RecodeVO vo : recordList) {
//							System.out.println(vo);
//						}
//						if(true) {
//							dos.writeUTF("RANKINGSUCCESS");
//							oos.writeObject(recordList);
//						}else
//							dos.writeUTF("RANKINGFAIL");
						
						break;
					case SETUSERRECORD:
						recordList=new ArrayList<RecodeVO>();
						recordList = (ArrayList<RecodeVO>)ois.readObject();
						// DB가 켜져있을 시 가능
//----------------------------------------------------------------------------------------------------------------
						if(service.setUserRecord(recordList)==true) {
							dos.writeUTF("SETUSERRECORDSUCCESS");
						}else {
							dos.writeUTF("SETUSERRECORDFAIL");
						}
//----------------------------------------------------------------------------------------------------------------
//						if(true) {
//							dos.writeUTF("SETUSERRECORDSUCCESS");
//							System.out.println(recordList);
//						}else {
//							dos.writeUTF("SETUSERRECORDFAIL");
//						}
						//recordList.removeAll(recordList);
						break;
					case UPDATEUSERRECORD:
						
						RecodeVO recordVO = new RecodeVO();
						recordVO =(RecodeVO)ois.readObject();
						System.out.println("업데이트 기록 확인용:");
						System.out.println(vo);
						System.out.println(recordVO);

						// DB가 켜져있을 시 가능
//----------------------------------------------------------------------------------------------------------------
						if(service.updateUserRecord(recordVO))
						{
							dos.writeUTF("UPDATEUSERRECORDSUCCESS");
						}else {
							dos.writeUTF("UPDATEUSERRECORDFAIL");
						}
					
//----------------------------------------------------------------------------------------------------------------
//						if(true){
//							System.out.println(recordVO);
//							dos.writeUTF("UPDATEUSERRECORDSUCCESS");
//						}else {
//							dos.writeUTF("UPDATEUSERRECORDFAIL");
//						}
						
						break;
					default:
						break;
					}
				}
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				clients.remove(name);
				System.out.println(name + " 접속 종료");
			}
			
		}
	}
	
}
