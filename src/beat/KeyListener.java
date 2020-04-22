package beat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) {
		if(SelectSong.gameplay == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			SelectSong.gameplay.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			SelectSong.gameplay.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			SelectSong.gameplay.pressF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			SelectSong.gameplay.pressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			SelectSong.gameplay.pressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			SelectSong.gameplay.pressL();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(SelectSong.gameplay == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			SelectSong.gameplay.releaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			SelectSong.gameplay.releaseD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			SelectSong.gameplay.releaseF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			SelectSong.gameplay.releaseJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			SelectSong.gameplay.releaseK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			SelectSong.gameplay.releaseL();
		}
		
	}
}
