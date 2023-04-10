import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.Database;

public class TestCaseDatabase {

    private Database database;

    @Before
    public void initDatabase() {
        database = new Database();
    }

    @Test
    public void testGetAvailableBuns() {
        Assert.assertFalse(database.availableBuns().isEmpty());
    }

    @Test
    public void testGetAvailableIngredients() {
        Assert.assertFalse(database.availableIngredients().isEmpty());
    }
}
