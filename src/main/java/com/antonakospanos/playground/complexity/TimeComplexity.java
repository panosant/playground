package com.antonakospanos.playground.complexity;

import java.text.NumberFormat;
import java.util.stream.LongStream;

public class TimeComplexity {

    private static final long N = 1_000_000L;
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
     * 10_000     ->	   50 msecs ~(50*1)
     * 100_000    ->    4.500 msecs ~(100*50)
     * 1_000_000  ->  400.500 msecs ~(100*50)
     *
     * Big O Notation:
     *
     * It's Quadratic O(n*n) cause:
     *
     * a) Constant with c = 10, that is O(10)? No, it's not a constant time growth!
     * b) Logarithmic, that is O(logn)? Hmm..
     * c) Linear, that is O(n)? No, it's not a linear time growth!
     * c) Quasilinear, that is O(n logn)? Hmm..
     * d) Quadratic, that is O(n*n)? Yes! With n =
     * e) Cube, that is O(n*n*n)? Nope.
     * f) Exponetional, that is O(c^n)? Nope.
     */
    private static void computation() {
        for (long i = 0; i < N; i++) {
            nestedComputation();
        }
    }

    /**
     * 1_000   	- >       100 msecs
     * 10_000   - >       300 msecs ~(3*100)
     * 100_000  - >       900 msecs ~(3*300)
     * 1_000_000  - >   4.900 msecs ~(5*900)
     * 10_000_000 - >  35.884 msecs ~(7*900)
     *
     *
     * Big O Notation:
     *
     * It's LINEAR O(n) cause:
     *
     * a) Constant with c = 10, that is O(10)? No, it's not a constant time growth!
     * b) Logarithmic, that is O(logn)? Hmm..
     * c) Linear, that is O(n)? Yes! With n =
     * c) Quasilinear, that is O(n logn)? Hmm..											(merge sort, quick sort, etc.)
     * d) Quadratic, that is O(n*n)? No, it's not a quadratic time growth!  			(bubble sort, etc.)
     * e) Cube, that is O(n*n*n)? Nope.
     * f) Exponetional, that is O(c^n)? Nope.
     */
    private static void nestedComputation() {
        for (long i = 0; i < N; i++) {
            operation();
        }
    }

    /**
     * time = 60ms
     */
    private static void operation () {
        COUNTER++;
    }
}
