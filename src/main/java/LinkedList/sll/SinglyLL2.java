package LinkedList.sll;

/* Finding length of a singleLinkedList */
/* Time Complexity of length method is O(n) */
/* Space Complexity of length method is O(1) */
public class SinglyLL2 {

    private ListNode2 head;

    public static class ListNode2 {
        private int data;
        private ListNode2 next;

        public ListNode2(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display2() {
        ListNode2 current = head;
        while (current != null) {
            System.out.print(current.data +" --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int length() {
        if (head == null) {
            return  0;
        }
        int count = 0;
        ListNode2 current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }



    public static void main(String[] args) {
        SinglyLL2 testList = new SinglyLL2();
        testList.head = new ListNode2(10);
        ListNode2 second = new ListNode2(8);
        ListNode2 third = new ListNode2(1);
        ListNode2 fourth = new ListNode2(11);
        testList.head.next = second;
        second.next = third;
        third.next = fourth;

        testList.display2();
        System.out.println("The length of the list:: "+testList.length());
    }
}
