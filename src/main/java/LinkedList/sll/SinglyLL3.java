package LinkedList.sll;

/* How to insert a node at the beginning of the singly linked list */
/* Time Complexity of insertFirst is:: O(1)  */
/* Space Complexity of insertFirst is:: O(1) */
public class SinglyLL3 {

    private ListNode3 head;

    public static class ListNode3 {
        private int data;
        private ListNode3 next;

        public ListNode3(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display3() {
        ListNode3 current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void insertFirst(int value) {
        ListNode3 newNode = new ListNode3(value);
        newNode.next = head;
        head = newNode;
    }


    public static void main(String[] args) {
        SinglyLL3 testList = new SinglyLL3();
//        testList.head = new ListNode3(10);
//        ListNode3 second = new ListNode3(1);
//        ListNode3 third = new ListNode3(8);
//        ListNode3 fourth = new ListNode3(11);
//        testList.head.next = second;
//        second.next = third;
//        third.next = fourth;
//        testList.display3();

//        ListNode3 newFirst = new ListNode3(20);
//        newFirst.next = testList.head;
//        testList.head = newFirst;
//        testList.display3();

        testList.insertFirst(30);
        testList.display3();
        testList.insertFirst(40);
        testList.display3();
        testList.insertFirst(50);
        testList.display3();
        testList.insertFirst(60);
        testList.display3();
        testList.insertFirst(70);
        testList.display3();
        testList.insertFirst(80);
        testList.display3();
    }
}
