
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
	Scene1 scene1; 
	Scene2 scene2; 
	Scene3 scene3; 
	Scene currentScene; 
	int triggerSwitch = 0; 
	//these are dirty fixes for the way the touch osc btns work - build an app when you have time
	//this is redic lame. 

	
	SceneManager(PApplet p_,OscObject osc_,Observable observable_, ArrayList<PSMove>mlist_) {
		p=p_; 
		osc = osc_; 
		//mList = i
				
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
		
			scene1 = new Scene1(p); 
			currentScene = scene1; 
			
		} 
		
		else if(osc.oscReceived.equals("/scene2")){
			p.println("i am scene2");
		
			scene2 = new Scene2(p); 
			currentScene = scene2; 
			
		} 
		else if(osc.oscReceived.equals("/scene3")){
			p.println("i am scene3");

			scene3 = new Scene3(p);
			currentScene = scene3; 
		} 
		else if(osc.oscReceived.equals("/stop")){
			p.println("stop all scenes");
			triggerSwitch =0; 

		} 
		
		}	
	}
	public void updateScene(){
		if(currentScene!=null&&triggerSwitch==1){
		currentScene.update();
		currentScene.display();
		}
	} 
	
}
