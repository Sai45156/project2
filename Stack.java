public class Stack<T> {
    private class Node {
        T data; Node next;
        Node(T data) { this.data = data; this.next = null; }
    }

    private Node top;
    private int count;

    public Stack() { top = null; count = 0; }

    public void push(T item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        count++;
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T data = top.data;
        top = top.next;
        count--;
        return data;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty() { return count == 0; }
    public int size()        { return count; }
}