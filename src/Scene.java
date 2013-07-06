
import processing.core.*;
import java.util.TimerTask;
import java.util.Timer;
import io.thp.psmove.PSMove;
import io.thp.psmove.psmoveapi;

import java.util.ArrayList;

public abstract class Scene {
	protected PApplet p; 
	protected ArrayList<PSMove> mlistinScene; 
	public  String name; 
	Scene(PApplet p_){
	} 
	
	public void setMoves(ArrayList<PSMove> mlist_){
		mlistinScene = mlist_;
	} 
	
	public void setOsc(OscObject osc_, MoveToOsc mto_){
		for (int i = 0; i < mlistinScene.size(); i++) {
			mto_.handle(i,mlistinScene.get(i), osc_);
		}
	}
	public void setMoveColorstoWhite(){
		
		for (int i = 0; i < mlistinScene.size(); i++) {
			mlistinScene.get(i).set_leds(255, 255, 255);
			mlistinScene.get(i).update_leds();
		}

	}
	
	public void update() {
		
		
	} 
	
	public abstract void display(); 
	
	
}
