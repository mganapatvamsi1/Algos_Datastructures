package LinkedList;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {

    private NListNode last;
    private int length;


    private class NListNode {
        private NListNode next;
        private int data;

        public NListNode(int data) {
            this.data = data;
        }
    }

    public CircularSinglyLinkedList() {
        last = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void createCircularLinkedList() {
        NListNode first = new NListNode(1);
        NListNode second = new NListNode(5);
        NListNode third = new NListNode(10);
        NListNode fourth = new NListNode(15);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        last = fourth;
    }

    public void display() {
        if (last == null) return;
        NListNode first = last.next;
        while (first != last) {
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.println(first.data + " ");
    }

    public void insertAtBeginning(int value) {
        NListNode temp = new NListNode(value);
        if (last == null) {
            last = temp;
        } else {
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }

    public void insertAtEnd(int value) {
        NListNode temp = new NListNode(value);
        if (last == null) {
            last = temp;
            last.next = last;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    public NListNode removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Circular Singly Linked List is already empty");
        NListNode temp = last.next;
        if (last.next == last) last = null;
        else last.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public int removeFirstElement() {
        if (isEmpty()) throw new NoSuchElementException("Circular Singly Linked List is already empty");
        NListNode temp = last.next;
        int result = temp.data;
        if (last.next == last) last = null;
        else  last.next = temp.next;
        length--;
        return result;
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.createCircularLinkedList();
        csll.insertAtBeginning(3);
        csll.insertAtBeginning(2);
        csll.insertAtEnd(20);
        csll.display();

        csll.removeFirst();
        csll.display();

        csll.removeFirstElement();
        csll.display();
    }

}
