package com.infosupport.completionservice;

import com.infosupport.concurrencyutils.StopWatch;
import com.infosupport.sequential.Sequential;
import org.jooq.lambda.Unchecked;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ExecutorServiceTests {

    @Test
    @DisplayName(" submit callables to executerservice ")
    void submitAnimals() throws ExecutionException, InterruptedException {

        long duration = StopWatch.meseaureDuration(Unchecked.runnable(() -> {
            Sequential sequential = new Sequential();
            ExecutorService executorService = Executors.newFixedThreadPool(3);


            Callable<String> callable1 = () -> sequential.getElephant();
            Callable<String> callable2 = () -> sequential.getLion();
            Callable<String> callable3 = () -> sequential.getMonkey();

            Future<String> submit1 = executorService.submit(callable1);
            Future<String> submit2 = executorService.submit(callable2);
            Future<String> submit3 = executorService.submit(callable3);

            String result = submit1.get() + " " + submit2.get() + " " + submit3.get();

            System.out.println(result);

            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);

        }));
        System.out.println("Running for " + duration );
    }
}
