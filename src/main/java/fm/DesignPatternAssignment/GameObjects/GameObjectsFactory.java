package fm.DesignPatternAssignment.GameObjects;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * allows the mass production of objects
 */
public class GameObjectsFactory implements GameObjectFactoryIF {
	
	GraphicsContext gc;

	/**
	 * Creates object based on the discriminator provided
	 */
	@Override
	public GameObject createProduct(String discrim, double x, double y, double width, double height) {
		if(discrim.equals("Laser"))
		{
			return new Laser(x,y,gc);
		}
		
		
		if(discrim.equals("ColouredSquare")) {
			return new ColouredSquare(x, y, width, height, gc);
		}
		
		if(discrim.equals("Player")) {
			return new Player(x, y, width, height, gc);
		}
		
		return null;
		
	}
	
	public GameObjectsFactory(GraphicsContext gc)
	{
		super();
		this.gc = gc;
	}



}
