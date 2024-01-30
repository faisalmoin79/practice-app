package com.example.demo;

import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HRLoops1 {
// Hacker Rank questions 
// https://www.hackerrank.com/challenges/java-loops/problem?isFullScreen=true
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i <= t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
//        int a = 0, b=2, n = 10;
//			log.debug("Input -> a: {}, b: {}, n: {}", a, b, n);
			log.debug("Line  output: {}", getNextNumberInSeries(a, n, b));
		}

		in.close();
	}

	private static String getNextNumberInSeries(int a, int n, int b) {
		int num = 0;

		int i = 0;
		int result = a;
		StringBuilder series = new StringBuilder();
		while (i < n) {
			result = result + (int) Math.pow(2, i++) * b;
			 // result = get2ndArg(result, i++, b);
			series.append(result + " ");
		}
		return series.toString();
	}

	/*
	 * private static int get2ndArg(int result, int i, int b) { return result +
	 * (int) Math.pow(2, i) * b; }
	 */
}
