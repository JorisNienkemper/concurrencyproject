package com.infosupport.forkjoin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.*;

class ForkJoinSumCalculatorTest {

    @Test
    @DisplayName("    Forkjoin example")
    void calculateSum(){
        long[] numbers = LongStream.rangeClosed(0L, 1_000_000L)
                .toArray();
        ForkJoinSumCalculator fjSum =
                new ForkJoinSumCalculator(numbers);
        Long sum = new ForkJoinPool().invoke(fjSum);
        System.out.println(sum);


    }

    @Test
    @DisplayName("displayName")
    void methodName(){
        //Arrange
        //Where do we find the fork and join?
        IntStream.rangeClosed(0,1_000_000).parallel().peek(a -> System.out.println(a)).sum();
    }

}