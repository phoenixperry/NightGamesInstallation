
import java.util.Timer;
import java.util.TimerTask;
public class TimeMan_WhiteMoves extends TimerTask{
	Timer timer1; 
	Timer timer2; 
	String strObj; 
	private Scene currentScene; 
	//to create a timer task a class must extend TimerTask 
	//these can be run on intervals. 
	public TimeMan_WhiteMoves(String strObj, Scene currentScene_) {
		// TODO Auto-generated constructor stub
		this.strObj = strObj; 
		currentScene = currentScene_;
		
	}
	

public void run() {
	System.out.println("inside run task" + strObj); 
	currentScene.setMoveColorstoWhite();
	//put tests to see if strings are whatever function 
	//then run the little bastards 
	
}

}