
public class ArrayQueue<T> extends AList<T> implements QueueInterface<T> {
	
	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 29;
	private static final int MAX_CAPACITY = 10000;
	
	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}// end default constructor

	@SuppressWarnings("unchecked")
	public ArrayQueue(int initialCapacity) {
		checkCapacity(initialCapacity);
		T[] tempQueue = (T[]) new Object[initialCapacity+1];
		queue = tempQueue;
		frontIndex=0;
		backIndex= initialCapacity;
		initialized = true;
	}// end constructor

	@Override
	public void enqueue(T anEntry) {
		checkInitialization();
		//ensureCapacity();
		backIndex = (backIndex+1) % queue.length;
		queue[backIndex]=anEntry;
	}// end enqueue

	@Override
	public T dequeue() {
		checkInitialization();
		T front = queue[frontIndex]=null;
		frontIndex = (frontIndex+1) % queue.length;
		return front;
	}

	@Override
	public T getFront() {
		checkInitialization();
		return queue[frontIndex];
	} // end getFront

	@Override
	public boolean isEmpty() {
		return frontIndex == ((backIndex+1) % queue.length);
	}// end isEmpty

	private void checkCapacity(int desiredCapacity) {
		if(desiredCapacity>MAX_CAPACITY)
			throw new IllegalStateException();
	}// end checkCapacity
	
	private void checkInitialization() {
		if(!initialized)
			throw new SecurityException();
	}// end checkInitialization
	
	public T[] toArray() {
		checkInitialization();
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[queue.length];
		for(int index = 0;index<queue.length;index++) {
			result[index]=queue[index];
		}//end for
		return result;
	}//end toArray
	
	public static String displayQueue(Object[] Queue) {
        if (Queue == null)
            return "null";

        int iMax = Queue.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(String.valueOf(Queue[i]));
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        	}
	}
}// end ArrayQueue
