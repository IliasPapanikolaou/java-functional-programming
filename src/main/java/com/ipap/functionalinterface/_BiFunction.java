package com.ipap.functionalinterface;

import java.util.function.BiFunction;

/**
 * BiFunction<T, U, R>
 * -------------------
 * Same as Function<T,R> but instead of one input and one output,
 * it takes two inputs and produces one output
 */
public class _BiFunction {

    public static void main(String[] args) {
        // Regular style
        int i1 = incrementByOneAndMultiply(2, 10);
        int i2 = incrementByOneAndMultiply(4, 100);
        System.out.println(i1);
        System.out.println(i2);

        // BiFunction (takes two inputs and produces one result)
        BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
                (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(2, 10));
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100));
    }

    // Normal function
    static int incrementByOneAndMultiply(int numberToIncrementByOne, int numToMultiplyBy) {
        return (numberToIncrementByOne + 1) * numToMultiplyBy;
    }
}
