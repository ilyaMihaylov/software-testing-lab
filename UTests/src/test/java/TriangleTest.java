import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    private Triangle triangle;

    @BeforeEach
    void init() {
        triangle = new Triangle();
    }

    @Test
    @DisplayName("Triangle exists")
    void triangleClassExists() {
        assertNotNull(triangle);
    }

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
        assertEquals(expectedResult, triangle.isPossible(a, b, c),
                () -> "Triangle with sides: " + a + ", " + b + " and " + c + " " + "should" + (expectedResult ? " exist" : "n't exist"));
    }

    //assertTrue test. Checks if returning value is true
    @Test
    @DisplayName("assertTrue: Triangle with sides 10, 10 and 10 should exist")
    void isPossibleAssertTrue() {
        assertTrue(triangle.isPossible(10, 10, 10));
    }

    //assertFalse test. Checks if returning value is false
    @Test
    @DisplayName("assertFalse: Triangle with sides 1, 2 and 3 shouldn't exist")
    void isPossibleAssertFalse() {
        assertFalse(triangle.isPossible(1, 2, 3));
    }

    //assertSame test. Checks if expected and actual refer to the same object
    @Test
    @DisplayName("assertSame: Triangle with sides 11, 12 and 13 should exist")
    void isPossibleAssertSame() {
        assertSame(true, triangle.isPossible(11, 12, 13));
    }

    //assertEquals test. Checks if expected and actual are equal
    @Test
    @DisplayName("assertEquals: Triangle with sides 101, 102 and 103 should exist")
    void isPossibleAssertEquals() {
        assertEquals(true, triangle.isPossible(101, 102, 103));
    }

    //assertNotEquals test. Checks if expected and actual are not equal
    @Test
    @DisplayName("assertNotEquals: Triangle with sides 10, 5 and 5 shouldn't exist")
    void isPossibleAssertNotEquals() {
        assertNotEquals(true, triangle.isPossible(10, 5, 5));
    }

    @AfterEach
    void destroy() {
        triangle = null;
    }
}