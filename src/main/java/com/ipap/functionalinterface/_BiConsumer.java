package com.ipap.functionalinterface;

import java.util.function.BiConsumer;

/**
 * BiConsumer, instead of taking one argument, it takes two arguments
 */
public class _BiConsumer {

    public static void main(String[] args) {
        greetCustomerConsumerV2.accept(new _Consumer.Customer("Mario", "1234"), true);
        greetCustomerConsumerV2.accept(new _Consumer.Customer("Alex", "1234"), false);
        greetCustomerConsumerV2.accept(new _Consumer.Customer("Helen", "1234"), false);
    }

    static BiConsumer<_Consumer.Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) -> {
        String response = showPhoneNumber
                ? "Hello " + customer.getCustomerName() + ", thanks for registering phone number " + customer.getCustomerPhoneNumber()
                :  "Hello " + customer.getCustomerName() + ", thanks for registering phone number ****";

        System.out.println(response);
    };
}
