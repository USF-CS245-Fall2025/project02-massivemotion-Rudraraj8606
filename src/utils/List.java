package utils;

/**
 * a generic interface for a list data structure
 * @param <T> the type of data in the list
 */
public interface List<T> {

    public void add (int index, T element) throws IndexOutOfBoundsException;
    public boolean add (T element) throws IndexOutOfBoundsException;
    public T get (int index) throws IndexOutOfBoundsException;
    public T remove (int index) throws IndexOutOfBoundsException;
    public int size ();
}
