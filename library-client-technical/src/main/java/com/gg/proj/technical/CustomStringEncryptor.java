package com.gg.proj.technical;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class CustomStringEncryptor {

    public static String encrypt(String toEncyrpt) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("p)EkutxF,f;wJ7gxD)zB9h");
        encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
        return encryptor.encrypt(toEncyrpt);
    }
}
