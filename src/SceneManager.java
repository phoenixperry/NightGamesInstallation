
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Handler;

import org.omg.CORBA.PUBLIC_MEMBER;

import processing.core.*;
import io.thp.psmove.*;

public class SceneManager implements Observer{
	PApplet p; 
	OscObject osc; 
	MoveToOsc mto; 
	Observable observable; 
	public ArrayList<PSMove> mList; 

	//all three scenes 

	Scene currentScene; 
	int triggerSwitch = 0; 
	PSMove currentMove; 
	
	SceneManager(PApplet p_, MoveToOsc mto_,OscObject osc_, Observable observable_, ArrayList<PSMove>mlist_) {
		osc = osc_; 
		p=p_; 
		mList = mlist_;				
		this.observable = observable_; 
		observable.addObserver(this); 
		mto = mto_;
		p.println(osc.gy +"test");
	
	
	}

	public void oscReceived(Observable obs, Object arg) {
		
		sceneSelect();
		
	} 
	public void update(Observable obs, Object arg) {
		if(obs instanceof OscObject)
		{
			osc = (OscObject)obs;  

		}
		if(osc.receivedMsg.checkTypetag("s")){
			p.println(osc.receivedMsg.get(0).stringValue() + "in scene magaer");
			
		}
		
		
		//checking to make sure it's a float so we have the right value
		if(osc.receivedMsg.checkTypetag("f")){
		triggerSwitch = (int)osc.receivedMsg.get(0).floatValue(); 
		//p.println(triggerSwitch + "i am the trigger switch");
		}
		sceneSelect(); 

	} 
	public void sceneSelect() {
		if(osc.oscReceived!=null){
			//currentScene.receiveMessage(osc);
			if(osc.oscReceived.equals("/red")){
			
				p.println("Red"+ "test");
				currentScene.receiveMessage("/red");
			}
			
			if(osc.oscReceived.equals("/blue")){
				
				currentScene.receiveMessage("/blue");
			}
			
			if(osc.oscReceived.equals("/winnerRed")){
				
				currentScene.receiveMessage("/winnerRed");
			}
			
			if(osc.oscReceived.equals("/winnerBlue")){
				
				currentScene.receiveMessage("/winnerBlue");
			}
			if(osc.oscReceived.equals("/scene1")){
				
				p.println("i am scene1");	
				currentScene =  new Scene1(p);
				currentScene.name = "scene1";
				currentScene.setMoveToOsc(mto);
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
			currentScene.setOscObject(osc);
			
				
				
			}
		}	
		
		

	
	public void updateScene( PSMove move, OscObject osc_, int i_){
	
		if(currentScene!=null&&triggerSwitch==1){
				mto.handle(move, osc_,i_);
				mto.working(move); 
				
				mList.set(i_, move);
				//currentScene.mlistinScene.set(i_, move);
				//p.println(move.getGx() + "updating " + i_); 
				//go through and check the fact you really don't need both these array objec
				currentScene.update( move, i_);
				currentScene.display();
				//p.println(osc.gx + "test2"); 
				
			}
		} 
	} 
	
	