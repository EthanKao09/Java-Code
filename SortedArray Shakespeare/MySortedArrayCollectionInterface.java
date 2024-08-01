package Homework3;
// This question is modified based on Page 342 Problem 26 and Page 343 Problem 30. 

public interface MySortedArrayCollectionInterface<T> extends CollectionInterface<T> {
	public String toString();
	// Creates and returns a string that correctly represents the current
	// collection.
	// Such a method could prove useful for testing and debugging the class and for
	// testing and debugging applications that use the class.
	// Assume each stored element already provides its own reasonable toString
	// method.

	public T smallest();
	// Returns null if the collection is empty, otherwise returns the smallest
	// element of the collection.

	public int greater(T element);
	// Returns a count of the number of elements e in the collection that are
	// greater then element, that is such that e.compareTo(element) is > 0

	public MySortedArrayCollection<T> combine(MySortedArrayCollection<T> other);
	// Creates and returns a new SortedArrayCollection object that is a combination
	// of this object and the argument object.

	public T[] toArray();
	// Returns an array containing all of the elements of the collection.

	public void clear();
	// Removes all elements.

	public boolean equals(Object o);
	// Takes an Object argument, returning true if it is equal to the current
	// collection and false otherwise

	public boolean addAll(MySortedArrayCollection<T> c);
	// Takes a MySortedArrayCollection argument and adds its contents to the current
	// collection;
	// returns a boolean indicating success or failure.

	public boolean retainAll(MySortedArrayCollection<T> c);
	// Takes a MySortedArrayCollection argument and removes any elements from the
	// current collection that are not in the argument collection; returns a boolean
	// indicating success or failure.

	public void removeAll(MySortedArrayCollection<T> c);
	// Takes a MySortedArrayCollection argument and removes any elements from the
	// current collection that are also in the argument collection.
}
