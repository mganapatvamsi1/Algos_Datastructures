package LinkedList;

public class NewSLL {
    public NewListNode head;

    public static class NewListNode {
        private int data;
        private NewListNode next;

        public NewListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean containsLoop() {
        NewListNode fastPointer = head;
        NewListNode slowPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if (slowPointer == fastPointer)
                return true;
        }
        return false;
    }

    public void createALoopInLinkedList() {
        NewListNode firstNode = new NewListNode(1);
        NewListNode secondNode = new NewListNode(2);
        NewListNode thirdNode = new NewListNode(3);
        NewListNode fourthNode = new NewListNode(4);
        NewListNode fifthNode = new NewListNode(5);
        NewListNode sixthNode = new NewListNode(6);

        head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;
        sixthNode.next = thirdNode;
    }

    public void insertFirst(int value) {
        NewListNode firstNode = new NewListNode(value);
        firstNode.next = head;
        head = firstNode;
    }

    public void lastElementInsertion(int value) {
        NewListNode lastNode = new NewListNode(value);
        if (head == null) {
            head = lastNode;
            return;
        }
        NewListNode current = head;
        while (null != current.next) {
            current = current.next;
        }
        current.next = lastNode;
    }

    public boolean searchElement(int value) {
        if (head == null)
            return false;
        NewListNode searchNode = head;
        while (searchNode != null) {
            if (searchNode.data == value) {
                System.out.print("\n We found the key: " + value);
                System.out.println("\n");
                return true;
            }
            searchNode = searchNode.next;
        }
        System.out.print("\n The key is not found in the list: " + value);
        System.out.println("\n");
        return false;
    }

    public NewListNode reverseList(NewListNode head) {
        if (head == null) return head;
        return logicForListReversing(head);
    }

    public NewListNode logicForListReversing(NewListNode head) {
        NewListNode current = head;
        NewListNode previous = null;
        NewListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public NewListNode reverseListWithoutParameters() {
        return logicForListReversing(head);
    }

    public void display() {
        NewListNode current = head;
        printListValues(current);
    }

    public void printListValues(NewListNode current) {
        while (current != null) {
            System.out.print(current.data + " -->> ");
            current = current.next;
        }
        System.out.print("null");
    }

    public void displayWithParameter(NewListNode newListNode) {
        NewListNode current = newListNode;
        printListValues(current);
    }

    public NewListNode findMiddleElementInAList() {
        if (head == null) return null;
        NewListNode slowPointer = head;
        NewListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    public NewListNode getNthElementFromEndOfList(int n) {
        if (head == null) return null;
        if (n <= 0) throw new IllegalArgumentException("Invalid value:    n = "+n);
        NewListNode mainPointer = head;
        NewListNode refPointer = head;
        int count = 0;
        while (count < n) {
            if (refPointer == null) throw new IllegalArgumentException(n + " is greater than the number of nodes in the list");
            refPointer = refPointer.next;
            count++;
        }
        while (refPointer != null) {
            refPointer = refPointer.next;
            mainPointer = mainPointer.next;
        }
        return mainPointer;
    }

    public void removeDuplicatesFromSortedList() {
        if (head == null) return;
        NewListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public NewListNode insertAnElementInSortedLinkedList(int newNodeValue) {
        NewListNode newNode = new NewListNode(newNodeValue);
        if (head == null) return newNode;
        NewListNode current = head;
        NewListNode temp = null;
        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
    }

    public void removeAGivenKeyFromList(int valueToBeRemoved) {
        if (head == null) return;
        NewListNode current = head;
        NewListNode temp = null;
        if (current != null && current.data == valueToBeRemoved) {
            head = current.next;
            return;
        }
        while (current != null && current.data != valueToBeRemoved) {
            temp = current;
            current = current.next;
        }
        if (current == null) return;
        temp.next = current.next;
    }

    public static void main(String[] args) {
        NewSLL newSLL = new NewSLL();

        newSLL.insertFirst(22);
        newSLL.insertFirst(22);
        newSLL.insertFirst(11);
        newSLL.insertFirst(11);

        newSLL.lastElementInsertion(33);
        newSLL.lastElementInsertion(33);
        newSLL.lastElementInsertion(55);
        newSLL.lastElementInsertion(55);

        newSLL.display();
        // newSLL.displayWithParameter();

        newSLL.searchElement(5);

//        NewListNode newHead = newSLL.reverseListWithoutParameters();
//        newSLL.head = newHead;
//        newSLL.display();
       // newSLL.displayWithParameter(newHead);
       // TODO printing middle element is not working when using displayWithParameters() method

       // NewListNode reverseListHead = newSLL.reverseList(newSLL.head);
       // newSLL.displayWithParameter(reverseListHead);

        NewListNode evenListMiddleNumber = newSLL.findMiddleElementInAList();
        System.out.print("\n middle node is: "+evenListMiddleNumber.data);


        NewListNode elementFromEnd = newSLL.getNthElementFromEndOfList(2);
        System.out.println("\n The element from end is: "+elementFromEnd.data);

        newSLL.removeDuplicatesFromSortedList();
        newSLL.display();

        newSLL.insertAnElementInSortedLinkedList(44);
        System.out.println("\n");
        newSLL.display();

        newSLL.removeAGivenKeyFromList(33);
        System.out.println("\n");
        newSLL.display();

        System.out.println("\n"+ newSLL.containsLoop());

        NewSLL sll = new NewSLL();
        sll.createALoopInLinkedList();
        System.out.println(sll.containsLoop());
    }

}
