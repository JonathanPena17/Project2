/** A class of stacks whose entries are stored in an array. */
public final class ResizeableArrayStack<T> implements StackInterface<T>
{
    private T[] stack;    // Array of stack entries
    private int topIndex; // Index of top entry
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;
  
    public ResizeableArrayStack()
    {
      this(DEFAULT_CAPACITY);
    } // end default constructor
  
    public ResizeableArrayStack(int initialCapacity)
    {
        integrityOK = false;
        checkCapacity(initialCapacity);
      
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    } // end constructor
  
   //  < Implementations of the stack operations go here. >
    public void push(T newEntry)
    {
        checkInyegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    } // end push
    
    public T pop()
    {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else
        {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        } // end if
    } // end pop

    public T peek()
    {
       checkIntegrity();
       if (isEmpty())
          throw new EmptyStackException();
       else
          return stack[topIndex];
    } // end peek

    public boolean isEmpty()
    {
        return topIndex < 0;
    } // end isEmpty
    
    public void clear()
    {
        checkIntegrity();
      
        // Remove references to the objects in the stack,
        // but do not deallocate the array
        while (topIndex > -1)
        {
            stack[topIndex] = null;
            topIndex--;
        } // end while
        //Assertion: topIndex is -1
    } // end clear
    
     /**
     * Ensures array is not out of bounds
     */
    private void checkIntegrity()
    {
        if(!integrityOK)
            throw new SecurityException("ArrayList Object is corrupt.");
    }

    /**
     * Ensures array has not exceeded maximum capacity
     */
    private void checkCapacity()
    {
        if(topIndex > MAX_CAPACITY)
            throw new ArrayIndexOutOfBoundsException("Array capacity has exceeded maximum capacity.");
    }
    
    /**
     * If stack has reached capacity, this function doubles the capacity
     */
    private void ensureCapacity()
    {
        if (topIndex >= stack.length - 1)
        {
            int newLength = 2 * stack.length;
            checkCapacity();
            stack = Arrays.copyOf(stack, newLength);
        }
    }

} // end ArrayStack
