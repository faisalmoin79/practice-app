package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JavaStreams {

	private static List<String> listofParts;


	@Builder
	@Getter
	public static class Detail {
		String itemName;
		List<String> parts;
	}

	public static void usingFlatMap() {

		Detail item1 = Detail.builder().itemName("monitor").parts(new ArrayList<String>() {
			{

				add("stand");
				add("hdmi Cable");
				add("power Cable");
				add("vga Cable");
			}
		}).build();

		Detail item2 = Detail.builder().itemName("printer").parts(new ArrayList<String>() {
			{

				add("usb cable");
				add("printer tray");
				add("power Cable");
				add("printer paper");
			}
		}).build();

		@SuppressWarnings("serial")
		List<Detail> items = new ArrayList<JavaStreams.Detail>() {
			{
				add(item1);
				add(item2);
			}
		};

		// FlatMap: If you have a stream where every element contains its own sequence,
		// and you want to create a Stream of those inner elements, use flatMap() method
		Stream<String> innerPartsStream = items.stream().flatMap(item -> item.getParts().stream());

		listofParts = innerPartsStream.collect(Collectors.toList());
		log.debug("List of inner parts: {}", listofParts);

	}

	private static void usingReduce() {
		Optional<Integer> result = Arrays.asList(1, 2, 3, 4).stream().reduce((a, b) -> a + b);
		log.debug("Reduce result: {}", result.get());

	}

	private static void lazyInvocation() {
		log.info("\nlazyInvocation()...........");
		String[] inputArray = new String[] {"abc1","cbsd2","de2k3","er2d"};
		
		List<String> inputList = Arrays.asList(inputArray);
		log.debug("inputList: {}", inputList);
		List<String> resultList = inputList
		.stream()
		.filter(s -> {
				log.debug("filter() was called");
				return s.contains("2");
			})
//		.peek(System.out::println)
		.peek(s-> log.debug("peek was called on : {}",s))
		.map(element -> {
			log.debug("map(); was called");
			return element.toUpperCase();
		})
		.collect(Collectors.toList());
		
		log.debug("Result list: {}",resultList);
		
	}

	private static void usingSkipmethod() {
		Stream<String> onceModifiedStream = Stream.of("abcd", "bbcd", "cbcd").skip(2); // remove first two items
		log.debug("using skip method: {}", onceModifiedStream.collect(Collectors.toList()));

	}
	
	
	public static void main(String[] args) {
		usingFlatMap();
		usingReduce();
		lazyInvocation();
		usingSkipmethod();
		sortAssending();
		sortingLists();
	}

	private static void sortAssending() {
		int[] intArray = {3,56,24,1,87,-2,0,98,45,67};
		List<Integer> intList = Arrays.stream(intArray).boxed().collect(Collectors.toList());
		log.debug("Before sort: {}",intList);
		intList.sort((a,b) -> b.compareTo(a));
		log.debug("Comparable Sort: {}", intList);
		Collections.sort(intList);
		log.debug("Collections. Sort: {}", intList);
		 
		
		
	}

	private static void sortingLists() {
		log.info("\nsorting using streams....using list.sort()");
		log.debug("listOfParts before: {}", listofParts);
		listofParts.sort((part1,part2) -> part1.compareTo(part2));
		log.debug("listOfParts after sort: {}", listofParts);
		
		
		log.info("\nusing Collections.sort()");
		usingFlatMap();
		Collections.sort(listofParts);
		log.debug("listOfParts after sort: {}", listofParts);
		
		log.info("\nusing Streams.sorted()");
		usingFlatMap();
		List<String> sortedLIst = listofParts.stream().sorted((part1, part2) -> part1.compareTo(part2)).collect(Collectors.toList());
		log.debug("listOfParts after sort: {}", sortedLIst);
		
		
		
	}

}
