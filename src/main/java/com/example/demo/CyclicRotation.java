package com.example.demo;
// https://app.codility.com/demo/results/trainingY5U9TN-X8C/

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");
import java.util.Arrays;
import java.util.stream.Collectors;

//import 
public class CyclicRotation {
	public static int[] solution(int[] A, int K) {
		// Implement your solution here
		int[] rotatedArray = new int[A.length];
		if (A != null && A.length > 0 && A.length <= 100 && K > 0 && K <= 100) {
			if (K == A.length) {
				return A;
			}

			for (int i = 0; i < K; i++) {
				rotatedArray = rotateArray(A);
				System.out.println(printArray(A)+" -> "+printArray(rotatedArray));
				A = rotatedArray;
			}
		}
		return rotatedArray;
	}

	public static int[] rotateArray(int[] A) {
		int[] newArray = new int[A.length];
		int i = 0;
		int j = 0;
		while (i < A.length) {
			j = i + 1;
			if (j >= A.length) {
				j = A.length - j;
			}
			newArray[j] = A[i];
			i++;
		}
		return newArray;
	}

	public static String printArray(int[] A) {
		if (A != null && A.length > 0) {
			return Arrays.stream(A).boxed().collect(Collectors.toList()).toString();
		}
		return null;
	}

	public static void main(String[] args) {
		int[] numbers = new int[] {3, 8, 9, 7, 6};
		int K=3;
		
//		List<Integer> binaryGaps = Arrays.stream(numbers).boxed().map(N -> solution(N)).collect(Collectors.toList());
//		System.out.println(binaryGaps);
		System.out.println(printArray(solution(numbers, K)));

	}
}