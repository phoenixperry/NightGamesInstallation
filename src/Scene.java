import io.thp.psmove.PSMove;

import java.util.ArrayList;

import processing.core.PApplet;


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
