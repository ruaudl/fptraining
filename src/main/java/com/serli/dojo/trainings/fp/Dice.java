package com.serli.dojo.trainings.fp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dice {

    private static final Random RANDOM = new Random();

    public static int roll() {
        return RANDOM.nextInt(6) + 1;
    }

    public static List<Integer> roll(int diceCount) {
        return IntStream.range(0, diceCount)
                .map(i -> roll())
                .boxed()
                .collect(Collectors.toList());
    }
}
