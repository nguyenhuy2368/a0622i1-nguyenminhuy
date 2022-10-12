package ss10.bt.arraylist;

import java.util.Arrays;

public class MyList <E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements [];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
     elements = new Object[capacity];
    }
    public void add (int index, E element){

    }
    public void ensureCapacity(int minCapacity) {
        int newSize = this.elements.length + minCapacity;
        elements = Arrays.copyOf(elements, newSize);
    }

    public boolean add(E element) {
        if (elements.length == size) {
            ensureCapacity(5);
        }
        elements[size] = element;
        size++;
        return true;
    }
    public int size (){ return this.size;   }
    public Object get(int index) {
        return elements[index];
    }

    public Object remove(int index) {
        Object o = null;
        if (index < elements.length) {
            o = elements[index];
            for (int i = index; i < elements.length - 1; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
        }
        return o;
    }


}
