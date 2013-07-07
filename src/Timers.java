
import java.util.Timer;
import java.util.TimerTask;


public class Timers {
	Timer timer1; 
	Timer timer2;
	Scene currentScene; 
	public Timers(int t1,Scene currentScene_) {
		timer1 = new Timer(); 
		currentScene = currentScene_; 
		
		//note this this thing to do, time to wait to start, interval for doing it
		timer1.schedule(new TimeMan_WhiteMoves("alpha", currentScene_), 2*60*1000); 
	//	timer2.schedule(new TimeMan_WhiteMoves("delta"), t1*1000, t1*1000); 
		
	}
}
