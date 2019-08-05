package com.hackerrank.dashboard.java.advanced;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA256 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String toEncrypt =  in.nextLine();

        MessageDigest sha = null;

        try {
            sha = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        sha.update(toEncrypt.getBytes());
        byte[] digest = sha.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toLowerCase();
        System.out.println(myHash);
    }
}
