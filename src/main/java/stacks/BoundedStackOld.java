package stacks;

import java.util.NoSuchElementException;

public class BoundedStackOld implements StackOld {

    private Object[] array;
    private int size = 0;

    public BoundedStackOld(int capacity) {
        array = new Object[capacity];
    }


    @Override
    public void push(Object item) {
        if (size == array.length) throw new IllegalStateException("Cannot add to full stack");
        array[size++] = item;
    }

    @Override
    public Object pop() {
        if (size == 0) throw new NoSuchElementException("Cannot pop from empty stack");
        Object result = array[size - 1];
        array[--size] = null;
        return result;
    }

    @Override
    public Object peek() {
        if (size == 0) throw new NoSuchElementException("Cannot peek into empty stack");
        return array[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
