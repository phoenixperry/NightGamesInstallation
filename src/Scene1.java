 import io.thp.psmove.PSMove;


import java.util.ArrayList;


import processing.core.*;

public class Scene1 extends Scene{



	//PApplet p; 

	int count = 0; 
	int savedTime;
	int totalTime = 5000;

	int passedTime; 
	int passedTime2; 
	ArrayList<PSMove> movesInPlay = new ArrayList<PSMove>(); 
	boolean firstRun = true; 

	boolean shaken = false; 
	boolean colorLoopComplete = false;
	private int shakenMove = 0; 
	
	int[ ] beenShaken = {0,0,0,0,0,0,0};
	
	Scene1(PApplet p_) {
		super(p_);

		savedTime = p.millis();
	
	}
	
//this will restart the simple counter 
public void resetTime () {
	savedTime = p.millis();
} 
 public void update(PSMove mover, int i_){
	 	passedTime = p.millis() - savedTime;
	 	//keep our moves up to date 
	 	mlistinScene.set(i_, mover);
	 	
	 	//p.println(passedTime + " this much time has passed");
	 	if(firstRun){
	 		while(passedTime < totalTime){
	 			passedTime = p.millis() - savedTime;
	 		 	//p.println(passedTime + " this much time has passed");
	 			setMoveColorstoWhite();     
	 		}
	 		
			firstRun = false; 
			resetTime(); 
		}
		if (!firstRun){
			//p.println("inside second RUN");
			colorLoop(mover); 
			
		}
		if(colorLoopComplete){
			for(int i =0; i< mlistinScene.size(); i++){
				PSMove move = mlistinScene.get(i);
					mto.setLedColor(i, move, colors.get(i).r, colors.get(i).g, colors.get(i).b);
			} 
		}			
	}

 public void colorLoop(PSMove thisMove){
		if(count > mlistinScene.size()-1){
			colorLoopComplete = true; 
 		}
		
		else{
 			
 		passedTime2 = p.millis() - savedTime;
		
		//set the move at count to a color
	 	mlistinScene.get(count).set_leds(colors.get(count).r, colors.get(count).g, colors.get(count).b);
	 	mlistinScene.get(count).update_leds();
	 	mlistinScene.get(count).set_rumble(100);
		
		
	 	//set all other moves to while 
		for(int j =count+1; j<mlistinScene.size(); j++){
	 			mlistinScene.get(j).set_leds(255,255,255);
	 		 	mlistinScene.get(j).update_leds();
	 		 	mlistinScene.get(j).set_rumble(0);
	 	} 
		
		//update more than just the tip
		for(int k =0; k<count; k++){
 			mlistinScene.get(k).set_leds(colors.get(k).r,colors.get(k).g,colors.get(k).b);
 		 	mlistinScene.get(k).update_leds();
		} 
 	
		if(passedTime2 < totalTime){
			
		 	boolean shaken = mto.shaken(thisMove);
		 	//account for first shake and ignore other shakes 
		 	if(shaken && beenShaken[count]==0) 
		 	{
		 	beenShaken[count]=1;
		 	shakenMove = count; 
			setChanged();
		 	notifyObservers();
		 	}
		 		//make sure it doens't run on loop
	 		if(shaken && beenShaken[count] == 1) 
	 		{
	 			beenShaken[count] = 2;
	 			clearObservers();
	 		} 
		 		
		} else if(passedTime2 > totalTime && beenShaken[count]==2){ 
			
			mlistinScene.get(count).set_rumble(0);
			resetTime(); 
			count++; 
			p.println("count" + count);
			
	
		}
		//account for stupid players who don't shake the move 
		else if (passedTime2 > totalTime && beenShaken[count]==0) {
			resetTime();
			mlistinScene.get(count).set_rumble(0);
			count++; 
		}
		
		
 	}	
} 

 public String getMessage( ){
	 String myString = "/shakenMove"; 
	 return myString;
 } 
 @Override
public int getNumber(){
	return shakenMove;
}
 public void display(){
	
	} 

 
}
