package tasktimer;

public class StopWatch {
	private static long startTime;
	private static long stopTime;
	private boolean running;
	
	public static void start(){
		startTime = System.nanoTime();
	}
	
	public static void stop(){
		stopTime = System.nanoTime();
	}
	
	public static double getElapsed(){
		
		return (stopTime - startTime)*1.0E-9;
	}
}
