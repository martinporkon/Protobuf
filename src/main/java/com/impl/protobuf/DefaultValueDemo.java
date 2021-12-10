package com.impl.protobuf;

import com.test.models.Person;

public class DefaultValueDemo {

    public static void main(String[] args) {

        Person person = Person.newBuilder().build();

        System.out.println(// there is no null in protobuf, it gives the default value
                "City : " + person.getAddress().getCity()
        );

        System.out.println(
                person.hasAddress()
        );

        // int32 / any number type -> 0 (default)
        // bool -> false (default)
        // string -> empty string (default)
        // enum -> first value (default)
        // repeated -> empty list (default)
        // map -> wrapper / empty map (default)

        // enum forces to have the 0



    }
}
