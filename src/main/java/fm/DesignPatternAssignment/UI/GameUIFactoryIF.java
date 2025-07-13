package fm.DesignPatternAssignment.UI;

public interface GameUIFactoryIF {

	GameUI createProduct(String discrim, double x, double y, double width, double height);
	
}
