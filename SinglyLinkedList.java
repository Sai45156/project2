import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private class Node {
        T data;
        Node next;
        Node(T data) { this.data = data; this.next = null; }
    }

    private Node head;
    private int count;

    public SinglyLinkedList() { head = null; count = 0; }

    public void addFirst(T item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
        count++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) { head = newNode; }
        else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        count++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        T data = head.data;
        head = head.next;
        count--;
        return data;
    }

    public boolean contains(T item) {
        Node current = head;
        while (current != null) {
            if (item == null ? current.data == null : item.equals(current.data)) return true;
            current = current.next;
        }
        return false;
    }

    public int size()        { return count; }
    public boolean isEmpty() { return count == 0; }
    public void clear()      { head = null; count = 0; }

    public void insertAfter(T key, T toInsert) {
        Node current = head;
        while (current != null) {
            if (key == null ? current.data == null : key.equals(current.data)) {
                Node newNode = new Node(toInsert);
                newNode.next = current.next;
                current.next = newNode;
                count++;
                return;
            }
            current = current.next;
        }
        throw new NoSuchElementException("Key not found: " + key);
    }

    public boolean equals(SinglyLinkedList<T> other) {
        if (other == null)        return false;
        if (this == other)        return true;
        if (count != other.count) return false;
        Node a = this.head, b = other.head;
        while (a != null) {
            if (a.data == null ? b.data != null : !a.data.equals(b.data)) return false;
            a = a.next; b = b.next;
        }
        return true;
    }
} 