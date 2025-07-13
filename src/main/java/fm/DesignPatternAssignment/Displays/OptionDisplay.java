package fm.DesignPatternAssignment.Displays;

import fm.DesignPatternAssignment.GameOptions.GameOptions;
import fm.DesignPatternAssignment.UI.GameUI;
import fm.DesignPatternAssignment.UI.TextUI;
import javafx.scene.paint.Color;
/**
 * UI to display the question and the options the player have
 */
public class OptionDisplay {
	private GameUI background;
	private GameUI question;
	
	private GameUI optionRed;
	private GameUI redSquare;
	
	
	private GameUI optionGreen;
	private GameUI greenSquare;
	
	private GameUI optionYellow;
	private GameUI yellowSquare;
	
	private GameUI optionBlue;
	private GameUI blueSquare;
	
	private Color correctOptionColour;
	
	/**
	 * Updates the UI based on the option given
	 * @param option 	
	 */
	public void readOptionsData(GameOptions option) {
		TextUI questionText = (TextUI) question;
		TextUI optionRedText = (TextUI) optionRed;
		TextUI optionGreenText = (TextUI) optionGreen;
		TextUI optionBlueText = (TextUI) optionBlue;
		TextUI optionYellowText = (TextUI) optionYellow;
		
		//Updates the UI to display the next question and its options using the new 'GameOptions' passed
		questionText.setText(option.getQuestion());
		optionRedText.setText(option.getOptionRed());
		optionGreenText.setText(option.getOptionGreen());
		optionBlueText.setText(option.getOptionBlue());
		optionYellowText.setText(option.getOptionYellow());
		
		this.correctOptionColour = option.getCorrectOptionColour();
		
		
	}
	
	public void updateAllChildWithOffset(double offsetX, double offsetY) {
		question.updateWithOffset(offsetX, offsetY);
		
		TextUI optionRedText = (TextUI) optionRed;
		optionRedText.updateWithOffset(offsetX, offsetY);
		redSquare.setX(optionRedText.getTextCenterXWithOffset(offsetX));
		redSquare.setY(optionRedText.getBelowTextYWithOffset(offsetY));
		redSquare.update();
		
		TextUI optionGreenText = (TextUI) optionGreen;
		optionGreenText.updateWithOffset(offsetX, offsetY);
		greenSquare.setX(optionGreenText.getTextCenterXWithOffset(offsetX));
		greenSquare.setY(optionGreenText.getBelowTextYWithOffset(offsetY));
		greenSquare.update();
		
		TextUI optionYellowText = (TextUI) optionYellow;
		optionYellowText.updateWithOffset(offsetX, offsetY);
		yellowSquare.setX(optionYellowText.getTextCenterXWithOffset(offsetX));
		yellowSquare.setY(optionYellowText.getBelowTextYWithOffset(offsetY));
		yellowSquare.update();
		
		TextUI optionBlueText = (TextUI) optionBlue;
		optionBlueText.updateWithOffset(offsetX, offsetY);
		blueSquare.setX(optionBlueText.getTextCenterXWithOffset(offsetX));
		blueSquare.setY(optionBlueText.getBelowTextYWithOffset(offsetY));
		blueSquare.update();
	}
	

	/**
	 * @return the background
	 */
	public GameUI getBackground() {
		return background;
	}

	/**
	 * @param background the background to set
	 */
	public void setBackground(GameUI background) {
		this.background = background;
	}

	/**
	 * @return the question
	 */
	public GameUI getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(GameUI question) {
		this.question = question;
	}

	/**
	 * @return the optionRed
	 */
	public GameUI getOptionRed() {
		return optionRed;
	}

	/**
	 * @param optionRed the optionRed to set
	 */
	public void setOptionRed(GameUI optionRed) {
		this.optionRed = optionRed;
	}

	/**
	 * @return the optionGreen
	 */
	public GameUI getOptionGreen() {
		return optionGreen;
	}

	/**
	 * @param optionGreen the optionGreen to set
	 */
	public void setOptionGreen(GameUI optionGreen) {
		this.optionGreen = optionGreen;
	}

	/**
	 * @return the optionYellow
	 */
	public GameUI getOptionYellow() {
		return optionYellow;
	}

	/**
	 * @param optionYellow the optionYellow to set
	 */
	public void setOptionYellow(GameUI optionYellow) {
		this.optionYellow = optionYellow;
	}

	/**
	 * @return the optionBlue
	 */
	public GameUI getOptionBlue() {
		return optionBlue;
	}

	/**
	 * @param optionBlue the optionBlue to set
	 */
	public void setOptionBlue(GameUI optionBlue) {
		this.optionBlue = optionBlue;
	}

	/**
	 * @return the redSquare
	 */
	public GameUI getRedSquare() {
		return redSquare;
	}

	/**
	 * @param redSquare the redSquare to set
	 */
	public void setRedSquare(GameUI redSquare) {
		this.redSquare = redSquare;
	}

	/**
	 * @return the greenSquare
	 */
	public GameUI getGreenSquare() {
		return greenSquare;
	}

	/**
	 * @param greenSquare the greenSquare to set
	 */
	public void setGreenSquare(GameUI greenSquare) {
		this.greenSquare = greenSquare;
	}

	/**
	 * @return the yellowSquare
	 */
	public GameUI getYellowSquare() {
		return yellowSquare;
	}

	/**
	 * @param yellowSquare the yellowSquare to set
	 */
	public void setYellowSquare(GameUI yellowSquare) {
		this.yellowSquare = yellowSquare;
	}

	/**
	 * @return the blueSquare
	 */
	public GameUI getBlueSquare() {
		return blueSquare;
	}

	/**
	 * @param blueSquare the blueSquare to set
	 */
	public void setBlueSquare(GameUI blueSquare) {
		this.blueSquare = blueSquare;
	}

	/**
	 * @return the correctOptionColour
	 */
	public Color getCorrectOptionColour() {
		return correctOptionColour;
	}

	/**
	 * @param correctOptionColour the correctOptionColour to set
	 */
	public void setCorrectOptionColour(Color correctOptionColour) {
		this.correctOptionColour = correctOptionColour;
	}
	
	
	
	
	
	
	

}