import processing.core.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import java.util.Random;

public class ParticleSystem {
	PApplet p; 
	ArrayList<Particle> particles = new ArrayList<Particle>(); 
	PVector origin; 
	Random genRandom; 
	PVector location; 
	 ParticleSystem(PApplet p_) {
	
		 p= p_;
		 genRandom = new Random(); 
	}
	 public void setLocation(int x, int y) {
		 location = new PVector(x,y); 
		 origin = new PVector(); 
		 origin.x = location.x;
	
		 origin.y = location.y;  
		 for (int i = 0; i < 15; i++) {
			addParticle();
		}
	 } 
	 public void addParticle(){
		 int r = genRandom.nextInt(100); 
		 int s = genRandom.nextInt(100);
		 PVector startPlace = new PVector(r,s); 
		 particles.add(new Particle(p, startPlace)); 
	 } 
	 
	 public void run(){
		 Iterator<Particle> it = particles.iterator(); 
		 while(it.hasNext()){
			 Particle p = it.next(); 
			 p.run(); 
			 if(p.isDead()){
				 it.remove(); 
			 }
		 }
	 }
	 public void applyForce(PVector f){
		 for(Particle ps:particles){
			 ps.applyForce(f);
		 }
	 }
	 public void applyRepeller(Repeller r){
		 for(Particle ps:particles){
			 PVector force=r.repel(ps); 
			 ps.applyForce(force);
		 }
	 }
}
