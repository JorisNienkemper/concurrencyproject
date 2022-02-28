package com.infosupport.concurrencyutils;

public class StopWatch {

    public static long meseaureDuration(Runnable runnable) {
        long startTime = System.currentTimeMillis();
        runnable.run();
        long endTime = System.currentTimeMillis();
        return endTime -startTime;
    }
}
