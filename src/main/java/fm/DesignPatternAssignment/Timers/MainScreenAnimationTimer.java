package fm.DesignPatternAssignment.Timers;

import java.util.TimerTask;

import fm.DesignPatternAssignment.Controller;
import fm.DesignPatternAssignment.UI.GameUI;
import javafx.scene.paint.Color;

/**
 * This TimerTask is used to animate the pre-game's screen
 */
public class MainScreenAnimationTimer extends TimerTask {
	
	
	private GameUI mainScreenBackground;
	private boolean isOnFirstColour = true;

	public MainScreenAnimationTimer(GameUI mainScreenBackground) {
		this.mainScreenBackground = mainScreenBackground;
	}
	

	@Override
	public synchronized void run() {
		double x = mainScreenBackground.getX();
		double y = mainScreenBackground.getY();
		double width = mainScreenBackground.getWidth();
		double height = mainScreenBackground.getHeight();
		
		if(Controller.getInstance().getModel() != null) {
			if(Controller.getInstance().getModel().isGameInProgress())
				this.cancel();
		}

		
		
		int animationSpeed = 40;
		
		
		if(isOnFirstColour) {
			mainScreenBackground.setColour(Color.WHITE);
		}else {
			mainScreenBackground.setColour(Color.PINK);
		}
			
		if(width <= 2000) {
				mainScreenBackground.setX(( x - animationSpeed/2));
				mainScreenBackground.setY((y - animationSpeed/2));
				mainScreenBackground.setWidth((width + animationSpeed));
				mainScreenBackground.setHeight((height + animationSpeed));
				
			
					
			}else {
				
				restartValues();
				isOnFirstColour = !isOnFirstColour;
			}
		
		
		
		
	}
	
	public void restartValues() {
		mainScreenBackground.setX((400));
		mainScreenBackground.setY((290));
		mainScreenBackground.setWidth((0));
		mainScreenBackground.setHeight((0));
	}

}
