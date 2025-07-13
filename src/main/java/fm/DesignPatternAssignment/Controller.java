package fm.DesignPatternAssignment;

import java.util.Timer;
import java.util.TimerTask;
import fm.DesignPatternAssignment.Displays.AnswerTimeDisplay;
import fm.DesignPatternAssignment.Displays.OptionDisplay;
import fm.DesignPatternAssignment.GameObjects.ColouredSquare;
import fm.DesignPatternAssignment.GameObjects.GameObjectsFactory;
import fm.DesignPatternAssignment.GameObjects.Player;
import fm.DesignPatternAssignment.GameOptions.GameOptions;
import fm.DesignPatternAssignment.GameOptions.OptionLists;
import fm.DesignPatternAssignment.Timers.GameCountdownTimer;
import fm.DesignPatternAssignment.Timers.MainGameTimer;
import fm.DesignPatternAssignment.Timers.UIAnimationTimer;
import fm.DesignPatternAssignment.UI.GameUI;
import fm.DesignPatternAssignment.UI.GameUIFactory;
import fm.DesignPatternAssignment.UI.RectangleUI;
import fm.DesignPatternAssignment.UI.TextUI;
import fm.DesignPatternAssignment.Views.GameOverView;
import fm.DesignPatternAssignment.Views.GameView;
import fm.DesignPatternAssignment.Views.InstructionsView;
import fm.DesignPatternAssignment.Views.StartView;
import fm.DesignPatternAssignment.Views.View;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * This class acts an intermediary between the model (data) and the view (UI). It handles the logic of the game
 * and makes updates to the model when necessary
 * 
 * This class uses a singleton design pattern to centralise control of the program
 */

public class Controller implements EventHandler<ActionEvent> {
	private static Controller instance = null;
	
	
	private Model model;
	private View view;
	
	private Controller() {
		super();
	
	}
	
	/**
	 * Gets an instance of the controller. Only 1 controller can be instantiated 
	 * @return Controller
	 */
	public static Controller getInstance() {
		
		if(instance == null) {
			instance = new Controller();
		}
		
		return instance;
	}
	
	/**
	 * Determines what happens when buttons are pressed by checking what view it came from and what button was pressed
	 */
	@Override
	public void handle(ActionEvent event) {
		
		//If the event came from pre-game screen
		if(this.view instanceof StartView) {
			StartView view = (StartView) this.view;
			//If play button has been clicked
			if(event.getSource() == view.getPlayButton()) {
				this.setView(new InstructionsView(this.getView().getScene(), this.getView().getRoot(), this.getView().getModel()));
				
				
				//To start the game on the main thread
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						Platform.runLater(() -> {setupAndStartGameCountdown();} );
					}
				},5000);
			};
			
		}
		
		
		//If the event came from Game over screen
		if(this.view instanceof GameOverView) {
			GameOverView view = (GameOverView) this.view;
			//If return to main screen button has been pressed
			if(event.getSource() == view.getReturnButton()) {
				this.goToMainScreen();
			};
			
		}
	}
	
	/*
	 * listens for key presses to allow players to move
	 */
	EventHandler<KeyEvent> onKeyPressed = new EventHandler<KeyEvent>() {
	    @Override
	    public void handle(KeyEvent keyEvent) {
	        if (keyEvent.getCode() == KeyCode.A) {
	            model.getPlayer().moveLeft();
	        }
	        
	        if (keyEvent.getCode() == KeyCode.W) {
	        	model.getPlayer().moveUp();
	        }
	        
	        if (keyEvent.getCode() == KeyCode.S) {
	        	model.getPlayer().moveDown();
	        }
	        
	        if (keyEvent.getCode() == KeyCode.D) {
	        	model.getPlayer().moveRight();
	        }
	    }
	};
	
	
	/*
	 * Handles the update to the UI of the game and checks what colour the player is standing on
	 */
AnimationTimer gameAnimationTimer = new AnimationTimer() {
		
		@Override
		public void handle(long arg0)
		{
			if(!model.isGameInProgress())
			{
				Controller controller = Controller.getInstance();
				gameAnimationTimer.stop();
				controller.goToGameOverScreen();
				
			}
			
			updateColourPlayerStandingOn();
			updateView();
			
		}
		
	};

	
	/*
	 * Handles the update to the UI of the pre-game screen
	 */
