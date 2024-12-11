package learning.java;

import java.io.*;
import java.util.*;

public class OppositeSignNumbersApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть шлях до вхідного файлу:");
        String inputFilePath = scanner.nextLine();

        System.out.println("Введіть шлях до вихідного файлу:");
        String outputFilePath = scanner.nextLine();

        System.out.println("Введіть точність (наприклад, 0.001):");
        double precision = scanner.nextDouble();

        FileHandler fileHandler = new FileHandler();
        OppositeSignNumbersFinder finder = new OppositeSignNumbersFinder(precision);

        try {
            List<Double> numbers = fileHandler.readNumbersFromFile(inputFilePath);
            List<String> pairs = finder.findOppositeSignPairs(numbers);
            fileHandler.writePairsToFile(outputFilePath, pairs);
            System.out.println("Обробка завершена. Результат записано у файл: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Помилка під час обробки файлів: " + e.getMessage());
        }
    }
}
