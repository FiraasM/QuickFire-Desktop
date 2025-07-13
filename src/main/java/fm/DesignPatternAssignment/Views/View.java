package fm.DesignPatternAssignment.Views;

import fm.DesignPatternAssignment.Model;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public abstract class View {
	protected Scene scene;
	protected Pane root;
	protected Model model;
	
	protected Canvas canvas;
	


	protected GraphicsContext gc;
	
	
	
	public View(Scene scene, Pane root, Model model) {
		super();
		this.scene = scene;
		this.root = root;
		this.model = model;
		canvas = new Canvas(root.getWidth(),root.getHeight());
		gc = canvas.getGraphicsContext2D();
		
	}
	
	public void updateView() {
		
	}

	public Pane getRoot() {
		return root;
	}

	public Model getModel() {
		return model;
	}
	
	
	public GraphicsContext getGraphicsContext() {
		return gc;
	}
	
	/**
	 * @return the scene
	 */
	public Scene getScene() {
		return scene;
	}
	
	
	
	

}
