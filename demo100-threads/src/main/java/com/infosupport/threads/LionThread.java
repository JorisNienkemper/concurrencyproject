package com.infosupport.threads;

import static com.infosupport.concurrencyutils.Sleeper.sleepInMs;

public class LionThread extends Thread {
    private String getLion() {
        sleepInMs(3000);
        return "Lion";
    }

    @Override
    public void run() {
        getLion();
    }
}