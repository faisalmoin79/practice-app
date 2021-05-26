package com.example.demo;

import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HRStringTokens {

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String s = scan.nextLine();
    	String s = "           YES      leading spaces        are valid,    problemsetters are         evillllll";
        String regex= "[^A-Za-z]+";
        s = s.trim();
        String[] tokens = s.split(regex);
        
        System.out.println(tokens.length);
        for (String token : tokens) {
        	if(!StringUtils.isEmpty(token))
			System.out.println(token);
		}
        // Write your code here.
//        scan.close();
    }

	 
}
