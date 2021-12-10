package com.impl.protobuf;

import com.test.models.Television;
import com.test.models.Type;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VersionCompatibilityTest {

    public static void main(String[] args) throws IOException {

        Path pathV1 = Paths.get("tv-v1");
        Path pathV2 = Paths.get("tv-v2");
        /*Television television = Television.newBuilder()
                .setBrand("sony")
                .setYear(2015)// the other service or company is still using this message format
                // no set year
                .build();


        Path pathV1 = Paths.get("tv-v1");
        Files.write(pathV1, television.toByteArray());*/
        Television television = Television.newBuilder()
                .setBrand("sony")
                .setModel(2016)
                .setType(Type.OLED)
                .build();

        Files.write(pathV1, television.toByteArray());

        //
        byte[] bytes = Files.readAllBytes(pathV1);
        System.out.println(
                Television.parseFrom(bytes).getType()
        );

    }
}
