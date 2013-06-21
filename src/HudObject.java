import processing.core.*;
import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;

public class HudObject implements Observer {
	PApplet p;

	int moveNumber = 0;
	ImageCreator greenMonster, yellowMonster, blueMonster, pinkMonster,
			redMonster, greyMonster;

	Observable observable;

	Animation animation0, animation1, animation2, animation3, animation4,
			animation5;

	int currentTriggeredMove;

	public NightGames2.Colors green = NightGames2.Colors.GREEN;
	public NightGames2.Colors blue = NightGames2.Colors.BLUE;
	public NightGames2.Colors yellow = NightGames2.Colors.YELLOW;
	public NightGames2.Colors pink = NightGames2.Colors.PINK;
	public NightGames2.Colors red = NightGames2.Colors.RED;
	public NightGames2.Colors grey = NightGames2.Colors.GREY;

	private ArrayList<ImageCreator> images = new ArrayList<ImageCreator>();

	HudObject(PApplet p_, int moveNumber_, Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
		p.println("constructor for button " + moveNumber_);
		p = p_;

		moveNumber = moveNumber_;

		loadAnimations();

	}

	private void loadAnimations() {
		switch (moveNumber) {
		case 0:
			animation0 = new Animation(p, "green", 3, green);
			ImageCreator img = new ImageCreator(p, "green");
			images.add(img);
			break;
		case 1:
			animation1 = new Animation(p, "yellow", 3, yellow);
			ImageCreator img1 = new ImageCreator(p, "yellow");
			images.add(img1);

			break;
		case 2:
			animation2 = new Animation(p, "blue", 3, blue);
			ImageCreator img2 = new ImageCreator(p, "blue");
			images.add(img2);
			break;
		case 3:
			animation3 = new Animation(p, "pink", 3, pink);
			ImageCreator img3 = new ImageCreator(p, "pink");
			images.add(img3);
			break;
		case 4:
			animation4 = new Animation(p, "red", 3, red);
			ImageCreator img4 = new ImageCreator(p, "red");

			images.add(img4);
			break;
		case 5:
			animation5 = new Animation(p, "grey", 3, grey);
			ImageCreator img5 = new ImageCreator(p, "grey");
			images.add(img5);
			break;

		default:
			break;
		}
	}

	public void update(Observable obs, Object arg) {
		// fires when move is shakedn
		if (obs instanceof MoveToOsc) {
			MoveToOsc moveOsc = (MoveToOsc) obs;
			currentTriggeredMove = moveOsc.activeMove;
			playAnimations();
		}
	}

	private void playAnimations() {
		if (currentTriggeredMove == moveNumber) {
			switch (moveNumber) {
			case 0:
				animation0.display(0, 0);
				images.get(0).display(0, 0);
				break;
			case 1:
				animation1.display(animation1.getWidth(), 0);
				images.get(0).display(images.get(0).getWidth(), 0);
				break;

			case 2:
				animation2.display(2 * animation2.getWidth(), 0);
				images.get(0).display(images.get(0).getWidth()*2,0 );
				break;
			case 3:
				animation3.display(0, animation3.getHeight());
				images.get(0).display(0, images.get(0).getHeight());
				break;
			case 4:
				animation4.display(animation4.getWidth(),
						animation4.getHeight());
				images.get(0).display(images.get(0).getWidth(),
						images.get(0).getHeight());
				break;
			case 5:
				animation5.display(2 * animation5.getWidth(),
						animation5.getHeight());
				images.get(0).display(images.get(0).getWidth() * 2,
						images.get(0).getHeight());
				break;
			default:
				break;
			}
		}
	}

	public void display() {

		// put images here in switch case
		switch (moveNumber) {
		case 0:
			images.get(0).display(0, 0);
			break;
		case 1:
			images.get(0).display(images.get(0).getWidth(), 0);
			break;
		case 2:
			images.get(0).display(images.get(0).getWidth() * 2, 0);
			break;
		case 3:
			images.get(0).display(0, images.get(0).getHeight());
			break;
		case 4:
			images.get(0).display(images.get(0).getWidth(),
					images.get(0).getHeight());
			break;
		case 5:
			images.get(0).display(images.get(0).getWidth() * 2,
					images.get(0).getHeight());
			break;
		default:
			break;
		}

	}
}
