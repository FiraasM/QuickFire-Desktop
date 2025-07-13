package fm.DesignPatternAssignment.Displays;

import fm.DesignPatternAssignment.UI.GameUI;
import fm.DesignPatternAssignment.UI.TextUI;
/**
 * A ui to display the time left to answer the question
 */
public class AnswerTimeDisplay {
	private GameUI background;
	private GameUI time;
	
	
	
	public void updateAllChildWithOffset(double offsetX, double offsetY) {
		TextUI timeText = (TextUI) time;
		timeText.updateWithOffset(offsetX, offsetY);
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
	 * @return the time
	 */
	public GameUI getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(GameUI time) {
		this.time = time;
	}
	
	
	
}
