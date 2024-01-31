package com.example.demo;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");
import java.util.*;
//https://app.codility.com/demo/results/trainingTVFCEJ-ZX2/
public class UnpairedNumbersInOddArray {
	public static int solution(int[] A) {
		// Implement your solution here
		int unpairedNum = getUnPairedNum(A);

		return unpairedNum;
	}

	public static int getUnPairedNum(int[] A) {
		int unpairedNum = 0;

		if (A != null && A.length > 0 && (A.length % 2 != 0)) {
			List<Integer> pairedIndexes = new ArrayList<Integer>();
			int i = 0;
			int j = 2;
			while (i < A.length && j < A.length) {
				// System.out.println("i: "+i+",j: "+j);
				if (!pairedIndexes.contains(i) && !pairedIndexes.contains(j)) {
					if (i < A.length && j < A.length) {
						if (A[i] == A[j]) {
							// System.out.println("Found pair "+A[i]+", at indexes: "+i+", "+j);
							pairedIndexes.add(i);
							pairedIndexes.add(j);
							// System.out.println("Paired Indexes: "+pairedIndexes);
						}
					}
				}
				i++;
				j = i + 2;

			}
			unpairedNum = A[i];
		}
		return unpairedNum;
	}
	
	public static void main(String[] args) {
		int[] numbers = new int[] {9,3,9,3,9,7,9};
		System.out.println(solution(numbers));
	}
}