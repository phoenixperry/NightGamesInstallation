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
	int totalTime = 1000;
//	Timer whiteOut; 
//	TimeMan_WhiteMoves twm;
//	Timer colorLoop; 
//	TimeMan_MoveChange tcl; 
	int passedTime; 
	int passedTime2; 
	ArrayList<PSMove> movesInPlay = new ArrayList<PSMove>(); 
	boolean firstRun = true; 
	private int whileShaken = 0; 
	private float[] gx = { 0.f };
	private float[] gy = { 0.f };
	private float[] gz = { 0.f };	
	
	Scene1(PApplet p_) {
		super(p_);

		savedTime = p.millis();
	
	}
	
//this will restart the simple counter 
public void resetTime () {
	savedTime = p.millis();
} 
 public void update(){
	 	passedTime = p.millis() - savedTime;
	 	//p.println(passedTime + " this much time has passed");
	 	if(firstRun){
	 		while(passedTime < totalTime){
	 			passedTime = p.millis() - savedTime;
	 		 	p.println(passedTime + " this much time has passed");
	 			setMoveColorstoWhite(); 
	 		}
	 		
	 		//p.println("inside FIRST RUN");
	
			firstRun = false; 
		}
		if (!firstRun){
			//p.println("inside second RUN");
			colorLoop(); 
			updateInPlayMoves();
		}
			
	}

 public void colorLoop(){
	
	 //this handles the rest 
	 //this loop runs every two seconds. 
	 
	 while(count < mlistinScene.size()){
		//p.println("inside color RUN");
		//get the top move in the 1st array  
		//p.println("inside the move " + count);
		colors.get(count); 
		mlistinScene.get(count).set_leds(colors.get(count).r, colors.get(count).g, colors.get(count).b);
	 	mlistinScene.get(count).update_leds();
	 	mlistinScene.get(count).set_rumble(100);
		 
	 	passedTime2 = p.millis() - savedTime;
	
	 	int checkifMoved  = shaken(mlistinScene.get(count));
	 	
		//p.println("checking if it moved " + checkifMoved);
		
	 	if(passedTime2 > totalTime && checkifMoved > 0 ){
			//p.println("moveing moves to the second array " + movesInPlay.size());
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
	public int shaken(PSMove currentMove){
		currentMove.get_gyroscope_frame(io.thp.psmove.Frame.Frame_SecondHalf, gx, gy,
				gz);
		
		float yt = gy[0];
		//p.println(yt);
		
		if(yt > 1.3){
			whileShaken +=yt;
		}	
		else {
			whileShaken = 0; 
		} 
		return whileShaken; 
	}

 public void display(){
	
	} 

 
}
