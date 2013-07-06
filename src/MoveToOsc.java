import processing.core.*;
import io.thp.psmove.*;
import java.util.Observable;

public class MoveToOsc extends Observable {
	PApplet p;
	//sets up gyro vals 
	public boolean useMoves = true;
	private float[] gx = { 0.f };
	private float[] gy = { 0.f };
	private float[] gz = { 0.f };
	public float on = 0.0f; 
	public float off = 0.0f; 
	private float holderx;
	
	private float holdery; 
	private float holderz; 
	
	//keeps a record of the most active move 
	int activeMove = 0;
	private int trigger = 0; 
	
	MoveToOsc(PApplet p_) {
		p = p_;
	
	}

	//triggers when move vals change 
	void handle(int i_, PSMove move, OscObject osc, HudObject btn) {
	
		
		while (move.poll() != 0) {
		}
		activeMove = i_;
		    
		move.get_gyroscope_frame(io.thp.psmove.Frame.Frame_SecondHalf, gx, gy,
				gz);
		//highpass vals

		float xt = PApplet.abs(getGX());
		float yt = gy[0];
		//println(yt+"yt");
		float zt = PApplet.abs(getGZ());
		//acts a high pass filter to weed junk out 
		
		if (yt > 1.2) {
			setChanged();
			on = 127; 
			holderx = p.map(gx[0], -20, 20, 0, 50);
			holderx = p.abs(holderx);
			
			
			holdery = p.map(gy[0], -20, 20, 0, 127);
			holdery = p.abs(holdery);
			
			holderz = p.map(gz[0], -20, 20, 0, 127);
			holderz = p.abs(holderz);
			p.println("i am the holder " + holderx);
			setChanged();
			notifyObservers();
			

		} else {
			on = 0.0f; 
			clearChanged();
		}

	}

	
	//holder for monster -- overloaded 
	void handle(int i_, PSMove move, OscObject osc, ParticleSystem ps) {
	
		
		while (move.poll() != 0) {
		}
		//gets the active move and assigns it to i 
		activeMove = i_;
		

		    
		move.get_gyroscope_frame(io.thp.psmove.Frame.Frame_SecondHalf, gx, gy,
				gz);


		float xt = PApplet.abs(getGX());
		float yt = gy[0];
		//println(yt+"yt");
		float zt = PApplet.abs(getGZ());
		//acts a high pass filter to weed junk out 
		
		if (yt > 1.2) {
			setChanged();
			on = 127; 
			holderx = p.map(gx[0], -20, 20, 0, 50);
			holderx = p.abs(holderx);
			
			
			holdery = p.map(gy[0], -20, 20, 0, 127);
			holdery = p.abs(holdery);
			
			holderz = p.map(gz[0], -20, 20, 0, 127);
			holderz = p.abs(holderz);
			p.println("i am the holder " + holderx);
	
			//p.println( gy[0] + " before observe");
			setChanged();
			notifyObservers();
			//p.println( gy[0] + " after observe");

		} else {
			on = 0.0f; 
			clearChanged();
		}

	}
	
	void handle(int i_, PSMove move, OscObject osc) {
	
		
		while (move.poll() != 0) {
		}
		activeMove = i_;
		

		    
		move.get_gyroscope_frame(io.thp.psmove.Frame.Frame_SecondHalf, gx, gy,
				gz);


		float xt = PApplet.abs(getGX());
		float yt = gy[0];
		//println(yt+"yt");
		float zt = PApplet.abs(getGZ());
		//acts a high pass filter to weed junk out 
		
		if (yt > 1.2) {
			setChanged();
			on = 127; 
			holderx = p.map(gx[0], -20, 20, 0, 50);
			holderx = p.abs(holderx);
			
			
			holdery = p.map(gy[0], -20, 20, 0, 127);
			holdery = p.abs(holdery);
			
			holderz = p.map(gz[0], -20, 20, 0, 127);
			holderz = p.abs(holderz);
			p.println("i am the holder " + holderx);
	
			//p.println( gy[0] + " before observe");
			setChanged();
			notifyObservers();
			//p.println( gy[0] + " after observe");

		} else {
			on = 0.0f; 
			clearChanged();
		}

	}
	
	public float getGX() {
		return holderx; 
		//return gx[0];
	}

	public float getGY() {
		return holdery;
//		return gy[0];
	}

	public float getGZ() {
		return holderz; 
//		return gz[0];
	}
//	public int getTrigger() {
//		//return trigger; 
//	} 
//	
	public String getMessage() {
		return new String("/move" + activeMove);
	}
	
	//sets led colors 
	public void setLedColor(int i, PSMove move, int r, int g, int b) {
		move.set_leds(r, g, b);
		move.update_leds();
	}

}
