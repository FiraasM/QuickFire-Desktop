package fm.DesignPatternAssignment.GameObjects;

/**
 * interface for creating objects
 */
public interface GameObjectFactoryIF {

	GameObject createProduct(String discrim, double x, double y, double width, double height);
	
}
