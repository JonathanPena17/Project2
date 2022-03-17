public class LinkedStack<T> implements StackInterface<T>
{
    private Node topNode; //refrences the first node in the chain
    
    public LinkedStack()
    {
        topNode = null;
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
}//end LinkedStack
