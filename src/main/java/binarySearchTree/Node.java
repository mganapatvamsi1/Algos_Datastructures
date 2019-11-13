package binarySearchTree;

/**
 * Recursive implementation of BinarySearchTree
 */
public class Node {
    Node left, right;
    private int data;
    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) left = new Node(value);
            else left.insert(value);
        } else {
            if (right == null) right = new Node(value);
            else right.insert(value);
        }
    }

    public boolean contains(int value) {
        if (value == data) return true;
        else if (value < data) {
            if (left == null) return false;
            else return left.contains(value);
        } else {
            if (right == null) return false;
            else return right.contains(value);
        }
    }

    public void printInOrderTraversal() {
        if (left != null) left.printInOrderTraversal();
        System.out.println(data);
        if (right != null) right.printInOrderTraversal();
    }

    public void printPreOrderTraversal() {
        System.out.println(data);
        if (left != null) left.printPreOrderTraversal();
        if (right != null) right.printPreOrderTraversal();
    }

    public void printPostOrderTraversal() {
        if (left != null) left.printPostOrderTraversal();
        if (right != null) right.printPostOrderTraversal();
        System.out.println(data);
    }

    public static void main(String[] args) {
        Node node = new Node(10);
       node.left = new Node(5);
       node.right = new Node(12);
        node.insert(4);
        node.insert(7);
        node.insert(11);
        node.insert(14);
        node.insert(13);
        System.out.println(node.contains(6));
        System.out.println(node.contains(10));
       node.printInOrderTraversal();
        System.out.println();
        node.printPreOrderTraversal();
        System.out.println();
        node.printPostOrderTraversal();
    }

}
