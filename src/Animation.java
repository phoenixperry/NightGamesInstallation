

import processing.core.*;; 

public class Animation {
PApplet p; 
private PImage[] images; 
private int imageCount; 

private int frame=0; 
private NightGames2.Colors mycolor; 
	 Animation(PApplet p_, String imagePrefix, int count, NightGames2.Colors color_) {
		 p = p_; 
		 mycolor = color_; 
		 imageCount = count; 
		 images = new PImage[imageCount]; 
		 for (int i = 0; i < imageCount; i++) {
			 //use nf() to number format i into four digits 
			 String filename = imagePrefix +PApplet.nf(i, 2)+ ".png"; 
			 images[i]= p.loadImage(filename); 
			 PApplet.println(images.length);
			
		}
	 } 
	 
	 public void display(float xpos, float ypos){
		 frame = (frame+1)%imageCount; 
		 PImage img = images[frame];
		 p.tint(mycolor.r, mycolor.g, mycolor.b, 150); 
		 p.image(img, xpos,ypos);
	   	
	   
	 } 
	 
	 public int getWidth() 
	 {
		 return images[0].width; 
	 }
	 public int getHeight() 
	 {
		 return images[0].height; 
	 }
	
}
