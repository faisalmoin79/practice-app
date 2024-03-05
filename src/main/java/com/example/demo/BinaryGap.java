package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://app.codility.com/demo/results/trainingSGMBEG-477/
public class BinaryGap {

	public static int solution(int N) {
		// Implement your solution here
		int gap = 0;
		if (N > 0) {
			String binaryString = getBinaryString(N);
			System.out.println("binaryString for "+N+" is "+binaryString);
			gap = getBinaryGap(binaryString);
			// System.out.println(gap);
		}

		return gap;

	}

	public static String getBinaryString(int N) {
		int num = N;
		StringBuilder builder = new StringBuilder();

		while (num > 0) {
			builder.append(num % 2);
			num = num / 2;
		}
		return builder.reverse().toString();

	}

	public static int getBinaryGap(String binaryString) {
		int gap = 0;
		int gapCounter = 0;

		boolean gapStart = false;
		boolean gapProcessing = false;

		if (binaryString != null && !binaryString.isEmpty() && binaryString.contains("0")
				&& binaryString.contains("1")) {

			int i = 0;
			while (i < binaryString.length()) {

				if (binaryString.charAt(i) == '1') {
					if (!gapStart) { // gap didnt start yet
						gapStart = true;
					} else { // gap was already started
						if (gapProcessing) {
							gapProcessing = false; // end processing
							if (gap < gapCounter) { // replace old gap if new one is bigger
								gap = gapCounter;
							}
							gapCounter = 0; // reset counter
						}
					}
				} else { // 0
					if (gapStart) { // if gap was already started
						gapProcessing = true; // gap processing started
						gapCounter++;
					}

				}
				// System.out.println(binaryString.charAt(i) + ": "+ gapCounter+", gap: "+gap);
				i++;
			}

		}
		return gap;
	}

	/*
	 * For example, 
	 * number 9 has binary representation 1001 and contains a binary gap of length 2. 
	 * The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
	 * The number 20 has binary representation 10100 and contains one binary gap of length 1. 
	 * The number 15 has binary representation 1111 and has no binary gaps. 
	 * The number 32 has binary representation 100000 and has no binary gaps.
	 */
	
	public static void main(String[] args) {
		int[] numbers = new int[] {9,529,20,15,32};
		
//		List<Integer> binaryGaps = Arrays.stream(numbers).boxed().map(N -> solution(N)).collect(Collectors.toList());
//		System.out.println(binaryGaps);
		Arrays.stream(numbers).boxed().forEach(N -> System.out.println("Binary Gap for "+N+" is "+solution(N)));
	}
}
