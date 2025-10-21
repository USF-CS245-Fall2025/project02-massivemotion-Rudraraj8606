package utils.testing;

import utils.ArrayList;
import utils.DoublyLinkedList;
import utils.DummyHeadLinkedList;
import utils.LinkedList;

public class TestCases {
    
    public static void main(String[] args) {
        System.out.println("Starting Data Structure Tests...");
        System.out.println("=".repeat(50));
        
        testArrayList();
        testLinkedList();
        testDummyHeadLinkedList();
        testDoublyLinkedList();
        
        System.out.println("\nAll tests completed!");
    }
    
    // Test ArrayList implementation
    public static void testArrayList() {
        System.out.println("\n*** Testing ArrayList ***");
        ArrayList<Integer> list = new ArrayList<>();
        
        // Test 1: Initial empty state
        System.out.println("Test 1 - Initial state:");
        System.out.println("Size: " + list.size() + " (expected: 0)");
        
        // Test 2: Add elements
        System.out.println("\nTest 2 - Adding elements:");
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Size after adding 3 elements: " + list.size() + " (expected: 3)");
        System.out.println("Element at index 0: " + list.get(0) + " (expected: 10)");
        System.out.println("Element at index 1: " + list.get(1) + " (expected: 20)");
        System.out.println("Element at index 2: " + list.get(2) + " (expected: 30)");
        
        // Test 3: Add at specific index
        System.out.println("\nTest 3 - Add at index:");
        list.add(1, 15);
        System.out.println("Size after adding at index 1: " + list.size() + " (expected: 4)");
        System.out.println("Element at index 1: " + list.get(1) + " (expected: 15)");
        System.out.println("Element at index 2: " + list.get(2) + " (expected: 20)");
        
        // Test 4: Remove element
        System.out.println("\nTest 4 - Remove element:");
        Integer removed = list.remove(1);
        System.out.println("Removed element: " + removed + " (expected: 15)");
        System.out.println("Size after removal: " + list.size() + " (expected: 3)");
        System.out.println("Element at index 1: " + list.get(1) + " (expected: 20)");
        
        // Test 5: Test capacity growth
        System.out.println("\nTest 5 - Capacity growth:");
        ArrayList<Integer> smallList = new ArrayList<>(2);
        for (int i = 0; i < 5; i++) {
            smallList.add(i);
        }
        System.out.println("Small list size after adding 5 elements: " + smallList.size() + " (expected: 5)");
        
        // Test 6: Exception handling
        System.out.println("\nTest 6 - Exception handling:");
        try {
            list.get(-1);
            System.out.println("ERROR: Should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Correctly threw exception for negative index");
        }
        
        try {
            list.get(10);
            System.out.println("ERROR: Should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Correctly threw exception for index >= size");
        }
    }
    
    // Test LinkedList implementation
    public static void testLinkedList() {
        // after running the code I found out that the size printed one less than expected
        System.out.println("\n*** Testing LinkedList ***");
        LinkedList<String> list = new LinkedList<>();
        
        // Test 1: Initial empty state
        System.out.println("Test 1 - Initial state:");
        System.out.println("Size: " + list.size() + " (expected: 0)");
        
        // Test 2: Add elements
        System.out.println("\nTest 2 - Adding elements:");
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("Size after adding 3 elements: " + list.size() + " (expected: 3)");
        System.out.println("Element at index 0: " + list.get(0) + " (expected: A)");
        System.out.println("Element at index 1: " + list.get(1) + " (expected: B)");
        System.out.println("Element at index 2: " + list.get(2) + " (expected: C)");
        
        // Test 3: Add at beginning
        System.out.println("\nTest 3 - Add at beginning:");
        list.add(0, "Start");
        System.out.println("Size after adding at beginning: " + list.size() + " (expected: 4)");
        System.out.println("Element at index 0: " + list.get(0) + " (expected: Start)");
        System.out.println("Element at index 1: " + list.get(1) + " (expected: A)");
        
        // Test 4: Add at middle
        System.out.println("\nTest 4 - Add at middle:");
        list.add(2, "Middle");
        System.out.println("Size after adding at middle: " + list.size() + " (expected: 5)");
        System.out.println("Element at index 2: " + list.get(2) + " (expected: Middle)");
        
        // Test 5: Remove from beginning
        System.out.println("\nTest 5 - Remove from beginning:");
        String removed = list.remove(0);
        System.out.println("Removed element: " + removed + " (expected: Start)");
        System.out.println("Size after removal: " + list.size() + " (expected: 4)");
        System.out.println("New first element: " + list.get(0) + " (expected: A)");
        
        // Test 6: Remove from middle
        System.out.println("\nTest 6 - Remove from middle:");
        removed = list.remove(1);
        System.out.println("Removed element: " + removed + " (expected: Middle)");
        System.out.println("Size after removal: " + list.size() + " (expected: 3)");
        
        // Test 7: Exception handling
        System.out.println("\nTest 7 - Exception handling:");
        try {
            list.add(-1, "Invalid");
            System.out.println("ERROR: Should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Correctly threw exception for negative index in add");
        }
    }
    
