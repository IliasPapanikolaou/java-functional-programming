package com.ipap.lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {

        // Lambda expressions
        Function<String, String> upperCaseNameV1 = name -> name.toUpperCase();
        // same as the above with Method Reference
        Function<String, String> upperCaseNameV2 = String::toUpperCase;

        // Multiline lambda expressions
        Function<String, String> upperCaseNameV3 = name -> {
            //logic
            if (name.isBlank()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };

        //
        BiFunction<String, Integer, String> upperCaseNameV4 = (name, age) -> {
            //logic
            if (name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toUpperCase();
        };

        String alex = upperCaseNameV4.apply("Alex", 20);
        System.out.println(alex);
    }
}
