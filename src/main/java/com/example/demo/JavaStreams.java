package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JavaStreams {

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

		List<String> listofParts = innerPartsStream.collect(Collectors.toList());
		log.debug("List of inner parts: {}", listofParts);

	}

	private static void usingReduce() {
		Optional<Integer> result = Arrays.asList(1, 2, 3, 4).stream().reduce((a, b) -> a + b);
		log.debug("Reduce result: {}", result.get());

	}

	public static void main(String[] args) {
		usingFlatMap();
		usingReduce();
		usingSkipmethod();
		lazyInvocation();

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
		.peek(System.out::println)
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

}
