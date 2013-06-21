import java.awt.Stroke;
import java.util.Random;

import javax.xml.transform.Templates;



import processing.core.*;

public class Particle {
PApplet p; 
PVector velocity; 
PVector location;
PVector acceleration;
PVector mass; 
int lifespan; 
Random gen1; 
Random gen2;
double rand1; 
double rand2; 
ImageCreator myImage; 
	Particle(PApplet p_, PVector l) {
			p = p_; 
			location = l.get(); 
			acceleration = new PVector(0, 0.5f); 
			gen1 = new Random(); 
			gen2 = new Random();
			rand1 = gen1.nextDouble() *1 + -1 ; 
			rand2 = gen2.nextDouble() *-2; 
			velocity = new PVector((float)rand1, (float)rand2); 
			lifespan = 255; 
			mass = new PVector(0.5f, 0.5f);
			myImage = new ImageCreator(p,"particleLarge");
			myImage.scaled(0.2f);
			
	}
	public void update() {
		velocity.add(acceleration); 
		location.add(velocity); 
		acceleration.mult(0);
		lifespan -= 8.0; 
	} 
	public void display(NightGames2.Colors myColor) {
		if(lifespan > 0){
		//myImage.scaled(0.2f);
		myImage.displayParticle((int)location.x, (int)location.y,lifespan, myColor);
		
		//		p.stroke(0,lifespan); 
//		p.fill(175,lifespan); 
//		p.ellipse((int)location.x, (int)location.y, 8, 8); 
		}
	} 
	public void applyForce(PVector f) {
		//generic enough to work for any force, including gravity
		acceleration = PVector.div(f, mass); 		

	} 
	public void run () {
		update(); 
		
		NightGames2.Colors myColor=NightGames2.Colors.BLUE;
		display(myColor); 
	} 
	boolean isDead() {
		if(lifespan < 0.0){
			return true; 
		}
		else{
			return false; 
		}
		
	} 
}
