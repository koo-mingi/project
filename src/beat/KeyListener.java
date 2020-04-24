package beat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) {
		if(GamePlay.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			GamePlay.game.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			GamePlay.game.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			GamePlay.game.pressF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			GamePlay.game.pressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			GamePlay.game.pressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			GamePlay.game.pressL();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(GamePlay.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			GamePlay.game.releaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			GamePlay.game.releaseD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			GamePlay.game.releaseF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			GamePlay.game.releaseJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			GamePlay.game.releaseK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			GamePlay.game.releaseL();
		}
		
	}
}
