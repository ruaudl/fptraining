package com.serli.dojo.trainings.fp;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.serli.dojo.trainings.fp.Util.*;

public enum Line {
    ACES(sumForSide(1)),
    TWOS(sumForSide(2)),
    THREES(sumForSide(3)),
    FOURS(sumForSide(4)),
    FIVES(sumForSide(5)),
    SIXES(sumForSide(6)),
    THREE_OF_A_KIND(sumIf(hasGroup(3))),
    FOUR_OF_A_KIND(sumIf(hasGroup(4))),
    FULL_HOUSE(scoreIfAll(25, hasGroups(2), hasGroups(3))),
    SMALL_STRAIGHT(scoreIfOne(30,
            hasGroups(4, 1).and(missing(1, 2).or(missing(1, 6)).or(missing(5, 6))),
            hasGroups(5, 1).and(missing(1).or(missing(2)).or(missing(5)).or(missing(6)))
    )),
    LARGE_STRAIGHT(scoreIfAll(40, hasGroups(5, 1), missing(1).or(missing(6)))),
    YAHTZEE(scoreIf(50, hasGroups(1, 5))),
    CHANCE(sum());

    final Function<List<Integer>, Integer> score;

    public static final List<Line> UPPER_SECTION = Arrays.asList(ACES, TWOS, THREES, FOURS, FIVES, SIXES);

    Line(Function<List<Integer>, Integer> score) {
        this.score = score;
    }
}