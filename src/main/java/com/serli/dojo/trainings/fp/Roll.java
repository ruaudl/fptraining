package com.serli.dojo.trainings.fp;

import java.util.*;

public class Roll {

    private final List<Integer> dice;

    public Roll(List<Integer> list) {
        this.dice = Optional.ofNullable(list)
                .map(Collections::unmodifiableList)
                .orElseGet(Collections::emptyList);
    }

    public Roll(Integer... values) {
        this.dice = Optional.ofNullable(values)
                .map(Arrays::asList)
                .map(Collections::unmodifiableList)
                .orElseGet(Collections::emptyList);
    }

    public Roll rolling(Integer... indexes) {
        List<Integer> newDice = new ArrayList<>(dice);
        Optional.ofNullable(indexes).ifPresent(array -> Arrays.stream(indexes)
                .filter(index -> index < newDice.size())
                .filter(index -> index >= 0)
                .forEach(index -> newDice.set(index, Dice.roll())));
        return new Roll(newDice);
    }

    public List<Integer> getDice() {
        return dice;
    }

    public int sum() {
        return dice.stream().mapToInt(i -> i).sum();
    }

    public int score(Line line) {
        return line.score.apply(dice);
    }

    public Line bestLine() {
        Comparator<Line> lineComparator = Comparator.comparing((Line line) -> line.score.apply(dice)).reversed();
        return Arrays.stream(Line.values())
                .sorted(lineComparator)
                .findFirst()
                .orElse(Line.ACES);
    }
}
