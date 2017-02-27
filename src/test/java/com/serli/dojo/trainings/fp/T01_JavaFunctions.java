package com.serli.dojo.trainings.fp;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class T01_JavaFunctions {

    private final List<Integer> dice = Arrays.asList(1, 2, 3, 4, 5);

    @Test
    public void E01_objectMethodReference() throws Exception {
        Roll roll = null; //TODO: create an instance using 'Roll' class constructor and object 'dice' as parameter

        Supplier<String> toString = null; //TODO: get the reference to the 'toString' method of the object 'roll'
        assertThat(toString, notNullValue());
        assertThat(toString.get(), containsString("Roll"));

        Supplier<List<Integer>> getter = null; //TODO: get the reference to the 'toString' method of the object 'roll'
        assertThat(toString, notNullValue());
        assertThat(toString.get(), equalTo(dice));
    }

    @Test
    public void E02_staticMethodReference() throws Exception {
        Supplier<Integer> rollOne = null; //TODO: get the reference to the static method 'roll' of the class 'Dice'
        assertThat(rollOne, notNullValue());
        assertThat(rollOne.get(), Matchers.isOneOf(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void E03_innerClass() throws Exception {
        Supplier<Integer> rollOne = null; //TODO: create an inner class to implement the method 'roll'
        assertThat(rollOne, notNullValue());
        assertThat(rollOne.get(), Matchers.isOneOf(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void E04_lambda() throws Exception {
        Supplier<Integer> rollOne = null; //TODO: create a lambda to implement the method 'roll'
        assertThat(rollOne, notNullValue());
        assertThat(rollOne.get(), Matchers.isOneOf(1, 2, 3, 4, 5, 6));
    }
}
