package com.infosupport.sequential;


import static com.infosupport.concurrencyutils.Sleeper.sleepInMs;

public class Sequential {
    public String getElephant() {
        sleepInMs(5000);
        return "Elephant";
    }

    public String getLion() {
        sleepInMs(3000);
        return "Lion";
    }

    public String getMonkey() {
        sleepInMs(2000);
        return "Monkey";
    }
}
