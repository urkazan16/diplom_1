import org.junit.Assert;
import org.junit.Test;
import stellarBurgers.IngredientType;

import static stellarBurgers.constants.TestIngredient.INGREDIENT_TYPE_FILLING;
import static stellarBurgers.constants.TestIngredient.INGREDIENT_TYPE_SAUCE;

public class TestCaseIngredientType {

    @Test
    public void selectSauceTest() {
        Assert.assertEquals(IngredientType.valueOf(INGREDIENT_TYPE_SAUCE), IngredientType.SAUCE);
    }

    @Test
    public void selectFillingTest() {
        Assert.assertEquals(IngredientType.valueOf(INGREDIENT_TYPE_FILLING), IngredientType.FILLING);
    }
}
