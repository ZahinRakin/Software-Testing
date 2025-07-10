package io;

import static org.junit.Assert.*;
import org.junit.*;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileIOTest {

    private FileIO fileIO;

    @Before
    public void setUp() {
        fileIO = new FileIO();
    }

    // // Helper method to get file path from test resources
    // private String getResourcePath(String filename) {
    //     URL resource = getClass().getClassLoader().getResource(filename);
    //     if (resource == null) {
    //         throw new IllegalArgumentException("Test resource file not found: " + filename);
    //     }
    //     return resource.getPath();
    // }

    // // ------------------------------------------------------------------
    // // ✅ TEST CASES BASED ON YOUR EXISTING FILES
    // // ------------------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void testFileNotFound() {
        // Expected to fail — file doesn't exist
        fileIO.readFile("src/test/resources/nonexistent.txt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyFile() {
        fileIO.readFile("/home/zahin-abdullah-rakin/Documents/6th semester/Software-Testing/PITest/src/test/resources/empty_file.txt");
    }

    @Test
    public void testValidFile() {
        int[] expected = {3, 9, 0, 2, 10, 9, 3, 8, 0, 3};
        assertArrayEquals(expected, fileIO.readFile("/home/zahin-abdullah-rakin/Documents/6th semester/Software-Testing/PITest/src/test/resources/grades_valid.txt"));
    }

    @Test(expected = NumberFormatException.class)
    public void testInvalidFile() {
        fileIO.readFile("/home/zahin-abdullah-rakin/Documents/6th semester/Software-Testing/PITest/src/test/resources/grades_invalid.txt");
    }

    @Test
    public void testAnotherValidFile_PrimesTxt() {
        int[] expected = {3, 9, 2, 10, 9, 3, 8, 3};
        assertArrayEquals(expected, fileIO.readFile("/home/zahin-abdullah-rakin/Documents/6th semester/Software-Testing/PITest/src/test/resources/primes.txt"));
    }

    @Test
    public void testNonexistentFileWithFakePath() {
        File file = new File("totally_fake_file_123.txt");
        assertFalse(file.exists());
        assertThrows(IllegalArgumentException.class, () -> fileIO.readFile(file.getPath()));
    }
    
    @Test
    public void testThrowsRuntimeExceptionOnIOException() {
        String path = "/home/zahin-abdullah-rakin/Documents/6th semester/Software-Testing/PITest/src/test/resources/";
        // It’s a directory, not a file — should throw IOException wrapped in RuntimeException
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> fileIO.readFile(path));
        assertEquals("Failed to read file", thrown.getMessage());
    }
}
