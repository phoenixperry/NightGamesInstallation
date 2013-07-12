
import processing.core.*; 
import io.thp.psmove.*;
import java.util.ArrayList;

import processing.opengl.*;

import java.util.Observable;
import java.util.Observer;

public class NightGames2 extends PApplet {
//	public static void main(String args[]) {
//        PApplet.main(new String[] {"--present",  "NightGames2" });
//    }

	
	//just sends osc 
	public OscObject osc;
	//gets gx vals, filters them, fires events when changed, colors moves 
	public MoveToOsc mto; 
	public ArrayList<PSMove> mlist = new ArrayList <PSMove>();
	public float[] gx,gy,gz; 
	private ImageCreator bgImage; 

	private ArrayList<HudObject> hudMonsters = new ArrayList<HudObject>(); 
	private ParticleSystem mySystem; 
	
	public ArrayList<ParticleSystem> mySystems = new ArrayList<ParticleSystem>(); 
	Repeller repeller;
	SceneManager sceneManager; 
	PSMove thisMove; 
	public static final String location ="127.0.0.1"; 
	public static final int sendingPort = 8000; 
	public static final int receiveingPort = 8001; 
	
	
	public enum Colors{
		GREEN (94,191,140), 
		YELLOW(252,167,40), 
		BLUE (63,79,233), 
		PINK(239,156,162), 
		RED(224,60,27), 
		BLACK(0,8,21),
		GREY(96,133,147);
		public int r,g,b; 
		private Colors(int r, int g, int b)
		{
			this.r = r; 
			this.g = g; 
			this.b = b; 
		}
	}
	
	
	public Colors green = Colors.GREEN; 
	public Colors yellow = Colors.YELLOW; 
	public Colors blue = Colors.BLUE; 
	public Colors pink = Colors.PINK; 
	public Colors red = Colors.RED; 
	public Colors grey = Colors.GREY; 
	public Colors black = Colors.BLACK; 
	
	public enum MovePalette{
		GREEN_MOVE(15,255,50), 
		YELLOW_MOVE(255,220,0),
		BLUE_MOVE(10,10,255), 
		PINK_MOVE(255,210,200),
		RED_MOVE(255,20,0), 
		GREY_MOVE(90,220,200),
		VIOLET_MOVE(200,0,255);
		public int r,g,b; 
		private MovePalette(int r, int g, int b){
		this.r =r;
		this.g = g; 
		this.b =b; 
	}
}
	public MovePalette green_m = MovePalette.GREEN_MOVE; 
	public MovePalette yellow_m = MovePalette.YELLOW_MOVE; 
	public MovePalette blue_m = MovePalette.BLUE_MOVE; 
	public MovePalette pink_m = MovePalette.PINK_MOVE; 
	public MovePalette red_m = MovePalette.RED_MOVE; 
	public MovePalette grey_m = MovePalette.GREY_MOVE; 
	public MovePalette violet_m = MovePalette.VIOLET_MOVE; 
	
	
	
	public void setup() {
		size(1280,720);
		frameRate(30);
	
		PVector loc = new PVector(20,20);
		
		
		bgImage = new ImageCreator(this, "background");
		frameRate(30); 	
		smooth();
	
		background(0);
		mto = new MoveToOsc (this);
		osc = new OscObject(this, location, sendingPort,receiveingPort,mto); 
		//moves = new PSMove[psmoveapi.count_connected()];
		
		println(psmoveapi.count_connected()); 
		int countConnected = psmoveapi.count_connected(); 
		println(countConnected + "number of moves pre junk checker");
		  for (int i=0; i<countConnected; i++) {
			    mlist.add(new PSMove(i));		
		  }
		  
		  cleanList(); 

		  for (int i=0; i<countConnected; i++) {
		  HudObject btn =new HudObject(this, i, mto); 
			hudMonsters.add(btn);
			mySystem = new ParticleSystem(this);
			
			mySystems.add(mySystem); 
			
		  }
		  repeller =new Repeller(this, 700,650);	
		  sceneManager = new SceneManager(this, mto,osc, osc, mlist);
	} 

	private void cleanList() {
		for(int i=0; i <mlist.size(); i++){
			PSMove mover = mlist.get(i); 
			
			
			
			int checker = mover.getConnection_type();
			if(checker ==1)
				mlist.remove(mover); 
			
			println("i am the junk checker" + checker); 

		}
		println(mlist.size() + "after junk checker"); 
	} 
	public void draw() {
		background(black.r, black.g, black.b);
		bgImage.displayWithoutTint(0, 0);
		PVector gravity = new PVector(0,0.1f);
//		sceneManager.updateScene(); 
		for(int i =0; i< mlist.size(); i++){
			HudObject btn = hudMonsters.get(i);

			//ParticleSystem psNow = mySystems.get(i);
			PSMove move = mlist.get(i);	
			
			sceneManager.updateScene(move, osc,i); 
			

				switch (i) {
				case 0:
					mto.handle(i, move, osc, btn);
					//mto.setLedColor(i, move, green_m.r, green_m.g, green_m.b);

					break;
				case 1:
					mto.handle(i, move, osc, btn);
					//mto.setLedColor(i, move, yellow_m.r, yellow_m.g, yellow_m.b);
					break;
				case 2:
					mto.handle(i, move, osc, btn);
					//mto.handle(i, move, osc, psNow);
					//mto.setLedColor(i, move, blue_m.r, blue_m.g, blue_m.b);
					break;
				case 3:
					mto.handle(i, move, osc, btn);
					//mto.setLedColor(i, move, pink_m.r, pink_m.g, pink_m.b);
					break;
				case 4:
					mto.handle(i, move, osc, btn);
					//mto.setLedColor(i, move, red_m.r, red_m.g, red_m.b);
					break;
				case 5:
					mto.handle(i, move, osc, btn);
					//mto.setLedColor(i, move, grey_m.r, grey_m.g, grey_m.b);
					break;
				case 6:
					//mto.handle(i, move, osc, mySystem);
					//mto.setLedColor(i, move, violet_m.r, violet_m.g, violet_m.b);
					break;

				default:
					break;
				}

		btn.display();

		}		
			
	}

//			public void keyPressed(){
//			        if(key == 'f') exitFullscreen();
//			    }
//
//
//	  private void exitFullscreen() {
//	        frame.setBounds(0,0,width,height);
//	        setBounds((screenWidth - width) / 2,(screenHeight - height) / 2,width, height);
//	        frame.setLocation((screenWidth - width) / 2,(screenHeight - height) / 2);
//	        setLocation((screenWidth - width) / 2,(screenHeight - height) / 2);
//	    }
//	
}

