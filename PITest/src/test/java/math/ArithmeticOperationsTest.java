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

    // Division Tests
    @Test
    public void testDivide_PositiveNumbers() {
        assertEquals(2.5, arithmeticOperations.divide(5.0, 2.0), 0.0001);
    }

    @Test
    public void testDivide_NegativeNumerator() {
        assertEquals(-2.5, arithmeticOperations.divide(-5.0, 2.0), 0.0001);
    }

    @Test
    public void testDivide_NegativeDenominator() {
        assertEquals(-2.5, arithmeticOperations.divide(5.0, -2.0), 0.0001);
    }

    @Test
    public void testDivide_BothNegative() {
        assertEquals(2.5, arithmeticOperations.divide(-5.0, -2.0), 0.0001);
    }

    @Test
    public void testDivide_ZeroNumerator() {
        assertEquals(0.0, arithmeticOperations.divide(0.0, 2.0), 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivide_ByZero() {
        arithmeticOperations.divide(10.0, 0.0);
    }

    // Multiplication Tests
    @Test
    public void testMultiply_BasicPositive() {
        assertEquals(6, arithmeticOperations.multiply(2, 3));
    }

    @Test
    public void testMultiply_ZeroX() {
        assertEquals(0, arithmeticOperations.multiply(0, 5));
    }

    @Test
    public void testMultiply_ZeroY() {
        assertEquals(0, arithmeticOperations.multiply(5, 0));
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
    public void testMultiply_BothNegative() {
        arithmeticOperations.multiply(-1, -1);
    }

    @Test
    public void testMultiply_MaxValueWithOne() {
        assertEquals(Integer.MAX_VALUE, arithmeticOperations.multiply(Integer.MAX_VALUE, 1));
    }

    @Test
    public void testMultiply_EdgeCaseNoOverflow() {
        int x = Integer.MAX_VALUE / 2;
        assertEquals(Integer.MAX_VALUE - 1, arithmeticOperations.multiply(x, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiply_OverflowCase() {
        arithmeticOperations.multiply(Integer.MAX_VALUE / 2 + 1, 2);
    }

    @Test
    public void testMultiply_LargeButSafe() {
        assertEquals(2000000000, arithmeticOperations.multiply(100000, 20000));
    }

    @Test
    public void testMultiply_One() {
        assertEquals(5, arithmeticOperations.multiply(5, 1));
    }

    @Test
    public void testMultiply_ZeroWithMaxValue() {
        assertEquals(0, arithmeticOperations.multiply(0, Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiply_ZeroWithNegative() {
        arithmeticOperations.multiply(0, -1);
    }
}