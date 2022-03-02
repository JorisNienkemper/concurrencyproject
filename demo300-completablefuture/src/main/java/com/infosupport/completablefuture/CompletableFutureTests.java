package com.infosupport.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

public class CompletableFutureTests {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> textBuildInSteps =
                CompletableFuture
                        //hard asynchronous work:
                        .supplyAsync(() ->{
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            return "Johan";})
                        .thenApply( arg -> arg)
                        //hard asynchronous work on SingleThreadExecutor:
                        .thenApplyAsync(name -> "Hello " + name, newSingleThreadExecutor())
                        .thenApply( arg -> arg)
                        //hard asynchronous work on default ForkJoinPool:
                        .thenApplyAsync(grt -> grt + " welcome to the near future!");

        System.out.println(textBuildInSteps.get());
    }
}
