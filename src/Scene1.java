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

public class Scene1 extends Scene {

	//implements Observer
	int count = 0; 
	int savedTime;
	int totalTime = 5000;
	Timer whiteOut; 
	Timer colorFlip; 
	public Observable ob;
	
	Scene1(PApplet p_) {
		// Observable ob_
		super(p_);
		//this.ob = ob_; 
		//ob.addObserver(this);
		whiteOut = new Timer(); 
		savedTime = p.millis();
	
		
		//p=p_; 
		// TODO Auto-generated constructor stub
	}


	
public void updateScene(){
//		p.println("scene 1 updates");
//		whiteOut.schedule(new TimeMan_WhiteMoves("whiteMoves", this),0,500);
//		int currentTime = savedTime - totalTime;
//		
//		if(currentTime>=0 && currentTime >-1){
//			whiteOut.cancel(); 
//			p.println("Turning one move loop");
//			display();
//		}	

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
	 //this accounts for the first red move 
//	 colors.get(count); 
//	 if(count != mlistinScene.size()){
//	 	mlistinScene.get(count).set_leds(colors.get(count).r, colors.get(count).g, colors.get(count).b);
//	 	mlistinScene.get(count).update_leds();
//	 	sceneMto.shaken(mlistinScene.get(count));
//	 }
	}


//
 public void colorLoop(){
//	 //this handles the rest 
//	 if(count != mlistinScene.size()){
//	 colors.get(count); 
//	 mlistinScene.get(count).set_leds(colors.get(count).r, colors.get(count).g, colors.get(count).b);
//	 mlistinScene.get(count).update_leds();
//	 }
//} 
//
//	public void update(Observable o, Object arg) {
//		
//		colorFlip.schedule(new TimeMan_MoveChange("colorLoop",this), (long)5000,(long)500.);
//		// TODO Auto-generated method stub
//		p.println("red move shaken");
	} 

}