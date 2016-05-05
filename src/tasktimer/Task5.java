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
public class Task5 implements Runnable {
	
	static final int MAXCOUNT = 50_000;
	
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
        
        String result = "";
        String word = null;
        int count = 0;
        try {
            while( (word=br.readLine()) != null && count < MAXCOUNT) {
                result = result + word;
                count++;
            }
        } catch(IOException ioe) { System.out.println( ioe.getMessage() ); }
        System.out.printf("Done appending %d words to string.\n", count);
	}
	
	/**
	 * This method is used to describe the task
	 */
	public String toString(){
		return "Starting task: append "+MAXCOUNT+" words to a String using +";
	}

}
