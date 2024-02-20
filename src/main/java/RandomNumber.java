import java.util.Random;

public class RandomNumber {
    private static final Random r = new Random();
    public static int generateInt(int limit) {
        return r.nextInt(limit);
    }
}
