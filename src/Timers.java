
import java.util.Timer;
import java.util.TimerTask;


public class Timers {
	Timer timer1; 
	Timer timer2;
	
	public Timers(int t1, int t2) {
		timer1 = new Timer(); 
		timer2 = new Timer();
		//note this this thing to do, time to wait to start, interval for doing it
		//timer1.schedule(new TimerManager("alpha"), t1*1000, t1*1000); 
		//timer2.schedule(new TimerManager("delta"), t1*1000, t1*1000); 
		
	}
}
