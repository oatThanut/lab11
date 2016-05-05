package tasktimer;

import static java.lang.System.out;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import tasktimer.TaskTimer.IntCounter;

/**
 * 
 * @author Thanut Sajjakulnukit (5810545416)
 *
 */
public class Task3 implements Runnable {
	
	/**
	 * This is the run method of this task to read wordlist.txt file and processing
	 * to find average word length
	 */
	public void run() {
		BufferedReader br = null;
        try {
            br = new BufferedReader( new InputStreamReader(Dictionary.getWordsAsStream()) );
        } catch (Exception ex) {
            out.println("Could not open dictionary: "+ex.getMessage());
            return;
        }
        long totalsize = 0;
        long count = 0;
        // This code uses Java's IntStream.average() method.
        // But there is no way to also get the count of items.
        // averageLength = br.lines().mapToInt( (word) -> word.length() ).average().getAsDouble();
        // So instead we write out own IntConsumer to count and average the stream,
        // and use our IntConsumer to "consume" the stream.
        IntCounter counter = new IntCounter();
        br.lines().mapToInt( word -> word.length() ).forEach( counter );
        // close the input
        try {
            br.close();
        } catch(IOException ex) { /* ignore it */ }
        out.printf("Average length of %,d words is %.2f\n",counter.getCount(), counter.average() );
	}
	
	/**
	 * This method is used to describe the task
	 */
	public String toString(){
		return "Starting task: read words using BufferedReader and Stream";
	}
}
