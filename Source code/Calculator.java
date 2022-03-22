public class Calculator 
{
    public static void main(String args[])
    {
        
        /**
         * This tests the implementations convertToPostfix(String) and evaluatePostfix(String)
         */
        String inFixString = "a*b/(c-a)+d*e";
        String postFix = convertToPostfix(inFixString);

        System.out.println("To display our Linked and Resizable Array Stacks, my team will convert the given infix expression to postfix and evaluate it.");
        System.out.println("\n\t Given Infix expression: " + inFixString);
        System.out.println("\n We will now pass our infix string to our infix to the postfix converter.");
        System.out.println("\n\tPostfix Expression: " + postFix);
        System.out.println("\n We will now evaluate the postfix expression, assuming a= 2, b= 3, c= 4, d= 5, and e= 6.");
        System.out.println("\n\tThe value of the postfix expression is: " + evaluatePostfix(postFix));
        System.out.println("\n\n");
        
    }

    /**
     * Converts an infix expression to postfix expression
     * @param anEntry an infix expression represented as a String 
     * @return a postfix expression represented as a String
     */
    public static String convertToPostfix(String anEntry){
        String output = ""; //the Postfix expression that will be returned

        LinkedStack<Character> stack = new LinkedStack<>(); //a stack to hold operands

        for(int i = 0; i < anEntry.length(); i++)//scan the input letter by letter
        {
            char ch = anEntry.charAt(i);    //the current letter (char) being scanned

            if(Character.isLetterOrDigit(ch))   //if the current letter is a variable (not an operand), simply add it to the output
                output += ch;
            
            else if (ch == '(') //if the current letter is a '(' push it to the stack, this will start building out the sequence of operands in the Postfix
                stack.push(ch);

            else if (ch == ')') //if the current letter is a ')', keep removing operands from the stack until the parantheses is closed
            { 
                while(!stack.isEmpty() && stack.peek() != '(')//keep popping until we reach a '('
                    output += stack.pop();
                
                stack.pop();//once we reach the '(', pop it, thereby closing the parentheses
            } 
            else
            {
                //if the current letter is not a letter, number or parentheses, it must be an operand.
                while(!stack.isEmpty() && Precedence(ch) <= Precedence(stack.peek()))//keep removing operands from the top of the stack until we reach an operand that -
                                                                                     //is of HIGHER precedence than the current letter.  
                    output += stack.pop();//each operand removed from the top of the stack is added to the output (they are of LOWER or EQUAL precedence than the current)

                stack.push(ch);//add the current operand to the top of the stack.  Because of the previous while loop, this operand must be of higher precedence
                                //than the one before it.
            }
        }

        while(!stack.isEmpty()){
            if(stack.peek() == '(') //if we find an extra '(', this means the expression is invalid since that parentheses cannot be closed
                return "Error, input was not a valid infix expression";

            output += stack.pop();
        }
        return output;

    }

    
    /**
     * Evaluate a postfix expression with pre-defined variable values 'a' - 'e'
     * @param postfix a postfix expression
     * @return the numerical value of the evaluated expression
     */
    public static double evaluatePostfix(String postfix)
    {
        // This stack will hold the intermediary answers
        ResizeableArrayStack<Double> stack = new ResizeableArrayStack<>();

        for(int i = 0; i < postfix.length(); i++){
            // to parse the string that we pass in
            char ch = postfix.charAt(i);

            // 
            if(Character.isLetter(ch))
                switch(ch)
                {
                    case 'a':
                        stack.push((double)2);
                        break;
                    case 'b':
                        stack.push((double)3);
                        break;
                    case 'c':
                        stack.push((double)4);
                        break;
                    case 'd':
                        stack.push((double)5);
                        break;
                    case 'e':
                        stack.push((double)6);
                        break;
                    default:
                        break;
                }
                
            else{
                double x = stack.pop();
                double y = stack.pop();
                switch(ch)
                {
                    case '+':
                        stack.push(y+x);
                        break;
                    case '-':
                        stack.push(y-x);
                        break;
                    case '*':
                        stack.push(y*x);
                        break;
                    case '/':
                        stack.push(y/x);
                        break;
                    case '^':
                        stack.push(Math.pow(y, x));
                        break;
                }
                }
        }
    return stack.pop();
    }
    
    /**
     * Helper method for determining precedence of operands.
     * @param x the operand
     * @return the precidence of the operand
     */
    public static int Precedence(char x){
        switch(x){
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}//end Calculator
