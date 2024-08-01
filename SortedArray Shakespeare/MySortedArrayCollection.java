package Homework3;

public class MySortedArrayCollection<T> extends SortedArrayCollection<T> implements MySortedArrayCollectionInterface<T> {

	public MySortedArrayCollection() {
		elements = (T[]) new Object[DEFCAP];
		origCap = DEFCAP;
	}

	public MySortedArrayCollection(int capacity) {
		elements = (T[]) new Object[capacity];
		this.origCap = capacity;
	}

	@Override
	public T smallest() {
		if (isEmpty())
			return null;
		return elements[0];
	}

	@Override
	public int greater(T element) {
		if (isEmpty())
			return 0;
		else if (contains(element))
			return numElements - location - 1;
		else return 0;
	}

	@Override
	public MySortedArrayCollection<T> combine(MySortedArrayCollection<T> other) {
		MySortedArrayCollection<T> combination = new MySortedArrayCollection<T>();

		for (int index = 0; index < this.numElements; index++) {
			combination.add(this.elements[index]);
		}

		for (int index = 0; index < other.numElements; index++) {
			combination.add(other.elements[index]);
		}

		return combination;
	}

	@Override
	public T[] toArray() {
		T[] newArray = (T[]) new Object[numElements];
     
		for (int index = 0; index < numElements; index++) {
			newArray[index] = elements[index];
		}

		return newArray;
		
	}

	@Override
	public void clear() {
		elements = (T[]) new Object[DEFCAP];
		numElements = 0;

	}

	@Override
	public boolean addAll(MySortedArrayCollection<T> c) {

		boolean success = false;

		for (int index = 0; index < c.numElements; index++) {
			success =  add(c.elements[index]);
		}

		return success;
	}

	@Override
	public boolean retainAll(MySortedArrayCollection<T> c) {
		boolean success = false;
		int index = 0;

		while (index < this.numElements) {
			if (!c.contains(this.elements[index]))
				success = remove(this.elements[index]);
			else index++;
		}

		return success;
	}

	@Override
	public void removeAll(MySortedArrayCollection<T> c) {
		int index = 0;

		while (index < this.numElements) {
			if (c.contains(this.elements[index]))
				remove(this.elements[index]);
			else index++;
		}
	}

	public boolean equals(Object o) {

		return true; 

	}

	public String toString() {

		String elementsList = "" ;

		for (int index = 0; index < numElements; index++) {
			elementsList =  elementsList + "\nElement[" + index + "] " + elements[index];
		}
    
		
		return "Size: " + size() +
				"\nisEmpty(): " + isEmpty() +
				"\nisFull(): " + isFull() +
				"\nSmallest(): " + smallest() +
				elementsList + "\n";

	}

}
