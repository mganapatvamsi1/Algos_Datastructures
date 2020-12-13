package LinkedList.sll;

import sun.tools.jconsole.HTMLPane;

/* Inserting node at the middle of SinglyLinkedList */
/* Time Complexity is::  and Space Complexity is::  */
public class SinglyLLInsertionMiddle {

    private InsertionMiddleListNode head;

    public static class InsertionMiddleListNode {
        private int data;
        private InsertionMiddleListNode next;

        public InsertionMiddleListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        InsertionMiddleListNode current = head;
        while (current != null) {
            System.out.print(current.data+" --> ");
            current =  current.next;
        }
        System.out.println("null");
    }

    public int length() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        InsertionMiddleListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertMiddle(int value) {
        InsertionMiddleListNode newMiddleNode = new InsertionMiddleListNode(value);
        if (head == null) {
            head = newMiddleNode;
            return;
        }
        InsertionMiddleListNode current = head;
        InsertionMiddleListNode oldNext = current.next;

//        while (null != current.next) {
//            current = current.next;
//            newMiddleNode.next = head.next;
//        }
        while (null != current.next) {
            newMiddleNode.next = current.next;
            current.next = newMiddleNode;
        }
        current.next = newMiddleNode;

    }

    public static void main(String[] args) {
        SinglyLLInsertionMiddle testNode = new SinglyLLInsertionMiddle();

        testNode.insertMiddle(10);
        testNode.display();
        testNode.insertMiddle(20);
        testNode.display();
        testNode.insertMiddle(13);
        testNode.display();
    }
}
