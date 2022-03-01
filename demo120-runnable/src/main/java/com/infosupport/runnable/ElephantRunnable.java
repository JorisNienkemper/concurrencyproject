package com.infosupport.runnable;

import static com.infosupport.concurrencyutils.Sleeper.sleepInMs;

public class ElephantRunnable implements Runnable {
    private String getElephant() {
        sleepInMs(5000);
        return "Elephant";
    }

    @Override
    public void run() {
        getElephant();

    }
}