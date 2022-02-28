import java.util.ArrayList;

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

// Your import statements

/**
 * TODO: Add class header
 */
public class MyMinHeap<E extends Comparable<E>> implements MinHeapInterface <E>{
    public ArrayList<E> data;

    public MyMinHeap() {
        this.data = new ArrayList<>();
    }

    public MyMinHeap(Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < collection.Length; i++) {
            if (collection[i] = null) {
                throw new NullPointerException();
            }
        }
        this.data = collection;
    }

    /**
     * swap the elements at from and to indicies in data
     * @param from int that  gives index of one of the elements to be swapped
     * @param to int that gives the second index of another element
     */
    protected void swap(int from, int to) {
        Object temp = this.data[from];
        this.data[from] = this.data[to];
        this.data[to] = temp;
    }

    protected int getParentIdx(int index) {

    }

    protected int getLeftChildIdx(int index) {

    }

    protected int getRightChildIdx(int index) {

    }

    protected int getMinChildIdx(int index) {

    }

    protected void percolateUp(int index) {

    }

    protected void percolateDown(int index) {

    }

    protected E deleteIndex(int index) {
    }

}