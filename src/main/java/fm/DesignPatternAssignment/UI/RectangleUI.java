package fm.DesignPatternAssignment.UI;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RectangleUI extends GameUI {

	

	public RectangleUI(double x, double y, double width, double height, GraphicsContext gc) {
		super(x, y, width, height, gc);
		
	}
	
	
	@Override
	public void update() 
	{
		gc.setFill(colour);
		gc.setGlobalAlpha(opacity);
		gc.fillRect(x, y, width, height);
	}
	
	
	
	
	

}
