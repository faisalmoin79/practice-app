package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class FunctionalInterfaceDemo {

	public static void basicFunction() {
		Map<String, Integer> someMap = new HashMap<>();
		someMap.computeIfAbsent("someKey", k -> k.length());
		log.debug("map with computeIfAbsent: {}", someMap);
		
		someMap.putIfAbsent("AnotherKey", 2);
		log.debug("putting key in map if it is absent: {}", someMap);
		 
		// defining a custom Function  -> first param is input, second is output
		Function<Integer, String> intoToStringFn = Object::toString;
		log.debug("converting 2 to String: {}",intoToStringFn.apply(2));
		
		//another custom Function
		Function<String, String> appendQuotesToStringFn = s -> "'".concat(s).concat("'");
		log.debug("Appending quotes to a randomString: {}",appendQuotesToStringFn.apply("Faisal"));
		
		//combining functions  - see which one goes first
		Function<Integer, String> intoToStringWithQuotes = appendQuotesToStringFn.compose(intoToStringFn);
		log.debug("Combining functions using intToString and appendQuotesToString to 1234: {}",intoToStringWithQuotes.apply(1234));
		
;		
	}
	
	public static void main(String[] args) {
		basicFunction();
	}
}
