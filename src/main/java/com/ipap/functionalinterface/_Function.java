package com.ipap.functionalinterface;

import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {

        // Regular style
        System.out.println(incrementByOne(2));
        System.out.println(incrementByOne(3));

        // Functional style
        System.out.println(incrementByOneFunction.apply(1));
        System.out.println(incrementByOneFunction.apply(2));

        // Function methods (apply, andThen)
        // Example without andThen()
        int increment = incrementByOneFunction.apply(1);
        int multi1 = multiplyBy10Function.apply(increment);
        System.out.println(multi1);
        // Example with andThen()
        Integer multi2 = incrementByOneFunction.andThen(multiplyBy10Function).apply(1);
        System.out.println(multi2);
        // or
        Function<Integer, Integer> addBy1andThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        Integer multi2a = addBy1andThenMultiplyBy10.apply(1);
        System.out.println(multi2a);

    }

    // Normal function
    static int incrementByOne(int number) {
        return number + 1;
    }

    // Function<T,R> -> T: input R: output
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;
}
