package com.hasanemo.model;

public class Sprite {

    public int getPrice(int size) {
        return switch (size) {
            case 250 -> 25;
            case 500 -> 35;
            default -> 55;
        };
    }

}