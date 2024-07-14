
import java.util.*;
import java.security.SecureRandom;
public class PasswordGenerator {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$%&*()_+-=[]|,./?><";

    private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;
    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        System.out.println("enter the length of the password");
        Scanner sc=new Scanner(System.in);
        int length = sc.nextInt(); // Password length
        System.out.println(generatePassword(length));
    }

    public static String generatePassword(int length) {
        if (length < 8 || length > 16) {
            throw new IllegalArgumentException("Password length must be at least 8 to 16 characters");
        }

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(PASSWORD_ALLOW_BASE.length());
            password.append(PASSWORD_ALLOW_BASE.charAt(randomIndex));
        }

        return password.toString();
    }
}
