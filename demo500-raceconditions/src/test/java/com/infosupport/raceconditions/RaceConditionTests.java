package com.infosupport.raceconditions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceConditionTests {

    @Test
    @DisplayName("Race conditions")
    void whatIsGoingOn() throws InterruptedException {
        Counter counter = new Counter();
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    synchronized (this) {
                        int count1 = counter.getCount();
                        System.out.println(count1);
                        counter.increment();
                        int count2 = counter.getCount();
                        assertThat(count2 - count1 == 1).isTrue();
                    }
                }
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        assertThat(counter.getCount()).isEqualTo(40000);
    }
}
class Counter {
    private int count = 0;

    public synchronized void increment() {
        int localCount = getCount();
        localCount += 1;
        this.count = localCount;
    }
    public  int getCount() {
        return count;
    }
}