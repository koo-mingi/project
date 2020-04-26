package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import domain.UserVO;

public class ClientThread extends Thread {

	private Socket socket;
	private DataInputStream dis;
	private ObjectInputStream ois;
	private DataOutputStream dos;
	private ObjectOutputStream oos;
	
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
	
	
	public void login(UserVO vo) {
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
	}
}
