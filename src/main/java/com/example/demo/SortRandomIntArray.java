package com.example.demo;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SortRandomIntArray {
	public static int solution(int[] A) {
		// write your code in Java SE 8
		int result = 1;
		List<Integer> list = Arrays.stream(A) // IntStream
				.boxed() // returns a Stream<Integer>
				.collect(Collectors.toList());
		
		Collections.sort(list);
		
		log.debug("Sorted List: {}",list);
		
		for (int i = 0; i < A.length; i++) {
			if (list.contains(result)) {
				result++;
			} else {
				break;
			}

		}
		return result;

	}

	public static void main(String[] args) {
		int[] input = { 1, 3, 6, 4, 1, 2 };
		System.out.println(SortRandomIntArray.solution(input));
	}
}
