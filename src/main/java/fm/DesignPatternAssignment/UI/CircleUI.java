package fm.DesignPatternAssignment.UI;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CircleUI extends GameUI {
	
	

	public CircleUI(double x, double y, double width, double height, GraphicsContext gc) {
		super(x, y, width, height, gc);
		
	}
	
	
	@Override
	public void update() 
	{
		gc.setFill(colour);
		gc.setGlobalAlpha(opacity);
		gc.fillOval(x, y, width, height);
	}
	
	
	
	


}
