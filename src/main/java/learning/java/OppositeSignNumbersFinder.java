package learning.java;

import java.util.*;

// пошук пар чисел із протилежними знаками
public class OppositeSignNumbersFinder {
    private final double precision;

    public OppositeSignNumbersFinder(double precision) {
        this.precision = precision;
    }

    public List<String> findOppositeSignPairs(List<Double> numbers) {
        List<String> pairs = new ArrayList<>();
        Set<String> foundPairs = new HashSet<>();

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                double num1 = numbers.get(i);
                double num2 = numbers.get(j);
                if (Math.abs(Math.abs(num1) - Math.abs(num2)) <= precision && num1 * num2 < 0) {
                    String pair = String.format("%.3f, %.3f", num1, num2);
                    if (!foundPairs.contains(pair)) {
                        pairs.add(pair);
                        foundPairs.add(pair);
                    }
                }
            }
        }
        return pairs;
    }
}
