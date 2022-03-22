public class CalculatorTest
{
     public static void main (String[] args)
     {
          String testString = "ab*ca-/de*+";
          double result;
          result = Calculator.evaluatePostfix(testString);
          double expectedResult = 33;
          System.out.println("The expected result is "+ expectedResult);
          System.out.println("The answer we got is " + result);

          String anotherTestString = "a*b/(c-a)+d*e";
          String result1;
          result1 = Calculator.convertToPostfix(anotherTestString);
          String expectedResult1 = "ab*ca-/de*+";
          System.out.println("The expected result is "+ expectedResult1);
          System.out.println("The answer we got is " + result1);
     }

}//end CalculatorTest
