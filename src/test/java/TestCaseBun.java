import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import stellarBurgers.Bun;

import static stellarBurgers.constants.TestBun.BUN_NAME;
import static stellarBurgers.constants.TestBun.BUN_PRICE;

@RunWith(MockitoJUnitRunner.class)
public class TestCaseBun {
    private Bun bun;

    @Before
    public void initBun() {
        bun = new Bun(BUN_NAME, BUN_PRICE);
    }

    @Test
    public void testBunName() {
        String result = bun.getName();
        String expectName = BUN_NAME;
        Assert.assertEquals(expectName, result);
    }

    @Test
    public void testBunPrice() {
        Float result = bun.getPrice();
        Float expectPrice = BUN_PRICE;
        Assert.assertEquals(expectPrice, result);
    }
}