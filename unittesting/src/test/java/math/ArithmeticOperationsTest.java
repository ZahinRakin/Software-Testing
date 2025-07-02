package math;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ArithmeticOperationsTest {

    private ArithmeticOperations arithmeticOperations;

    @Before
    public void setUp() {
        arithmeticOperations = new ArithmeticOperations();
    }

    // Test for divide method
    @Test
    public void testDivide_ValidInputs() {
        assertEquals(5.0, arithmeticOperations.divide(10.0, 2.0), 0.0001);
        assertEquals(-2.5, arithmeticOperations.divide(-5.0, 2.0), 0.0001);
    }

    @Test
    public void testDivide_ValidInputs_2() {
        assertEquals(0.5, arithmeticOperations.divide(1.0, 2.0), 0.0001);
        assertEquals(-2.5, arithmeticOperations.divide(-5.0, 2.0), 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivide_ByZero() {
        arithmeticOperations.divide(10.0, 0);
    }

    // Test for multiply method
    @Test
    public void testMultiply_ValidInputs() {
        assertEquals(20, arithmeticOperations.multiply(4, 5));
        assertEquals(0, arithmeticOperations.multiply(0, 5));
    }

    @Test
    public void testMultiply_ValidInputs_2() {
        assertEquals(9, arithmeticOperations.multiply(3, 3));
        assertEquals(0, arithmeticOperations.multiply(0, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiply_NegativeX() {
        arithmeticOperations.multiply(-1, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiply_NegativeY() {
        arithmeticOperations.multiply(5, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiply_ProductOverflow() {
        int x = Integer.MAX_VALUE;
        int y = 2;
        arithmeticOperations.multiply(x, y);
    }
}
