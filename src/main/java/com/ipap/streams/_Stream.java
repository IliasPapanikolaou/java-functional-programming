package com.ipap.streams;

import com.ipap.imperative.Main;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static com.ipap.streams._Stream.Gender.FEMALE;
import static com.ipap.streams._Stream.Gender.MALE;

public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Kate", FEMALE),
                new Person("Alex", MALE),
                new Person("Helen", FEMALE)
        );

        // Stream
        System.out.println("\n----- List -----");
        people.stream()
                // Map does transformations
                .map(person -> person.gender)
                .forEach(System.out::println);

        // Stream Set
        System.out.println("\n----- Set ------");
        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        // MapToInt
        System.out.println("\n----- MapToInt ------");
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        // Or
        System.out.println("\n----- MapToInt ------");
        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length  = String::length;
        IntConsumer println = System.out::println;

        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);
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
