package com.card_management_system.card_management_system;

import java.security.MessageDigest;
import java.util.Base64;

public class HashUtil {

    /**
     * Generates a SHA-256 hash of the given input string.
     *
     * @param data The input string to hash.
     * @return A Base64-encoded SHA-256 hash.
     * @throws Exception If hashing fails.
     */
    public static String hash(String data) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(data.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(hash);
    }


    public static boolean verifyHash(String data, String expectedHash) throws Exception {
        String actualHash = hash(data);
        return actualHash.equals(expectedHash);
    }
}
