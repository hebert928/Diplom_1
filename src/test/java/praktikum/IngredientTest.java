package praktikum;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest{
    public Ingredient ingredient;

    @Before
    public void testData() {
        ingredient = new Ingredient(IngredientType.SAUCE,"sour cream", 200);
    }

    @Test
    public void getPriceReturnPrice() {
        float actual = ingredient.getPrice();
        float expected = 200;

        assertEquals(expected, actual, 0.05);
    }

    @Test
    public void getNameReturnName() {
        String actual = ingredient.getName();
        String expected = "sour cream";

        assertEquals(expected, actual);
    }

    @Test
    public void getTypeReturnType() {
        IngredientType actual = ingredient.getType();
        IngredientType expected = IngredientType.SAUCE;

        assertEquals(expected, actual);
    }
}