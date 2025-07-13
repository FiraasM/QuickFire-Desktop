package fm.DesignPatternAssignment.Timers;

/**
 * Class which can be used to manipulate time
 * Mainly used for count down displays for this project
 */
public class GameTime {
	
	protected double second;
	
	public GameTime(double second) {
		this.second = second;
	}
	
	
	
	/**
	 * @return the second
	 */
	public double getSecond() {
		return second;
	}
	
	

	/**
	 * @param second the second to set
	 */
	public void setSecond(double second) {
		this.second = second;
	}



	public String getSecondInString() {
		String secondString = second + "";
		int stringLength = secondString.length();
		int i = 0;
		while(i < stringLength) {
			if(secondString.charAt(i) == '.') {
				secondString = secondString.substring(0, i + 2);
				break;
			}
			i++;
		}
			
		return secondString + "s";
	}


	public void Elapse(double d) {
		this.second -= d;
	}
	
	public boolean timeReachedZero() {
		return second <= 0;
	}

}
