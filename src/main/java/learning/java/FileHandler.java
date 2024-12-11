package learning.java;

import java.io.*;
import java.util.*;

public class FileHandler {
    public List<Double> readNumbersFromFile(String filePath) throws IOException {
        List<Double> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.trim().split("\\s+");
                for (String token : tokens) {
                    try {
                        numbers.add(Double.parseDouble(token));
                    } catch (NumberFormatException e) {
                        // ігнорування некоректних даних
                    }
                }
            }
        }
        return numbers;
    }

    public void writePairsToFile(String filePath, List<String> pairs) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String pair : pairs) {
                writer.write(pair);
                writer.newLine();
            }
        }
    }
}
