package stacks;

import java.util.LinkedList;

public class SimpleStackOld implements StackOld {
    private LinkedList<Object> list = new LinkedList<>();

    @Override
    public void push(Object item) {
        list.addFirst(item);
    }

    @Override
    public Object pop() {
        return list.removeFirst();
    }

    @Override
    public Object peek() {
        return list.getFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
