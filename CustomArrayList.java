
package dataStructure;


public class CustomArrayList<T> {
    private Object[] array;
    private int size;

    public CustomArrayList() {
        array = new Object[10];
        size = 0;
    }

    public void add(T item) {
        ensureCapacity();
        array[size++] = item;
    }
    //error handling

    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return (T) array[index];
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }
}
