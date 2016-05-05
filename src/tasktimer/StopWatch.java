package tasktimer;

/**
 * 
 * @author Thanut Sajjakulnukit (5810545416)
 *
 */
public class StopWatch {
	private static long startTime;
	private static long stopTime;
	private boolean running;
	
	/**
	 * This method is used to measure the time before run the program
	 */
	public static void start(){
		startTime = System.nanoTime();
	}
	
	/**
	 * This method is used to measure the time after run the program
	 */
	public static void stop(){
		stopTime = System.nanoTime();
	}
	
	/**
	 * This method is used to calculate the time that it used
	 * @return stop time minus start time ,so it is the time interval that each program used
	 */
	public static double getElapsed(){
		return (stopTime - startTime) * 1.0E-9;
	}
}
