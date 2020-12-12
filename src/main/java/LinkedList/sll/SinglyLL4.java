package LinkedList.sll;

/* Inserting a node at the end of a SinglyLinkedList */
/* Time Complexity of insertion at last is O(n) */
/* Space Complexity of insertion at last is O(1) */
public class SinglyLL4 {

    private ListNode4 head;

    public static class ListNode4 {
        private int data;
        private ListNode4 next;

        public ListNode4(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        ListNode4 current = head;
        while (current != null) {
            System.out.print(current.data+" --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void insertLast(int value) {
        ListNode4 newNode = new ListNode4(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode4 current = head;
        while (null != current.next) {
            current = current.next;
        }
         current.next = newNode;
    }

    public static void main(String[] args) {
        SinglyLL4 testList = new SinglyLL4();

        testList.insertLast(10);
        testList.display();
        testList.insertLast(20);
        testList.display();
        testList.insertLast(30);
        testList.display();
        testList.insertLast(40);
        testList.display();
        testList.insertLast(50);
        testList.display();
    }
}
