package com.ipap.functionalinterface;

import java.util.List;
import java.util.function.Consumer;

/**
 * Represents an operation that accepts a single input argument and returns no result;
 */
public class _Consumer {

    public static void main(String[] args) {

        // Regular style
        greetCustomer(new Customer("John", "211-1234568"));

        // Consumer Functional Interface
        greetCustomerConsumer.accept(new Customer("John", "211-1234568"));

        List<Consumer<Customer>> consumers = List.of(_Consumer.greetCustomerConsumer, _Consumer.farewellCustomer);

        // Difficult example
        List<Customer> customers = List.of(
                new Customer("Maria", "1234"),
                new Customer("Jack", "2345"),
                new Customer("Helen", "3456"),
                new Customer("Mick", "4567")
        );

        customers.forEach(customer -> consumers.forEach(consumer -> consumer.accept(customer)));

    }

    // Normal function
    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName
                + ", thanks for registering phone number " + customer.customerPhoneNumber);
    }

    // Consumer function (greet)
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName
                    + ", thanks for registering phone number " + customer.customerPhoneNumber);

    // Consumer function (farewell)
    static Consumer<Customer> farewellCustomer = customer ->
            System.out.println("Goodbye " + customer.customerName + " see you later");

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getCustomerPhoneNumber() {
            return customerPhoneNumber;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "customerName='" + customerName + '\'' +
                    ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                    '}';
        }
    }
}
