package praktikum;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class BurgerTest {
    public Burger burger;
    public Database database;
    @Before
    public void testData() {
        burger = new Burger();
        database = new Database();
    }

    @Test
    public void checkSetBunsEqualsBun() {
        Bun bun = database.availableBuns().get(2);
        burger.setBuns(bun);
        Bun actual = burger.bun;
        Bun expected = bun;

        assertEquals(expected, actual);
    }

    @Test
    public void checkAddIngredientEqualsIngredient() {
        Ingredient ingredient = database.availableIngredients().get(1);
        burger.addIngredient(ingredient);
        Ingredient actual = ingredient;
        Ingredient expected = burger.ingredients.get(0);

        assertEquals(expected, actual);
    }

    @Test
    public void checkRemoveIngredientListIsEmpty() {
        Ingredient ingredient = database.availableIngredients().get(5);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        boolean actual = burger.ingredients.isEmpty();

        assertTrue(actual);
    }

    @Test
    public void checkMoveIngredientChangeIndex() {
        Ingredient[] testData = {database.availableIngredients().get(0),
                                 database.availableIngredients().get(1),
                                 database.availableIngredients().get(2)};
        burger.ingredients.addAll(Arrays.asList(testData));
        burger.moveIngredient(0, 2);
        Ingredient actual = burger.ingredients.get(2);
        Ingredient expected = testData[0];

        assertEquals(expected, actual);
    }

    @Test
    public void checkGetPriceReturnPrice() {
        Bun bun = database.availableBuns().get(1);
        Ingredient ingredient = database.availableIngredients().get(0);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        float expected = 500;

        assertEquals(expected, actual, 0.05);
    }
}