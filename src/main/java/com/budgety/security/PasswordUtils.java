package com.budgety.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.apache.commons.lang3.StringUtils;

public class PasswordUtils {

  private static final int ITERATIONS = 10000;
  private static final int KEY_LENGTH = 256;

  public static String getSalt() {
    SecureRandom secureRandom = new SecureRandom();
    byte bytes[] = new byte[20];
    secureRandom.nextBytes(bytes);
    return byteToString(bytes);
  }

  public static String byteToString(byte[] bytes) {
    return Base64.getEncoder().encodeToString(bytes);
  }

  public static byte[] hash(char[] password, byte[] salt) {
    PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
    Arrays.fill(password, Character.MIN_VALUE);
    try {
      SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
      return skf.generateSecret(spec).getEncoded();
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
    } finally {
      spec.clearPassword();
    }
  }

  public static String generateSecuredPassword(String password, String salt) {
    byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
    return byteToString(securePassword);
  }

  public static boolean isExpectedPassword(String password, String expectedPassword, String salt) {
    String generatedPassword = generateSecuredPassword(password, salt);
    return StringUtils.equals(generatedPassword, expectedPassword);

  }

}
