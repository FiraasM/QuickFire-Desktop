package fm.DesignPatternAssignment.Timers;

import java.util.Timer;
import java.util.TimerTask;

import fm.DesignPatternAssignment.Controller;
import fm.DesignPatternAssignment.Displays.AnswerTimeDisplay;
import fm.DesignPatternAssignment.Displays.OptionDisplay;
import fm.DesignPatternAssignment.GameObjects.Player;
import fm.DesignPatternAssignment.GameOptions.GameOptions;
import fm.DesignPatternAssignment.GameOptions.OptionLists;
import fm.DesignPatternAssignment.UI.TextUI;
import fm.DesignPatternAssignment.Views.View;
import javafx.scene.layout.Pane;


public class MainGameTimer extends TimerTask {

	private Controller controller;
	private GameTime timerCountdown = new GameTime(5.0);
	private AnswerTimeDisplay answerTimeDisplay;
	
	
	public MainGameTimer(Controller controller) {
		this.controller = controller;
		this.answerTimeDisplay = controller.getModel().getAnswerTimeDisplay();
			
	}
	
	
	/**
	 * Game's main logic is executed here
	 */
	@Override
	public void run() {
		
		timerCountdown.Elapse(0.1);
		if(timerCountdown.timeReachedZero()) {
			this.cancel();
			TextUI timeText = (TextUI) answerTimeDisplay.getTime();
			timeText.setText("");
			
			Player player = controller.getModel().getPlayer();
			OptionDisplay optionDisplay = controller.getModel().getOptionDisplay();
			
			controller.showCorrectAnswer(optionDisplay.getCorrectOptionColour());
			boolean isPlayerCorrect = controller.checkPlayerAnswer();
			controller.hideUI();
			
			//If player chose the wrong answer
			if(!isPlayerCorrect) {
				controller.endGame();
			}
			
			
			
			try {
				Thread.sleep(3000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//Gives the player new question to answer
			if(isPlayerCorrect) {
				getNewQuestion();
			}
			
		}else{
			//Display the amount of time left to answer the question
			TextUI timeText = (TextUI) answerTimeDisplay.getTime();
			timeText.setText(timerCountdown.getSecondInString());
		}
		
	}
	
	/**
	 * gets the next question to display and restart the count down time if the player has not selected the wrong answer
	 */
	public void getNewQuestion() {
		controller.hideCorrectAnswer();
		timerCountdown.setSecond(5.0);
		OptionDisplay optionDisplay = controller.getModel().getOptionDisplay();
		GameOptions gameOption = OptionLists.getInstance().getRandomOption();
		controller.getModel().setCurrentGameOption(gameOption);
		
		optionDisplay.readOptionsData(gameOption);
		controller.showUI();
		//starts the count down timer again (This class run() function)
		new Timer().scheduleAtFixedRate(new MainGameTimer(controller), 0, 100);
	}
}
