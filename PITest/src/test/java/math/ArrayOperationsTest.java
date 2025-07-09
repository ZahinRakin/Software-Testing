package math;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import io.FileIO;

import java.io.IOException;

public class ArrayOperationsTest {
    private ArrayOperations arrayOps;
    private FileIO fileIO;
    private MyMath myMath;
    private String testFilePath = "src/test/resources/primes.txt";

    @Before
    public void setUp() throws IOException {
        arrayOps = new ArrayOperations();
        fileIO = new FileIO();
        myMath = new MyMath();
    }

    @Test
    public void testFindPrimesInFile() {
        int[] expected = {3, 2, 3, 3};
        int[] actual = arrayOps.findPrimesInFile(fileIO, testFilePath, myMath);
        assertArrayEquals(expected, actual);
    }
}
