package com.antonakospanos.playground.complexity;

import java.text.NumberFormat;
import java.util.stream.LongStream;

public class TimeComplexity {

    private static final long N = 10_000_000_000L;
    private static long COUNTER = 0;

    public static void main(String[] args) {
        checkTimeComplexity();
    }

    /**
     * Prints the computation's Time Complexity using the Big O Notation of the input's size N
     */
    public static void checkTimeComplexity() {
        double avgTime;
        long[] times = new long[10];

        // 10 times for validation
        for (int i = 0; i < 10; i++) {
            times[i] = calculateTimeComplexity();
        }

        avgTime = LongStream.of(times).average().getAsDouble();
        System.out.println();
        System.out.println("Average computation = " + NumberFormat.getInstance().format(avgTime) + " milliseconds");
    }

    /**
     * Prints the computation's Time Complexity using the Big O Notation of the input's size N
     */
    private static long calculateTimeComplexity() {
        long start = System.currentTimeMillis();
        computation();
        long end = System.currentTimeMillis();

        long time = end - start;
        System.out.println("Computation = " + NumberFormat.getInstance().format(time) + " milliseconds");

        return time;
    }

    /**
     * 1000   	  ->        1 msecs
     * 10_000     ->	   50 msecs ~(50*1)      // n * 10 -> time * 50
     * 100_000    ->    4.500 msecs ~(100*50)    // n * 10 -> time * 100
     * 1_000_000  ->  440,118 msecs ~(100*4.500) // n * 10 -> time * 100
     *
     * Big O Notation is O(n*n), that is Quadratic!
     *
     * a) Constant with c = 10, that is O(10)? No, it's not a constant time growth!
     * b) Logarithmic, that is O(logn)? No, it's greater than linear growth!
     * c) Linear, that is O(n)? No, it's not a linear time growth!
     * c) Quasilinear, that is O(n logn)? No, its quadratic!
     * d) Quadratic, that is O(n*n)? Yes!
     * e) Cube, that is O(n*n*n)? Nope.
     * f) Exponetional, that is O(c^n)? Nope.
     */
    private static void computation() {
        for (long i = 0; i < N; i++) {
            nestedComputation();
        }
    }

    /**
     * 1_000_000      ->      1 msec
     * 10_000_000     ->      5 msecs ~(5*1)     // n * 10 -> time * 5
     * 100_000_000    ->     45 msecs ~(10*5)    // n * 10 -> time * 10
     * 1_000_000_000  ->    450 msecs ~(10*45)   // n * 10 -> time * 10
     * 10_000_000_000 ->  4.700 msecs ~(10*450)  // n * 10 -> time * 10
     *
     * Big O Notation is O(n), that is LINEAR!
     *
     * a) Constant with c = 10, that is O(10)? No, it's not a constant time growth!
     * b) Logarithmic, that is O(logn)? No, it's linear growth!
     * c) Linear, that is O(n)? Yes!
     * c) Quasilinear, that is O(n logn)? Nope.										(merge sort, quick sort, etc.)
     * d) Quadratic, that is O(n*n)? Nope.                                			(bubble sort, etc.)
     * e) Cube, that is O(n*n*n)? Nope.
     * f) Exponential, that is O(c^n)? Nope.
     */
    private static void nestedComputation() {
        for (long i = 0; i < N; i++) {
            operation();
        }
    }

    /**
     * time = 0ms
     */
    private static void operation () {
        COUNTER++;
    }
}
