package tasktimer;

import static java.lang.System.out;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Thanut Sajjakulnukit (5810545416)
 *
 */
public class Task2 implements Runnable {
	
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
        
        try {
            int count = 0;
            long totalsize = 0;
            String word = null;
            while( (word=br.readLine()) != null ) {
                totalsize += word.length();
                count++;
            }
            double averageLength = ((double)totalsize)/(count>0 ? count : 1);
            out.printf("Average length of %,d words is %.2f\n", count, averageLength);  
        } catch(IOException ioe) {
            out.println(ioe);
            return;
        } finally {
            try { br.close(); } catch (Exception ex) { /* ignore it */ }
        }
	}
	
	/**
	 * This method is used to describe the task
	 */
	public String toString(){
		return "Starting task: read words using BufferedReader.readLine() with a loop";
	}
}
