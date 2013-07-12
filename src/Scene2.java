import io.thp.psmove.PSMove;
import io.thp.psmove.psmoveapi;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import processing.core.*;

public class Scene2 extends Scene{

	int savedTime;
	int totalTime = 5000;

	int passedTime; 
	boolean firstRun = true;  
	
	int groupSize=0; 
	//PApplet p; 
	
	Scene2(PApplet p_) {
		super(p_);
		savedTime = p.millis();
		
		//p=p_; 
		// TODO Auto-generated constructor stub
	}

 public void update(PSMove mover, int i_){
	 	passedTime = p.millis() - savedTime;
	 	mlistinScene.set(i_, mover);
	 	groupSize = mlistinScene.size()/2; 
	 	//p.println("scene 2 updates");
	 	if(firstRun){
	 		while(passedTime < totalTime){
	 			passedTime = p.millis() - savedTime;
	 		 	//p.println(passedTime + " this much time has passed");
	 			setMoveColorstoWhite();     
	 		}
	 		
			firstRun = false; 
			resetTime(); 
		}
	 	
	 	if(oscCurrentMessage == "/red"){
	 	
	 		for(int i=0; i< groupSize; i++)
	 		{
	 				mlistinScene.get(i).set_leds(colors.get(0).r, colors.get(0).g,colors.get(0).b); 
		 			mlistinScene.get(i).update_leds();
	 		}
	 		for(int i = groupSize; i < mlistinScene.size()-1; i++)
	 		{
	 			mlistinScene.get(i).set_leds(255,255,255); 
	 			mlistinScene.get(i).update_leds();
	 		}
	 			
	 			mlistinScene.get(6).set_leds(colors.get(2).r, colors.get(2).g,colors.get(2).b); 
	 			mlistinScene.get(6).update_leds();
	 		
	 	}
	 	
	 	if(oscCurrentMessage == "/blue"){
	 	
	 			for(int i=groupSize; i< mlistinScene.size()-1; i++)
	 			{
	 				mlistinScene.get(i).set_leds(colors.get(3).r, colors.get(3).g,colors.get(3).b); 
		 			mlistinScene.get(i).update_leds();
	 			}
		 		for(int i = 0; i < groupSize; i++)
		 		{
		 			mlistinScene.get(i).set_leds(255,255,255); 
		 			mlistinScene.get(i).update_leds();
		 		}
		 		
	 			mlistinScene.get(6).set_leds(colors.get(2).r, colors.get(2).g,colors.get(2).b); 
	 			mlistinScene.get(6).update_leds();
	 	}
	 	
	 	if(oscCurrentMessage == "/winnerRed"){
	 		for(int i=0; i< mlistinScene.size(); i++)
	 		{
	 			mlistinScene.get(i).set_leds(colors.get(0).r, colors.get(0).g,colors.get(0).b); 
	 			mlistinScene.get(i).update_leds();
	 		}
 		
	 	}
	 	
	 	if(oscCurrentMessage == "/winnerBlue"){
	 		for(int i=0; i< mlistinScene.size(); i++)
	 		{
	 			mlistinScene.get(i).set_leds(colors.get(3).r, colors.get(3).g,colors.get(3).b); 
	 			mlistinScene.get(i).update_leds();
	 		}
	 	}
	} 

 public void display(){
	//p.println("scene 2 displays");
	} 
public void colorLoop(PSMove thisMove){}

public String getMessage(){
	 String myString = "/shakenMove"; 
	 return myString;
}
public int getNumber() {
	return 0; 
} 

public void resetTime () {
	savedTime = p.millis();
} 

}