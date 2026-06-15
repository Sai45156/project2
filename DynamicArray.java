public class DynamicArray {
    private int[] array;
    private int count;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 8;

    public DynamicArray() {
        array = new int[DEFAULT_CAPACITY];
        count = 0;
        capacity = DEFAULT_CAPACITY;
    }

    public DynamicArray(int initialCapacity) {
        if (initialCapacity <= 0) throw new IllegalArgumentException("Capacity must be positive");
        array = new int[initialCapacity];
        count = 0;
        capacity = initialCapacity;
    }

    public void insertAtEnd(int value) {
        if (count == capacity) resize(capacity * 2);
        array[count++] = value;
    }

    public int deleteLast() {
        if (isEmpty()) throw new IllegalStateException("Array is empty");
        int removed = array[--count];
        array[count] = 0;
        if (count > 0 && count <= capacity / 4 && capacity / 2 >= DEFAULT_CAPACITY)
            resize(capacity / 2);
        return removed;
    }

    public int get(int index) {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException();
        return array[index];
    }

    public void set(int index, int value) {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException();
        array[index] = value;
    }

    public int size()       { return count; }
    public int capacity()   { return capacity; }
    public boolean isEmpty(){ return count == 0; }

    private void resize(int newCapacity) {
        int[] resized = new int[newCapacity];
        System.arraycopy(array, 0, resized, 0, count);
        array    = resized;
        capacity = newCapacity;
    }
}