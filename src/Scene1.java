import io.thp.psmove.PSMove;
import io.thp.psmove.psmoveapi;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.stream.events.StartDocument;

import processing.core.*;

public class Scene1 extends Scene implements Observer{

	int count = 0; 
	int savedTime;
	int totalTime = 5000;
	Timer whiteOut; 
	Timer whiteRed; 
	public Observable ob;
	
	Scene1(PApplet p_, Observable ob_) {
		super(p_);
		this.ob = ob_; 
		ob.addObserver(this);
		whiteOut = new Timer(); 
		whiteOut.schedule(new TimerManager("alpha", this),1000);
		whiteRed.schedule(new TimerManager("whiteRed",this), 1000,500);
		
		//p=p_; 
		// TODO Auto-generated constructor stub
	}


	
public void updateScene(){
			
			p.println("scene 1 updates");
	 		
	 		//setMoveColorstoWhite(); 
	 		
//	 		colors.get(count); 
//	 		mlistinScene.get(count).set_leds(colors.get(count).r, colors.get(count).g, colors.get(count).b);
//	 		mlistinScene.get(count).update_leds();
//	 		sceneMto.shaken(mlistinScene.get(count));
	 	
	}
	
// public eventForRumble(){
//	start a Timer that will increment cout 
// } 
//	
 public void display(){
	 p.println("scene 1 displays");
	}




@Override
public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	p.println("red move shaken");
} 

}
