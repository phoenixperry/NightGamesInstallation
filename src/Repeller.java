import java.awt.Stroke;

import javax.swing.SpringLayout.Constraints;

import processing.core.*;
public class Repeller {
PApplet p; 
public float strength =100; 
PVector location; 
float r = 10; 
	public Repeller(PApplet p_, float x, float y) {
		location = new PVector(x,y); 
		p=p_;
	}
	
	public void display(){
		p.stroke(255); 
		p.fill(255); 
		p.ellipse(location.x, location.y, r*2, r*2);
	}
	PVector repel(Particle part){
		PVector dir = PVector.sub(location, part.location); 
		float d = dir.mag(); 
		dir.normalize(); 
		d = p.constrain(d, 5, 100); 
		float force = -1*strength/(d*d); 
		dir.mult(force);
		return dir;
		
	}

}
