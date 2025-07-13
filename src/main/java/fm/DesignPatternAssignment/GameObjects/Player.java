package fm.DesignPatternAssignment.GameObjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Player extends GameObject {
	
	private Color colourStandingOn = null;
	private Color playerColor;
	
	private double speedX;
	private double speedY;
	private double speedLimit;
	
	private boolean isPlayerDead;

	public Player(double x, double y, double width, double height, GraphicsContext gc) {
		super(x, y, width, height, gc);
		this.playerColor = Color.PINK;
		this.speedX = 0;
		this.speedY = 0;
		this.isPlayerDead = false;
		this.speedLimit = 5;
		
	}
	
	public void moveRight() {
		this.speedX += 0.75;
	}
	
	public void moveLeft() {
		this.speedX -= 0.75;
	}
	
	public void moveUp() {
		this.speedY -= 0.75;
	}
	
	public void moveDown() {
		this.speedY += 0.75;
	}
	
	
	
	
	@Override
	public void update() {
		checkSpeed();
		checkBounds();
		super.update();
		applyFriction(0.1);
		this.x += speedX;
		this.y += speedY;
		gc.setFill(this.playerColor);
		gc.fillOval(x, y, width, height);

	}
	
	/**
	 * ensures the player can't go at an inappropriate speed
	 */
	public void checkSpeed() {
		if(speedX > speedLimit)
			speedX = speedLimit;
		
		if(speedX < -speedLimit)
			speedX = -speedLimit;
		
		if(speedY > speedLimit)
			speedY = speedLimit;
		
		if(speedY < -speedLimit)
			speedY = -speedLimit;
		
		
	}
	
	public void checkBounds() {
		if(!isPlayerDead) {
			
		
		if(x > 810)
			x = -10;
		
		if(x < -10)
			x = 810;
		
		if(y > 610)
			y = -10;
		
		if(y < -10)
			y = 610;
		}
			
	}
	
	/**
	 * slows down the player when no key is pressed
	 * @param friction
	 */
	public void applyFriction(double friction) {
		if(speedX < 0.3 && speedX > -0.3)
			speedX = 0;
		
		if(speedY < 0.3 && speedY > -0.3)
			speedY = 0;
		
		
		if(speedX >= 0.3) {
			speedX -= friction;
		}
		
		if(speedX <= -0.3) {
			speedX += friction;
		}
		
		if(speedY >= 0.3) {
			speedY -= friction;
		}
		
		if(speedY <= -0.3) {
			speedY += friction;
		}
	}
	
	/**
	 * Lets the user know he picked the wrong answer
	 */
	public void playDeadSequence() {
		try {
			isPlayerDead = true;
			for(int i = 1; i<=3; i++) {
				this.playerColor = Color.RED;
				Thread.sleep(500);
				this.playerColor = Color.PINK;
				Thread.sleep(500);
			}
			
			
			int animationSpeed = 5;
			while(width <= 2000) {
				Thread.sleep(25);
				this.x -= (animationSpeed/2);
				this.y -= (animationSpeed / 2);
				this.width += animationSpeed;
				this.height += animationSpeed;
				animationSpeed += 2;
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the colourStandingOn
	 */
	public Color getColourStandingOn() {
		return colourStandingOn;
	}

	/**
	 * @param colourStandingOn the colourStandingOn to set
	 */
	public void setColourStandingOn(Color colourStandingOn) {
		this.colourStandingOn = colourStandingOn;
	}
	
	

	

}