    // Test DummyHeadLinkedList implementation
    public static void testDummyHeadLinkedList() {
        System.out.println("\n*** Testing DummyHeadLinkedList ***");
        DummyHeadLinkedList<Double> list = new DummyHeadLinkedList<>();
        
        // Test 1: Initial empty state
        System.out.println("Test 1 - Initial state:");
        System.out.println("Size: " + list.size() + " (expected: 0)");
        
        // Test 2: Add elements
        System.out.println("\nTest 2 - Adding elements:");
        list.add(1.1);
        list.add(2.2);
        list.add(3.3);
        System.out.println("Size after adding 3 elements: " + list.size() + " (expected: 3)");
        System.out.println("Element at index 0: " + list.get(0) + " (expected: 1.1)");
        System.out.println("Element at index 1: " + list.get(1) + " (expected: 2.2)");
        System.out.println("Element at index 2: " + list.get(2) + " (expected: 3.3)");
        
        // Test 3: Add at specific positions
        System.out.println("\nTest 3 - Add at specific positions:");
        list.add(0, 0.0);  // Add at beginning
        list.add(2, 1.5);  // Add in middle
        list.add(5, 4.4);  // Add at end
        System.out.println("Size after adding at positions: " + list.size() + " (expected: 6)");
        System.out.println("Element at index 0: " + list.get(0) + " (expected: 0.0)");
        System.out.println("Element at index 2: " + list.get(2) + " (expected: 1.5)");
        System.out.println("Element at index 5: " + list.get(5) + " (expected: 4.4)");
        
        // Test 4: Remove elements
        System.out.println("\nTest 4 - Remove elements:");
        Double removed = list.remove(0);  // Remove first
        System.out.println("Removed first element: " + removed + " (expected: 0.0)");
        removed = list.remove(1);  // Remove middle
        System.out.println("Removed middle element: " + removed + " (expected: 1.5)");
        removed = list.remove(list.size() - 1);  // Remove last
        System.out.println("Removed last element: " + removed + " (expected: 4.4)");
        System.out.println("Final size: " + list.size() + " (expected: 3)");
        
        // Test 5: Exception handling
        System.out.println("\nTest 5 - Exception handling:");
        try {
            list.remove(10);
            System.out.println("ERROR: Should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Correctly threw exception for invalid remove index");
        }
    }
    
    // Test DoublyLinkedList implementation
    public static void testDoublyLinkedList() {
        System.out.println("\n*** Testing DoublyLinkedList ***");
        DoublyLinkedList<Character> list = new DoublyLinkedList<>();
        
        // Test 1: Initial empty state
        System.out.println("Test 1 - Initial state:");
        System.out.println("Size: " + list.size() + " (expected: 0)");
        
        // Test 2: Add elements
        System.out.println("\nTest 2 - Adding elements:");
        list.add('A');
        list.add('B');
        list.add('C');
        System.out.println("Size after adding 3 elements: " + list.size() + " (expected: 3)");
        System.out.println("Element at index 0: " + list.get(0) + " (expected: A)");
        System.out.println("Element at index 1: " + list.get(1) + " (expected: B)");
        System.out.println("Element at index 2: " + list.get(2) + " (expected: C)");
        
        // Test 3: Add at beginning
        System.out.println("\nTest 3 - Add at beginning:");
        list.add(0, 'Z');
        System.out.println("Size after adding at beginning: " + list.size() + " (expected: 4)");
        System.out.println("Element at index 0: " + list.get(0) + " (expected: Z)");
        System.out.println("Element at index 1: " + list.get(1) + " (expected: A)");
        
        // Test 4: Add at middle
        System.out.println("\nTest 4 - Add at middle:");
        list.add(2, 'X');
        System.out.println("Size after adding at middle: " + list.size() + " (expected: 5)");
        System.out.println("Element at index 2: " + list.get(2) + " (expected: X)");
        
        // Test 5: Add at end using add(index, element)
        System.out.println("\nTest 5 - Add at end using index:");
        list.add(list.size(), 'Y');
        System.out.println("Size after adding at end: " + list.size() + " (expected: 6)");
        System.out.println("Last element: " + list.get(list.size() - 1) + " (expected: Y)");
        
        // Test 6: Remove from different positions
        System.out.println("\nTest 6 - Remove from different positions:");
        Character removed = list.remove(0);  // Remove head
        System.out.println("Removed head: " + removed + " (expected: Z)");
        removed = list.remove(list.size() - 1);  // Remove tail
        System.out.println("Removed tail: " + removed + " (expected: Y)");
        removed = list.remove(1);  // Remove middle
        System.out.println("Removed middle: " + removed + " (expected: X)");
        System.out.println("Final size: " + list.size() + " (expected: 3)");
        
        // Test 7: Verify final state
        System.out.println("\nTest 7 - Final state verification:");
        System.out.println("Element at index 0: " + list.get(0) + " (expected: A)");
        System.out.println("Element at index 1: " + list.get(1) + " (expected: B)");
        System.out.println("Element at index 2: " + list.get(2) + " (expected: C)");
        
        // Test 8: Test bidirectional traversal efficiency (nodeAt method)
        System.out.println("\nTest 8 - Bidirectional traversal:");
        DoublyLinkedList<Integer> bigList = new DoublyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            bigList.add(i);
        }
        System.out.println("Big list size: " + bigList.size() + " (expected: 10)");
        System.out.println("Element at index 8: " + bigList.get(8) + " (expected: 8)");
        System.out.println("Element at index 1: " + bigList.get(1) + " (expected: 1)");
        
        // Test 9: Exception handling
        System.out.println("\nTest 9 - Exception handling:");
        try {
            list.add(100, 'I');
            System.out.println("ERROR: Should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Correctly threw exception for invalid add index");
        }
    }
}