package LinkedList.lists.dll;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private DListNode head;
    private DListNode tail;
    private int length;

    public static class DListNode {
        private int data;
        private DListNode previous;
        private DListNode next;

        public DListNode(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    } // head == null

    public int length() {
        return length;
    }

    public void insertFirst(int value) {
        DListNode newNode = new DListNode(value);
        if (isEmpty()) {
            head = newNode;
        } // tail = newNode;
        else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= length;
    }

    public void insertAtPosition(int value, int position) {
        DListNode newNode = new DListNode(value);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            DListNode previous = head;
            int count = 0;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            DListNode current = previous.next;
            newNode.next = current;
            previous.next = newNode;
        }
    }

    /* Given a node as previous node, insert a newNode after the given node. */
    public void insertAfter(DListNode previousNode, int newValue) {
        if (previousNode == null) {
            System.out.println("The given previous node cannot be null.");
            return;
        }
        DListNode newNode = new DListNode(newValue);
        newNode.next = previousNode.next;
        newNode.previous = previousNode;
        previousNode.next = newNode;
        if (newNode.next != null) {
            newNode.next.previous = newNode;
        }
    }

    public void insertLast(int value) {
        DListNode newNode = new DListNode(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
        length++;
    }
    public void displayForward() {
        if (head == null) {
            return;
        }
        DListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public void displayBackWard() {
        if (tail == null) {
            return;
        }
        DListNode current = tail;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.previous;
        }
        System.out.println("null");
    }
    public DListNode deleteFirst() {
        if (head == null) {
            return head;
        } // return null;
        DListNode temp = head;
        head = head.next;
        temp.next = null;
        head.previous = null;
        return temp;
    }

    public DListNode deleteFirst2() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        DListNode temp = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }
    public DListNode deleteLast1() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (head == null || head.next == null) {
            return head;
        }
        DListNode mainPtr = head;
        DListNode refPtr = null;
        while (null != mainPtr.next) {
            refPtr = mainPtr;
            mainPtr = mainPtr.next;
        }
        refPtr.next = null;
        mainPtr.previous = null;
        length--;
        return mainPtr;
    }
    public DListNode deleteLast2() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        DListNode temp = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        tail.previous = null;
        length--;
        return temp;
    }

    public void deleteAtPosition(int position) {
        if (position == 0) {
            DListNode temp = head;
            head = head.next;
            temp.next = null;
            head.previous = null;
        } else {
            DListNode refPtr = head;
            int count = 0;
            while (count < position - 1) {
                count++;
                refPtr = refPtr.next;
            }
            DListNode mainPtr = refPtr.next;
            refPtr.next = mainPtr.next;
            mainPtr.next = null;
            mainPtr.previous = null;
            if (mainPtr.next != null) {
                mainPtr.next.previous = refPtr;
            }
        }
    }

    //    public void insertAtP(int value, int index) {
//        if (!isValidIndex(index)) {
//            throw new IndexOutOfBoundsException("Index "+index+" is not valid.");
//        }
//        DListNode newNode = new DListNode(value);
//        DListNode current = head;
//        if (index == 0) {
//            insertFirst(value);
//        } else if (index == length) {
//            insertLast(value);
//        } else {
//            for (int j = 0; j < index; j++) {
//                current = current.next;
//            }
//            newNode.next = current;
//            if (current.previous != null) {
//                current.previous.next = newNode; //TODO:: it breaks at this line if current.previous is null
//            }
//            newNode.previous = current.previous;
//            current.previous = newNode;
//            length++;
//        }
//    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        // Inserting at the end of the Doubly Linked List
        // time and space complexity for inserting a node at the end of a doubly linked list is O(1) and O(1)
        dll.insertLast(1);
        dll.insertLast(10);
        dll.insertLast(15);
        dll.insertLast(25);

        // inserting forward and printing
        // Time Complexity of display forward and display backward is O(n)
        //Space Complexity of display forward and display backward is O(n)
        dll.displayForward(); //1 --> 10 --> 15 --> 25 --> null

        // inserting from backward
        dll.displayBackWard(); //25 --> 15 --> 10 --> 1 --> null

        // Inserting at the beginning of a Doubly Linked List
        // Time and Space Complexity of insertFirst are O(1) and O(1)
        dll.insertFirst(4);
        dll.insertFirst(2);
        dll.insertFirst(3);
        dll.displayForward();  // 3 --> 2 --> 4 --> 1 --> 10 --> 15 --> 25 --> null
        dll.displayBackWard(); // 25 --> 15 --> 10 --> 1 --> 4 --> 2 --> 3 --> null

        // inserting at a certain position in DLL
        dll.insertAtPosition(5, 1);
        dll.displayForward(); // 3 --> 5 --> 2 --> 4 --> 1 --> 10 --> 15 --> 25 --> null
        dll.insertAtPosition(13, 2);
        dll.displayForward(); // 3 --> 5 --> 13 --> 2 --> 4 --> 1 --> 10 --> 15 --> 25 --> null
        dll.insertAtPosition(9, 2);
        dll.displayForward(); // 3 --> 5 --> 9 --> 13 --> 2 --> 4 --> 1 --> 10 --> 15 --> 25 --> null
        dll.displayBackWard();

        // TODO:: this is the issue as its not giving all elements while printing from backward
        // 25 --> 15 --> 10 --> 1 --> 4 --> 2 --> 3 --> null
        dll.insertAfter(new DListNode(4), 7);

        // deleting a node in the start of the doubly linked list
        // time and space complexity of deleting first and last is O(1) and O(1)
        dll.displayForward(); // 3 --> 5 --> 9 --> 13 --> 2 --> 4 --> 1 --> 10 --> 15 --> 25 --> null
        dll.deleteFirst();
        dll.displayForward(); // 5 --> 9 --> 13 --> 2 --> 4 --> 1 --> 10 --> 15 --> 25 --> null
        dll.deleteFirst();
        dll.displayForward(); // 9 --> 13 --> 2 --> 4 --> 1 --> 10 --> 15 --> 25 --> null

        // deleting a node in the end of a DLL
        System.out.println("deleting :: " + dll.deleteLast1().data);
        dll.displayForward();
        System.out.println("deleting :: " + dll.deleteLast1().data);
        dll.displayForward(); // 9 --> 13 --> 2 --> 4 --> 1 --> 10 --> null

        // deleting a node at a position
        dll.deleteAtPosition(1);
        dll.displayForward(); // 9 --> 2 --> 4 --> 1 --> 10 --> null
        dll.deleteAtPosition(3);
        dll.displayForward(); // 9 --> 2 --> 4 --> 10 --> null
    }

}


