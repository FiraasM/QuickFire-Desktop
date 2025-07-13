package fm.DesignPatternAssignment.UI;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TextUI extends GameUI {
	private String text;
	private double actualTextX;
	private Font font;
	
	

	public TextUI(String text, double x, double y, GraphicsContext gc) {
		super(x, y, gc);
		this.text = text;
		this.actualTextX = x;
		this.colour = Color.WHITE;
		this.font = new Font(12);
		
	}
	
	
	
	
	
	@Override
	public void update() 
	{
		gc.setFill(colour);
		gc.setGlobalAlpha(opacity);
		gc.setFont(font);
		gc.fillText(text, x, y);
	}
	
	
	public void setFontSize(double fontSize) {
		this.font = new Font(fontSize);
	}
	
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
	public int getTextLength() {
		return text.length();
	}
	
	public double getTextCenterX() {
		return x + (3 * text.length()) + 40;//(x + ((3 * text.length()))) / 2;
	}
	
	public double getBelowTextYWithOffset(double offsetY) {
		return y + offsetY + 11;
	}
	
	public double getTextCenterXWithOffset(double offsetX) {
		return x + offsetX + (3 * text.length()) - 10;//(x + ((3 * text.length()))) / 2;
	}
	



	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
		this.setX(actualTextX - (3 * text.length()));
	}



}
