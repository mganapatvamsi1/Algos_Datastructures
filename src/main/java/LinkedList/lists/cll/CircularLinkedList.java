package LinkedList.lists.cll;

import java.util.NoSuchElementException;

public class CircularLinkedList {
    private CListNode last;
    private int length;

    public static class CListNode {
        private int data;
        private CListNode next;

        public CListNode(int data) {
            this.data = data;
        }
    }

    public CircularLinkedList() {
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
        CListNode first = new CListNode(1);
        CListNode second = new CListNode(5);
        CListNode third = new CListNode(10);
        CListNode fourth = new CListNode(15);
        CListNode fifth = new CListNode(20);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = first;
        last = fifth;
    }

    public void display() {
        if (last == null) {
            return;
        }
        CListNode first = last.next;
        while (first != last) {
            System.out.print(first.data + " --> ");
            first = first.next;
        }
        System.out.println(first.data);
    }

    public int lengthOfCLL() {
        if (last == null) {
            return 0;
        }
        int count = 1;
        CListNode first = last.next;
        while (first != last) {
            count++;
            first = first.next;
        }
        return count;
    }

    public void insertFirst(int value) {
        CListNode newNode = new CListNode(value);
        if (last == null) {
            // last = temp;
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
        }
        length++;
    }

    public void insertLast(int value) {
        CListNode newNode = new CListNode(value);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public CListNode removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Circular Linked List is already empty.");
        }
        CListNode first = last.next;
         if (last.next == last) {
            return last;
        }
        else {
            last.next = first.next;
        }
        first.next = null;
        length--;
        return first;
    }

    public CListNode removeLast() {
//        if (isEmpty()) {
//            throw new NoSuchElementException("CLL is already empty");
//        }
        //TODO:: why is the length of the list becoming '0' while trying to remove the last element for the second time in  a row..?
        CListNode first = last.next;
        if (last.next == last) {
            return last;
        }
        CListNode refPtr = null;
        while (first != last) {
            refPtr = first;
            first = first.next;
        }
        CListNode temp = last;
        refPtr.next = last.next;
        last = refPtr;
        length--;
        return temp;
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.createCircularLinkedList();
        cll.display(); // 1 --> 5 --> 10 --> 15 --> 20
        System.out.println("length of CLL is:: " + cll.lengthOfCLL());
        cll.insertLast(25);
        cll.display(); // 1 --> 5 --> 10 --> 15 --> 20 --> 25

        cll.insertFirst(4);
        cll.display(); // 4 --> 1 --> 5 --> 10 --> 15 --> 20 --> 25
        cll.insertFirst(2);
        cll.display(); // 2 --> 4 --> 1 --> 5 --> 10 --> 15 --> 20 --> 25

        System.out.println("removing first element:: "+cll.removeFirst().data);
        cll.display();
        System.out.println("removing first element:: "+cll.removeFirst().data);
        cll.display(); // 1 --> 5 --> 10 --> 15 --> 20 --> 25

        System.out.println("removing last element:: "+cll.removeLast().data);
        cll.display(); // 1 --> 5 --> 10 --> 15 --> 20
        System.out.println("removing last element:: "+cll.removeLast().data);
        cll.display(); // 1 --> 5 --> 10 --> 15

    }

}
