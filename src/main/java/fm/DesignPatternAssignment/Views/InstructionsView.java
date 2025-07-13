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
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class InstructionsView extends View {


	

	
	public InstructionsView(Scene scene, Pane root, Model model) {
		super(scene, root, model);
		Image img = new Image(this.getClass().getResourceAsStream("instructions.png"));
		
		gc.drawImage(img, 0, 0, root.getWidth(), root.getHeight());
		
//		gc.setFill(Color.RED);
//		gc.fillRect(0, 0, 1000, 600);
		
		root.getChildren().addAll(canvas);
		
		
		
	}
	
	
	
	





	
	
	
	

}
