package com.impl.protobuf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Int32Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.impl.json.JPerson;
import com.test.models.Person;

public class PerformanceTest {

    public static void main(String[] args) {// serialize and deserialize test
        // how it performs


        // json

        JPerson person = new JPerson();

        person.setName("sam");
        person.setAge(10);

        ObjectMapper mapper = new ObjectMapper();

        Runnable json = () -> {
            try {
                byte[] bytes = mapper.writeValueAsBytes(person);
                System.out.println(bytes.length);
                JPerson person1 = mapper.readValue(bytes, JPerson.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // protobuf
        Runnable proto = () -> {

            Person sam = Person.newBuilder()
                    .setName("sam")
                    //.setAge(10)
                    .setAge(Int32Value.newBuilder().setValue(25).build())
                    .build();

            System.out.println(
                    sam.hasAge()// has age is now as well after int32 wrapper type
            );

            try {
                byte[] bytes = sam.toByteArray();
                System.out.println(bytes.length);// for the same data json is 23 elements in byte array
                // protocol buffer array has only 7 elements
                Person.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 1; i++) {
            runPerformanceTest(json, "JSON");
            runPerformanceTest(proto, "PROTO");
        }
    }

    private static void runPerformanceTest(Runnable runnable, String method) {

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {

            runnable.run();
        }
        long time2 = System.currentTimeMillis();

        System.out.println(
                method + " : " + (time2 - time1) + " ms"
        );

    }

}
