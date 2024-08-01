package FinalExam.Question2;

import java.util.Iterator;

public class HMapQuadraticProbing<K, V> extends HMap<K, V> {
	protected boolean[] entryFlag; // Boolean array for remove() as required.

	public HMapQuadraticProbing() {
		super();
		entryFlag = new boolean[currCap];
		for(int i=0; i<currCap; i++)
			entryFlag[i] = false;
	}

	public HMapQuadraticProbing(int initCap, double initLoad) {
		super(initCap, initLoad);
		entryFlag = new boolean[currCap];
		for(int i=0; i<currCap; i++)
			entryFlag[i] = false;
	}

	// Problem 28(a)
	// It includes a toString method that prints out the entire contents of the
	// internal array, showing the array index along with its contents.
	// This is helpful for testing the rest of this exercise and some of the
	// following exercises also.
	public String toString() {
		String output = "\nHMap: \n";

		for (int i = 0; i < currCap; i++) {
			if (map[i] == null || map[i].getValue()==null) {
				output += i + ": (null, null) " + entryFlag[i] + "\n";
			} else {
				output += i + ": (" + map[i].getKey() + ", " + map[i].getValue() + ") " + entryFlag[i] + "\n";
			}
		}

		return output;
	}

	// Problem 28(b)
	// It uses quadratic probing.
	public V put(K k, V v) {
		if (k == null)
			throw new IllegalArgumentException("Maps do not allow null keys.");
		if ((float) numPairs / currCap > load)
			enlarge();
		MapEntry<K, V> entry = new MapEntry<K, V>(k, v);

		int location = Math.abs(k.hashCode());
		int nLocation;
		int index = 0;

		while (true){
			nLocation = (location + index*index) % currCap;
			index++;
			if(map[nLocation] == null || map[nLocation].getKey().equals(k) || map[nLocation].getValue()==null) break;
		}
		location = nLocation;
		entryFlag[location] = true;
		if (map[location] == null) // k was not in map
		{
			map[location] = entry;
			numPairs++;
			return null;
		} else // k already in map
		{
			V temp = (V) map[location].getValue();
			map[location] = entry;
			return temp;
		}
	}


	// Problem 28(c)
	// It provides a working remove method, using an additional boolean value
	// associated with each hash table slot to track removal.
	public V remove(K k) {
		if (k == null)
			throw new IllegalArgumentException("Maps do not allow null keys.");

		int location = positionOf(k);
		if(location==-1) return null;
		V value =  (V)map[location].getValue();
		map[location].setValue(null);
		return value;
	}


	private int positionOf(K k){
		if (k == null)
			throw new IllegalArgumentException("Maps do not allow null keys.");

		int location = Math.abs(k.hashCode());
		int nLocation;
		int index = 0;
		while (true){
			nLocation = (location + index*index) % currCap;
			index++;
			if(map[nLocation] == null) return -1;
			if(map[nLocation].getKey().equals(k)) break;
		}
		if(map[nLocation].getValue()==null) return -1;
		return nLocation;
	}

	private void enlarge()
	// Increments the capacity of the map by an amount
	// equal to the original capacity.
	{
		int count = numPairs;

		currCap = currCap + origCap;
		boolean [] oldEntryFlag = entryFlag;
		entryFlag = new boolean[currCap];
		for(int i=0; i<currCap; i++)
			entryFlag[i] = false;

		Iterator<MapEntry<K, V>> i = iterator();
		numPairs = 0;
		map = new MapEntry[currCap];

		MapEntry entry;
		for (int n = 1; n <= count; n++) {
			entry = i.next();
			//if(oldEntryFlag[n-1])
			this.put((K) entry.getKey(), (V) entry.getValue());
		}

	}

	public V get(K k)
	// If an entry in this map with a key k exists then the value associated
	// with that entry is returned; otherwise null is returned.
	{
		if (k == null)
			throw new IllegalArgumentException("Maps do not allow null keys.");

		int location = positionOf(k);
		if(location==-1) return null;
		return (V) map[location].getValue();
	}

	// It is possible to use quadratic probing for contain()
	public boolean contains(K k)
	// Returns true if an entry in this map with key k exists;
	// Returns false otherwise.
	{
		int location = positionOf(k);
		if(location==-1) return false;
		return true;
	}
}