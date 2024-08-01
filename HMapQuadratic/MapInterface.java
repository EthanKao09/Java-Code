//---------------------------------------------------------------------------
package FinalExam.Question2;

public interface MapInterface<K, V> extends Iterable<MapEntry<K, V>> {
	V put(K k, V v);
	// If an entry in this map with key k already exists then the value
	// associated with that entry is replaced by value v and the original
	// value is returned; otherwise, adds the (k, v) pair to the map and
	// returns null.

	V get(K k);
	// If an entry in this map with a key k exists then the value associated
	// with that entry is returned; otherwise null is returned.

	V remove(K k);
	// If an entry in this map with key k exists then the entry is removed
	// from the map and the value associated with that entry is returned;
	// otherwise null is returned.
	//
	// Optional. Throws UnsupportedOperationException if not supported.

	boolean contains(K k);
	// Returns true if an entry in this map with key k exists;
	// Returns false otherwise.

	boolean isEmpty();
	// Returns true if this map is empty; otherwise, returns false.

	boolean isFull();
	// Returns true if this map is full; otherwise, returns false.

	int size();
	// Returns the number of entries in this map.
}
