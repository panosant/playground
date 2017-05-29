package com.antonakospanos.playground;

import java.util.Scanner;

import com.antonakospanos.playground.permutation.Permutation;

public class PlaygroundApp {
	
	public static void main(String... strings) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the phrase that you need to permutate:");
		String phrase = scanner.nextLine();
		
		Permutation.printPermutations(phrase);
	}
}
