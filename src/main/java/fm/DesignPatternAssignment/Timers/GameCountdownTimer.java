package fm.DesignPatternAssignment.Timers;

import java.util.TimerTask;

import fm.DesignPatternAssignment.AudioPlayer;
import fm.DesignPatternAssignment.Controller;
import fm.DesignPatternAssignment.UI.GameUIFactory;
import fm.DesignPatternAssignment.UI.TextUI;
import fm.DesignPatternAssignment.Views.View;
import javafx.scene.layout.Pane;



public class GameCountdownTimer extends TimerTask {

	private Controller controller;
	private GameTime timerCountdown = new GameTime(4);
	private TextUI countdownText;
	private boolean isAudioPlaying = false;
	
	/**
	 * Creates the count down text and stores it in the model class for the view to display it
	 * @param controller
	 */
	public GameCountdownTimer(Controller controller) {
		this.controller = controller;
		View view = this.controller.getView();
		Pane root = view.getRoot();
		
		GameUIFactory factory = new GameUIFactory(view.getGraphicsContext());
		countdownText = (TextUI) factory.createProduct("Text", (root.getWidth()/2) - 50, (root.getHeight()/2) + 75, 0, 0);
		countdownText.setFontSize(250.0);
		countdownText.setText("3");
		controller.getModel().setCountdownText(countdownText);
		
	}
	
	/**
	 * counts down and starts the game after the countdown
	 */
	@Override
	public void run() {
		//Ensures the count down audio is played only once per game
		if(!isAudioPlaying) {
			isAudioPlaying = true;
			AudioPlayer.playAudio("countdown.wav");
		}
		timerCountdown.Elapse(1);
		if(timerCountdown.timeReachedZero()) {
			this.controller.getModel().setCountdownText(null);
			this.controller.startGame();
			//Stops counting down
			this.cancel();
		}else
		{
			countdownText.setText("" + (int) timerCountdown.getSecond());
		}
		
	}

}
