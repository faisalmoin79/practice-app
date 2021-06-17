package com.example.demo;
import java.util.Scanner;
import java.util.regex.Pattern;

class HRRegex{

    public static void main(String[] args){ 
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().part));
            
        }

    } 
    
  //Write your code here
     static class MyRegex {
    	public final String part = "([0-1][0-9][0-9)]{1,3}|(2[0-4][0-9]){1,3}|(25[0-5]){1,3}";
        public  final String pattern = part+"\\."+part+"\\."+part+"\\."+part;
     }    
    
}


