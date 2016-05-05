package tasktimer;

import static java.lang.System.out;
import java.util.Scanner;
import java.io.*;
import java.util.function.IntConsumer;
import java.util.function.Consumer;
import java.util.concurrent.atomic.*;  // hack, using AtomicInteger as accumulator

/**
 * Time how long it takes to perform some tasks
 * using different programming constructs.
 * @author Thanut Sajjakulnukit (5810545416)
 */
public class TaskTimer
{
    private static String DICTIONARY = "wordlist.txt";
    
    /**
     * This method is used to run the task
     * @param task is task that you want to run the program
     */
    public static void execAndPrint(Runnable task){
    	System.out.println(task.toString());
    	StopWatch.start();
    	task.run();
    	StopWatch.stop();
    	out.printf("Elapsed time is %f sec\n",StopWatch.getElapsed());
    }
    
    /** 
     * Define a customer Consumer class that computes <b>both</b> the average 
     * and count of values.
     * An IntConsumer is a special Consumer interface the has an 'int' parameter 
     * in accept().
     */
    static class IntCounter implements IntConsumer {
        // count the values
        public int count = 0;
        // total of the values
        private long total = 0;
        /** accept consumes an int. In this method, count the value and add it to total. */
        public void accept(int value) { count++; total += value; }
        /** Get the average of all the values consumed. */
        public double average() { 
            return (count>0) ? ((double)total)/count : 0.0;
        }
        public int getCount() { return count; }
    }
        
    /** Run all the tasks. */
    public static void main(String [] args) {
    	execAndPrint(new Task1());
    	execAndPrint(new Task2());
    	execAndPrint(new Task3());
    	execAndPrint(new Task4());
    	execAndPrint(new Task5());
    	execAndPrint(new Task6());
    }
    
}