AnimationTimer mainScreenAnimationTimer = new AnimationTimer() {

		@Override
		public void handle(long arg0)
		{
			
			updateView();
			
		}
		
	};
	
	
	/*
	 * Switches to game view and initialises everything and starts the game's count down
	 */
	
	public void setupAndStartGameCountdown() {
		//Stops making UI updates to the pre-game screen
		this.mainScreenAnimationTimer.stop();
		
		//Clearing data from the previous game
		this.getModel().getGameObjects().clear();
		this.getModel().setOptionDisplay(null);
		this.getModel().setAnswerTimeDisplay(null);
		this.getModel().setGameScore(0);
		
		//Switches to game view
		setView(new GameView(this.view.getScene(), this.view.getRoot(), this.view.getModel()));
		
		initializeGameObjects();
		initializeGameOptionsUI();
		initializeGameAnswerTimeUI();
		//This function plays a part in displaying the question on the UI
		getAndDisplayRandomQuestion();
		this.model.setGameInProgress(true);
		gameAnimationTimer.start();
		
		//Starts the game count down sequence
		Timer gameCountdownTimer = new Timer();
		gameCountdownTimer.scheduleAtFixedRate(new GameCountdownTimer(this), 0, 1000);
		
	}
	
	/**
	 * initialises the 4 coloured squares and the player
	 */
	public void initializeGameObjects() {
		double squareSpacer = 50;
		double windowWidth = view.getRoot().getWidth();
		double windowHeight = view.getRoot().getHeight();
		
		GameObjectsFactory factory = new GameObjectsFactory(this.view.getGraphicsContext());
		
		
		ColouredSquare redSquare = (ColouredSquare) factory.createProduct("ColouredSquare", 0, 0, (windowWidth / 2) - squareSpacer, (windowHeight / 2) - squareSpacer);
		redSquare.setSquareColour(Color.RED);
		this.model.setRedSquare(redSquare);
		this.model.addGameObject(redSquare);
		
		ColouredSquare greenSquare = (ColouredSquare) factory.createProduct("ColouredSquare",(windowWidth / 2) + squareSpacer, 0, (windowWidth / 2) - squareSpacer, (windowHeight / 2) - squareSpacer);
		greenSquare.setSquareColour(Color.GREEN);
		this.model.setGreenSquare(greenSquare);
		this.model.addGameObject(greenSquare);
		
		ColouredSquare yellowSquare = (ColouredSquare) factory.createProduct("ColouredSquare",0 , (windowHeight / 2) + squareSpacer, (windowWidth / 2) - squareSpacer, (windowHeight / 2) - squareSpacer);
		yellowSquare.setSquareColour(Color.YELLOW);
		this.model.setYellowSquare(yellowSquare);
		this.model.addGameObject(yellowSquare);
		
		
		ColouredSquare blueSquare = (ColouredSquare) factory.createProduct("ColouredSquare",(windowWidth / 2) + squareSpacer, (windowHeight / 2) + squareSpacer, (windowWidth / 2) - squareSpacer, (windowHeight / 2) - squareSpacer);
		blueSquare.setSquareColour(Color.BLUE);
		this.model.setBlueSquare(blueSquare);
		this.model.addGameObject(blueSquare);
		
		Player player = (Player) factory.createProduct("Player", (windowWidth / 2) - 25, (windowHeight / 2) - 25, 50, 50);
		this.model.setPlayer(player);
		this.model.addGameObject(player);
		
	}
	
	/**
	 * Initialises the game UI which displays the question and options
	 * Grabs the first question 
	 */
	
	public void initializeGameOptionsUI() {
		double spacer = 50;
		double windowWidth = view.getRoot().getWidth();
		double windowHeight = view.getRoot().getHeight();
		
		GameUIFactory factory = new GameUIFactory(this.view.getGraphicsContext());
		OptionDisplay optionDisplay = new OptionDisplay();
		
		
		RectangleUI background = (RectangleUI) factory.createProduct("Rectangle", spacer, 0, windowWidth - (spacer*2), 100);
		background.setColour(Color.BLACK);
		background.setOpacity(0.7);
		optionDisplay.setBackground(background);
		
		this.model.setOptionDisplay(optionDisplay);
		
		
		double optionsXOffset = 80;
		double optionsY = 60;
		
		
		TextUI question = (TextUI) factory.createProduct("Text", (windowWidth/2) - 50 , 20, -1, -1);
		this.model.getOptionDisplay().setQuestion(question);
		
		
		
		TextUI optionRed = (TextUI) factory.createProduct("Text", optionsXOffset, optionsY, -1, -1);
		RectangleUI redSquare = (RectangleUI) factory.createProduct("Rectangle", optionRed.getTextCenterX(), optionRed.getY() + 10, 25, 20);
		redSquare.setColour(Color.RED);
		this.model.getOptionDisplay().setOptionRed(optionRed);
		this.model.getOptionDisplay().setRedSquare(redSquare);
		
		
		
		
		TextUI optionGreen = (TextUI) factory.createProduct("Text", optionsXOffset * 3 , optionsY, -1, -1);
		RectangleUI greenSquare = (RectangleUI) factory.createProduct("Rectangle", optionGreen.getTextCenterX(), optionGreen.getY() + 10, 25, 20);
		greenSquare.setColour(Color.GREEN);
		this.model.getOptionDisplay().setOptionGreen(optionGreen);
		this.model.getOptionDisplay().setGreenSquare(greenSquare);
		
		
		
		
		TextUI optionBlue = (TextUI) factory.createProduct("Text", optionsXOffset * 5 , optionsY, -1, -1);
		RectangleUI blueSquare = (RectangleUI) factory.createProduct("Rectangle", optionBlue.getTextCenterX(), optionBlue.getY() + 10, 25, 20);
		blueSquare.setColour(Color.BLUE);
		this.model.getOptionDisplay().setOptionBlue(optionBlue);
		this.model.getOptionDisplay().setBlueSquare(blueSquare);
		
		
		
		TextUI optionYellow = (TextUI) factory.createProduct("Text", optionsXOffset * 7 , optionsY, -1, -1);
		RectangleUI yellowSquare = (RectangleUI) factory.createProduct("Rectangle", optionYellow.getTextCenterX(), optionYellow.getY() + 10, 25, 20);
		yellowSquare.setColour(Color.YELLOW);
		this.model.getOptionDisplay().setOptionYellow(optionYellow);
		this.model.getOptionDisplay().setYellowSquare(yellowSquare);
		
		
		
		
		
		
	}
	
	
	/**
	 * Gets a random question to display on the UI
	 */
	public void getAndDisplayRandomQuestion() {
		//Grabs a random option to display as the first question
		GameOptions option = OptionLists.getInstance().getRandomOption();
		//Reads the option into the UI
		this.model.getOptionDisplay().readOptionsData(option);
		this.model.setCurrentGameOption(option);
	}
	
	/**
	 * Initialises the game UI which displays the time left for a question
	 * 
	 */
	public void initializeGameAnswerTimeUI() {
		Pane root = view.getRoot();
		GameUIFactory factory = new GameUIFactory(view.getGraphicsContext());
		
		AnswerTimeDisplay answerTimeDisplay = new AnswerTimeDisplay();
		model.setAnswerTimeDisplay(answerTimeDisplay);
		
		
		RectangleUI background = (RectangleUI) factory.createProduct("Rectangle", 350, 500, 100, 100);
		background.setColour(Color.PINK);
		background.setOpacity(0.5);
		answerTimeDisplay.setBackground(background);
		
		
		TextUI countdownText = (TextUI) factory.createProduct("Text", 27, 63, 0, 0);
		countdownText.setFontSize(45);
		countdownText.setText("5.0s");
		answerTimeDisplay.setTime(countdownText);
	}
	
	/*
	 * Allows the player to move
	 */
	public void registerMoveEvent() {
		this.view.getScene().addEventHandler(KeyEvent.KEY_PRESSED, onKeyPressed);
	}
	
	/*
	 * Stops the player from being able to move
	 */
	public void removeMoveEvent() {
		this.view.getScene().removeEventHandler(KeyEvent.KEY_PRESSED, onKeyPressed);
	}
	

	
	/*
	 * Update the controller's current view
	 */
	public void updateView() {
		view.updateView();
	}

	
	

	/*
	 * Starts the game (After the count down)
	 */
	public void startGame() {
		registerMoveEvent();
		
		Timer gameTimer = new Timer();
		gameTimer.scheduleAtFixedRate(new MainGameTimer(this), 0, 100);

	}
	
	/*
	 * Goes to pre-game view
	 * Sets up the event for play button being pressed
	 * AnimationTimer to play the pre-game background animation is also called
	 */
	public void goToMainScreen() {
		setView(new StartView(this.getView().getScene(), this.getView().getRoot(), this.getView().getModel()));
		((StartView) this.view).getPlayButton().setOnAction(this);
		this.mainScreenAnimationTimer.start();
	}
	
	/*
	 * changes the view to game over screen
	 */
	public void goToGameOverScreen(){
		setView(new GameOverView(this.getView().getScene(), this.getView().getRoot(), this.getView().getModel()));
		((GameOverView) this.view).getReturnButton().setOnAction(this);
		
	}
	
	
	

	/*
	 * Logic to store what colour the player is standing on
	 * This is used to check what answer the player has selected
	 */
