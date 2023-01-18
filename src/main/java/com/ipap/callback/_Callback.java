package com.ipap.callback;

import java.util.function.Consumer;

/**
 * Callbacks like JS
 *
 * ----- JS Code ------
 *
 * function hello(firstName, lastName, callback) {
 *     console.log(firstName);
 *     if (lastName) {
 *         console.log(lastName)
 *     } else {
 *         callback();
 *     }
 * }
 *
 */

// Java Implementation
public class _Callback {
    public static void main(String[] args) {
        // First Option with Consumer<String> callback
        hello("Maria", "Buying", value -> System.out.println("No lastName provided for " + value));
        hello("John", null, value -> System.out.println("No lastName provided for " + value));

        // Second Option with Runnable callback
        hello("Jack", null, () -> System.out.println("No lastName provided"));
        hello("Maria", "Shopping", () -> System.out.println("No lastName provided"));
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
}


