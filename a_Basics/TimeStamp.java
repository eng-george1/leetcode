package a_Basics;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TimeStamp {
    public static void main(String[] args) {
        //to get the timestamp 
        long currentTime = System.currentTimeMillis();
        //to run schedular 
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
    }
}
