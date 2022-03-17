public class LinkedStack<T> implements StackInterface<T>
{
    private Node topNode; //refrences the first node in the chain
    
    public LinkedStack()
    {
        topNode = nulll;
    } //end default constructor

    // implementations of the stack operations 

    public void push(T newEntry)
    {
      Node newNode = new Node(newEntry, topNode);
      topNode = newNode;
      //topNode = new Node(newEntry, topNode); // Alternate code
    } // end push

    public T pop()
    {
   T top = peek();  // Might throw EmptyStackException
   // Assertion: topNode != null
   topNode = topNode.getNextNode();
   return top;
    } // end pop

    public T peek()
    {
   if (isEmpty())
      throw new EmptyStackException();
   else
      return topNode.getData();
    } // end peek

   public boolean isEmpty()
    {
   return topNode == null;
    } // end isEmpty

    public void clear()
    {
   topNode = null;
    } // end clear

    private class node
    {
        //Constuctors
        private T data;
        private Node next;

        private Node(T dataPortion)
        {
         this(dataPortion, null);
        } //end constructor

        private Node(T dataPortion, Node nextNode)
        {
         data = dataPortion;
         next = nextNode;
        }//end constructor

        //Accessors and mutators methods: getData, setData, getNextNode, setNextNode
        private T getData()
        {
            return data;
        }//end getData

        private void setData(T newData)
        {
            data = newData;

        }//end setData

        private Node getNextNode()
        {
            return next;
        }//end getNextNode

        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        }//end setNextNode

    } //end node
    
    public static convertToPostfix(infix)
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
                   Append nextCharacter to postfix
                   break
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
      return postfix;
    }
    
}//end LinkedStack
