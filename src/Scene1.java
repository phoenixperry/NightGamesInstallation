import io.thp.psmove.PSMove;
import io.thp.psmove.psmoveapi;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import processing.core.*;

public class Scene1 extends Scene{



	//PApplet p; 
	Timers tm = new Timers(1,5);
	
	Scene1(PApplet p_) {
		super(p_);

		//p=p_; 
		// TODO Auto-generated constructor stub
	}


	

 public void update(){
	 	p.println("scene 1 updates");
	 	setMoveColorstoWhite(); 
		
	} 
	
 public void display(){
	 p.println("scene 1 displays");
	} 

}
