package LinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    public ListNode head;
    public ListNode tail;
    //gives the count of number of nodes in the DoublyLinkedList
    private int length;

    public static class ListNode {
        int data;
        ListNode previous;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0; // head == null (because even if head is null then the list will be empty)
    }

    public int length() {
        return length;
    }

    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if (isEmpty()) head = newNode;
        else tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
        length++;
    }

    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        if (isEmpty()) tail = newNode;
        else head.previous = newNode;
        newNode.next = head;
        head = newNode;
        length++;
    }

    public ListNode deleteFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        ListNode temp = head;
        if (head == tail) tail = null;
        else head.next.previous = null;
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public ListNode deleteLast() {
        if (isEmpty()) throw new NoSuchElementException();
        ListNode temp = tail;
        if (head == tail) head = null;
        else tail.previous.next = null;
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }

    public void printElementsForward() {
        if (head == null) return;
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void printElementsBackward() {
        if (tail == null) return;
        ListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }



    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
//        dll.head = new ListNode(5);
//        ListNode second = new ListNode(10);
//        ListNode third = new ListNode(15);
//        ListNode fourth = new ListNode(20);
//
//        dll.head.next = second;
//        second.previous = dll.head;
//
//        second.next = third;
//        third.previous = second;
//
//        third.next = fourth;
//        fourth.previous = third;
//        fourth.next = null;
//        dll.tail = fourth;

        dll.insertFirst(1);
        dll.insertFirst(2);
        dll.insertFirst(3);
        dll.insertFirst(4);

        dll.printElementsForward();
       // dll.printElementsBackward();

        dll.deleteFirst();
        dll.printElementsForward();

        dll.deleteLast();
        dll.deleteLast();
        dll.printElementsForward();




    }

}
