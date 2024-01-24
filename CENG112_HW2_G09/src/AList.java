
public class AList<T> implements ListInterface<T>{
	
	private T[] list;
	private int numberOfEntries;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 30;
	private static final int MAX_CAPACITY = 10000;
	
	public AList() {
		this(DEFAULT_CAPACITY);
	}// end default constructor

	@SuppressWarnings("unchecked")
	public AList(int initialCapacity) {
		if(initialCapacity<DEFAULT_CAPACITY) {
			initialCapacity = DEFAULT_CAPACITY;
		}
		else {
			checkCapacity(initialCapacity);
			T[] tempList = (T[]) new Object[initialCapacity+1];
			list = tempList;
			numberOfEntries = 0;
			initialized = true;
		}
	}// end constructor

	private void checkCapacity(int desiredCapacity) {
		if (desiredCapacity>MAX_CAPACITY)
		throw new IllegalStateException();
	}// end checkCapacity

	@Override
	public void add(T newEntry) {
		checkInitialization();
		list[numberOfEntries]=newEntry;
		numberOfEntries++;
	}// end add

	
		

	@Override
	public void add(int newPosition, T newEntry) {
		checkInitialization();
		if(newPosition >=0 && newPosition<=numberOfEntries) {
			makeRoom(newPosition);
			list[newPosition]=newEntry;
			numberOfEntries++;
          }//end if
		else
			throw new IndexOutOfBoundsException();
	}//end add

	private void makeRoom(int newPosition) {
		assert (newPosition >=0 && newPosition<=numberOfEntries);
		int newIndex = newPosition;
		int lastIndex = numberOfEntries-1;
		for(int index=lastIndex;index>=newIndex;index--) {
			list[index+1]=list[index];
		}//end for
	}//end makeRoom

	@Override
	public T replace(int givenPosition, T newEntry) {
		checkInitialization();
		if(givenPosition>=0 && givenPosition<=numberOfEntries+1) {
			assert !isEmpty();
			T originalEntry = list[givenPosition];
			list[givenPosition]=newEntry;
			return originalEntry;
		}
		else
			throw new IndexOutOfBoundsException();
	}//end replace

	@Override
	public T getEntry(int givenPosition) {
		checkInitialization();
		if(givenPosition>=0 && givenPosition<=numberOfEntries-1) {
			assert !isEmpty();
			return list[givenPosition];
		}
		else
			throw new IndexOutOfBoundsException();
	}//end getEntry

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		checkInitialization();
		T[] result = (T[]) new Object[numberOfEntries];
		for(int index = 0;index<numberOfEntries;index++) {
			result[index]=list[index];
		}//end for
		return result;
	}//end toArray

	@Override
	public boolean contains(T anEntry) {
		checkInitialization();
		boolean found = false;
		int index = 0;
		while(!found && index<=numberOfEntries) {
			if(anEntry.equals(list[index])) {
				found = true;
			}
			index++;
		}
		return found;
	}//end contains

	@Override
	public int getLength() {
		return numberOfEntries;
	}//end getLength

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}//end isEmpty
	private void checkInitialization() {
		if(!initialized)
			throw new SecurityException();
	}// end checkInitialization
	
	public T remove(int givenPosition) {
		checkInitialization();
		if(givenPosition>=0 && givenPosition<numberOfEntries) {
			assert !isEmpty();
			T result = list[givenPosition];
			removeGap(givenPosition);
			numberOfEntries--;
			return result;
		}
		else
			throw new IndexOutOfBoundsException();
		}
		
	//end remove

	private void removeGap(int givenPosition) {
		assert givenPosition>=0 && givenPosition<numberOfEntries;
		int removedIndex = givenPosition;
		int lastIndex = numberOfEntries;
		for(int index = removedIndex;index<lastIndex;index++) {
			list[index]=list[index+1];
		}
		
	}
	public static String displayList(Object[] List) {
        if (List == null)
            return "null";

        int iMax = List.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(String.valueOf(List[i]));
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        	}//end for 
		}// end displayList	
	

}
