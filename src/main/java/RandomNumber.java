import java.util.Random;

public class RandomNumber {
    private static final Random r = new Random();
    private RandomNumber() {
        throw new IllegalStateException("Utility class");
    }
    public static int generateInt(int limit) {
        return r.nextInt(limit);
    }
}
