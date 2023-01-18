package com.ipap.combinatorpattern;

import java.time.LocalDate;

import static com.ipap.combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alic@email.com",
                "306944001122",
                LocalDate.of(2000, 1, 1)
        );

        System.out.println(new CustomerValidatorService().isValid(customer));

        // Use of combinator pattern
        ValidationResult result = isEmailsValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                // apply() can be used in later time -> result.apply(customer)
                .apply(customer);

        System.out.println(result);

        if (!result.equals(ValidationResult.SUCCESS)) {
            throw new IllegalStateException(result.name());
        }
    }
}
