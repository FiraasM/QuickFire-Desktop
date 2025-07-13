package fm.DesignPatternAssignment.UI;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public abstract class GameUI {
	
	protected Image img;
	protected double x,y;
	protected GraphicsContext gc;
	protected double width, height;
	
	protected double currentXOffset;
	protected double currentYOffset;
	protected double opacity;
	protected Color colour;
	
	
	public GameUI(double x, double y, double width, double height, GraphicsContext gc) {
		super();
		this.x = x;
		this.y = y;
		this.gc = gc;
		this.width = width;
		this.height = height;
		this.opacity = 1;
		this.colour = Color.WHITE;
	}
	
	public GameUI(double x, double y, GraphicsContext gc) {
		super();
		this.x = x;
		this.y = y;
		this.gc = gc;
		this.opacity = 1;
		this.colour = Color.WHITE;
	}


	public void update() 
	{
		
		
		if(img != null)
		{
			gc.drawImage(img, x, y, width, height);
		}
				
		
	}
	
	
	public void updateWithOffset(double offsetX, double offsetY) {
		this.x += offsetX;
		this.y += offsetY;
		this.currentXOffset = offsetX;
		this.currentYOffset = offsetY;
		this.update();
		this.x -= offsetX;
		this.y -= offsetY;
		
	}
	
	
	
	/**
	 * @return the currentXOffset
	 */
	public double getCurrentXOffset() {
		return currentXOffset;
	}

	/**
	 * @param currentXOffset the currentXOffset to set
	 */
	public void setCurrentXOffset(double currentXOffset) {
		this.currentXOffset = currentXOffset;
	}

	/**
	 * @return the currentYOffset
	 */
	public double getCurrentYOffset() {
		return currentYOffset;
	}

	/**
	 * @param currentYOffset the currentYOffset to set
	 */
	public void setCurrentYOffset(double currentYOffset) {
		this.currentYOffset = currentYOffset;
	}

	/**
	 * @return the img
	 */
	public Image getImg() {
		return img;
	}


	/**
	 * @param img the img to set
	 */
	public void setImg(Image img) {
		this.img = img;
	}


	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}


	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}


	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}


	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}


	/**
	 * @return the opacity
	 */
	public double getOpacity() {
		return opacity;
	}


	/**
	 * @param opacity the opacity to set
	 */
	public void setOpacity(double opacity) {
		this.opacity = opacity;
	}


	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @return the colour
	 */
	public Color getColour() {
		return colour;
	}

	/**
	 * @param colour the colour to set
	 */
	public void setColour(Color colour) {
		this.colour = colour;
	}
	
	
	
	

}
