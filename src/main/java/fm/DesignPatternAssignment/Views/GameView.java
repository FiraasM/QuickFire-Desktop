package fm.DesignPatternAssignment.Views;
import fm.DesignPatternAssignment.Model;
import fm.DesignPatternAssignment.Displays.AnswerTimeDisplay;
import fm.DesignPatternAssignment.Displays.OptionDisplay;
import fm.DesignPatternAssignment.GameObjects.GameObject;
import fm.DesignPatternAssignment.UI.GameUI;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameView extends View {
	
	
	public GameView(Scene scene, Pane root, Model model) {
		super(scene, root, model);
		
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, root.getWidth(), root.getHeight());
		
		root.getChildren().addAll(canvas);
		
		
	}
	
	
	
	
	
	
	
	public void updateView() {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, root.getWidth(), root.getHeight());
		
		for(GameObject obj : this.getModel().getGameObjects())
		{
			obj.update();
		}
		
		OptionDisplay optionDisplay = this.getModel().getOptionDisplay();
		GameUI optionDisplayBackground = optionDisplay.getBackground();
		optionDisplayBackground.update();
		double offsetX = optionDisplayBackground.getX();
		double offsetY = optionDisplayBackground.getY();
		optionDisplay.updateAllChildWithOffset(offsetX, offsetY);
		
		AnswerTimeDisplay answerTimeDisplay = this.getModel().getAnswerTimeDisplay();
		GameUI answerTimeDisplayBackground = answerTimeDisplay.getBackground();
		answerTimeDisplayBackground.update();
		offsetX = answerTimeDisplayBackground.getX();
		offsetY = answerTimeDisplayBackground.getY();
		answerTimeDisplay.updateAllChildWithOffset(offsetX, offsetY);
		
		if(model.getCountdownText() != null) {
			model.getCountdownText().update();
		}
		
	}
	
	
	
	
	
	

}
