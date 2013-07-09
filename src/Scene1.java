import io.thp.psmove.PSMove;
import io.thp.psmove.psmoveapi;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.ws.soap.MTOM;

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
	ArrayList<PSMove> movesInPlay = new ArrayList<PSMove>(); 
	
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
	
//this will restart the simple counter 
public void resetTime () {
	savedTime = p.millis();
} 
 public void update(){
	 	passedTime = p.millis() - savedTime;
	 	//p.println(passedTime);
		if(passedTime > totalTime){
			whiteOut.cancel(); 
			p.println("Turning one move loop");
			resetTime();
			colorLoop(); 
		}
		updateInPlayMoves();	
	}

 public void colorLoop(){
	 //this handles the rest 
	 //this loop runs every two seconds. 
	 
	 while(count != mlistinScene.size()){
		//get the top move in the 1st array  
		colors.get(count); 
		mlistinScene.get(count).set_leds(colors.get(count).r, colors.get(count).g, colors.get(count).b);
	 	mlistinScene.get(count).update_leds();
	 	mlistinScene.get(count).set_rumble(100);
		 
	 	passedTime = p.millis() - savedTime;
	 	int checkifMoved  = mto.shaken(mlistinScene.get(count));
	 	if(passedTime > totalTime && checkifMoved > 0 ){
	 		movesInPlay.add(mlistinScene.get(count));
	 		mlistinScene.remove(count);
	 		resetTime(); 
	 		count++; 
	 	} 
	 	
	//checkifMoved > 0 -- how to tell if a move has moved - if it has moved it greater than 0 
	 
	 }
	 //what you need is something that checks if a move has been shaken and if it has passed a duration of time for 
	 //solo. if both those things have happened move on to the next move but also keep updating that move 
	 //this is going to call for a subarray of moves that know they've already been triggered. 
	 //you then need to loop through that array. note mto is dumb and only knows which move it's got if you pass it in
} 
 public void updateInPlayMoves() {
	 //updates moves currently in play 
	 for(int i = 0; i < movesInPlay.size(); i++){
		 colors.get(i); 
		 movesInPlay.get(i).set_leds(colors.get(i).r, colors.get(i).g, colors.get(i).b);
		 movesInPlay.get(i).update_leds();
	 }
	 
	 
 } 
 public void display(){
	
	} 

 
}
