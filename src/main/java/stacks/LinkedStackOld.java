package stacks;

import java.util.NoSuchElementException;

/**
 * An implementation of the stack interface using singly-linked nodes.
 */
public class LinkedStackOld implements StackOld {

    private class Node {
        public Object data;
        public Node next;
        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

    }
    private Node top = null;

    @Override
    public void push(Object item) {
        top = new Node(item, top);
    }

    @Override
    public Object pop() {
        Object item = peek();
        top = top.next;
        return item;
    }

    @Override
    public Object peek() {
        if (top == null) throw new NoSuchElementException();
        return top.data;
    }

    @Override
    public int size() {
        int count = 0;
        for (Node node = top; node != null; node = node.next) count++;
        return count;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

}
