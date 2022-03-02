/**
 * Name: Joshua Yang
 * ID: A16667394
 * Email: jwyang@ucsd.edu
 * Sources used: PublicTester.java
 * 
 * This file is a tester that tests cases that public tests do not.
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Custom tester for MyMinHeap. Uses public method initMinHeap from the public
 * tester.
 */
public class CustomTester {
    
    /**
     * Helper method to initialize all instance variables of MyDeque
     * 
     * @param meanHeap The heap to initialize
     * @param data     The data array
     */
    static void initMinHeap(MyMinHeap<Integer> heap, ArrayList<Integer> data) {
        heap.data = new ArrayList<>(data);
    }

    /**
     * Test the constructor when all elements are the same except one
     */
    @Test
    public void testMyMinHeapConstructor() {
        ArrayList<Integer> inputList = new ArrayList<Integer>(
            Arrays.asList(
                    new Integer[] { 2,1,1,1,1,1,1,1,}
            )
        );
        MyMinHeap<Integer> minHeap = new MyMinHeap<>(inputList);
        Integer[] expected = {1,1,1,1,1,1,1,2 };
        for (int i = 0; i < 8; i++) {
            assertEquals(
                    "MinHeap order should be implemented",
                    expected[i],
                    minHeap.data.get(i));
        }
    }

    /**
     * Test the getMinChildIdx method when its a leaf
     */
    @Test
    public void testGetMinChildIdx() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        ArrayList<Integer> startingList = new ArrayList<Integer>(
            Arrays.asList(
                new Integer[] { 5, 3, 2 }
            )
        );
        initMinHeap(heap, startingList);
        assertEquals("Minimum child index of 1", -1, heap.getMinChildIdx(1));
        Integer[] expected = { 5, 3, 2 };
        for (int i = 0; i < 3; i++) {
            assertEquals(
                    "Heap after getting minimum child index should be unchanged. ",
                    expected[i],
                    heap.data.get(i));
        }
    }
    

    /**
     * Test the percolateUp method when [TODO]
     */
    @Test
    public void testPercolateUp() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        ArrayList<Integer> startingList = new ArrayList<Integer>(
            Arrays.asList(
                new Integer[] { 1, 4, 4, 5, 2 }
            )
        );
        initMinHeap(heap, startingList);
        heap.percolateUp(3);
        Integer[] expected = { 1, 4, 4, 5, 2 };
        for (int i = 0; i < 5; i++) {
            assertEquals(
                    "Heap after getting minimum child index should be unchanged. ",
                    expected[i],
                    heap.data.get(i));
        }

        MyMinHeap<Integer> heap2 = new MyMinHeap<>();
        ArrayList<Integer> startingList2 = new ArrayList<Integer>(
            Arrays.asList(
                new Integer[] { 5, 4, 4, 5, 2 }
            )
        );
        initMinHeap(heap2, startingList2);
        heap2.percolateUp(4);
        Integer[] expected2 = {2,5,4,5,4};
        for (int i = 0; i < 5; i++) {
            assertEquals(expected2[i], heap2.data.get(i));
        }

    }

    /**
     * Test the percolateDown method when [TODO]
     */
    @Test
    public void testPercolateDown() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        ArrayList<Integer> startingList = new ArrayList<Integer>(
            Arrays.asList(
                new Integer[] { 8, 4, 3, 5, 2 }
            )
        );
        initMinHeap(heap, startingList);
        heap.percolateDown(0);
        Integer[] expected = { 3, 4, 8, 5, 2 };
        for (int i = 0; i < 5; i++) {
            assertEquals(
                "Heap after getting minimum child index should be unchanged. ", 
                expected[i], 
                heap.data.get(i)
            );
        }

    }

    /**
     * Test the deleteIndex method when the replacement is a smaller number
     */
    @Test
    public void testDeleteIndex() {
        MyMinHeap<Character> heap = new MyMinHeap<>();
        ArrayList<Character> startingList = new ArrayList<Character>(
            Arrays.asList(
                new Character[] { 'A', 'D', 'D', 'E', 'Z', 'X', 'B' }
            )
        );
        heap.data = new ArrayList<>(startingList);
        heap.deleteIndex(2);
        Character[] expected = { 'A', 'D', 'B', 'E', 'Z', 'X' };
        for (int i = 0; i < 6; i++) {
            assertEquals(
                "Heap after deleting index 0. " , 
                expected[i], 
                heap.data.get(i)
            );
        }
        assertEquals(6, heap.data.size());
    }

    /**
     * Test the deleteIndex method when there is only one element
     */
    @Test
    public void testDeleteIndex2() {
        MyMinHeap<Character> heap = new MyMinHeap<>();
        ArrayList<Character> startingList = new ArrayList<Character>(
            Arrays.asList(
                new Character[] { 'A' }
            )
        );
        heap.data = new ArrayList<>(startingList);
        heap.deleteIndex(0);
        assertEquals(0, heap.data.size());
    }

    /**
     * Test the insert method when null exception is thrown
     */
    @Test
    public void testInsert(){
        boolean exceptionThrown = false;
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        ArrayList<Integer> startingList = new ArrayList<Integer>(
            Arrays.asList(
                new Integer[] { 11, 12, 13 }
            )
        );
        initMinHeap(heap, startingList);
        try {
            heap.insert(null);
        }
        catch (NullPointerException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    /**
     * Test the insert method when the element added is smallest, so percolate 
     * to root
     */
    @Test
    public void testInsert2(){
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        ArrayList<Integer> startingList = new ArrayList<Integer>(
            Arrays.asList(
                new Integer[] { 11, 12, 13, 14, 15 }
            )
        );
        initMinHeap(heap, startingList);
        heap.insert(3);
        Integer[] expected = { 3, 12, 11, 14, 13, 15 };
        for (int i = 0; i < 4; i++) {
            assertEquals(
                "Heap after inserting 3. ", 
                expected[i], 
                heap.data.get(i)
            );
        }
    }

   
    /**
     * Test remove when the list is empty and when the replacement node is 
     * smallest
     */
    @Test
    public void testRemove(){
        MyMinHeap<Integer> heap = new MyMinHeap<>(); 
        ArrayList<Integer> startingList = new ArrayList<Integer>(
            Arrays.asList(
                new Integer[]{}
            )
        );
        heap.data = new ArrayList<>(startingList);
        assertEquals("Minimum element", null, heap.remove());

        MyMinHeap<Integer> heap2 = new MyMinHeap<>(); 
        ArrayList<Integer> startingList2 = new ArrayList<Integer>(
            Arrays.asList(
                new Integer[]{13,18,18,25,18,3}
            )
        );
        heap2.data = new ArrayList<>(startingList2);
        Integer[] expected2 = {3,18,18,25,18};
        assertEquals("Minimum element", new Integer(13), heap2.remove());
        assertEquals("Smaller size element", 5, heap2.data.size());
        for (int i = 0; i < 5; i++) {
            assertEquals(
                "Heap after getMin should not be changed. ", 
                expected2[i], 
                heap2.data.get(i)
            );
        }
    }

  
    /**
     * Test getMin when list is empty
     */
    @Test
    public void testGetMin(){
        MyMinHeap<Integer> heap = new MyMinHeap<>(); 
        ArrayList<Integer> startingList = new ArrayList<Integer>(
            Arrays.asList(
                new Integer[]{}
            )
        );
        heap.data = new ArrayList<>(startingList);
        assertEquals("Minimum element", null, heap.getMin());
    }
}