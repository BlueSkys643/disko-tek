package LoginRegister;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypto {
    private static Crypto crypto = null;
    private Crypto() {}
    protected static String md5Sum(String input) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException("Unable to compute md5sum");
        }
        assert (messageDigest != null);
        messageDigest.update(input.getBytes());
        BigInteger hash = new BigInteger(1, messageDigest.digest());
        return (hash.toString(16));
    }
    public static Crypto getInstance() {
        if (crypto == null) {
            crypto = new Crypto();
            return crypto;
        }
        else {
            return crypto;
        }
    }
}
