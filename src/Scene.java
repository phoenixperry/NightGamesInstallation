
import processing.core.*;
import java.util.TimerTask;
import java.util.Timer;
import io.thp.psmove.PSMove;
import io.thp.psmove.psmoveapi;

import java.util.ArrayList;

public abstract class Scene {
	PApplet p; 
	
	Scene(PApplet p_){
		p=p_; 
	} 
	
	public void getMoves(ArrayList<PSMove> mlist){} 
	
	public void setMoveColorstoWhite(){}
	
	public void update(){} 
	
	public void display(){} 
	
	
}
