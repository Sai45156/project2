import java.util.NoSuchElementException;

public class DoublyLinkedList<T extends Comparable<T>> {
    private class Node {
        T data; Node next; Node prev;
        Node(T data) { this.data = data; }
    }

    private Node head, tail;
    private int count;

    public DoublyLinkedList() { head = null; tail = null; count = 0; }

    public void addFirst(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) { head = tail = newNode; }
        else { newNode.next = head; head.prev = newNode; head = newNode; }
        count++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) { head = tail = newNode; }
        else { newNode.prev = tail; tail.next = newNode; tail = newNode; }
        count++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        T data = head.data;
        if (head == tail) { head = tail = null; }
        else { head = head.next; head.prev = null; }
        count--;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        T data = tail.data;
        if (head == tail) { head = tail = null; }
        else { tail = tail.prev; tail.next = null; }
        count--;
        return data;
    }

    public boolean contains(T item) {
        Node current = head;
        while (current != null) {
            if (current.data.compareTo(item) == 0) return true;
            current = current.next;
        }
        return false;
    }

    public int size()        { return count; }
    public boolean isEmpty() { return count == 0; }
    public void clear()      { head = null; tail = null; count = 0; }

    public void addSorted(T item) {
        if (isEmpty() || item.compareTo(head.data) <= 0) { addFirst(item); return; }
        if (item.compareTo(tail.data) >= 0)              { addLast(item);  return; }
        Node current = head.next;
        while (current != null && item.compareTo(current.data) > 0) current = current.next;
        Node newNode = new Node(item);
        Node predecessor = current.prev;
        newNode.next = current; newNode.prev = predecessor;
        predecessor.next = newNode; current.prev = newNode;
        count++;
    }

    public void reverse() {
        if (count <= 1) return;
        Node current = head, temp = null;
        while (current != null) {
            temp = current.prev; current.prev = current.next; current.next = temp;
            current = current.prev;
        }
        temp = head; head = tail; tail = temp;
    }

    public void removeAllOccurrences(T key) {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            if (current.data.compareTo(key) == 0) {
                if (current == head && current == tail) { head = tail = null; }
                else if (current == head) { head = head.next; head.prev = null; }
                else if (current == tail) { tail = tail.prev; tail.next = null; }
                else { current.prev.next = current.next; current.next.prev = current.prev; }
                count--;
            }
            current = next;
        }
    }
}