import java.util.EmptyStackException;

public class ArrayStack<T> extends ArrayQueue<T> implements StackInterface<T> {
	
	private T[] stack; //Array of stack entries
	private int topIndex; // Index of top entry
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}// end default constructor

	public ArrayStack(int initialCapacity) {
		checkCapacity(initialCapacity);
		
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
		initialized = true;
	} // end constructor

	@Override
	public void push(T newEntry) {
		checkInitialization();
		ensureCapacity();
		stack[topIndex+1] = newEntry;
		topIndex ++;
	} // end push
	
	private void ensureCapacity() {
		if (topIndex == stack.length-1) { // If array is full, double its size.
			int newLength = 2*stack.length;
			checkCapacity(newLength);
			stack = copyArrayStack(stack, newLength);
		} // end if
	} // end ensureCapacity

	@Override
	public T pop() {
		checkInitialization();
		if(isEmpty()) 
			throw new EmptyStackException();
		else {
			T top = stack[topIndex];
			stack[topIndex]=null;
			topIndex--;
			return top;
		}// end else
	}// end pop

	@Override
	public T peek() {
		checkInitialization();
		if(isEmpty()) 
			throw new EmptyStackException();
		else {
			return stack[topIndex];
		}//end else
	}// end peek

	@Override
	public boolean isEmpty() {
		return topIndex<0;
	}// end isEmpty

	@Override
	public void clear() {
		while(!isEmpty()) {
			pop();
		}// end while
	}// end clear
	
	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
		throw new IllegalStateException("Attempt to create a stack whose capacity exeeds allowed maximum of "+MAX_CAPACITY);
	}// end checkCapacity
	
	private void checkInitialization() {
		if (!initialized)
			throw new 	SecurityException("ArrayStack object is not initialized properly.");
	}// end checkInitialization
	
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		T[] result = (T[]) new Object[topIndex+1];
		for(int index=0; index<=topIndex;index++) {
			result[index]=stack[index];
		}//end for
		return result;
	}// end toArray
	public static String displayStack(Object[] Stack) {
        if (Stack == null)
            return "null";

        int iMax = Stack.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(String.valueOf(Stack[i]));
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }// end for 
	}//end displayStack
	public static <T> T[] copyArrayStack(T[] original, int newLength) {
        return (T[]) copyArrayStack(original, newLength);
    }

	
} // end ArrayStack
