package com.impl.protobuf;

import com.test.models.Credentials;
import com.test.models.EmailCredentials;
import com.test.models.PhoneOTP;

public class OneOfDemo {

    public static void main(String[] args) {

        EmailCredentials email = EmailCredentials.newBuilder()
                .setEmail("nobody@gmail.com")
                .setPassword("admin123")
                .build();

        PhoneOTP phoneOTP = PhoneOTP.newBuilder()
                .setNumber(1231234)
                .setCode(456)
                .build();

        Credentials credentials = Credentials.newBuilder()
                .setEmailMode(email)
                .setPhoneMode(phoneOTP)// not both
                // the moment we set phone, the email is gone.
                // right now only the phone mode has been set
                .build();

        login(credentials);
    }

    private  static void login(Credentials credentials) {

        // this is not printing any value, because oneof is one, but not
        // both
        System.out.println(
                credentials.getEmailMode()
        );

        switch(credentials.getModeCase()) {
            case EMAILMODE:
                System.out.println(credentials.getEmailMode());
                break;
            case PHONEMODE:
                System.out.println(credentials.getPhoneMode());
                break;
        }

        System.out.println(
                credentials.getPhoneMode()
        );

    }
}
