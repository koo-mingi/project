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
					}else if(dis.readUTF().equals("LOGINFAIL")){
						
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
	
	// 개인유저의 기록 가져오기
	public ArrayList<RecodeVO> getUserRecord(UserVO vo){
		if(dos!=null)
			try {
				dos.writeUTF("GETUSERRECORD");
				oos.writeObject(vo);
				while(dis!=null) {
					if(dis.readUTF().equals("GETUSERRECORDSUCCESS")) {
						System.out.println("개인 기록 획득 성공");
						recodeVO = (ArrayList<RecodeVO>) ois.readObject();
						System.out.println(recodeVO);
						break;
					}else if(dis.readUTF().equals("GETUSERRECORDFAIL")){
						
						break;
					}
				}
							
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return recodeVO;
	}
	
	public UserVO createUser(UserVO vo) {
		UserVO uservo = null;
		if(dos!=null)
			try {
				dos.writeUTF("CREATUSER");
				oos.writeObject(vo);
				while(dis!=null) {
					if(dis.readUTF().equals("CREATUSERSUCCESS")) {
						uservo = (UserVO)ois.readObject();
						System.out.println("유저 생성 성공");
						break;
					}else if(dis.readUTF().equals("CREATUSERFAIL")){
						System.out.println("유저 생성 실패");
					}
				}
							
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return uservo;
	}
	
	// 새로운 개인 유저 기록을 DB에 쓰기
	public void setUserRecord(ArrayList<RecodeVO> recordList) {
		if(dos!=null) {
			try {
				dos.writeUTF("SETUSERRECORD");
				oos.writeObject(recordList);
				while(dis!=null) {
					System.out.println("기록 DB에 보냄");
					if(dis.readUTF().equals("SETUSERRECORDSUCCESS")){
						System.out.println("기록 DB 저장 성공");
						
						break;
					}else if(dis.readUTF().equals("SETUSERRECORDFAIL"))
					{
						System.out.println("기록 DB 저장 실패");
						break;
					}
				}
			} catch (IOException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	// 기존 유저의 기록을 업데이트
	public void updateUserRecord(RecodeVO recordVO) {
		if(dos!=null) {
			try {
				dos.writeUTF("UPDATEUSERRECORD");
				oos.writeObject(recordVO);
				while(dis!=null) {
					System.out.println("update 기록 DB에 보냄");
					if(dis.readUTF().equals("UPDATEUSERRECORDSUCCESS")){
						System.out.println("update 기록 DB 저장 성공");
						
						break;
					}else if(dis.readUTF().equals("UPDATEUSERRECORDFAIL"))
					{
						System.out.println("update 기록 DB 저장 실패");
						break;
					}
				}
			} catch (IOException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	// 전체 유저의 기록을 DB로부터 받기
	@SuppressWarnings("unchecked")
	public ArrayList<RecodeVO> getAllRankingInfo() {
		System.out.println("랭킹 요청");
		if(dos!=null) {
			try {
				dos.writeUTF("RANKING");
				System.out.println("랭킹 문자 보냄");
				while(dis!=null) {
					if(dis.readUTF().equals("RANKINGSUCCESS")){
						System.out.println("랭킹 조회 성공");
						recodeVO = (ArrayList<RecodeVO>) ois.readObject();
						System.out.println("랭킹 조회:"+recodeVO);
						break;
					}else if(dis.readUTF().equals("RANKINGFAIL"))
					{
						System.out.println("랭킹 조회 실패");
						break;
					}
				}
			} catch (IOException  | ClassNotFoundException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return recodeVO;
	}
	
}
