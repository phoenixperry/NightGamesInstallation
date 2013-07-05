
import processing.core.*;
import java.util.TimerTask;
import java.util.Timer;
import io.thp.psmove.PSMove;
import io.thp.psmove.psmoveapi;

import java.util.ArrayList;

public abstract class Scene {
	PApplet p; 
	private ArrayList<PSMove> mlist; 
	Scene(PApplet p_, ArrayList<PSMove> mlist_){
		p=p_; 
		mlist = mlist_; 
	} 
	
	public void getMoves(ArrayList<PSMove> mlist){} 
	
	public void setMoveColorstoWhite(){}
	
	public void update(){} 
	
	public void display(){} 
	
	
}
