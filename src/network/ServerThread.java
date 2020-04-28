package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;

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
		private int mode = 0; // 기본 상태
		private final int LOGIN = 1; // 로그인 모드.
		
		
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
					
					switch (mode) {
					case LOGIN:
						UserVO vo = new UserVO(1, "관리자", "1111", "나", "ㅁㅁ");
						name = vo.getUserId();
						dos.writeUTF("LOGINSUCCESS");
						oos.writeObject(vo);
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
