import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import stellarBurgers.Burger;
import stellarBurgers.Ingredient;
import stellarBurgers.IngredientType;


@RunWith(Parameterized.class)
public class TestCaseIngredientParameterized {

    private final String name;
    private final float price;
    public Burger burger;
    public Ingredient ingredient;
    private IngredientType type;

    public TestCaseIngredientParameterized(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Набор параметров {index}")
    public static Object[][] getIngredientDatabase() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
                {IngredientType.FILLING, "", 0},
        };
    }

    @Before
    public void initIngredient() {
        burger = new Burger();
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testGetType() {
        Assert.assertEquals(type, ingredient.getType());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

}