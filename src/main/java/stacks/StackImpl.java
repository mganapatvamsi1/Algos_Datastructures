package stacks;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackImpl {

    private LNode top;
    private int length;

    private class LNode {
        private int data;
        private LNode next;

        public LNode(int data) {
            this.data = data;
            //this.next = top;
        }
    }

    public StackImpl() {
        top = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(int data) {
        LNode temp = new LNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop() {
        if (isEmpty()) throw new EmptyStackException();
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public int peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    public static String reverseElementsInStack(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) stack.push(c);
        for (int i = 0; i < str.length(); i++) chars[i] = stack.pop();
        return new String(chars);
    }

    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        stack.push(2);
        stack.push(4);
        stack.push(6);
        stack.push(8);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());

        String str = "PQRST";
        System.out.println("The original string is: "+str);
        System.out.println("Reversed string using stack LIFO is: "+reverseElementsInStack(str));

    }
}
