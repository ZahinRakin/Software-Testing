package math;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MyMathTest {

    private MyMath myMath;

    @Before
    public void setUp() {
        myMath = new MyMath();
    }

    // Tests for factorial method
    @Test
    public void testFactorial_ValidInputs() {
        assertEquals(1, myMath.factorial(0));  // Edge case
        assertEquals(1, myMath.factorial(1));
        assertEquals(120, myMath.factorial(5));
        assertEquals(479001600, myMath.factorial(12));  // Upper limit
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorial_NegativeInput() {
        myMath.factorial(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorial_AboveLimitInput() {
        myMath.factorial(13);
    }

    // Tests for isPrime method
    @Test
    public void testIsPrime_ValidInputs() {
        assertTrue(myMath.isPrime(2));  // Smallest prime
        assertTrue(myMath.isPrime(3));
        assertFalse(myMath.isPrime(4));
        assertTrue(myMath.isPrime(13));
        assertFalse(myMath.isPrime(15));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsPrime_InvalidInput() {
        myMath.isPrime(1);
    }
}
