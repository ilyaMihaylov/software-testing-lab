import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTest {
    @ParameterizedTest(name = "isPossible function, Sides: {0}, {1} and {2}")
    @CsvSource({
            "0, 0, 0, false",                   //All sides equals 0, should'nt be possible
            "-1, -1, -1, false",                //All sides are negative, should'nt be possible
            "-5, 5, 5, false",                  //One of sides is negative, shouldn't be possible
            "5, -5, 5, false",                  //One of sides is negative, shouldn't be possible
            "5, 5, -5, false",                  //One of sides is negative, shouldn't be possible
            "0, 5, 5, false",                   //One of sides is 0, shouldn't be possible
            "5, 0, 5, false",                   //One of sides is 0, shouldn't be possible
            "5, 5, 0, false",                   //One of sides is 0, shouldn't be possible
            "1, 1, 1, true",                    //Equilateral triangle should exist
            "2, 2, 2, true",                    //Equilateral triangle should exist
            "5, 5, 5, true",                    //Equilateral triangle should exist
            "2, 1, 1, false",                   //The sum of the two sides is not greater than the third
            "1, 2, 1, false",                   //The sum of the two sides is not greater than the third
            "1, 1, 2, false",                   //The sum of the two sides is not greater than the third
            "1.2, 2.399999999, 1.2, true",      //Double passed as a parameter and the triangle exists
            "2.5, 5.000000001, 2.5, false",     //Double passed as a parameter and the triangle shouldn't exist
            "5, 4, 3, true",                    //The sum of the two sides is greater than the third
            "7, 8, 9, true",                    //The sum of the two sides is greater than the third
            "2, 3, 4, true"                     //The sum of the two sides is greater than the third
    })
    void isPossible(double a, double b, double c, boolean expectedResult) {
        Triangle triangle = new Triangle();
        assertEquals(expectedResult, triangle.isPossible(a, b, c),
                () -> "Triangle with sides: " + a + ", " + b + " and " + c + " " + "should" + (expectedResult ? " exist" : "n't exist"));
    }
}