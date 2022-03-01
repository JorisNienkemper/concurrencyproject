package com.infosupport.threads;

import com.infosupport.concurrencyutils.StopWatch;
import org.jooq.lambda.Unchecked;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ThreadsTests {

    @Test
    @DisplayName("  Hopefully a more efficient use of the processors")
    void howLongDoesTake(){
        long duration = StopWatch.meseaureDuration(Unchecked.runnable(() ->{
            ElephantThread elephantThread = new ElephantThread();
            elephantThread.start();
            LionThread lionThread = new LionThread();
            lionThread.start();
            MonkeyThread monkeyThread = new MonkeyThread();
            monkeyThread.start();

            elephantThread.join();
            lionThread.join();
            monkeyThread.join();
        }));
        System.out.println("Duration is " + duration);
    }
}
