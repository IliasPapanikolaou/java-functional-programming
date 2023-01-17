package com.ipap.functionalinterface;

import java.util.function.Predicate;

/**
 * Represents a predicate (boolean-valued function) of one argument
 */
public class _Predicate {

    public static void main(String[] args) {
        // Normal Style
        System.out.println("\n---- Without Predicate ----");
        System.out.println(isPhoneNumberValid("306945693456"));
        System.out.println(isPhoneNumberValid("316945693456"));
        System.out.println(isPhoneNumberValid("3069456934561"));

        // Functional Style
        System.out.println("\n---- With Predicate ----");
        System.out.println(isPhoneNumberValidPredicate.test("306945693456"));
        System.out.println(isPhoneNumberValidPredicate.test("316945693456"));
        System.out.println(isPhoneNumberValidPredicate.test("3069456934561"));

        // Chain of predicates with AND
        System.out.println("\n---- Chain of Predicates with AND ----");
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("306945693456"));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("306940693406"));

        // Chain of predicates with OR
        System.out.println("\n---- Chain of Predicates with OR ----");
        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("306945693456"));
        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("306940693406"));

    }

    // Regular function
    static boolean isPhoneNumberValid(String phoneNumber) {
        // example validation, not real
        return phoneNumber.startsWith("30") && phoneNumber.length() == 12;
    }

    // Predicate function
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("30") && phoneNumber.length() == 12;

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("5");
}
