package com.example.demo;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

/*
 * 

 * 
 */

public class AdjacentLetters {
	public static String solution(int N) {
		// Implement your solution here
		String finalString = null;
		// System.out.println(getNextLetterString("aaaaa"));

		if (N > 0) {
			String initialString = computeString('a', N);
			finalString = transformString(initialString);
			// System.out.println(containsAdjacentLetters("cbababacd"));
		}

		return finalString;

	}

	public static String transformString(String inputString) {
		String nextString = null;
		int i = 0;
		while (containsAdjacentLetters(inputString)) {
			System.out.println("Iter-" + i++ + ", processing " + inputString);

			if (!containsDifferentLetters(inputString)) { // if all letters are same
				nextString = getNextLetterString(inputString);

			} else {
				String adjacentLettersString = getAdjacentLetterString(inputString);
				// bbbbba
				String nonAdjacentString = inputString.substring(adjacentLettersString.length()+1);

//				System.out.println("\tadjacentLettersString: " + adjacentLettersString);
//				System.out.println("\tnonAdjacentString: " + nonAdjacentString);

				nextString = getNextLetterString(adjacentLettersString).concat(nonAdjacentString);

			}
			System.out.println("\tnextString: " + nextString);
			inputString = nextString;

		}

		return nextString;
	}

	// N = 67108876

	public static String getAdjacentLetterString(String input) {
		char[] inputChars = input.toCharArray();
		StringBuffer adjacentLetters = new StringBuffer();
		
		for (int i = 0, j = i + 1; i < inputChars.length && j < inputChars.length; i++, j++) {
			if (inputChars[i] == inputChars[j]) {
				adjacentLetters.append(inputChars[i]);
			} else {
				break;
			}
		}
		

		return adjacentLetters.toString();

	}

	// aaaa (4) -> bb (2)
	// aaaaa (5) -> bb (2) + a

	public static String getNextLetterString(String inputString) {
		char letter = inputString.charAt(0);
		char nextLetter = (char) (letter + 1);
		String nextString = null;
		int nextLength = inputString.length() / 2;
		nextString = computeString(nextLetter, nextLength);

		if (inputString.length() % 2 != 0) {// odd characters
			nextString = nextString.concat(String.valueOf(letter));
		}
		return nextString;
	}

	public static boolean containsAdjacentLetters(String input) {
		boolean hasAdjacentLetters = false;
		char[] chars = input.toCharArray();

		for (int i = 0, j = i + 1; i < chars.length && j < chars.length; i++, j++) {
			if (chars[i] == chars[j]) {
				hasAdjacentLetters = true;
				break;
			}

		}

		return hasAdjacentLetters;
	}

	public static boolean containsDifferentLetters(String input) {
		boolean hasDifferentLetters = false;
		char[] chars = input.toCharArray();

		for (int i = 0, j = i + 1; i < chars.length && j < chars.length; i++, j++) {
			if (chars[i] != chars[j]) {
				hasDifferentLetters = true;
				break;
			}

		}

		return hasDifferentLetters;
	}

	public static String computeString(char letter, int N) {
		StringBuffer buffer = new StringBuffer();
		if (N > 0) {
			for (int i = 0; i < N; i++) {
				buffer.append(letter);
			}
		}
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("Result: "+solution(11));
		System.out.println("Result: "+solution(17));
//		System.out.println("bbbba".substring(4));
	}

}
