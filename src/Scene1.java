import io.thp.psmove.PSMove;
import io.thp.psmove.psmoveapi;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import processing.core.*;

public class Scene1 extends Scene{



	//PApplet p; 

	int count = 0; 
	int savedTime;
	int totalTime = 5000;
	Timer whiteOut; 
	TimeMan_WhiteMoves twm;
	Timer colorLoop; 
	TimeMan_MoveChange tcl; 
	int passedTime; 
	Scene1(PApplet p_) {
		super(p_);
		whiteOut = new Timer(); 
		twm = new TimeMan_WhiteMoves("whiteMoves", this);
		whiteOut.schedule(twm,500,2000);
		savedTime = p.millis();
		tcl = new TimeMan_MoveChange("colorLoop", this);
		//p=p_; 
		// TODO Auto-generated constructor stub
	}

 public void update(){
	 	passedTime = p.millis() - savedTime;
	 	//p.println(passedTime);
		if(passedTime > totalTime){
		whiteOut.cancel(); 
		p.println("Turning one move loop");
		colorLoop();
		}
		
	}
 public void startColorLoop(){
	 colorLoop.schedule(tcl,10,2000);
 }
 public void colorLoop(){
	 //this handles the rest 
	 if(count != mlistinScene.size()){
	 colors.get(count); 
	 mlistinScene.get(count).set_leds(colors.get(count).r, colors.get(count).g, colors.get(count).b);
	 mlistinScene.get(count).update_leds();
	 mlistinScene.get(count).set_rumble(100);
	 }
} 
 public void display(){
	
	} 

 
}
