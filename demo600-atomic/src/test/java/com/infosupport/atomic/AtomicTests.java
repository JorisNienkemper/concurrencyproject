package com.infosupport.atomic;

import org.jooq.lambda.Unchecked;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class AtomicTests {

    private AtomicInteger currentValue = new AtomicInteger(0);
    private AtomicInteger lastValue = new AtomicInteger(0);

    @Test
    @DisplayName("Atomic types")
    void atomicInteger() throws InterruptedException {
        Runnable runnable = Unchecked.runnable(() -> incrementCurrentValue());

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int run = 0; run < 20; run++) {

            executorService.execute(runnable);
        }

        executorService.shutdown();

        executorService.awaitTermination(2, TimeUnit.SECONDS);

        System.out.println("Current Value: " + currentValue);
        System.out.println("Last Value: " + lastValue);
    }

    public void incrementCurrentValue() throws InterruptedException {
        currentValue.incrementAndGet();
        //sleep(1000);
        if (currentValue.get() > 1 &&
                currentValue.get() - lastValue.get() == 2) {
            lastValue = new AtomicInteger(currentValue.get() - 1);
        } else if (currentValue.get() > 1) {
            lastValue = new AtomicInteger(42);
        }
    }
}


