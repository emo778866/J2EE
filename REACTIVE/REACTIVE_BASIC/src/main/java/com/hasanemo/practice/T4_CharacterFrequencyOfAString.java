package com.hasanemo.practice;

import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.Map;

public class T4_CharacterFrequencyOfAString {

    public static void main(String[] args) {

        Flux<String> stringFlux = Flux.just("Count", "Word");

        Map<Character, Integer> characterFrequency = new HashMap<>();

        stringFlux
                .flatMap(word -> Flux.fromArray(boxCharArray(word.toCharArray()))).subscribe(character -> characterFrequency.merge(character, 1, Integer::sum));

        characterFrequency.forEach((character, frequency) -> System.out.println(character + " : " + frequency));

    }

    private static Character[] boxCharArray(char[] chars) {
        Character[] boxed = new Character[chars.length];
        for (int i = 0; i < chars.length; i++) {
            boxed[i] = chars[i];
        }
        return boxed;
    }

}