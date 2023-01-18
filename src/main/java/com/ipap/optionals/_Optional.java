package com.ipap.optionals;

import java.util.Optional;

public class _Optional {

    public static void main(String[] args) {
        // ofNullable
        // orElseGet
        Object o1 = Optional.ofNullable(null)
                .orElseGet(() -> "default value");

        System.out.println(o1);

        Object o2 = Optional.ofNullable("Hello")
                .orElseGet(() -> "default value");

        System.out.println(o2);

        // orElseThrow
        Object o3 = Optional.ofNullable("Hello")
                .orElseThrow(() -> new IllegalStateException("exception"));

        System.out.println(o3);

        // ifPresent
        Optional.ofNullable("Hello")
                .ifPresent(System.out::println);

        Optional.ofNullable("john@mail.com")
                .ifPresent(email -> System.out.println("Sending email to " + email));

        // ifPresentOrElse
        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Cannot send email"));
    }
}
