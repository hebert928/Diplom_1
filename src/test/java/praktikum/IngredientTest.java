package praktikum;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest{
    @Mock
    public Ingredient ingredient;

    @Test
    public void getPriceReturnPrice() {
        Mockito.when(ingredient.getPrice()).thenReturn(200F);
        float actual = ingredient.getPrice();
        float expected = 200;

        assertEquals(expected, actual, 0.05);
    }

    @Test
    public void getNameReturnName() {
        Mockito.when(ingredient.getName()).thenReturn("sour cream");
        String actual = ingredient.getName();
        String expected = "sour cream";

        assertEquals(expected, actual);
    }

    @Test
    public void getTypeReturnType() {
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        IngredientType actual = ingredient.getType();
        IngredientType expected = IngredientType.SAUCE;

        assertEquals(expected, actual);
    }
}