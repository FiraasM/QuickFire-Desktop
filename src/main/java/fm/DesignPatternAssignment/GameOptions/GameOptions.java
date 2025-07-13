package fm.DesignPatternAssignment.GameOptions;

import javafx.scene.paint.Color;

/**
 * This class stores data about questions, their corresponding options and the correct answer
 * 
 * This demonstrates encapsulation, where the data and the methods related to them are binded within a single class
 * Making it easier to understand, maintain, and reuse
 */

public class GameOptions {
	private String question;
	private String optionRed;
	private String optionGreen;
	private String optionBlue;
	private String optionYellow;
	private Color correctOptionColour;
	
	
	public GameOptions(String question, String optionRed, String optionGreen, String optionBlue, String optionYellow, Color correctOptionColour) {
		super();
		this.question = question;
		this.optionRed = optionRed;
		this.optionGreen = optionGreen;
		this.optionBlue = optionBlue;
		this.optionYellow = optionYellow;
		this.correctOptionColour = correctOptionColour;
	}


	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * Returns the correct answer based on its correctOptionColour
	 * e.g if optionYellow is 'oxygen' and correctOptionColour is Color.Yellow, 'oxygen' is returned
	 * @return	Correct answer
	 */
	public String getCorrectAnswer() {
		if(correctOptionColour == Color.RED)
			return optionRed;
		else if (correctOptionColour == Color.GREEN)
			return optionGreen;
		else if (correctOptionColour == Color.BLUE)
			return optionBlue;
		else
			return optionYellow;
	}


	/**
	 * @return the optionRed
	 */
	public String getOptionRed() {
		return optionRed;
	}


	/**
	 * @return the optionGreen
	 */
	public String getOptionGreen() {
		return optionGreen;
	}


	/**
	 * @return the optionBlue
	 */
	public String getOptionBlue() {
		return optionBlue;
	}


	/**
	 * @return the optionYellow
	 */
	public String getOptionYellow() {
		return optionYellow;
	}


	/**
	 * @return the correctOptionColour
	 */
	public Color getCorrectOptionColour() {
		return correctOptionColour;
	}
	
	
	
	
	

}