public void updateColourPlayerStandingOn() {
	Player player = model.getPlayer();
	
	if(player.isIntersectingWith(model.getRedSquare()))
		player.setColourStandingOn(Color.RED);
	else if(player.isIntersectingWith(model.getGreenSquare()))
		player.setColourStandingOn(Color.GREEN);
	else if(player.isIntersectingWith(model.getBlueSquare()))
		player.setColourStandingOn(Color.BLUE);
	else if(player.isIntersectingWith(model.getYellowSquare()))
		player.setColourStandingOn(Color.YELLOW);
	else
		player.setColourStandingOn(null);
	
}

/*
 * This checks if the player is standing on the colour corresponding to the correct answer
 */
public boolean checkPlayerAnswer() {
	OptionDisplay optionDisplay = model.getOptionDisplay();
	Player player = model.getPlayer();
	//If the player selects the colour corresponding to the correct answer
	if(optionDisplay.getCorrectOptionColour() == player.getColourStandingOn()) {
		AudioPlayer.playAudio("correct.wav");
		model.incrementGameScore(1);
		return true;
	}
	
	return false;
}


/*
 * Shows the correct answer by turning the specified correct square to stand on to green and the rest to red
 * @param correctColour		The correct colour to stand on
 */
public void showCorrectAnswer(Color correctColour) {
	ColouredSquare redSquare = model.getRedSquare();
	ColouredSquare greenSquare = model.getGreenSquare();
	ColouredSquare blueSquare = model.getBlueSquare();
	ColouredSquare yellowSquare = model.getYellowSquare();
	
	
	if(redSquare.getSquareColour() == correctColour) {
		redSquare.changeDisplayedColour(Color.LIME);
	}else {
		redSquare.changeDisplayedColour(Color.ORANGERED);
	}
	
	if(greenSquare.getSquareColour() == correctColour) {
		greenSquare.changeDisplayedColour(Color.LIME);
	}else {
		greenSquare.changeDisplayedColour(Color.ORANGERED);
	}
	
	if(blueSquare.getSquareColour() == correctColour) {
		blueSquare.changeDisplayedColour(Color.LIME);
	}else {
		blueSquare.changeDisplayedColour(Color.ORANGERED);
	}
	
	if(yellowSquare.getSquareColour() == correctColour) {
		yellowSquare.changeDisplayedColour(Color.LIME);
	}else {
		yellowSquare.changeDisplayedColour(Color.ORANGERED);
	}
	
}

