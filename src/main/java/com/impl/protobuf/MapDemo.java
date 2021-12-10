package com.impl.protobuf;

import com.test.models.BodyStyle;
import com.test.models.Car;
import com.test.models.Dealer;

public class MapDemo {

    public static void main(String[] args) {

        Car accord = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setBodyStyle(BodyStyle.COUPE)
                .setYear(2020)
                .build();

        Car civic = Car.newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setBodyStyle(BodyStyle.SEDAN)
                .setYear(2005)
                .build();

        Dealer dealer = Dealer.newBuilder()
                .putModel(2005, civic)
                .putModel(2020, accord)
                .build();

        // .getModelCount()
        // .getModelCountOrThrow <- if a key is not present etc
        // .getModelOrDefault(2019, accord) <- wrapper around a map
        // .getModelMap(). <-- gives directly java map realizations


        // we have not specifically said it was a SEDAN,
        // it then uses a default value, but really it is not a SEDAN
        // which is why we need a default unknown = 0; value
        System.out.println(
                dealer.getModelOrThrow(2020).getBodyStyle()
        );// 2020 model car

    }
}
