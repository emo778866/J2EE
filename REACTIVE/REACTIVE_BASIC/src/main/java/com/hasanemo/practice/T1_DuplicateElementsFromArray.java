package com.hasanemo.practice;

import reactor.core.publisher.Flux;

import java.util.HashSet;
import java.util.Set;

public class T1_DuplicateElementsFromArray {

    public static void main(String[] args) {

        Integer[] numbers = {1, 1, 2, 2, 3, 3, 4, 5};
        Set<Integer> uniqueNumbers = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        Flux.fromArray(numbers)
                .filter(e -> !uniqueNumbers.add(e))
                .doOnNext(duplicates::add)
                .subscribe();

        duplicates.forEach(System.out::println);

    }

}