package com.infosupport.cancable;

import com.infosupport.concurrencyutils.Sleeper;

public class CancelFlagRunnable implements Runnable {
    private static  volatile   boolean cancelled;

    @Override
    public void run() {
        long counter = 0;
        while(!cancelled) {
           // System.out.println("Very important work");
            counter++;
        }
        System.out.println("cancelled after " + counter + " counts");
    }

    public static void cancel() {
        cancelled = true;
    }

    public static void main(String[] args) throws InterruptedException {
        CancelFlagRunnable cancelFlag = new CancelFlagRunnable();

        Thread thread = new Thread(cancelFlag);

        thread.start();

        Sleeper.sleepInMs(100);

        CancelFlagRunnable.cancel();

        thread.join();
    }

}