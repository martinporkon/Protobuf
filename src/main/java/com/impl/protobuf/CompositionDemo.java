package com.impl.protobuf;

import com.google.protobuf.Int32Value;
import com.test.models.Address;
import com.test.models.Car;
import com.test.models.Person;

import java.util.ArrayList;

public class CompositionDemo {

    public static void main(String[] args) {

        Address address = Address.newBuilder()
                .setPostbox(123)
                .setStreet("main street")
                .setCity("Atlanta")
                .build();


        Car accord = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setYear(2020)
                .build();

        Car civic = Car.newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setYear(2005)
                .build();

        Person sam = Person.newBuilder()
                .setName("sam")
                //.setAge(25)
                .setAge(Int32Value.newBuilder().setValue(25).build())
                .addCar(accord)
                .addCar(civic)
                .setAddress(address)
                .build();


        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(accord);
        cars.add(civic);

        Person sam1 = Person.newBuilder()
                        .setName("sam1")
                        //.setAge(25)
                        .setAge(Int32Value.newBuilder().setValue(25).build())
                        .addAllCar(cars)
                        .setAddress(address)
                        .build();


        System.out.println(
                sam1
        );


    }
}
