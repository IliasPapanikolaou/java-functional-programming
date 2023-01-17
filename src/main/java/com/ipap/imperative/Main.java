package com.ipap.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.ipap.imperative.Main.Gender.FEMALE;
import static com.ipap.imperative.Main.Gender.MALE;

public class Main {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Kate", FEMALE),
                new Person("Alex", MALE),
                new Person("Helen", FEMALE)
        );

        // Find how many females we have:

        // Imperative approach (define every single detail)
        System.out.println("\n----- Imperative approach -----");
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }
        for (Person female : females) {
            System.out.println(female);
        }

        // Declarative approach
        System.out.println("\n----- Declarative approach -----");
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .forEach(System.out::println);

        // Predicate (holds a boolean value) - functional interface
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);


    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}