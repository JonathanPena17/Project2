public class Calculator 
{
    public static void main(String args[])
    {
        
        /**
         * This block tests the implementations convertToPostfix(String) and evaluatePostfix(String)
         */
        String inFixString = "A*B/(C-A)+D*E";
        System.out.println("\n************* DEMO *************\n\n");
        System.out.println("To demonstrate our linked and resizable array stacks we will convert an infix expression to postfix and evaluate it.");
        System.out.println("\n\tInfix expression: " + inFixString);
        System.out.println("\n(Task 2) We will now pass our infix string to our infix to postfix converter.");
        String postFix = convertToPostfix(inFixString);
        System.out.println("\n\tPostfix Expression: " + postFix);
        System.out.println("\n(Task 5) Now we will evaluate the postfix expression assuming all the values are equal to what task 4 stated in the project description.");
        System.out.println("\n\tThe value of the postfix expression is: " + evaluatePostfix(postFix));
        System.out.println("\n\n");
        
    }
    static String convertToPostfix(String anEntry)
    {
    // Converts an infix expression to an equivalent postfix expression. 
    operatorStack = a new empty stack
    postfix = a new empty string
    while (infix has characters left to parse)
    {
        nextCharacter = next nonblank character of infix 
        switch (nextCharacter)
        {
            case variable:
            Append nextCharacter to postfix break
            case '^' : 
               operatorStack.push(nextCharacter)
               break
            case '+' : case '-' : case '*' : case '/' : 
               while (!operatorStack.isEmpty() and
                 precedence of nextCharacter <= precedence of operatorStack.peek())
               {
                   Append operatorStack.peek() to postfix 
                   operatorStack.pop()
               }  
               operatorStack.push(nextCharacter) 
               break
            case '( ' : 
               operatorStack.push(nextCharacter) 
               break
            case ')' : // Stack is not empty if infix expression is valid 
               topOperator = operatorStack.pop()
               while (topOperator != '(')
               {
                   Append topOperator to postfix
                   topOperator = operatorStack.pop() 
               }
               break
            default: break // Ignore unexpected characters
        }
    }
    while (!operatorStack.isEmpty()) 
    {
       topOperator = operatorStack.pop()
       Append topOperator to postfix 
    }
    return postfix
    }
    
    static double evaluatePostfix(string postfix)
    {
    // Evaluates a postfix expression. 
    valueStack = a new empty stack
    while (postfix has characters left to parse) 
    {
    nextCharacter = next nonblank character of postfix 
    
        switch (nextCharacter)
        {
          case variable:
             valueStack.push(value of the variable nextCharacter) 
             break
          case '+' : case '-' : case '*' : case '/' : case '^' :
             operandTwo = valueStack.pop()
             operandOne = valueStack.pop()
             result = the result of the operation in nextCharacter and its operands
                      operandOne and operandTwo 
             valueStack.push(result)
             break
         default: break // Ignore unexpected characters
         } 
     }
     return valueStack.peek()
     }
    
}
