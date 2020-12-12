package LinkedList.lists;

public class SinglyLinkedList {
    private ListNode head;

    public static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void insertFirst(int value) {
        ListNode newValue = new ListNode(value);
        if (head == null) {
            head = newValue;
            return;
        }
        newValue.next = head;
        head = newValue;
    }

    public void insertAtPosition(int data, int position) {
        ListNode newNode = new ListNode(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode previous = head;
            int counter = 0;
            while (counter < position - 1) {
                previous = previous.next;
                counter++;
            }
            ListNode current = previous.next;
            newNode.next = current;
            previous.next = newNode;
        }
    }

    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (null != current.next) {
            current = current.next;
        }
        current.next = newNode;
    }

    public int length() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public ListNode deleteFirst() {
        if (head == null) {
            return head; // return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public void deleteAtPosition(int position) {
        if (position == 0) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
        } else {
            ListNode previous = head;
            int counter = 0;
            while (counter < position - 1) {
                previous = previous.next;
                counter++;
            }

            ListNode current = previous.next;
            previous.next = current.next;
            current.next = null;
        }
    }

    public ListNode deleteLast() {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while (null != current.next) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    public boolean search(int key) {
        ListNode current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public ListNode reverseLinkedList() {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public int printMiddleIndex() {
        if (head == null) {
            return 0;
        }
        ListNode current = head;
        int counter = 0;
        while (current != null) {
            current = current.next;
            counter++;
        }
        return (counter / 2);
    }

    public ListNode findMiddleNode() {
        if (head == null) {
            return null;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    public ListNode findNthEleFromLast(int number) {
        ListNode mainPointer = head;
        ListNode refPointer = head;
        int counter = 0;
        while (counter < number) {
            refPointer = refPointer.next;
            counter++;
        }
        while (refPointer != null) {
            refPointer = refPointer.next;
            mainPointer = mainPointer.next;
        }
        return mainPointer;
    }

    public ListNode findNthEleFromStart(int number) {
        ListNode mainPointer = head;
        ListNode refPointer = head;
        int counter = 0;
        while (counter < number) {
            mainPointer = refPointer;
            refPointer = refPointer.next;
            counter++;
        }
        return mainPointer;
    }

    //TODO:Q) Have doubt on how to remove the link between the old current.next and its next..?
    //TODO: above todo ANS) As the node has no reference to it, so it will be garbage collected.
    public ListNode removeDuplicates() {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public void removeDuplicatesNew() {
        if (head == null) {
            return;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public ListNode insertionInSortedSLL(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            return newNode;
        }
        ListNode current = head;
        ListNode temp = null;
        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
    }

    public ListNode removingKeyFromSLL(int value) {
        if (head == null) {
            return head;
        }

        ListNode current = head;
        ListNode temp = null;
        while (current != null && current.data != value) {
            temp = current;
            current = current.next;
        }
        if (current == null) return null;
        temp.next = current.next;
        return current;
    }

    public void deleteNode(int key) {
        ListNode current = head;
        ListNode temp = null;
        if (current != null && current.data == key) {
            head = current.next;
            return;
        }
        while (current != null && current.data != key) {
            temp = current;
            current = current.next;
        }
        if (current == null) {
            return;
        }
        temp.next = current.next;
    }

    public boolean doesLoopExist() {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
//        // Inserting in the start of a SLL
//        sll.insertFirst(5);
//        sll.display();
//        sll.insertFirst(4);
//        sll.display();
//        sll.insertFirst(3);
//        sll.display();
//        sll.insertFirst(2);
//        sll.display();
//        sll.insertFirst(1);
//        sll.display();
//        sll.insertFirst(7);
//        sll.display();
//        sll.insertFirst(6);
//        sll.display(); //6 --> 7 --> 1 --> 2 --> 3 --> 4 --> 5 --> null
//
//        // Inserting an element in the last of the SLL
//        sll.insertLast(11);
//        sll.display();
//        sll.insertLast(12);
//        sll.display();
//        sll.insertLast(13);
//        sll.display();
//        sll.insertLast(14);
//        sll.display();
//        sll.insertLast(15);
//        sll.display(); //6 --> 7 --> 1 --> 2 --> 3 --> 4 --> 5 --> 11 --> 12 --> 13 --> 14 --> 15 --> null
//
//        // number of elements in the SLL
//        System.out.println("Number of elements in this SLL are:: " + sll.length()); //Number of elements in this SLL are:: 12
//
//        // Inserting an element in the middle of the SLL (at some specific location)
//        sll.insertAtPosition(8, 2);
//        sll.display(); //6 --> 7 --> 8 --> 1 --> 2 --> 3 --> 4 --> 5 --> 11 --> 12 --> 13 --> 14 --> 15 --> null
//        sll.insertAtPosition(9, 3);
//        sll.display(); //6 --> 7 --> 8 --> 9 --> 1 --> 2 --> 3 --> 4 --> 5 --> 11 --> 12 --> 13 --> 14 --> 15 --> null
//        sll.insertAtPosition(10, 4);
//        sll.display(); //6 --> 7 --> 8 --> 9 --> 10 --> 1 --> 2 --> 3 --> 4 --> 5 --> 11 --> 12 --> 13 --> 14 --> 15 --> null
//
//        // number of elements in the SLL
//        System.out.println("Number of elements in this SLL are:: " + sll.length());
//
//        // deleting the first element from a SLL
//        sll.deleteFirst();
//        sll.display();
//        sll.deleteFirst();
//        sll.display();
//        sll.deleteFirst();
//        sll.display();
//        sll.deleteFirst();
//        sll.display();
//        sll.deleteFirst();
//        sll.display();  // 1 --> 2 --> 3 --> 4 --> 5 --> 11 --> 12 --> 13 --> 14 --> 15 --> null
//
//        System.out.println("value of the node deleted first is:: " + sll.delFirst().data); // 1
//        System.out.println("value of the node deleted first is:: " + sll.delFirst().data); // 2
//        sll.display(); // 3 --> 4 --> 5 --> 11 --> 12 --> 13 --> 14 --> 15 --> null
//
//        // deleting the last element from a SLL
//        System.out.println("value of the node deleted last is:: " + sll.deleteLast().data); // 15
//        sll.display(); // 3 --> 4 --> 5 --> 11 --> 12 --> 13 --> 14
//        System.out.println("value of the node deleted last is:: " + sll.deleteLast().data); // 14
//        sll.display(); // 3 --> 4 --> 5 --> 11 --> 12 --> 13
//        System.out.println("value of the node deleted last is:: " + sll.deleteLast().data); // 13
//        sll.display(); // 3 --> 4 --> 5 --> 11 --> 12
//
//        // deleting an element at a certain location from a SLL
//        sll.deleteAtPosition(0);
//        sll.display(); // 4 --> 5 --> 11 --> 12 --> null
//        sll.deleteAtPosition(1);
//        sll.display(); // 4 --> 11 --> 12 --> null
//        sll.deleteAtPosition(2);
//        sll.display(); // 4 --> 11 --> null
//
//        //searching an element in a SLL
//        System.out.println("Searching 4 in the linkedList: " + sll.search(4));
//        System.out.println("Searching 5 in the linkedList: " + sll.search(5));
//
//        //reversing the given linked list
//        sll.display();
//        System.out.println(sll.reverseLinkedList().data);

        sll.head = new ListNode(10);
        ListNode second = new ListNode(8);
        ListNode third = new ListNode(1);
        ListNode fourth = new ListNode(11);
        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        sll.display();

        ListNode reversedListHead = sll.reverseLinkedList();
        sll.head = reversedListHead;
        sll.display(); // 11 --> 1 --> 8 --> 10 --> null

        // finding the middle node in a SLL (Time Complexity is O(n) and Space Complexity is O(1))
        System.out.println("Middle node is: " + sll.findMiddleNode().data); //8
        sll.insertFirst(3);
        sll.display(); // 3 --> 11 --> 1 --> 8 --> 10 --> null
        System.out.println("Middle node is: " + sll.findMiddleNode().data); //1

        // finding the nth element from the last
        System.out.println("4th element from the last is:: " + sll.findNthEleFromLast(4).data); //4th element from the last is:: 11
        System.out.println("3rd element from the last is:: " + sll.findNthEleFromLast(3).data); //3rd element from the last is:: 1

        // finding the nth element from the start
        System.out.println("2nd element from the start is:: " + sll.findNthEleFromStart(2).data);
        System.out.println("1nd element from the start is:: " + sll.findNthEleFromStart(1).data);
        sll.display(); //3 --> 11 --> 1 --> 8 --> 10 --> null

        // making the list sorted
        sll.deleteAtPosition(0);
        sll.display();
        sll.deleteAtPosition(0);
        sll.display();
        sll.insertAtPosition(4, 1);
        sll.insertAtPosition(6, 2);
        sll.display();
        sll.insertLast(10);
        sll.insertLast(10);
        sll.display();
        sll.insertFirst(1);
        sll.display();
        sll.insertAtPosition(6, 3);
        sll.display();

        // removing duplicates from a sorted list
//        sll.removeDuplicates();
//        sll.display();
        sll.removeDuplicatesNew();
        sll.display(); // 1 --> 4 --> 6 --> 8 --> 10 --> null

        // inserted a node in a sorted SLL
        sll.insertionInSortedSLL(5);
        sll.display();
        sll.insertionInSortedSLL(7);
        sll.display();
        sll.insertionInSortedSLL(9);
        sll.display(); // 1 --> 4 --> 5 --> 6 --> 7 --> 8 --> 9 --> 10 --> null

        // removing a key from a sorted SLL
        System.out.println("Removing this key:: " + sll.removingKeyFromSLL(4).data);
        sll.display(); // 1 --> 5 --> 6 --> 7 --> 8 --> 9 --> 10 --> null
        System.out.println("Removing this key:: " + sll.removingKeyFromSLL(6).data);
        sll.display(); // 1 --> 5 --> 7 --> 8 --> 9 --> 10 --> null
        System.out.println("Removing this key:: " + sll.removingKeyFromSLL(9).data);
        sll.display(); // 1 --> 5 --> 7 --> 8 --> 10 --> null

        // detecting a loop
        System.out.println("Does the loop exist..?  " + sll.doesLoopExist());

        // sort this list (using merge sort)
//        int[] testArray = { 12, 13, 6, 11, 15, 5, 7, 2, 11, 6, 15, 2 };
//        sort(testArray, 0, testArray.length - 1);
//        printArray(testArray);

    }

}




