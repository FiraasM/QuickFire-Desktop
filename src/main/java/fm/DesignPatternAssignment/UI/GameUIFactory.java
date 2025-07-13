package fm.DesignPatternAssignment.UI;

import javafx.scene.canvas.GraphicsContext;

public class GameUIFactory implements GameUIFactoryIF {
	
	private GraphicsContext gc;

	@Override
	public GameUI createProduct(String discrim, double x, double y, double width, double height) {
		if(discrim.equals("Rectangle"))
		{
			return new RectangleUI(x, y, width,height,gc);
		}
		
		if(discrim.equals("Circle"))
		{
			return new CircleUI(x, y, width,height,gc);
		}
		
		if(discrim.equals("Text"))
		{
			return new TextUI("Placeholder text", x, y, gc);
		}
		
		
		return null;
		
	}
	
	public GameUIFactory(GraphicsContext gc)
	{
		super();
		this.gc = gc;
	}



}
