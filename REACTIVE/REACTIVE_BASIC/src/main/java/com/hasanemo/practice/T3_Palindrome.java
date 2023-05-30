package com.hasanemo.practice;

import reactor.core.publisher.Mono;

public class T3_Palindrome {

    public static void main(String[] args) {

        String checkString = "KhalidIsAStupid";

        Mono.just(checkString).map(s -> s.equalsIgnoreCase(String.valueOf(new StringBuilder(s).reverse()))).subscribe(isPalindrome -> System.out.println("The given string is" + (isPalindrome ? " a palindrome" : " not a palindrome")));

    }

}