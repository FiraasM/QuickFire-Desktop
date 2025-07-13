package fm.DesignPatternAssignment.GameObjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Laser extends GameObject {
	

	public Laser(double x, double y, GraphicsContext gc) {
		super(x, y, gc);
		update();
	}
	
	
	static double dx = 1, yOffset=0;
	double yStart = y;
	
	@Override
	public void update() 
	{
		x += dx;
		y = yStart + yOffset;
		
		if(x>800 || x<0) {
			dx=-dx;
			yOffset+=30;
		}
		super.update();
		
	}

	

}
