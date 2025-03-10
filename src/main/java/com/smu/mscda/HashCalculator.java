package com.smu.mscda;
import java.math.BigInteger;
import java.security.MessageDigest;
import java. security. NoSuchAlgorithmException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashCalculator {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        System.out.print("Enter a string: ");
        String input = System.console().readLine();

        List<String> list = getCapitalizedHash(input);

        System.out.println("Capitalized string: " + list.get(0));
        System.out.println("String MD5 Hash: " + list.get(1));
    }

    public static List<String> getCapitalizedHash(String input) throws NoSuchAlgorithmException {

        List<String> subs = List.of(StringUtils.split(input)); // Split input by space
        subs = subs.stream().map(StringUtils::capitalize).toList(); // Apply StringUtils.capitalize() to each element
        String capitalized = StringUtils.join(subs, " "); // Join list by space
        MessageDigest md = MessageDigest.getInstance("MD5"); // Get MD5 algorithm instance
        md.update(capitalized.getBytes()); // Set what bytes to create hash out of
        byte[] digest = md.digest(); // Get digest
        String stringHash = String.format("%032x", new BigInteger(1, digest)); // Convert bytes back to string
        return List.of(capitalized, stringHash);
    }
}