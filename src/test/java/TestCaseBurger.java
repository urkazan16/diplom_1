import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import stellarBurgers.Bun;
import stellarBurgers.Burger;
import stellarBurgers.Ingredient;
import stellarBurgers.IngredientType;

import static org.junit.Assert.assertEquals;
import static stellarBurgers.IngredientType.FILLING;
import static stellarBurgers.IngredientType.SAUCE;
import static stellarBurgers.constants.TestBun.BUN_NAME;
import static stellarBurgers.constants.TestBun.BUN_PRICE;
import static stellarBurgers.constants.TestIngredient.*;

@RunWith(MockitoJUnitRunner.class)
public class TestCaseBurger {
    public Burger burger;
    @Mock
    public Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void initBurger() {
        burger = new Burger();
        burger.addIngredient(new Ingredient(SAUCE, INGREDIENT_NAME_CUTLET, INGREDIENT_PRICE));
    }

    @Test
    public void testAddIngredientTest() {
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredientTest() {
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredientTest() {
        burger.addIngredient(new Ingredient(FILLING, INGREDIENT_NAME_CUTLET, INGREDIENT_PRICE));
        burger.moveIngredient(1, 1);
        assertEquals(INGREDIENT_NAME_CUTLET, burger.ingredients.get(1).name);
    }

    @Test
    public void testGetPriceTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(200F);
        assertEquals(burger.getPrice(), 600F, 0);
    }

    @Test
    public void testGetReceiptTest() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, INGREDIENT_NAME_SOUR_CREAM, INGREDIENT_PRICE));
        bun = new Bun(BUN_NAME, BUN_PRICE);
        burger.setBuns(bun);
        String expectedReceipt = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void testGetReceiptTest1() {
        burger = new Burger();
        Mockito.when(ingredient.getName()).thenReturn(INGREDIENT_NAME_CUTLET);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(INGREDIENT_PRICE);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        burger.setBuns(bun);
        StringBuilder receipt = new StringBuilder();
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("= %s %s =%n", burger.ingredients.get(0).getType().toString().toLowerCase(), burger.ingredients.get(0).getName()));
        receipt.append(String.format("(==== %s ====)%n", "black bun"));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        String expectedReceipt = receipt.toString();
        String actual = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, actual);
    }
}