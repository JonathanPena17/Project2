import junit.framework.TestCase;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest extends TestCase 
{
   public void testEvaluateMethod(){
        // Arrange
        String testString = "AB*CA-/DE*+";
        double result;

        // Act
        result = Calculator.evaluatePostfix(testString);
        double expectedResult = 33;

        // Assert
        assertEquals(result, expectedResult);
    }

    /**a public test method for the convert method in calculator class
     * used assertEquals and passes in the expected string and the resulting string
     * to make sure that they are equivalent to each other
     */
    public void testConfigMethod()
    {
       // Arrange
            String anotherTestString = "A*B/(C-A)+D*E";
            String result;

       // Act
            result = Calculator.convertToPostfix(anotherTestString);
            String expectedResult = "AB*CA-/DE*+";

       // Assert
            assertEquals(result, expectedResult);
    }
}//end CalculatorTest
