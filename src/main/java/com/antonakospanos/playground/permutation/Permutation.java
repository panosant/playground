package com.antonakospanos.playground.permutation;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Stream;

public class Permutation {
	
	public static void printPermutations(String string) {
		Collection<String> permutations = calculateMyPermutations(string);
		
		if (permutations != null & !permutations.isEmpty()) {
			Stream.of(permutations).forEach(permutation -> {
				System.out.println(permutation);
			});
		} else {
			System.out.println("No permutation possible!");
		}
	}
	
	
	
	private static Collection<String> calculateMyPermutations(String string) {
		return calculateMyPermutations("", string);
	}

	private static Collection<String> calculateMyPermutations(String fixed, String swappingChars) {
		Collection<String> permutations = new HashSet<>();
		int charLength = swappingChars.length();

		for (int character = 0; character < charLength; character++) {
			System.out.println("Add permutations of "+ fixed+swappingChars +" keeping fixed character: "+ swappingChars.charAt(character));
			addPermutations(
					new char[] { swappingChars.charAt(character) }, 
					(swappingChars.substring(0, character) + swappingChars.substring(character+1, charLength)).toCharArray(), 
					permutations);
		}
		
		return permutations;
	}
	
	private static void addPermutations(char[] fixed, char[] swappingChars, Collection<String> permutations) {
		String permutation = String.valueOf(fixed) + String.valueOf(swappingChars);
		System.out.println(permutation);
		if (swappingChars.length == 0) {
			permutations.add(permutation);
		} else {
			permutations.add(permutation);
			// Swap chars to provide all possible anagrams
			String newFixed = String.valueOf(fixed) + String.valueOf(swappingChars[0]);
			String newSwappingChars = String.valueOf(Arrays.copyOfRange(swappingChars, 1, swappingChars.length));
			calculateMyPermutations(newFixed, newSwappingChars);
		}
	}

	
	
	
	private static Collection<String> calculatePermutations(String string) {
		Collection<String> permutations = new HashSet<>();
		
		String prefix = "";
		String suffix = string;
		
		addPermutationsOfSuffix(prefix, suffix, permutations);
		
		return permutations;
	}
	
	private static void addPermutationsOfSuffix(String prefix, String suffix, Collection<String> permutations) {
		int charLength = suffix.length();

		if (suffix.length() == 0) {
			permutations.add(prefix);
		} else {
			for (int character = 0; character < charLength; character++) {
				System.out.println(prefix + suffix);
				permutations.add(prefix + suffix);

				// prefix = prefix + permutation.charAt(character);
				// permutation = permutation.substring(0, character) + permutation.substring(character+1, charLength); // BOTH before and after prefix!
				// addPermutationsOfSuffix(prefix, permutation, permutations);
				addPermutationsOfSuffix(
						prefix + suffix.charAt(character),	
						suffix.substring(0, character) + suffix.substring(character + 1, charLength), 
						permutations);
			}
		}
	}
}