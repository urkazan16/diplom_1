import org.junit.Assert;
import org.junit.Test;
import stellarburgers.IngredientType;

import static stellarburgers.constants.TestIngredient.INGREDIENT_TYPE_FILLING;
import static stellarburgers.constants.TestIngredient.INGREDIENT_TYPE_SAUCE;

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
