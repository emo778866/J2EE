package com.hasanemo.practice;

import reactor.core.publisher.Flux;

public class T2_RotateElementsOfArray {

    public static void main(String[] args) {

        Integer[] array = {5, 4, 3, 2, 1};

        Flux.fromArray(array)
                .collectList()
                .flatMap(list -> Flux.fromIterable(list).)
                .subscribe(System.out::println);

    }

}