/* (C)2023 */
package com.shevliakov.upsbatterycalculator.logic;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/** Hash class is used to hash passwords */
public class Hash {

    /**
     * Method to hash string
     *
     * @param base string to hash
     * @return hashed string
     */
    public static String getHash(final String base) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(base.getBytes(StandardCharsets.UTF_8));
            final StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                final String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
