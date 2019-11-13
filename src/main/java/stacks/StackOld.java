package stacks;

/**
 * A small stack interface. You can query the size of the stack and ask whether it is empty, push items, pop items and
 * peek at the top item.
 */
public interface StackOld {

    /**
     * Adds the given item to the top of the stack.
     * @param item
     */
    void push(Object item);

    /**
     * Removes the top element from the list and returns it.
     * @exception java.util.NoSuchElementException if the stack is empty.
     * @return
     */
    Object pop();

    /**
     * Returns the top element from the list without popping it.
     * @exception java.util.NoSuchElementException if the stack is empty.
     * @return
     */
    Object peek();

    /**
     * Returns the number of items currently in the stack.
     * @return
     */
    int size();

    /**
     * Returns whether the stack is empty or not.
     * @return
     */
    boolean isEmpty();
}
