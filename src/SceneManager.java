
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.omg.CORBA.PUBLIC_MEMBER;

import processing.core.*;
import io.thp.psmove.*;

public class SceneManager implements Observer{
	PApplet p; 
	OscObject osc; 

	Observable observable; 
	public ArrayList<PSMove> mList; 

	//all three scenes 

	Scene currentScene; 
	int triggerSwitch = 0; 

	
	SceneManager(PApplet p_,OscObject osc_,Observable observable_, ArrayList<PSMove>mlist_) {
		p=p_; 
		osc = osc_; 
		mList = mlist_;				
		this.observable = observable_; 
		observable.addObserver(this); 
		
	
	}
	
	public void oscReceived(Observable obs, Object arg) {
		
		sceneSelect();
		
	} 
	public void update(Observable obs, Object arg) {
		if(obs instanceof OscObject)
		osc = (OscObject)obs;  
		//checking to make sure it's a float so we have the right value
		if(osc.receivedMsg.checkTypetag("f")){
		triggerSwitch = (int)osc.receivedMsg.get(0).floatValue(); 
		//p.println(triggerSwitch + "i am the trigger switch");
		}
		sceneSelect(); 

	} 
	public void sceneSelect() {
		if(osc.oscReceived!=null){
			if(osc.oscReceived.equals("/scene1")){
				
				p.println("i am scene1");	
				currentScene =  new Scene1(p);
				currentScene.name = "scene1";
			} 
			
			else if(osc.oscReceived.equals("/scene2")){
				p.println("i am scene2");
			
				currentScene = new Scene2(p); 

				
			} 
			else if(osc.oscReceived.equals("/scene3")){
				p.println("i am scene3");
	
				currentScene = new Scene3(p);
				
			} 
			else if(osc.oscReceived.equals("/stop")){
				p.println("stop all scenes");
				triggerSwitch =0; 
	
			} 
			currentScene.setMoves(mList);
		}	
		
	}
	
	public void updateScene(OscObject sm_osc, MoveToOsc sm_mto){
		if(currentScene!=null&&triggerSwitch==1){
	
			currentScene.update();
			currentScene.display();
			currentScene.setOsc(sm_osc, sm_mto);
			
		}
	} 
	
}
