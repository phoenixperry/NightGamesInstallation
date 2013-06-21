import processing.core.*;
import io.thp.psmove.*;
import java.util.Observable;
import java.util.Observer;

public class MoveToOsc extends Observable {
	PApplet p;
	//sets up gyro vals 
	public boolean useMoves = true;
	private float[] gx = { 0.f };
	private float[] gy = { 0.f };
	private float[] gz = { 0.f };
	
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
		//gets the active move and assigns it to i 
		activeMove = i_;
		
		int buttons = move.get_buttons();
		if ((buttons & Button.Btn_MOVE.swigValue()) != 0) {
		      move.set_rumble(255);
		    } else {
		      move.set_rumble(0);
		    }
		   trigger = move.get_trigger();

		    
		move.get_gyroscope_frame(io.thp.psmove.Frame.Frame_SecondHalf, gx, gy,
				gz);
		//highpass vals
		p.println("is this only one val?" + gx[0]);
		float xt = PApplet.abs(getGX());
		float yt = PApplet.abs(getGY());
		float zt = PApplet.abs(getGZ());
		//acts a high pass filter to weed junk out 
		
		if (yt > 1.2) {
			setChanged();
			//fires out events 
			notifyObservers();
		} else {
			clearChanged();
		}

	}
	
	public float getGX() {
		return gx[0];
	}

	public float getGY() {
		return gy[0];
	}

	public float getGZ() {
		return gz[0];
	}
	public int getTrigger() {
		return trigger; 
	} 
	
	public String getMessage() {
		return new String("/move" + activeMove);
	}
	
	//sets led colors 
	public void setLedColor(int i, PSMove move, int r, int g, int b) {
		move.set_leds(r, g, b);
		move.update_leds();
	}

}
