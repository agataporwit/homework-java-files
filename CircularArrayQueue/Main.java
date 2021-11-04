package CircularArrayQueue;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        CircularQueue<Integer> circularQueue = new CircularQueue(8);

        circularQueue.enqueue(15);
        circularQueue.enqueue(16);
        circularQueue.enqueue(17);
        circularQueue.enqueue(18);
        circularQueue.enqueue(19);
        circularQueue.enqueue(20);
        circularQueue.enqueue(21);
        circularQueue.enqueue(22);

        System.out.println("Full Circular Queue" + circularQueue);

        System.out.print("De-queued following element from circular Queue ");
        System.out.println(circularQueue.dequeue() + " ");
        circularQueue.enqueue(23);
        System.out.println("After enqueueing circular queue with element having value 23");
        System.out.println(circularQueue);
    }

}


class CircularQueue<E> {

    private int currentSize;
    private E[] circularQueueElements;
    private int maxSize;

    private int tails;
    private int heads;

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        circularQueueElements = (E[]) new Object[this.maxSize];
        currentSize = 0;
        heads = -1;
        tails = -1;
    }

    /**
     * Enqueue elements to rear.
     */
    public void enqueue(E item) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException("Circular Queue is full. Element cannot be added");
        }
        else {
            tails = (tails+ 1) % circularQueueElements.length;
            circularQueueElements[tails] = item;
            currentSize++;

            if (heads == -1) {
                heads = tails;
            }
        }
    }

    /**
     * Dequeue element from Front.
     */
    public E dequeue() throws QueueEmptyException {
        E deQueuedElement;
        if (isEmpty()) {
            throw new QueueEmptyException("Circular Queue is empty. Element cannot be retrieved");
        }
        else {
            deQueuedElement = circularQueueElements[heads];
            circularQueueElements[heads] = null;
            heads = (heads + 1) % circularQueueElements.length;
            currentSize--;
        }
        return deQueuedElement;
    }

    /**
     * Check if queue is full.
     */
    public boolean isFull() {
        return (currentSize == circularQueueElements.length);
    }

    /**
     * Check if Queue is empty.
     */
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    @Override
    public String toString() {
        return "CircularQueue [" + Arrays.toString(circularQueueElements) + "]";
    }

}

class QueueFullException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public QueueFullException() {
        super();
    }

    public QueueFullException(String message) {
        super(message);
    }

}

class QueueEmptyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public QueueEmptyException() {
        super();
    }

    public QueueEmptyException(String message) {
        super(message);
    }

}
