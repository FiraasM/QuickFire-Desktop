package fm.DesignPatternAssignment.Timers;

import java.util.TimerTask;

import fm.DesignPatternAssignment.NumberAnimator;
import fm.DesignPatternAssignment.UI.GameUI;

/**
 * This is used to animate UI hiding and revealing sequence
 */
public class UIAnimationTimer extends TimerTask {


		private GameUI answerTimeDisplayParentUI;
		private GameUI optionDisplayParentUI;
		private String action;
		
		
		public UIAnimationTimer(GameUI answerTimeDisplayParentUI, GameUI optionDisplayParentUI, String action) {
			super();
			this.answerTimeDisplayParentUI = answerTimeDisplayParentUI;
			this.optionDisplayParentUI = optionDisplayParentUI;
			this.action = action;
		}


		@Override
		public synchronized void run() {
			
			
			if(this.action == "hide") {
				
				double optionDisplayY = optionDisplayParentUI.getY();
				double optionDisplayFinalValue = animateValue(optionDisplayY, -200);
				double answerTimeDisplayY = answerTimeDisplayParentUI.getY();
				double answerTimeDisplayFinalValue = animateValue(answerTimeDisplayY, 700);
				
				optionDisplayParentUI.setY(optionDisplayFinalValue);
				answerTimeDisplayParentUI.setY(answerTimeDisplayFinalValue);
				
				if(optionDisplayFinalValue <= -105 && answerTimeDisplayFinalValue >= 605) {
					this.cancel();
					optionDisplayParentUI.setY(-100);
					answerTimeDisplayParentUI.setY(600);
				}
					
			}else {
				
				if(this.action == "show") {
					double optionDisplayY = optionDisplayParentUI.getY();
					double optionDisplayFinalValue = animateValue(optionDisplayY, 50);
					double answerTimeDisplayY = answerTimeDisplayParentUI.getY();
					double answerTimeDisplayFinalValue = animateValue(answerTimeDisplayY, 450);
					
					optionDisplayParentUI.setY(optionDisplayFinalValue);
					answerTimeDisplayParentUI.setY(answerTimeDisplayFinalValue);
					
					if(optionDisplayFinalValue >= 0 && answerTimeDisplayFinalValue <= 500) {
						this.cancel();
						optionDisplayParentUI.setY(0);
						answerTimeDisplayParentUI.setY(500);
					}
					
				}
			}
			
			
			
		}
		
		
		public double animateValue(double start, double end) {
			return new NumberAnimator().easeIn(start, end);
		}
		
}
		

