package learning.java;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OppositeSignNumbersFinderTest {
    @Test
    public void testFindOppositeSignPairs() {
        OppositeSignNumbersFinder finder = new OppositeSignNumbersFinder(0.001);
        List<Double> numbers = Arrays.asList(3.0, -3.0, 1.5, -1.499, 2.0, -2.0001, 0.001, -0.001);
        List<String> expectedPairs = Arrays.asList("3.000, -3.000", "1.500, -1.499", "2.000, -2.000", "0.001, -0.001");

        List<String> actualPairs = finder.findOppositeSignPairs(numbers);

        assertEquals(expectedPairs, actualPairs);
    }

}