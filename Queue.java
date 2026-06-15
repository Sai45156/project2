public class Queue<T> {
    private class Node {
        T data; Node next;
        Node(T data) { this.data = data; this.next = null; }
    }

    private Node front, rear;
    private int count;

    public Queue() { front = null; rear = null; count = 0; }

    public void enqueue(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) { front = rear = newNode; }
        else { rear.next = newNode; rear = newNode; }
        count++;
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        T data = front.data;
        front = front.next;
        if (front == null) rear = null;
        count--;
        return data;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return front.data;
    }

    public boolean isEmpty() { return count == 0; }
    public int size()        { return count; }
}