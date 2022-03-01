package com.infosupport.runnable;

import com.infosupport.concurrencyutils.StopWatch;
import com.infosupport.sequential.Sequential;
import org.jooq.lambda.Unchecked;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RunnableTests {

    @Test
    @DisplayName("    Use Parallellism with Runnables ")
    void goingParallel() {
        long duration = StopWatch.meseaureDuration(Unchecked.runnable(() -> {
            Thread thread1 = new Thread(new ElephantRunnable());
            thread1.start();
            Thread thread2 = new Thread(new LionRunnable());
            thread2.start();
            Thread thread3 = new Thread(new MonkeyRunnable());
            thread3.start();

            thread1.join();
            thread2.join();
            thread3.join();
        }));
        System.out.println("Duration is " + duration);
    }
    
    @Test
    @DisplayName("Using Sequential class")
    void howDoWeSleep(){
        long duration = StopWatch.meseaureDuration(Unchecked.runnable(() -> {
            Sequential sequential = new Sequential();
            Runnable runnable1 = () -> {
                sequential.getElephant();
            };
            Runnable runnable2 = () -> {
                sequential.getLion();
            };
            Runnable runnable3 = () -> {
                sequential.getMonkey();
            };

            Thread thread1 = new Thread(runnable1);
            thread1.start();
            Thread thread2 = new Thread(runnable2);
            thread2.start();
            Thread thread3 = new Thread(runnable3);
            thread3.start();

            thread1.join();
            thread2.join();
            thread3.join();
        }));
        System.out.println("Duration is " + duration);
    }
}
