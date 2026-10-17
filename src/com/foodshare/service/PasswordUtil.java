package com.foodshare.service;
import java.security.*; import java.util.Base64; import javax.crypto.SecretKeyFactory; import javax.crypto.spec.PBEKeySpec;
/** JDK-only PBKDF2 password hashing. */
public final class PasswordUtil {
 private static final int ITERATIONS=210000, BITS=256; private static final SecureRandom RANDOM=new SecureRandom(); private PasswordUtil(){}
 public static String hash(String password){byte[] salt=new byte[16];RANDOM.nextBytes(salt);return "pbkdf2-sha256$"+ITERATIONS+"$"+Base64.getEncoder().encodeToString(salt)+"$"+Base64.getEncoder().encodeToString(derive(password.toCharArray(),salt,ITERATIONS));}
 public static boolean verify(String password,String encoded){try{String[] a=encoded.split("\\$",-1);if(a.length!=4||!"pbkdf2-sha256".equals(a[0]))return false;byte[] expected=Base64.getDecoder().decode(a[3]);return MessageDigest.isEqual(expected,derive(password.toCharArray(),Base64.getDecoder().decode(a[2]),Integer.parseInt(a[1])));}catch(RuntimeException e){return false;}}
 private static byte[] derive(char[] pw,byte[] salt,int iterations){PBEKeySpec spec=new PBEKeySpec(pw,salt,iterations,BITS);try{return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();}catch(GeneralSecurityException e){throw new IllegalStateException(e);}finally{spec.clearPassword();}}
}
