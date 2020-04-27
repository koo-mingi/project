package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import domain.RecodeVO;
import domain.UserVO;

public class ClientThread extends Thread {

	private Socket socket;
	private DataInputStream dis;
	private ObjectInputStream ois;
	private DataOutputStream dos;
	private ObjectOutputStream oos;
	ArrayList<RecodeVO> recodeVO = new ArrayList<RecodeVO>();
	
	public ClientThread(Socket socket) {
		this.socket = socket;
		try {
			dis = new DataInputStream(socket.getInputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		System.out.println("열림");
		while(socket.isConnected()) {
		
		}
		// 서버가 종료 시, 연결이 끊겼는지 확인할려고 했으나 안됨.
		
	}
	public boolean state() {
		if(this.getState() == this.getState().TERMINATED)
			return true;
		return false;
	}
	
	

	public UserVO login(UserVO vo) {
		if(dos!=null)
			try {
				dos.writeUTF("LOGIN");
				oos.writeObject(vo);
				while(dis!=null) {
					if(dis.readUTF().equals("LOGINSUCCESS")) {
						vo = (UserVO) ois.readObject();
						System.out.println(vo);
						break;
					}
				}
							
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return vo;
	}
	
	
	public ArrayList<RecodeVO> userRecord(){
		if(dos!=null)
			try {
				while(dis!=null) {
					dos.writeUTF("USERRECORD");
					if(dis.readUTF().equals("USERRECORDSUCCESS")) {
						System.out.println("성공");
						recodeVO = (ArrayList<RecodeVO>) ois.readObject();
						System.out.println(recodeVO);
						break;
					}
				}
							
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return recodeVO;
	}
	
	public boolean createUser(UserVO vo) {
		if(dos!=null)
			try {
				dos.writeUTF("CREATUSER");
				oos.writeObject(vo);
				while(dis!=null) {
					if(dis.readUTF().equals("CREATUSERSUCCESS")) {
						System.out.println("유저 생성 성공");
						return true;
					}else if(dis.readUTF().equals("CREATUSERFAIL")){
						return false;
					}
				}
							
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<RecodeVO> rankingInfo() {
		System.out.println("랭킹 요청");
		if(dos!=null) {
			try {
				dos.writeUTF("RANKING");
				System.out.println("랭킹 문자 보냄");
				while(dis!=null) {
					System.out.println("랭킹 문자 보냄");
					if(dis.readUTF().equals("RANKINGSUCCESS")){
						System.out.println("랭킹 조회 성공");
						//recodeVO = (ArrayList<RecodeVO>) ois.readObject();
						break;
					}else if(dis.readUTF().equals("RANKINGFAIL"))
					{
						System.out.println("랭킹 조회 실패");
						break;
					}
				}
			} catch (IOException /* | ClassNotFoundException */ e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return recodeVO;
	}
	
}
