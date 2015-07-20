package com.setplex.middleware.util;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Arrays;

public class PasswordHelper {

    private final static int SALT_LENGTH = 128;
    private final static MessageDigest messageDigest = getMessageDigest();
    private final static SecureRandom random = getSecureRandom();

    private static MessageDigest getMessageDigest() {
        try {
            return MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hash creation exception", e);
        }
    }

    private static SecureRandom getSecureRandom() {
        try {
            return SecureRandom.getInstance("SHA1PRNG", "SUN");
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            throw new RuntimeException("Salt creation exception", e);
        }
    }

    /**
     * Checks password against provided hash and salt. The assumption is that hash has been created
     * using {@link #hashPassword(String, String)} method.
     *
     * @param password password to check
     * @param hash     hash to check against
     * @param salt     salt
     * @return {@code true} if password is valid
     */
    public static boolean check(String password, String hash, String salt) {
        String newHash = hashPassword(password, salt);
        return Arrays.equals(newHash.getBytes(), hash.getBytes());
    }

    /**
     * Creates a new salt.
     *
     * @return created salt
     * @throws RuntimeException
     */
    public static String makeSalt() throws RuntimeException {
        byte[] salt = new byte[SALT_LENGTH];
        getSecureRandom().nextBytes(salt);
        return Base64.encodeBase64String(salt);
    }

    /**
     * Hashes password with salt.
     *
     * @param password password to hash
     * @param salt     salt
     * @return hashed password
     */
    public static synchronized String hashPassword(String password, String salt) throws RuntimeException {
        messageDigest.update(salt.getBytes());
        return Base64.encodeBase64String(messageDigest.digest(password.getBytes()));
    }
}
