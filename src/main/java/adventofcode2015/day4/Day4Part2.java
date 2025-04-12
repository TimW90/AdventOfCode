package adventofcode2015.day4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4Part2 {
    public static void main(String[] args) {

        int number = 0;

        do {
            String mD5Hash = getMD5Hash(SecretKey.getSecretKey() + number);
            if (mD5Hash.startsWith("000000")) {
                System.out.println("Hash starting with '000000' found!");
                System.out.println("'" + mD5Hash + "'");
                System.out.println("Number is: " + number);
                break;
            }
            number++;
        } while (true);
    }

    public static String getMD5Hash(String input) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();

            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
