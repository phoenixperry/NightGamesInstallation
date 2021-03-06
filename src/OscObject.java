import processing.core.*;
import oscP5.*; 
import netP5.*; 


import java.awt.print.Printable;
import java.util.Observable;
import java.util.Observer;


public class OscObject extends Observable  implements Observer {
	PApplet p; 
	public OscP5 oscP5; 
	public NetAddress myRemoteLocation; 
	public OscMessage myMessage; 
	public OscProperties myProperties = new OscProperties();
	public String oscReceived; 
	public OscMessage receivedMsg;
	public String typetag; 
	public int shakenMove; 
	Observable observable; 
	
	float gx, gy,gz, trigger,on,off=0.0f; 
	String message; 
	
	OscObject(PApplet p_, String location, int mySender, int myReceiver, Observable observable){
		this.observable = observable; 
		//you might need to comment this out and unimplement the observer 
		observable.addObserver(this);

		p=p_; 
		//listeing here
		oscP5 = new OscP5(this, 8001); 
		//sending here 
		myRemoteLocation =new NetAddress(location, 8000); 
		
	}
	public void addObserver(Observable observable){
		observable.addObserver(this); 
	}
	
	public void update(Observable obs, Object arg){
		if(obs instanceof MoveToOsc){
			//p.println("i fired");
			MoveToOsc moveOsc = (MoveToOsc)obs; 
			this.gx=moveOsc.getGX(); 
			this.gy = moveOsc.getGY(); 
			this.gz = moveOsc.getGZ();
			trigger = gx;
			//this is where you are at. 
			//this.trigger = moveOsc.getTrigger();  
			//p.println(trigger + "i'm triger");
			this.message = moveOsc.getMessage();
			
			addToMessage();
		} 
		if(obs instanceof Scene1){
			Scene1 currentScene = (Scene1)obs; 
			this.message = currentScene.getMessage();
			this.shakenMove = currentScene.getNumber(); 
			addToMessage();
			p.println("this osc is sending " +message+shakenMove );
		} 
	} 
	public void addToMessage() {
		
		//p.println(gx + "i am scaled gx?" + gy  + " i am gy" + gz +" i am gz" +on);
		if(message.equals("/move0")){
//			for (int i = 0; i < 10; i++) {
//				mySystem.addParticle();
//			}
		myMessage = new OscMessage("/move0"); 
		myMessage.add(gx);
		myMessage.add(gy); 
		myMessage.add(gz); 
		
		//myMessage.add(trigger);
		sendMessage(); 
		//p.println("i sent 0");
		}
		
		if(message.equals("/move1")){
			myMessage = new OscMessage("/move1"); 
			myMessage.add(gx);
			myMessage.add(gy); 
			myMessage.add(gz);
			
			//myMessage.add(trigger);
			sendMessage(); 
			}
		
		if(message.equals("/move2")){
			myMessage = new OscMessage("/move2"); 
			myMessage.add(gx);
			myMessage.add(gy); 
			myMessage.add(gz); 
			
			//myMessage.add(trigger);
			sendMessage(); 
			}
		if(message.equals("/move3")){
			myMessage = new OscMessage("/move3"); 
			
			myMessage.add(gx);
			myMessage.add(gy);
			myMessage.add(gz);
			
			//myMessage.add(trigger);
			sendMessage(); 
			}
		
		if(message.equals("/move4")){
			myMessage = new OscMessage("/move4"); 
			myMessage.add(gx);
			myMessage.add(gy); 
			myMessage.add(gz);
			
			//myMessage.add(trigger);
			sendMessage(); 
			}
		
		if(message.equals("/move5")){
			myMessage = new OscMessage("/move5"); 
			myMessage.add(gx);
			myMessage.add(gy); 
			myMessage.add(gz);
			
			//myMessage.add(trigger);
			sendMessage(); 
			}
		if(message.equals("/move6")){
			myMessage = new OscMessage("/move6"); 
			p.println("monster move");
			myMessage.add(gx);
			myMessage.add(gy); 
			myMessage.add(gz);		
			 
			//myMessage.add(trigger);
			sendMessage(); 
			}
		if(message.equals("/move7")){
			myMessage = new OscMessage("/move7"); 
			myMessage.add(gx);
			myMessage.add(gy); 
			myMessage.add(gz); 
			
			//myMessage.add(trigger);
			sendMessage(); 
			}
		if(message.equals("/move8")){
			myMessage = new OscMessage("/move8"); 
			myMessage.add(gx);
			myMessage.add(gy); 
			myMessage.add(gz);
			
			//myMessage.add(trigger);
			sendMessage(); 
			}
		
		if(message.equals("/move9")){
			myMessage = new OscMessage("/move9"); 
			myMessage.add(gx);
			myMessage.add(gy); 
			myMessage.add(gz);
			
			//myMessage.add(trigger);
			sendMessage(); 
			}
		
		else if(!message.equals("/move0")&& !message.equals("/move1")&& message.equals("/move2")&&message.equals("/move3")
				&& !message.equals("/move4") && !message.equals("/move5") && !message.equals("/move6")&& !message.equals("/move7")
				&& !message.equals("/move8") && !message.equals("/move9"))
		
		{
			//p.println(message + "I am mystery mover");
			myMessage = new OscMessage("/mysteryMove" ); 
			myMessage.add(gx);
			myMessage.add(gy); 
			myMessage.add(gz);
			
			//myMessage.add(trigger);
			sendMessage(); 		
			}
		
		else if(message.equals("/shakenMove")){
			
			myMessage = new OscMessage(message + shakenMove); 

			sendMessage();
		 }
	} 
	public void sendMessage() {
		oscP5.send(myMessage, myRemoteLocation); 
	} 
	
	public void oscEvent(OscMessage msg)
	{
		receivedMsg = msg; 
		oscReceived=(String)msg.addrPattern(); 
		msgReceived(); 
		p.println(oscReceived); 
		typetag = msg.typetag(); 
		 p.println(" typetag: "+msg.typetag()+ msg.addrPattern().valueOf(0));
		
	}
	
	
	
	public void msgReceived() {
		//p.println("notified");
		setChanged(); 
		notifyObservers(); 
		
	} 
	
}
