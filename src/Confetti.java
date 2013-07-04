

import processing.core.PApplet;
import processing.core.PVector;


public class Confetti extends Particle {

	public Confetti(PApplet p_, PVector l) {
		super(p_, l);
		
		// TODO Auto-generated constructor stub
	}
	public void display(){
		float theta = p.map(location.x, 0, p.width, 0, p.TWO_PI);
		p.rectMode(p.CENTER);
		p.fill(0, lifespan); 
		p.stroke(0,lifespan);
		p.pushMatrix();
		p.translate(location.x, location.y); 
		p.rotate(theta);
		p.rect(0, 0, 8, 8); 
		p.popMatrix(); 
	} 
}
