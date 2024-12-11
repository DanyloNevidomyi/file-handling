package learning.java;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {
    @Test
    public void testReadNumbersFromFile() throws IOException {
        FileHandler fileHandler = new FileHandler();
        String inputFilePath = "test_input.txt";

        // Create test input file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFilePath))) {
            writer.write("3.0 -3.0 1.5 -1.499\n2.0 -2.0001 0.001 -0.001\n");
        }

        List<Double> expectedNumbers = Arrays.asList(3.0, -3.0, 1.5, -1.499, 2.0, -2.0001, 0.001, -0.001);
        List<Double> actualNumbers = fileHandler.readNumbersFromFile(inputFilePath);

        assertEquals(expectedNumbers, actualNumbers);

        // Clean up
        new File(inputFilePath).delete();
    }

    @Test
    public void testWritePairsToFile() throws IOException {
        FileHandler fileHandler = new FileHandler();
        String outputFilePath = "test_output.txt";

        List<String> pairs = Arrays.asList("3.000, -3.000", "1.500, -1.499", "2.000, -2.000", "0.001, -0.001");

        fileHandler.writePairsToFile(outputFilePath, pairs);

        // Read back the file and verify
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFilePath))) {
            for (String expectedPair : pairs) {
                String actualLine = reader.readLine();
                assertEquals(expectedPair, actualLine);
            }
        }

        // Clean up
        new File(outputFilePath).delete();
    }

}