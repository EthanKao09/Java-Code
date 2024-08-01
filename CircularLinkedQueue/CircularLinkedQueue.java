package Homework2;

public class CircularLinkedQueue<T> implements QueueInterface<T> { 
	// Note: Do not add any new attributes.
	protected LLNode<T> rear; // reference to the rear of this queue

	// Implement following 7 methods:
	// Constructor
	public CircularLinkedQueue() {
		rear = null;
	}
	
	// Adds element to the rear of this queue.
	// enqueue(T element)
	public void enqueue (T element) {
		LLNode<T> newNode = new LLNode<T>(element);
		
		if(isEmpty()) {
			rear = newNode;
		}else {
			LLNode<T> otherNode = new LLNode<T>(element);
			newNode.setLink(otherNode);
			otherNode.setLink(rear);
			rear = newNode;
		}
	}

	// Throws QueueUnderflowException if this queue is empty;
	// otherwise, removes front element from this queue and returns it.
	// dequeue()
	public T dequeue() {
		if (isEmpty()) throw new QueueUnderflowException("Dequeue attempted on empty queue.");
		else {
			T element;
		
			rear = rear.getLink();
			element = rear.getInfo();
		
			if(rear.getLink() == null) rear = null;
		
			return element;	
		}		
	}

	// Returns a string that correctly represents the current stack.
	// toString()
	public String toString() {
		String result = "";
		LLNode<T> info = rear;
			while(info != null) {
				result = result + info.getInfo() + " ";
				info = info.getLink();				
			}
		return result;
	}
	
	// Returns true if this queue is empty; otherwise, returns false.
	// isEmpty()
	public boolean isEmpty() {
		return rear == null;
	}

	// Returns false - a linked queue is never full.
	// isFull()
	public boolean isFull() {
		return false;
	}	

	// Returns the number of elements in this queue.
	// size()
	public int size() {
		int count = 0;
		
		LLNode<T> info = rear;
		
		
		while(info != null) {
			info = info.getLink();
			if(info != null) {
			count++;
			}
		}
		
		return count;		
	}
};