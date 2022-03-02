package com.infosupport.forkjoin;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    private long[] numbers;
    private int start;
    private int end;
    private static AtomicInteger callNumber = new AtomicInteger(0);

    public static final long THRESHOLD = 10_000;

    public ForkJoinSumCalculator(long[] numbers) {
        super();
        this.numbers = numbers;
        start = 0;
        end = numbers.length;
    }

    public ForkJoinSumCalculator(long[] numbers, int start, int eind) {
        System.out.printf("callNumber  %4d start =  %d  einde = %d\n",
                callNumber.getAndIncrement(), start, eind);
        this.numbers = numbers;
        this.start = start;
        this.end = eind;
    }
    @Override
    protected Long compute() {
        int length=end-start;
        if(length<THRESHOLD)
            return sumCalculateSequentially();

        ForkJoinSumCalculator leftTask =
                new ForkJoinSumCalculator(numbers,start,start+(length/2));
        leftTask.fork();
        ForkJoinSumCalculator rightTask =
                new ForkJoinSumCalculator(numbers, start + length/2, end);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }
    private Long sumCalculateSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}