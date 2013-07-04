
import processing.core.*;


public class SceneManager {
	PApplet p; 
	OscObject osc; 
	String currentScene;
	
	SceneManager(PApplet p_,OscObject osc_) {
		p=p_; 
		osc = osc_; 
	}
	 
	public void sceneSelect() {
		if(osc.oscReceived!=null){
		if(osc.oscReceived.equals("/scene1")){
			p.println("i am scene1");
		} 
		
		else if(osc.oscReceived.equals("/scene2")){
			p.println("i am scene2");
		} 
		else if(osc.oscReceived.equals("/scene3")){
			p.println("i am scene3");
		} 
		else if(osc.oscReceived.equals("/stop")){
			p.println("stop all scenes");
		} 
		}	
	}			
	
}
