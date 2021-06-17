package com.example.demo;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        boolean isPalindrome = true;
        
        if(A != null && !A.isEmpty()){
            for(int i=0, j=A.length()-1;i< A.length() && j>0 && i<=j ; i++, j--){
                if(A.charAt(i) != A.charAt(j)){
                    isPalindrome = false;
                }
            }
        }
        System.out.println(isPalindrome ? "Yes": "No");
        
    }

}
