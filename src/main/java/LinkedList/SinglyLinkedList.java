package LinkedList;

public class SinglyLinkedList {
    public ListNode head;

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
        printListValues(current);
    }

    // printing the elements of a SinglyLinkedList
    public int listLength() {
        // This means that the singlyLinkedList is empty
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

    public boolean searchElement(int value) {
        if (head == null)
            return false;
        ListNode searchNode = head;
        while (searchNode != null) {
            if (searchNode.data == value) {
                return true;
            }
            searchNode = searchNode.next;
        }
        return false;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        return logicForListReversing(head);
    }

    public ListNode logicForListReversing(ListNode head) {
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

    public ListNode reverseListWithoutParameters() {
        return logicForListReversing(head);
    }

    public void displayValues(SinglyLinkedList singlyLinkedList) {
        ListNode current = singlyLinkedList.head;
        printListValues(current);
    }

    public void displayWithParameter(ListNode listNode) {
        ListNode current = listNode;
        printListValues(current);
    }

    public void printListValues(ListNode current) {
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null");
    }

    public ListNode findMiddleElement() {
        if (head == null) return null;
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    public ListNode getNthElementFromEndOfList(int number) {
        if (head == null) return null;
        if (number <= 0) throw new IllegalArgumentException("Illegal value: n = "+number);
        ListNode mainPointer = head;
        ListNode refPointer = head;
        int count = 0;
        while (count < number) {
            if (refPointer == null) throw new IllegalArgumentException(number + " is greater than the number of nodes in the list");
            refPointer = refPointer.next;
            count++;
        }
        while (refPointer != null) {
            refPointer = refPointer.next;
            mainPointer = mainPointer.next;
        }
        return mainPointer;
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);
        // now connecting these four nodes to form a chain
        singlyLinkedList.head.next = second;
        second.next = third;
        third.next = fourth;

        // Inserting node at the beginning of the singlyLinkedList
        ListNode newNode = new ListNode(25);
        newNode.next = singlyLinkedList.head;
        singlyLinkedList.head = newNode;

        //Inserting node at the end of the singlyLinkedList
        ListNode lastNode = new ListNode(15);
        fourth.next = lastNode;

        //displayValues(singlyLinkedList);
        singlyLinkedList.display();

        System.out.print("\nLength of this singlyLinkedlist is: " + singlyLinkedList.listLength());

        if (singlyLinkedList.searchElement(15)) {
            System.out.println("\n Search key found");
        } else {
            System.out.println("\n Search key not found");
        }

        ListNode newHead = singlyLinkedList.reverseListWithoutParameters();
        singlyLinkedList.head = newHead;

        //singlyLinkedList.displayWithParameter(newHead);
        //singlyLinkedList.displayValues(singlyLinkedList);
        // TODO printing middle element is not working when using displayWithParameters() method
        singlyLinkedList.display();

//        ListNode reverseList = singlyLinkedList.reverseList(singlyLinkedList.head);
//        singlyLinkedList.displayWithParameter(reverseList);

        ListNode middleElement = singlyLinkedList.findMiddleElement();
        System.out.print("\n Middle element is: "+middleElement.data);

        ListNode elementFromEnd = singlyLinkedList.getNthElementFromEndOfList(3);
        System.out.print("\n The element from the end is: "+elementFromEnd.data);
    }

}
