
import processing.core.PApplet;

public class ImageCreator {
	PApplet p;
	public int xpos,ypos; 
	public processing.core.PImage img; 
	
	
	ImageCreator(PApplet p_, String loadImg_) {
		p =p_; 
		 

		String string= new String(loadImg_ + ".png");
		img = p.loadImage(string);  
	}

	 public int getWidth() 
	 {
		 return img.width;

	 }
	 public int getHeight() 
	 {
		 return img.height;
	 }
	 
	 public void display(int xpos_, int ypos_){
			xpos = xpos_; 
			ypos = ypos_;
		p.tint(255,255,255);
		p.image(img,xpos,ypos);
		
	 }
	 
	 public void displayWithoutTint(int xpos_, int ypos_){
		 	xpos = xpos_; 
		 	ypos = ypos_;
		 	p.image(img,xpos,ypos);		 	
	 } 
	 
	 public void displayParticle(int xpos_, int ypos_, int lifespan, NightGames2.Colors myColor)
	 {	
		 	//p.imageMode(PApplet.CENTER);
			xpos = xpos_; 
			ypos = ypos_;
		p.tint(myColor.r,myColor.g,myColor.b,lifespan);
		p.image(img,xpos,ypos);
		//p.imageMode(PApplet.CORNER);
		
	 }
	 public void scaled(float scaler){
		 p.scale(scaler);
	 }

	 
}

	

