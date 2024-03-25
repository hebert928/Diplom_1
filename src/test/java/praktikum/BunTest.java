package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Mock
    public Bun bun;

    @Test
    public void getNameReturnName() {
        Mockito.when(bun.getName()).thenReturn("red bun");
        String actual = bun.getName();
        String expected = "red bun";

        assertEquals(expected, actual);
    }

    @Test
    public void getPriceReturnPrice() {
        Mockito.when(bun.getPrice()).thenReturn(300F);
        float actual = bun.getPrice();
        float expected = 300;

        assertEquals(expected, actual, 0.05);
    }
}