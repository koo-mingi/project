package beat;

public class GameFinishThread extends Thread {
	
	@Override
	public void run() {
		long start = System.currentTimeMillis();
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public boolean state() {
		boolean result = false;
		if(this.getState() == this.getState().TERMINATED) result = true;
		
		return result;
	}
}
