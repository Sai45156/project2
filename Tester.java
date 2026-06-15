public class Tester {
    public static void main(String[] args) {
        testDynamicArray();
        System.out.println();
        
        testSinglyLinkedList();
        System.out.println();
        
        testDoublyLinkedList();
        System.out.println();
        
        testStack();
        System.out.println();
        
        testQueue();
        System.out.println();
        
        printSummary();
    }

    private static int testsRun = 0;
    private static int testsPassed = 0;

    private static void testDynamicArray() {
        System.out.println("DYNAMIC ARRAY TESTS");
        System.out.println("==================");
        
        DynamicArray array = new DynamicArray();
        
        // Test insertAtEnd and size
        array.insertAtEnd(1);
        array.insertAtEnd(2);
        array.insertAtEnd(3);
        boolean insertTest = array.size() == 3;
        printTestResult(insertTest, "insertAtEnd");
        
        // Test deleteLast
        boolean deleteTest = array.deleteLast() == 3 && array.size() == 2;
        printTestResult(deleteTest, "deleteLast");
        
        // Test get/set
        array.set(0, 5);
        boolean getSetTest = array.get(0) == 5 && array.get(1) == 2;
        printTestResult(getSetTest, "get/set");
        
        // Test size/isEmpty
        boolean sizeTest = array.size() == 2 && !array.isEmpty();
        array.deleteLast();
        array.deleteLast();
        sizeTest = sizeTest && array.isEmpty();
        printTestResult(sizeTest, "size/isEmpty");
    }

    private static void testSinglyLinkedList() {
        System.out.println("SINGLY LINKED LIST TESTS");
        System.out.println("======================");
        
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        
        // Test addFirst
        list.addFirst("world");
        list.addFirst("hello");
        boolean addFirstTest = list.size() == 2;
        printTestResult(addFirstTest, "addFirst");
        
        // Test addLast
        list.addLast("!");
        boolean addLastTest = list.size() == 3;
        printTestResult(addLastTest, "addLast");
        
        // Test removeFirst
        boolean removeFirstTest = list.removeFirst().equals("hello") && list.size() == 2;
        printTestResult(removeFirstTest, "removeFirst");
        
        // Test contains
        boolean containsTest = list.contains("world") && !list.contains("hello");
        printTestResult(containsTest, "contains");
        
        // Test insertAfter
        list.insertAfter("world", "beautiful");
        boolean insertAfterTest = list.size() == 3;
        printTestResult(insertAfterTest, "insertAfter");
        
        // Test equals
        SinglyLinkedList<String> list2 = new SinglyLinkedList<>();
        list2.addLast("world");
        list2.addLast("beautiful");
        list2.addLast("!");
        
        boolean equalsTest = list.equals(list2);
        printTestResult(equalsTest, "equals");
    }

    private static void testDoublyLinkedList() {
        System.out.println("DOUBLY LINKED LIST TESTS");
        System.out.println("======================");
        
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        
        // Test addFirst
        list.addFirst(2);
        list.addFirst(1);
        boolean addFirstTest = list.size() == 2;
        printTestResult(addFirstTest, "addFirst");
        
        // Test addLast
        list.addLast(3);
        boolean addLastTest = list.size() == 3;
        printTestResult(addLastTest, "addLast");
        
        // Test removeFirst
        boolean removeFirstTest = list.removeFirst().equals(1) && list.size() == 2;
        printTestResult(removeFirstTest, "removeFirst");
        
        // Test removeLast
        boolean removeLastTest = list.removeLast().equals(3) && list.size() == 1;
        printTestResult(removeLastTest, "removeLast");
        
        // Test addSorted
        list.addSorted(1);
        list.addSorted(3);
        list.addSorted(2);
        boolean addSortedTest = list.size() == 4;
        printTestResult(addSortedTest, "addSorted");
        
        // Test reverse
        list.reverse();
        boolean reverseTest = list.size() == 4;
        printTestResult(reverseTest, "reverse");
        
        // Test removeAllOccurrences
        list.addLast(2);
        list.addLast(2);
        list.removeAllOccurrences(2);
        boolean removeAllTest = list.size() == 2; // Only 1 and 3 should remain
        printTestResult(removeAllTest, "removeAllOccurrences");
    }

    private static void testStack() {
        System.out.println("STACK TESTS");
        System.out.println("==========");
        
        Stack<Integer> stack = new Stack<>();
        
        // Test push/pop
        stack.push(1);
        stack.push(2);
        stack.push(3);
        boolean pushPopTest = stack.pop().equals(3) && stack.size() == 2;
        printTestResult(pushPopTest, "push/pop");
        
        // Test peek
        boolean peekTest = stack.peek().equals(2) && stack.size() == 2;
        printTestResult(peekTest, "peek");
        
        // Test isEmpty/size
        boolean sizeTest = stack.size() == 2 && !stack.isEmpty();
        stack.pop();
        stack.pop();
        sizeTest = sizeTest && stack.isEmpty();
        printTestResult(sizeTest, "isEmpty/size");
    }

    private static void testQueue() {
        System.out.println("QUEUE TESTS");
        System.out.println("==========");
        
        Queue<String> queue = new Queue<>();
        
        // Test enqueue/dequeue
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");
        boolean enqueueDequeueTest = queue.dequeue().equals("first") && queue.size() == 2;
        printTestResult(enqueueDequeueTest, "enqueue/dequeue");
        
        // Test peek
        boolean peekTest = queue.peek().equals("second") && queue.size() == 2;
        printTestResult(peekTest, "peek");
        
        // Test isEmpty/size
        boolean sizeTest = queue.size() == 2 && !queue.isEmpty();
        queue.dequeue();
        queue.dequeue();
        sizeTest = sizeTest && queue.isEmpty();
        printTestResult(sizeTest, "isEmpty/size");
    }

    private static void printTestResult(boolean passed, String testName) {
        testsRun++;
        if (passed) {
            testsPassed++;
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName);
        }
    }

    private static void printSummary() {
        System.out.println("SUMMARY: " + testsPassed + "/" + testsRun + " tests passed");
    }
}