package fm.DesignPatternAssignment;

import java.util.ArrayList;

import fm.DesignPatternAssignment.Displays.AnswerTimeDisplay;
import fm.DesignPatternAssignment.Displays.OptionDisplay;
import fm.DesignPatternAssignment.GameObjects.ColouredSquare;
import fm.DesignPatternAssignment.GameObjects.GameObject;
import fm.DesignPatternAssignment.GameObjects.Player;
import fm.DesignPatternAssignment.GameOptions.GameOptions;
import fm.DesignPatternAssignment.Timers.GameTime;
import fm.DesignPatternAssignment.UI.GameUI;
import fm.DesignPatternAssignment.UI.TextUI;

public class Model {
	private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	
	
	private boolean isGameInProgress = false;
	private int GameScore;
	
	//Game objects
	private ColouredSquare redSquare;
	private ColouredSquare greenSquare;
	private ColouredSquare blueSquare;
	private ColouredSquare yellowSquare;
	private Player player;
	
	//Stores info about  what question is currently being displayed
	private GameOptions currentGameOption;
	
	
	
	//The UIs
	private OptionDisplay optionDisplay;
	private AnswerTimeDisplay answerTimeDisplay;
	private TextUI countdownText;
	private GameUI mainScreenBackground;
	
	
	
	
	
	
	
	

	/**
	 * @return the currentGameOption
	 */
	public GameOptions getCurrentGameOption() {
		return currentGameOption;
	}

	/**
	 * @param currentGameOption the currentGameOption to set
	 */
	public void setCurrentGameOption(GameOptions currentGameOption) {
		this.currentGameOption = currentGameOption;
	}

	/**
	 * @return the mainScreenBackground
	 */
	public GameUI getMainScreenBackground() {
		return mainScreenBackground;
	}

	/**
	 * @param mainScreenBackground the mainScreenBackground to set
	 */
	public void setMainScreenBackground(GameUI mainScreenBackground) {
		this.mainScreenBackground = mainScreenBackground;
	}

	/**
	 * @return the isGameInProgress
	 */
	public boolean isGameInProgress() {
		return isGameInProgress;
	}

	/**
	 * @param isGameInProgress the isGameInProgress to set
	 */
	public void setGameInProgress(boolean isGameInProgress) {
		this.isGameInProgress = isGameInProgress;
	}

	/**
	 * @return the countdownText
	 */
	public TextUI getCountdownText() {
		return countdownText;
	}

	/**
	 * @param countdownText the countdownText to set
	 */
	public void setCountdownText(TextUI countdownText) {
		this.countdownText = countdownText;
	}
	
	
	
	/**
	 * @return the answerTimeDisplay
	 */
	public AnswerTimeDisplay getAnswerTimeDisplay() {
		return answerTimeDisplay;
	}

	/**
	 * @param answerTimeDisplay the answerTimeDisplay to set
	 */
	public void setAnswerTimeDisplay(AnswerTimeDisplay answerTimeDisplay) {
		this.answerTimeDisplay = answerTimeDisplay;
	}

	/**
	 * @return the optionDisplay
	 */
	public OptionDisplay getOptionDisplay() {
		return optionDisplay;
	}

	/**
	 * @param optionDisplay the optionDisplay to set
	 */
	public void setOptionDisplay(OptionDisplay optionDisplay) {
		this.optionDisplay = optionDisplay;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return the redSquare
	 */
	public ColouredSquare getRedSquare() {
		return redSquare;
	}

	/**
	 * @param redSquare the redSquare to set
	 */
	public void setRedSquare(ColouredSquare redSquare) {
		this.redSquare = redSquare;
	}

	/**
	 * @return the greenSquare
	 */
	public ColouredSquare getGreenSquare() {
		return greenSquare;
	}

	/**
	 * @param greenSquare the greenSquare to set
	 */
	public void setGreenSquare(ColouredSquare greenSquare) {
		this.greenSquare = greenSquare;
	}

	/**
	 * @return the blueSquare
	 */
	public ColouredSquare getBlueSquare() {
		return blueSquare;
	}

	/**
	 * @param blueSquare the blueSquare to set
	 */
	public void setBlueSquare(ColouredSquare blueSquare) {
		this.blueSquare = blueSquare;
	}

	/**
	 * @return the yellowSquare
	 */
	public ColouredSquare getYellowSquare() {
		return yellowSquare;
	}

	/**
	 * @param yellowSquare the yellowSquare to set
	 */
	public void setYellowSquare(ColouredSquare yellowSquare) {
		this.yellowSquare = yellowSquare;
	}


	
	

	public void addGameObject(GameObject obj) {
		gameObjects.add(obj);
	}

	public ArrayList<GameObject> getGameObjects() {
		return gameObjects;
	}
	
	

	public void setGameObjects(ArrayList<GameObject> gameObjects) {
		this.gameObjects = gameObjects;
	}

	public int getGameScore() {
		return GameScore;
	}

	public void setGameScore(int gameScore) {
		GameScore = gameScore;
	}
	
	public void incrementGameScore(int gameScore) {
		GameScore += gameScore;
	}
	
	

}
