package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmallestNumberOfArray {

	public static String solution1(String s) {
		char c = s.charAt(0);
		int asciiCode = (int) c;

		if (65 <= asciiCode && asciiCode <= 90) {
			return "upper";
		} else if (97 <= asciiCode && asciiCode <= 122) {
			return "lower";
		} else if (48 <= asciiCode && asciiCode <= 57) {
			return "digit";
		} else {
			return "other";
		}
	}

	public static void sort(int array[]) {
		int temp=array[0], size;
		
		size = array.length;
		List<Integer> someList = null;

		// brute force method 2 loops * n
//		for (int i = 0; i < size; i++) {
//			someList = Arrays.stream(array)
//				      .boxed()
//				      .collect(Collectors.toList());
//			System.out.println("iteration "+(i)+" - array: "+someList);
//			for (int j = i + 1; j < size; j++) {
//				if (array[i] > array[j]) {
////					System.out.println("\t swapped"+array[i]+" and "+array[j]);
//					temp = array[i];
//					array[i] = array[j];
//					array[j] = temp;
//					
//				}
//			}
//		}
		
		// looping once to get smallest element on first index
		for (int i = 0; i < 1; i++) {
			someList = Arrays.stream(array)
				      .boxed()
				      .collect(Collectors.toList());
			System.out.println("iteration "+(i)+" - array: "+someList);
			for (int j = i + 1; j < size; j++) {
				if (array[i] > array[j]) {
					System.out.println("\t swapped"+array[i]+" and "+array[j]);
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
			
			
		}
//		
//		for (int i = array.length-1; i > array.length-3; i--) {
//			someList = Arrays.stream(array)
//				      .boxed()
//				      .collect(Collectors.toList());
//			System.out.println("iteration "+(i)+" - array: "+someList);
//			for (int j = i + 1; j < size; j++) {
//				if (array[i] > array[j]) {
//					temp = array[i];
//					array[i] = array[j];
//					array[j] = temp;
//				}
//			}
//		}
		System.out.println(" Smallest element of the array is:: " + array[0]);
	}
	
	
	public static void main(String[] args) {
		log.debug(solution1("1"));
		log.debug(solution1("D"));
		log.debug(solution1("e"));
		log.debug(solution1("@"));
		int array[] = { 10, 20, 25, 63, 96, 57 ,1, 0, 5, 45, 34, 6, 2, 31, 24, 15};
		sort(array);

	}



}
