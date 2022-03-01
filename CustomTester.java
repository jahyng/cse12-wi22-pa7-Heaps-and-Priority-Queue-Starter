/**
 * TODO: Add your file header
 * Name:
 * ID:
 * Email:
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/**
 * TODO: Add your class header
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
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
     * Test the constructor when [TODO: fill in a possible edge case here]
     */
    @Test
    public void testMyMinHeapConstructor() {

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

    }

    /**
     * Test the percolateDown method when [TODO]
     */
    @Test
    public void testPercolateDown() {

    }

    /**
     * Test the deleteIndex method when [TODO]
     */
    @Test
    public void testDeleteIndex() {

    }

    /**
     * Test the deleteIndex method when [TODO]
     */
    @Test
    public void testDeleteIndex2() {

    }

    /**
     * Test the insert method when [TODO]
     */
    @Test
    public void testInsert(){

    }

    /**
     * Test the insert method when [TODO]
     */
    @Test
    public void testInsert2(){

    }

   
    /**
     * Test remove when [TODO]
     */
    @Test
    public void testRemove(){
        
    }

  
    /**
     * Test getMin when [TODO]
     */
    @Test
    public void testGetMin(){
        
    }
}