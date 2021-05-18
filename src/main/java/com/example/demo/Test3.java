package com.example.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test3 {

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

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println(" Smallest element of the array is:: " + array[1]);
	}
	
	
	public static void main(String[] args) {
		log.debug(solution1("1"));
		log.debug(solution1("D"));
		log.debug(solution1("e"));
		log.debug(solution1("@"));
		int array[] = { 10, 20, 25, 63, 96, 57 };
		sort(array);

	}



}
