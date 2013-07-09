import io.thp.psmove.PSMove;
import io.thp.psmove.psmoveapi;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import processing.core.*;

public class Scene3 extends Scene{



	//PApplet p; 

	
	Scene3(PApplet p_) {
		super(p_);

		//p=p_; 
		// TODO Auto-generated constructor stub
	}

 public void updateScene(){
	 	p.println("scene 3 updates");
	 	setMoveColorstoWhite(); 
		
	} 
	
 public void display(){
	 p.println("scene 1 displays");
	} 
 public void colorLoop(){}
}
