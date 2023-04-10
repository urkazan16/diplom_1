import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import stellarburgers.Bun;

@RunWith(Parameterized.class)
public class TestCaseBunParameterized {

    private final String name;
    private final float price;
    private Bun bun;

    public TestCaseBunParameterized(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Набор параметров {index}")
    public static Object[][] getBunDatabase() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {"bun", 30F},
                {"", 0},
        };
    }

    @Before
    public void initBurger() {
        bun = new Bun(name, price);
    }

    @Test
    public void testBunGetName() {
        bun.getName();
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void testBunGetPrice() {
        bun.getName();
        Assert.assertEquals(price, bun.getPrice(), 0);
    }

}