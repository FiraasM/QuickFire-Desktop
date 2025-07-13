package fm.DesignPatternAssignment.Views;

import java.util.Timer;

import fm.DesignPatternAssignment.Model;
import fm.DesignPatternAssignment.Timers.MainScreenAnimationTimer;
import fm.DesignPatternAssignment.UI.CircleUI;
import fm.DesignPatternAssignment.UI.GameUI;
import fm.DesignPatternAssignment.UI.GameUIFactory;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StartView extends View {
	
	private Text text;
	private Button playButton;


	

	
	public StartView(Scene scene, Pane root, Model model) {
		super(scene, root, model);
		
		double TextPosX = (root.getWidth() / 2) - 100;
		double TextPosY = (root.getHeight() / 4);
		text = new Text(TextPosX, TextPosY, "QuickFire");
		text.setFont(new Font(50));
		
		GameUIFactory factory = new GameUIFactory(gc);
		CircleUI circle = (CircleUI) factory.createProduct("Circle", 400, 290, 0, 0);
		this.getModel().setMainScreenBackground(circle); 
		
		Timer animationTimer = new Timer();
		animationTimer.scheduleAtFixedRate(new MainScreenAnimationTimer(circle),0, 40);
		
		
		gc.setFill(Color.PINK);
		gc.fillRect(0, 0, root.getWidth(), root.getHeight());
		
		circle.update();
		
		playButton = new Button("Start Game");
		playButton.setLayoutX((root.getWidth()/2) - 45);
		playButton.setLayoutY(root.getHeight()/2 - 45);
		playButton.setPrefSize(100, 50);
		
		root.getChildren().addAll(canvas, text, playButton);
		
		
	}
	
	
	
	
	@Override
	public void updateView() {
		super.updateView();
		this.getModel().getMainScreenBackground().update();	
	}




	public Button getPlayButton() {
		return playButton;
	}
	
	
	
	

}
