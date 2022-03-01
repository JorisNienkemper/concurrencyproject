package com.infosupport.cancable;

import com.infosupport.concurrencyutils.Sleeper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CancelFlagTest {

    @Test
    @DisplayName("    Cancel a long running task    ")
    void cancelTask() throws InterruptedException {
        CancelFlagRunnable cancelFlag = new CancelFlagRunnable();


        Thread thread = new Thread(cancelFlag);

        thread.start();

        Sleeper.sleepInMs(10);

        CancelFlagRunnable.cancel();

        thread.join();

    }
}