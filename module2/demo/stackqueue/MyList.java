package codegym.vn.stackqueue;

public class MyList<T> {
    private Object[] data;
    private int size = 0;
    public void push(T o) {
        data[size++] = o;
    }

    public T get(int index) {
        return (T) data[index];
    }
}
