package LinkedList.sll;

/* Printing the elements of a SingleLinkedList */
/*
Time Complexity of display method is O(n)
Space Complexity of display method is O(1)
 */
public class SinglyLL {

    private ListNode head;

    public static class ListNode {
        private int data;
        private ListNode nextNode;

        public ListNode(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    public void display() {
        ListNode current = head;
        printAllElementsInList(current);
    }

    public void printAllElementsInList(ListNode current) {
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.nextNode;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        SinglyLL testList = new SinglyLL();
        testList.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);
        testList.head.nextNode = second; // 10 --> 1
        second.nextNode = third; // 10 --> 1 --> 8
        third.nextNode = fourth; // 10 --> 1 --> 8 --> 11 --> null

        testList.display();
    }

}
