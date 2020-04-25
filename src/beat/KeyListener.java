package beat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	boolean pressedS, pressedD, pressedF, pressedJ, pressedK, pressedL = false;

	@Override
	public void keyPressed(KeyEvent e) {
		if(GamePlay.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S && !pressedS) {
			GamePlay.game.pressS();
			pressedS = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_D && !pressedD) {
			GamePlay.game.pressD();
			pressedD = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_F && !pressedF) {
			GamePlay.game.pressF();
			pressedF = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_J && !pressedJ) {
			GamePlay.game.pressJ();
			pressedJ = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_K && !pressedK) {
			GamePlay.game.pressK();
			pressedK = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_L && !pressedL) {
			GamePlay.game.pressL();
			pressedL = true;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(GamePlay.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			GamePlay.game.releaseS();
			pressedS = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			GamePlay.game.releaseD();
			pressedD = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			GamePlay.game.releaseF();
			pressedF = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			GamePlay.game.releaseJ();
			pressedJ = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			GamePlay.game.releaseK();
			pressedK = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			GamePlay.game.releaseL();
			pressedL = false;
		}
		
	}
}
