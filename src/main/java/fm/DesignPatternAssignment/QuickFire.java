package fm.DesignPatternAssignment;


import fm.DesignPatternAssignment.Views.StartView;
import fm.DesignPatternAssignment.Views.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class QuickFire extends Application {
	Pane root;
	Scene scene;
	
	int WindowWidth = 800;
	int WindowHeight = 600;
	
	View view;
	Model model;
	Controller controller;
	
	public static void main(String[] args) {
		launch(args);

	}

	/*
	 * Starts the application
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("QuickFire");
		root = new Pane();
		scene = new Scene(root, WindowWidth, WindowHeight);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		model = new Model();
		view = new StartView(scene, root, model);
		
		
		controller = Controller.getInstance();
		controller.setModel(model);
		controller.setView(view);
		controller.goToMainScreen();
		
		
		
		
		
		
	}
	
	
	

}
