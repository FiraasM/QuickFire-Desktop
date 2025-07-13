package fm.DesignPatternAssignment.GameObjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class ColouredSquare extends GameObject {
	private Color SquareColour;
	private Color displayedColour;
	

	public ColouredSquare(double x, double y, double width, double height, GraphicsContext gc) {
		super(x, y, width, height, gc);
		this.SquareColour = Color.RED;
		this.displayedColour = Color.RED;
	}
	
	
	
	@Override
	public void update() 
	{
		super.update();
		gc.setFill(displayedColour);
		gc.fillRect(x, y, width, height);
	}



	/**
	 * @return the squareColour
	 */
	public Color getSquareColour() {
		return SquareColour;
	}



	/**
	 * @param squareColour the squareColour to set
	 */
	public void setSquareColour(Color squareColour) {
		this.SquareColour = squareColour;
		changeDisplayedColour(squareColour);
	}
	
	/*
	 * This changes the colour of the square without changing the square's actual colour value
	 * This is mainly used to display the correct answer
	 */
	public void changeDisplayedColour(Color squareColour) {
		this.displayedColour = squareColour;
	}
	

	
	


	

}
