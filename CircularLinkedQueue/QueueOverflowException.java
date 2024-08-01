package Homework2;

public class QueueOverflowException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public QueueOverflowException() {
		super();
	}

	public QueueOverflowException(String message) {
		super(message);
	}
}