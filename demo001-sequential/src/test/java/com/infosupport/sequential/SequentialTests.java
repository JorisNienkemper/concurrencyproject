package com.infosupport.sequential;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.infosupport.concurrencyutils.StopWatch.meseaureDuration;

public class SequentialTests {

    @Test
    @DisplayName("    An inefficient way to use our resources ")
    void doSomeWork(){
        long duration = meseaureDuration(()->{
            Sequential sequential = new Sequential();
            sequential.getElephant();
            sequential.getLion();
            sequential.getMonkey();
        });
        System.out.println("Work done in " + duration + "ms");
    }


}
