import io.thp.psmove.PSMove;

import java.util.ArrayList;


public interface IScene {
	
	
	public void getMoves(ArrayList<PSMove> mlist); 
	
	public void setMoveColorstoWhite();
	
	public void update(); 
	
	public void display(); 
	
	
}
