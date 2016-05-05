package tasktimer;

import static java.lang.System.out;
import java.util.Scanner;

/**
 * 
 * @author Thanut Sajjakulnukit (5810545416)
 */
public class Task1 implements Runnable {
	
	/**
	 * This is the run method of this task to read wordlist.txt file and processing
	 * to find average word length
	 */
	public void run(){
		Scanner in = new Scanner(Dictionary.getWordsAsStream());
        // perform the task
        int count = 0;
        long totalsize = 0;
        while(in.hasNext()) {
            String word = in.next();
            totalsize += word.length();
            count++;
        }
        double averageLength = ((double)totalsize)/(count>0 ? count : 1);
        out.printf("Average length of %,d words is %.2f\n", count, averageLength);
	}
	
	/**
	 * This method is used to describe the task
	 */
	public String toString(){
		return "Starting task: read words using Scanner and a while loop";
	}
}
