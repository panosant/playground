package com.antonakospanos.playground;

import com.antonakospanos.playground.complexity.TimeComplexity;
import com.antonakospanos.playground.permutation.Permutation;

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.stream.LongStream;

public class PlaygroundApp {

	public static void main(String... strings) {
		// Call private method
		checkTimeComplexity();
	}

	private static void checkTimeComplexity() {
		TimeComplexity.checkTimeComplexity();
	}

	private static void permutate() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the phrase that you need to permutate:");
		String phrase = scanner.nextLine();

		Permutation.printPermutations(phrase);
	}
}
