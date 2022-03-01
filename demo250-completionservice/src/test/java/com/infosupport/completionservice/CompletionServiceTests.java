package com.infosupport.completionservice;

import com.infosupport.concurrencyutils.StopWatch;
import com.infosupport.sequential.Sequential;
import org.jooq.lambda.Unchecked;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class CompletionServiceTests {

    @Test
    @DisplayName(" Submit callables to the executorservice")
    void submitAnimals() throws ExecutionException, InterruptedException {

        long duration = StopWatch.meseaureDuration(Unchecked.runnable(() -> {
            Sequential sequential = new Sequential();
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            CompletionService<String> completionService = new ExecutorCompletionService<String>(executorService);

            Callable<String> callable2 = () -> sequential.getLion();
            Callable<String> callable3 = () -> sequential.getMonkey();
            Callable<String> callable1 = () -> sequential.getElephant();

            completionService.submit(callable2);
            completionService.submit(callable3);
            completionService.submit(callable1);

            for (int i = 0; i < 3; i++) {
                Future<String> take = completionService.take();
                System.out.println(take.get());
            }


        }));
        System.out.println("Running for " + duration );

    }
}
