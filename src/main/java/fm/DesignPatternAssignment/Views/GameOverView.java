package fm.DesignPatternAssignment.Views;

import fm.DesignPatternAssignment.Model;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameOverView extends View {
	
	private Text gameOverText;
	private Text correctAnswerText;
	private Text answerText;
	private Text scoreText;
	private Button returnButton;
	
	

	
	public GameOverView(Scene scene, Pane root, Model model) {
		super(scene, root, model);
		
		double TextPosX = (root.getWidth() / 2) - 125;
		double TextPosY = (root.getHeight() / 4);
		gameOverText = new Text(TextPosX, TextPosY, "Game over!");
		gameOverText.setFont(new Font(50));
		
		correctAnswerText = new Text(TextPosX - 10, TextPosY + 100, "The correct answer was: ");
		correctAnswerText.setFont(new Font(25));
		
		//actualTextX - (3 * text.length())
		String correctAnswer = this.getModel().getCurrentGameOption().getCorrectAnswer();
		answerText = new Text(TextPosX + 98 - (3.1 * correctAnswer.length()), TextPosY + 140, correctAnswer);
		answerText.setFont(new Font(25));
		answerText.setFill(Color.GREEN);
		
		scoreText = new Text(TextPosX + 80, TextPosY + 180, "Score: " + model.getGameScore());
		scoreText.setFont(new Font(25));
		
		gc.setFill(Color.PINK);
		gc.fillRect(0, 0, root.getWidth(), root.getHeight());
		
		returnButton = new Button("Return back to main screen");
		returnButton.setLayoutX((root.getWidth()/2) - 103);
		returnButton.setLayoutY(root.getHeight()/2 + 80);
		returnButton.setPrefSize(200, 50);
		
		root.getChildren().addAll(canvas, gameOverText, correctAnswerText, answerText, scoreText, returnButton);
		
		
	}
	
	
	public Button getReturnButton() {
		return returnButton;
	}
	
	
	
	

}
