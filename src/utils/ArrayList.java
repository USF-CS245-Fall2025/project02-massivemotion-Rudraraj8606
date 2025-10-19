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

    private Object[] growArr(){
        int prevSize = arr.length;
        return Arrays.copyOf(arr, 2*prevSize);
    }

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

    private void rangeCheck(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("not allowed !");
        }
    }

    @Override
    public boolean add(T element) {
        if (size == arr.length) {
            arr = (T[]) growArr();
        }
        arr[size] = element;
        size++;
        return true;
    }

    @Override
    public T get(int index) {
        rangeCheck(index);
        return arr[index];
    }

    @Override
    public T remove(int index) {
        rangeCheck(index);
        T removed = arr[index];
        int elementsToMove = size - index - 1;
        if (elementsToMove > 0) {
            System.arraycopy(arr, index + 1, arr, index, elementsToMove);
        }
        arr[--size] = null;
//        size--;
        return removed;
    }

    @Override
    public int size() {
        return size;
    }
}
