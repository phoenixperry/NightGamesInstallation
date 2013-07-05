
import java.util.Timer;
import java.util.TimerTask;
public class TimerManager extends TimerTask{
	Timer timer1; 
	Timer timer2; 
	String strObj; 
	//to create a timer task a class must extend TimerTask 
	//these can be run on intervals. 
	public TimerManager(String strObj, Scene currentScene) {
		// TODO Auto-generated constructor stub
		this.strObj = strObj; 
	}

public void run() {
	System.out.println("inside run task" + strObj); 
	//put tests to see if strings are whatever function 
	//then run the little bastards 
	
}

}