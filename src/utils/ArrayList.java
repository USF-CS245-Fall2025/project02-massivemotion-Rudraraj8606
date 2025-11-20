package utils;
import java.util.*;

public class ArrayList<T> implements List<T> {
    private T[] arr;
    private int size;

    public ArrayList() {
        this.arr = (T[]) new Object[10];
        size = 0;
    }

    public ArrayList(int capacity){
        if (capacity > 0){
            this.arr = (T[]) new Object[capacity];
            size = 0;
        }else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }

    /**
     * increases the size of the array when it reaches a certain size
     * increases it by multiple of 2
     * and then inserts the old data to the new sized array
     * complexity time O(n)
     * @return
     */
    private Object[] growArr(){
        int prevSize = arr.length;
        return Arrays.copyOf(arr, 2*prevSize);
    }

    /**
     * adds the data to a particular position
     * time complexity O(n)
     * @param index
     * @param element
     */
    @Override
    public void add(int index, T element) {
        rangeCheck(index);
        if(size == arr.length){
            arr = (T[]) growArr();
        }
        System.arraycopy(arr, index, arr, index + 1,size - index);
        arr[index] = element;
        size++;
    }

    /**
     * checks the range of the given input
     * throws the error if not in a particular range
     * time complexity O(1)
     * @param index
     */
    private void rangeCheck(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("not allowed !");
        }
    }

    /**
     * add method without inputting specific index
     * time complexity O(1)
     * @param element the data
     * @return boolean
     */
    @Override
    public boolean add(T element) {
        if (size == arr.length) {
            arr = (T[]) growArr();
        }
        arr[size] = element;
        size++;
        return true;
    }

    /**
     * retrieves the data at that index
     * time complexity O(1)
     * @param index input
     * @return T
     */
    @Override
    public T get(int index) {
        rangeCheck(index);
        return arr[index];
    }

    /**
     * removes the data at particular index
     * time complexity O(n)
     * @param index input
     * @return T
     */
    @Override
    public T remove(int index) {
        rangeCheck(index);
        T removed = arr[index];
        int elementsToMove = size - index - 1;
        if (elementsToMove > 0) {
            System.arraycopy(arr, index + 1, arr, index, elementsToMove);
        }
        arr[--size] = null;
        return removed;
    }

    /**
     * return the current size of the arrayList
     * @return int
     */
    @Override
    public int size() {
        return size;
    }
}
