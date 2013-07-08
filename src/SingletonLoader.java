

import processing.core.*;

public class SingletonLoader {
	PApplet p;
	ImageCreator img; 
	private boolean okToCreate = false;
	private String imgToMake; 
	private SingletonLoader instance; 
	public SingletonLoader() {
		// TODO Auto-generated constructor stub

		if(!okToCreate){
			p.println(imgToMake + "is a SingletonLoader. access use getInstance");

		}
		if(okToCreate){
			img = new ImageCreator(p, imgToMake);
			p.println("singlton made");
		}
		
	}
	
	public SingletonLoader getInstance(PApplet p_, String makeMe){
		if(instance.equals(null)){
	
			p=p_;
			imgToMake = makeMe; 
			instance = new SingletonLoader();
		} 
		
		return instance; 
	}

}
