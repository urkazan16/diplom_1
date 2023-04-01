import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import stellarBurgers.Bun;
import stellarBurgers.Burger;
import stellarBurgers.Database;

import java.util.List;

@RunWith(Parameterized.class)
public class TestCaseBunParameterized {

    private final String name;
    private final float price;
    public Burger burger;

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
        burger = new Burger();
    }

    @Test
    public void testGetName() {
        Database database = new Database();
        Bun bun = new Bun(name, price);
        List<Bun> buns = database.availableBuns();
        burger.setBuns(buns.get(0));
        bun.getName();
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Database database = new Database();
        Bun bun = new Bun(name, price);
        List<Bun> buns = database.availableBuns();
        burger.setBuns(buns.get(0));
        bun.getName();
        Assert.assertEquals(price, bun.getPrice(), 0);
    }

}