
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
	protected MoveToOsc sceneMto;
	
	public NightGames2.MovePalette green_m = NightGames2.MovePalette.GREEN_MOVE; 
	public NightGames2.MovePalette yellow_m = NightGames2.MovePalette.YELLOW_MOVE; 
	public NightGames2.MovePalette blue_m = NightGames2.MovePalette.BLUE_MOVE; 
	public NightGames2.MovePalette pink_m = NightGames2.MovePalette.PINK_MOVE; 
	public NightGames2.MovePalette red_m = NightGames2.MovePalette.RED_MOVE; 
	public NightGames2.MovePalette grey_m = NightGames2.MovePalette.GREY_MOVE; 
	public NightGames2.MovePalette violet_m = NightGames2.MovePalette.VIOLET_MOVE; 

	
	protected ArrayList<NightGames2.MovePalette> colors = new ArrayList<NightGames2.MovePalette>(7);
	Scene(PApplet p_){
	
		colors.add(red_m); 
		colors.add(yellow_m); 
		colors.add(pink_m);
		colors.add(grey_m); 
		colors.add(violet_m);  
		colors.add(blue_m); 
		colors.add(green_m);
	} 
	
	public void setMoves(ArrayList<PSMove> mlist_){
		mlistinScene = mlist_;
		p.println(mlistinScene.size() + "moves in scene manager"); 
	} 
	
	public void setOsc(OscObject osc_, MoveToOsc mto_){
		sceneMto = mto_;
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

	public abstract void updateScene(); 
	
	public abstract void display(); 
	
	public abstract void colorLoop();
	
}
