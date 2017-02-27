package com.serli.dojo.trainings.fp;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;
import static java.util.function.Function.identity;
import static java.util.function.Predicate.isEqual;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Util {

    public static final Comparator<Map.Entry<Integer, Long>> BY_SIDE_DESC = Map.Entry.<Integer, Long> comparingByValue().reversed();

    public static final Comparator<Map.Entry<Integer, Long>> BY_KEY_DESC = Map.Entry.<Integer, Long> comparingByKey().reversed();

    public static Function<List<Integer>, Integer> sum() {
        return dice -> ofNullable(dice)
                .orElseGet(Collections::emptyList)
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static Function<List<Integer>, Integer> sumForSide(int side) {
        return dice -> ofNullable(dice)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(die -> die == side)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static Function<List<Integer>, Integer> doIf(Function<List<Integer>, Integer> function, Predicate<List<Integer>> predicate) {
        return dice -> ofNullable(dice)
                .filter(predicate)
                .map(function)
                .orElse(0);
    }

    public static Function<List<Integer>, Integer> sumIf(Predicate<List<Integer>> predicate) {
        return doIf(sum(), predicate);
    }

    public static Function<List<Integer>, Integer> scoreIf(Integer score, Predicate<List<Integer>> predicate) {
        return doIf(dice -> score, predicate);
    }

    public static Function<List<Integer>, Integer> scoreIf(Integer score, BinaryOperator<Predicate<List<Integer>>> operator, Predicate<List<Integer>>... predicates) {
        return ofNullable(predicates)
                .map(Arrays::stream)
                .flatMap(stream -> stream.reduce(operator))
                .map(predicate -> scoreIf(score, predicate))
                .orElse(dice -> score);
    }

    public static Function<List<Integer>, Integer> scoreIfAll(Integer score, Predicate<List<Integer>>... predicates) {
        return scoreIf(score, Predicate::and, predicates);
    }

    public static Function<List<Integer>, Integer> scoreIfOne(Integer score, Predicate<List<Integer>>... predicates) {
        return scoreIf(score, Predicate::or, predicates);
    }

    public static Predicate<List<Integer>> missing(int... sides) {
        return dice -> stream(sides)
                .boxed()
                .map(Util::missing)
                .reduce(Predicate::and)
                .orElse(o -> false)
                .test(dice);
    }

    public static Predicate<List<Integer>> missing(int side) {
        return dice -> ofNullable(dice)
                .orElseGet(Collections::emptyList)
                .stream()
                .noneMatch(isEqual(side));
    }

    public static Predicate<List<Integer>> hasGroup(int diceCount) {
        return hasGroups(1, diceCount);
    }

    public static Predicate<List<Integer>> hasGroups(int diceCount) {
        return hasGroups(2, diceCount);
    }

    public static Predicate<List<Integer>> hasGroups(int groupCount, int diceCount) {
        return dice -> ofNullable(dice)
                .map(groups(diceCount))
                .filter(groups -> groups.count() >= groupCount)
                .isPresent();
    }

    public static Function<List<Integer>, Stream<Integer>> groups(int diceCount) {
        return dice -> ofNullable(dice)
                .orElseGet(Collections::emptyList)
                .stream()
                .collect(groupingBy(identity(), counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() >= diceCount)
                .map(Map.Entry::getKey);
    }
}
