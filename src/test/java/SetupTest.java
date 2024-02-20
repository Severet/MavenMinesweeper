import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SetupTest {
    @Test
    void setupTest() {
        GUI display = new GUI();
        display.displaySetup();
        int r = RandomNumber.generateInt(10);
        Assertions.assertTrue(0<=r && r<= 10);
    }
}
