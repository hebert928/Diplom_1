package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {
    public Bun bun;

    @Before
    public void testData() {
        bun = new Bun("red bun", 300);
    }

    @Test
    public void getNameReturnName() {
        String actual = bun.getName();
        String expected = "red bun";

        assertEquals(expected, actual);
    }

    @Test
    public void getPriceReturnPrice() {
        float actual = bun.getPrice();
        float expected = 300;

        assertEquals(expected, actual, 0.05);
    }
}