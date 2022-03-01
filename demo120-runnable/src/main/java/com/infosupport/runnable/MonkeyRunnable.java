package com.infosupport.runnable;

import static com.infosupport.concurrencyutils.Sleeper.sleepInMs;

public class MonkeyRunnable implements Runnable {
    private String getMonkey() {
        sleepInMs(2000);
        return "Monkey";
    }

    @Override
    public void run() {
        getMonkey();
    }
}