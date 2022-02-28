package com.infosupport.threads;

import static com.infosupport.concurrencyutils.Sleeper.sleepInMs;

public class MonkeyThread extends Thread {
    private String getMonkey() {
        sleepInMs(2000);
        return "Monkey";
    }

    @Override
    public void run() {
        getMonkey();
    }
}