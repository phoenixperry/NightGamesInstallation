
import processing.core.*;
import java.util.TimerTask;
import java.util.Timer;
import io.thp.psmove.PSMove;
import io.thp.psmove.psmoveapi;

import java.util.ArrayList;

public abstract class Scene {
	protected PApplet p; 
	protected ArrayList<PSMove> mlist; 
	public  String name; 
	Scene(PApplet p_){
	} 
	
	public void setMoves(ArrayList<PSMove> mlist_){
		mlist = mlist_;
	} 
	
	public void setMoveColorstoWhite(){
		for (int i = 0; i < mlist.size(); i++) {
			mlist.get(i).set_leds(255, 255, 255);
		}

	}
	
	public abstract void update(); 
	
	public abstract void display(); 
	
	
}
