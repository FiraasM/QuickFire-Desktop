package fm.DesignPatternAssignment.GameObjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public abstract class GameObject {
	
	protected Image img;
	//The location of the object
	protected double x,y;
	protected GraphicsContext gc;
	protected double width, height;
	//Rectangle is used for collision checking to check what colour the player is standing on
	protected Rectangle r;
	
	
	
	/**
	 * Creates an object based on the given parameters
	 * 
	 * @param x		default horizontal location of the object
	 * @param y		default vertical location of the object
	 * @param gc
	 */
	public GameObject(double x, double y, GraphicsContext gc) {
		super();
		this.x = x;
		this.y = y;
		this.gc = gc;
		this.width = 50;
		this.height = 50;
		this.r = new Rectangle(x,y, width, height);
		
	}
	
	
	/**
	 * Creates an object based on the given parameters
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param gc
	 */
	public GameObject(double x, double y, double width, double height, GraphicsContext gc) {
		super();
		this.x = x;
		this.y = y;
		this.gc = gc;
		this.width = width;
		this.height = height;
		this.r = new Rectangle(x,y, width, height);
	}
	
	/**
	 * Updates rectangle for accurate collision checks
	 */
	public void updateRectangle() {
		r.setX(x);
		r.setY(y);
		r.setWidth(width);
		r.setHeight(height);
	}
	
		
	/**
	 * draws the object onto the game's view
	 */
	public void update()
	{
		updateRectangle();
		gc.setGlobalAlpha(1.0);
		if(img != null)
		{
			gc.drawImage(img, x, y, width, height);
		}
		
		
			
		
	}
	
	/**
	 * Checks if this object intersects with the specified object
	 * @param obj	the object to check intersection with
	 * @return	whether this object intersects with the specified object
	 */
	public boolean isIntersectingWith(GameObject obj) {
		if(r.intersects(obj.x, obj.y, obj.width, obj.height)) {
			return true;
		}
		
		return false;
	}
	
	
	
	

}
