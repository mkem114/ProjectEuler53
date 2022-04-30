import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void testCombinations() {
        assertEquals(1144066D, Main.combinations(23, 10));
    }
}
