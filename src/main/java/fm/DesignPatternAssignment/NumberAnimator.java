package fm.DesignPatternAssignment;

/**
 * This class manipulates value to create smooth animations of UIs
 */
public class NumberAnimator {

	public double exponentialAnimation(double number) {
		
		return number * 2;
	}
	
	public double easeIn(double start, double end) {
		double finalValue = start;
		
		
		if(end > start) {
			double difference = end - start;
			if(difference >= 1000)
				finalValue += 100;
			else if (difference >= 500)
				finalValue += 50;
			else if(difference >= 250) 
				finalValue += 25;
			else if (difference >= 125)
				finalValue += 12.5;
			else 
				finalValue += 5;
			
		}else {
			double difference = start - end;
			if(difference >= 1000)
				finalValue -= 100;
			else if (difference >= 500)
				finalValue -= 50;
			else if(difference >= 250) 
				finalValue -= 25;
			else if (difference >= 125)
				finalValue -= 12.5;
			else 
				finalValue -= 5;
			
		}
		
		
		
		return finalValue;
	}
	
	
	
}
