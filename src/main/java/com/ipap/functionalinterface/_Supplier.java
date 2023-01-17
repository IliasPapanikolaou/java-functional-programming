package com.ipap.functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        // Normal style
        System.out.println(getDBConnectionUrl());

        // Functional style
        System.out.println(getDBConnectionUrlSupplier.get());
        System.out.println(getListOfDBConnectionsUrlSupplier.get());

    }

    // Regular function
    static String getDBConnectionUrl() {
        return "jdbc://localhost:5432/users";
    }

    // Supplier function
    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:5432/user_db";
    static Supplier<List<String>> getListOfDBConnectionsUrlSupplier = () ->
            List.of("jdbc://localhost:5432/user_db", "jdbc://192.168.30.14:5432/user_db");
}
