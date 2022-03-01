package com.infosupport.runnable;

import static com.infosupport.concurrencyutils.Sleeper.sleepInMs;

public class LionRunnable implements Runnable {
    private String getLion() {
        sleepInMs(3000);
        return "Lion";
    }

    @Override
    public void run() {
        getLion();
    }
}