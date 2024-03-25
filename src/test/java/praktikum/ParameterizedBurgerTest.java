package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedBurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    private String bunName;
    private float bunPrice;
    private IngredientType ingredientType;
    private String ingredientName;
    private float ingredientPrice;
    private String expected;

    public ParameterizedBurgerTest(String bunName,
                                   float bunPrice,
                                   IngredientType ingredientType,
                                   String ingredientName,
                                   float ingredientPrice,
                                   String expected) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object [] [] getTestData() {
        return new Object[][] {
                {
                        "red bun",
                        300,
                        IngredientType.SAUCE,
                        "sour cream",
                        200,
                        String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n", "red bun",
                                IngredientType.SAUCE.toString().toLowerCase(), "sour cream", "red bun", 800.0)
                },
                {
                        "white bun",
                        200,
                        IngredientType.FILLING,
                        "dinosaur",
                        200,
                        String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n", "white bun",
                                IngredientType.FILLING.toString().toLowerCase(), "dinosaur", "white bun", 600.0)
                },
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
    }

    @Test
    public void getReceiptReturnReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actual = burger.getReceipt();

        assertEquals(expected, actual);
    }
}
