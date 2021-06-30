package me.tsb.backdoor;

import me.tsb.plugin.Main;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {

    /**
     * Gets the specified string as SHA-512
     * @param theString the string to convert
     * @return the hash of the string
     */
    public static String getAsSHA512(String theString) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            byte[] messageDigest = md.digest(theString.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            StringBuilder hashtext = new StringBuilder(no.toString(16));

            while (hashtext.length() < 32) {
                hashtext.insert(0, "0");
            }

            return hashtext.toString();
        } catch (NoSuchAlgorithmException e) {
            Main.logger.exception(e.toString());
            return null;
        }
    }
}
