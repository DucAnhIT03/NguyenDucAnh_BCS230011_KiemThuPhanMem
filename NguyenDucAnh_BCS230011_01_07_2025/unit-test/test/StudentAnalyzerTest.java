import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTest {

    @Test
    public void testCountExcellentStudents_withMixedValidAndInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_emptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testCountExcellentStudents_boundaryValues() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(0.0, 0.0, 0.0)));
        assertEquals(3, analyzer.countExcellentStudents(Arrays.asList(10.0, 10.0, 10.0)));
    }

    @Test
    public void testCountExcellentStudents_allInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(-5.0, 11.0, 12.5)));
    }

    @Test
    public void testCalculateValidAverage_withMixedValidAndInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(8.17, analyzer.calculateValidAverage(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)), 0.01);
    }

    @Test
    public void testCalculateValidAverage_emptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.0);
    }

    @Test
    public void testCalculateValidAverage_boundaryValues() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0.0, analyzer.calculateValidAverage(Arrays.asList(0.0, 0.0, 0.0)), 0.0);
        assertEquals(10.0, analyzer.calculateValidAverage(Arrays.asList(10.0, 10.0, 10.0)), 0.0);
    }

    @Test
    public void testCalculateValidAverage_allInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0.0, analyzer.calculateValidAverage(Arrays.asList(-3.0, 15.0, null)), 0.0);
    }
}
