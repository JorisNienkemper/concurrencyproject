package com.infosupport.concurrencyutils;

public class Sleeper {

    public static void sleepInMs(long sleepDuration){
        try {
            Thread.sleep(sleepDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
