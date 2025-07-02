package io;

import static org.junit.Assert.*;
import org.junit.*;

public class FileIOTest {

    private FileIO fileIO;

    @Before
    public void setUp() {
        fileIO = new FileIO();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFileNotFound() {
        fileIO.readFile("src/test/resources/nonexistent.txt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyFile() {
        fileIO.readFile("src/test/resources/empty_file.txt");
    }

    @Test
    public void testValidFile() {
        int[] expected = {3, 9, 0, 2, 10, 9, 3, 8, 0, 3};
        assertArrayEquals(expected, fileIO.readFile("src/test/resources/grades_valid.txt"));
    }

    @Test(expected = NumberFormatException.class)
    public void testFileWithInvalidNumber() {
        fileIO.readFile("src/test/resources/grades_invalid.txt");
    }
}
