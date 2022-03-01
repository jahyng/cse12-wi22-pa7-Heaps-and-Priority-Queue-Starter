import java.util.ArrayList;
import java.util.Collection;

/**
 * Add your file header
 * Name: Josh Yang
 * ID: A16667394
 * Email: jwyang@ucsd.edu
 * Sources used: Zybooks, Lecture slides
 * 
 * 2-4 sentence file description here
 */

// Your import statements

/**
 * Add class header
 */
public class MyMinHeap<E extends Comparable<E>> implements MinHeapInterface <E>{
    public ArrayList<E> data;

    public MyMinHeap() {
        this.data = new ArrayList<>();
    }

    public MyMinHeap(Collection<? extends E> collection) {
        if (collection == null || collection.contains(null)) {
            throw new NullPointerException();
        }
        this.data = new ArrayList<>(collection);
        for (int i = 0; i < this.data.size(); i++) {
            this.percolateDown(i);
            this.percolateUp(i);
        }
    }

    /**
     * swap the elements at from and to indicies in data
     * @param from int that  gives index of one of the elements to be swapped
     * @param to int that gives the second index of another element
     */
    protected void swap(int from, int to) {
        Object temp = this.data.get(from);
        this.data.set(from, this.data.get(to));
        this.data.set(to, (E) temp);
    }

    /**
     * Calculate and return parent index of the index given
     * @param index int that gives the index to find parent of
     * @return parent index
     */
    protected int getParentIdx(int index) {
        return (index - 1) / 2;
    }
    /**
     * Get the left child index of the given index
     * @param index int that gives index for which to find left child for
     * @return index of left child
     */
    protected int getLeftChildIdx(int index) {
         return (2 * index) + 1;
    }

    /**
     * Get the right child of given index
     * @param index int that gives index for which to find left child for 
     * @return index of right child
     */
    protected int getRightChildIdx(int index) {
         return (index * 2) + 2;
    }

    /**
     * Get the smaller child of given index, or left child if children are equal
     * @param index index for which to find the smaller child for
     * @return smaller child index
     */
    protected int getMinChildIdx(int index) {
        if (this.getRightChildIdx(index) >= this.data.size() || this.getLeftChildIdx(index) >= this.data.size()) {
                return -1;
        }
        E left = this.data.get(this.getLeftChildIdx(index));
        E right = this.data.get(this.getRightChildIdx(index));
        
        if (left.compareTo(right) <= 0) return this.getLeftChildIdx(index);
        else return this.getRightChildIdx(index);
        
    }

    /**
     * Percolate element at index up until no heap properties are violated by
     * the element. DO this through swapping. 
     * @param index int giving index of the element to be percolated
     */
    protected void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = this.getParentIdx(index);
            if (this.data.get(index).compareTo(this.data.get(parentIndex)) 
                >= 0) {
                break;
            }
            else {
                this.swap(index, parentIndex);
                index = parentIndex;
            }
        }
    }

    /**
     * Percolate element at index down until no heap properties are violated by 
     * the element. Do this through swapping. 
     * @param index int giving the index of the element to be percolated
     */
    protected void percolateDown(int index) {
        int swapIndex = 0;
        // check for best case
        if (this.getMinChildIdx(index) > 0) { 
            swapIndex = this.getMinChildIdx(index);
            this.swap(index, swapIndex);
            this.percolateDown(swapIndex);
        }

    }

    /**
     * Remove and return element at index
     * @param index int giving index of element to be deleted
     * @return element that is deleted
     */
    protected E deleteIndex(int index) {
        E elem = this.data.get(index);
        // case when index is leaf
        if (index >= this.data.size()) this.data.remove(index);
        // other cases
        if (index < this.data.size()) {
            this.data.set(index, this.data.get(this.data.size() - 1));
        }
        this.percolateDown(index);
        
        return elem;
    }

    public void insert (E element) {
        if (element == null) throw new NullPointerException();
        this.data.add(element);
        percolateUp(this.data.size() - 1);
    }

    public E getMin() {
        if (this.data.size() == 0) return null;
        else return this.data.get(0);

    }

    public E remove() {
        if (this.data.size() == 0) return null;
        else return this.deleteIndex(0);
    }

    public int size() {
        int result = 0;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i) != null) result++;
        }
        return result;
    }

    public void clear() {
        for (int i = 0; i < this.data.size(); i++) {
            this.data.set(i, null);
        }
    }

}