
import java.util.Observable;
import java.util.Observer;

import org.omg.CORBA.PUBLIC_MEMBER;

import processing.core.*;


public class SceneManager implements Observer{
	PApplet p; 
	OscObject osc; 

	Observable observable; 
	
	//all three scenes 
	Scene1 scene1; 
	Scene2 scene2; 
	Scene3 scene3; 
	Scene currentScene; 
	
	//these are dirty fixes for the way the touch osc btns work - build an app when you have time
	//this is redic lame. 
	boolean sceneSwitch1 = true; 
	boolean sceneSwitch2 = true; 
	boolean sceneSwitch3 = true; 
	boolean sceneSwitch4 = true; 
	
	SceneManager(PApplet p_,OscObject osc_,Observable observable_) {
		p=p_; 
		osc = osc_; 
		this.observable = observable_; 
		observable.addObserver(this); 
	}
	
	public void oscReceived(Observable obs, Object arg) {
		
		sceneSelect();
		
	} 
	public void update(Observable obs, Object arg) {
		if(obs instanceof OscObject)
		osc = (OscObject)obs;  
		sceneSelect(); 

	} 
	public void sceneSelect() {
		if(osc.oscReceived!=null){
		if(osc.oscReceived.equals("/scene1")&&sceneSwitch1){
			p.println("i am scene1");
			sceneSwitch1 = false; 
			sceneSwitch2 = true; 
			sceneSwitch3 = true; 
			sceneSwitch4 = true; 
			scene1 = new Scene1(p); 
			currentScene = scene1; 
			
		} 
		
		else if(osc.oscReceived.equals("/scene2")&&sceneSwitch2){
			p.println("i am scene2");
			sceneSwitch1 = true; 
			sceneSwitch2 = false; 
			sceneSwitch3 = true; 
			sceneSwitch4 = true; 
			scene2 = new Scene2(p); 
			currentScene = scene2; 
			
		} 
		else if(osc.oscReceived.equals("/scene3")&&sceneSwitch3){
			p.println("i am scene3");
			sceneSwitch1 = true; 
			sceneSwitch2 = true; 
			sceneSwitch3 = false; 
			sceneSwitch4 = true; 
			scene3 = new Scene3(p);
			currentScene = scene3; 
		} 
		else if(osc.oscReceived.equals("/stop")&&sceneSwitch4){
			p.println("stop all scenes");
			sceneSwitch1 = true; 
			sceneSwitch2 = true; 
			sceneSwitch3 = true; 
			sceneSwitch4 = false; 
		} 
		
		}	
	}
	public void updateScene(){
		if(currentScene!=null){
		currentScene.update();
		currentScene.display();
		}
	} 
	
}