/*
 * Reverts the coloured square to their default colour
 */
public void hideCorrectAnswer() {
	ColouredSquare redSquare = model.getRedSquare();
	ColouredSquare greenSquare = model.getGreenSquare();
	ColouredSquare blueSquare = model.getBlueSquare();
	ColouredSquare yellowSquare = model.getYellowSquare();
	
	redSquare.changeDisplayedColour(redSquare.getSquareColour());
	greenSquare.changeDisplayedColour(greenSquare.getSquareColour());
	blueSquare.changeDisplayedColour(blueSquare.getSquareColour());
	yellowSquare.changeDisplayedColour(yellowSquare.getSquareColour());
}

/*
 * The game ends when the player chooses the wrong answer
 * Stops the player from moving
 */
public void endGame() {
	removeMoveEvent();
	AudioPlayer.playAudio("incorrect.wav");
	model.getPlayer().playDeadSequence();
	//Lets the other part of the program know the game has ended
	model.setGameInProgress(false);
	
	}


/*
 * Hides all of the game UIs with animations
 */
public void hideUI() {
	
	GameUI optionDisplayParentUI = this.model.getOptionDisplay().getBackground();
	GameUI answerTimeDisplayParentUI = this.model.getAnswerTimeDisplay().getBackground();
	Timer animationTimer = new Timer();
	animationTimer.scheduleAtFixedRate(new UIAnimationTimer(answerTimeDisplayParentUI, optionDisplayParentUI, "hide"), 0, 50);
	
	
}

/*
 * Shows all of the game UIs with animations
 */
public void showUI() {
	GameUI optionDisplayParentUI = this.model.getOptionDisplay().getBackground();
	GameUI answerTimeDisplayParentUI = this.model.getAnswerTimeDisplay().getBackground();
	Timer animationTimer = new Timer();
	animationTimer.scheduleAtFixedRate(new UIAnimationTimer(answerTimeDisplayParentUI, optionDisplayParentUI, "show"), 0, 50);
}
	

/**
 * @return view - current view of the controller
 */
public View getView() {
	return view;
}

/**
 * @return model 
 */
public Model getModel() {
	return model;
}

/**
 * @param model 
 */
public void setModel(Model model) {
	this.model = model;
}

/**
 * @param view 
 */
public void setView(View view) {
	this.view = view;
}


	
	
	
	
	
	

}
