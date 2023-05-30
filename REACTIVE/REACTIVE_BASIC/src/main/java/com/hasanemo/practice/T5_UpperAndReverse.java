package com.hasanemo.practice;

import reactor.core.publisher.Flux;

public class T5_UpperAndReverse {

    public static void main(String[] args) {

        String[] arr = {"ggE", "KsaT", "evIf"};

        Flux.fromArray(arr)
                .map(String::toUpperCase)
                .map(s -> new StringBuilder(s).reverse())
                .subscribe(System.out::println);

    }

}