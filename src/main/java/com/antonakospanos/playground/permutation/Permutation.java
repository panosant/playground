package com.antonakospanos.playground.permutation;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Stream;

public class Permutation {
	
	public static void printPermutations(String string) {
		Collection<String> permutations = calculatePermutations(string);
		
		if (permutations != null & !permutations.isEmpty()) {
			Stream.of(permutations).forEach(permutation -> {
				System.out.println(permutation);
			});
		} else {
			System.out.println("No permutation possible!");
		}
	}
	
	private static Collection<String> calculatePermutations(String string) {
		Collection<String> permutations = new HashSet<>();
		
		String prefix = "";
		String permutation = string;
		
		addPermutationsOfSuffix(prefix, permutation, permutations);
		
		return permutations;
	}
	
	private static void addPermutationsOfSuffix(String prefix, String permutation, Collection<String> permutations) {
		int charLength = permutation.length();

		if (permutation.length() == 0) {
			permutations.add(prefix);
		} else {
			for (int character = 0; character < charLength; character++) {
				System.out.println(prefix + permutation);
				permutations.add(prefix + permutation);

				// prefix = prefix + permutation.charAt(character);
				// permutation = permutation.substring(0, character) + permutation.substring(character+1, charLength); // BOTH before and after prefix!

				// addPermutationsOfSuffix(prefix, permutation, permutations);
				addPermutationsOfSuffix(
						prefix + permutation.charAt(character),	
						permutation.substring(0, character) + permutation.substring(character + 1, charLength), 
						permutations);
			}
		}
	}
}