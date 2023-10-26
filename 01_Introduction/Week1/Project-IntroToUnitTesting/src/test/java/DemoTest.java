
/*
 * The class containing your tests for the {@link Demo} class. Make sure you
 * test all methods in this class (including both
 * {@link Demo#main(String[])} and
 * {@link Demo#isTriangle(double, double, double)}).
 */
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class DemoTest {

    @Test
    public void test1() {
        boolean actual = Demo.isTriangle(1, 1, 1);
        boolean expect = true;
        assertEquals(expect, actual);
    }

    @Test
    public void test2() {
        assertTrue(3 + 0 == 1 + 2);
    }

}
