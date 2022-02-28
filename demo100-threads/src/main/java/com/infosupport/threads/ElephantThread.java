package com.infosupport.threads;

import static com.infosupport.concurrencyutils.Sleeper.sleepInMs;

public class ElephantThread extends Thread {
    private String getElephant() {
        sleepInMs(5000);
        return "Elephant";
    }

    @Override
    public void run() {
        getElephant();
    }
}