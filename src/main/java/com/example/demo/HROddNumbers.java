package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HROddNumbers {

	public static List<Integer> oddNumbers(int l, int r) {
		List<Integer> oddNumbers = new ArrayList<>();
		// Write your code here
		if (r > 1) {

			int i = l;
			while (i <= r) {
				if (i % 2 == 1) {
					System.out.println("adding " + i);
					oddNumbers.add(i);
				}
				i++;

			}
		}
		return oddNumbers;

	}

	static class MySort implements Comparator<String> {
		public int compare(String a, String b) {
			return b.compareTo(a);
		}

	}

	public static List<Integer> solve(int X, List<Integer> arr, List<Integer> query_values) {
		System.out.println("Intput -> X: "+X+", arr: "+arr+", query_values: "+query_values);
		List<Integer> result = new ArrayList();
		for (Integer queryValue : query_values) {
			if (arr != null && !arr.isEmpty()) {
				int occuranceIndex;
				if (arr.contains(X)) {
					occuranceIndex = getOccuranceOfXByQueryValue(X, arr, queryValue);
				} else {
					occuranceIndex = -1;
				}
				result.add(occuranceIndex);
				System.out.println("The "+queryValue+" occurance of "+X+" in arr is at position: "+occuranceIndex);
			}
		}
		return result;
	}

	private static int getOccuranceOfXByQueryValue(int x, List<Integer> arr, int queryValue) {
		int occurance = 0;
		boolean foundOccurance = false;
		int occuranceIndex = 0;
		if (arr != null && !arr.isEmpty()) {

			for (int i = 0; i < arr.size(); i++) {

				if (arr.get(i) == x) {
					occurance++;
				}

				if (occurance == queryValue) {
					foundOccurance = true;
					occuranceIndex = i + 1;
					break;
				}
			}
			return foundOccurance ? occuranceIndex : -1;

		}

		return -1;
	}

	public static void main(String[] args) {
//		System.out.println(oddNumbers(3, 5));
//		sortCities();
		
		solve(8, Arrays.asList(new Integer[]{0,2,8,8,6,9,5,3,8,7,4,0,5,8,8,8}), 
				Arrays.asList(new Integer[]{2,4,100,5,8,3,15,6,5}));
		
		

	}

	private static void sortCities() {
		System.out.println("\nsortCities().....");
		String[] cities = { "Bangalore", "Pune", "San Francisco", "New York City" };
		Arrays.sort(cities, new MySort());
		System.out.println("sorted cities: "+Arrays.asList(cities));
		System.out.println("New York City: " + Arrays.binarySearch(cities, "New York City"));
		System.out.println("Bangalore: " + Arrays.binarySearch(cities, "Bangalore"));
		System.out.println("Pune: " + Arrays.binarySearch(cities, "Pune"));
		System.out.println("San Francisco: " + Arrays.binarySearch(cities, "San Francisco"));
	}

}
