package binarySearchTree;

/**
 * Recursive implementation of BinarySearchTree
 */
public class BSTNode {
    BSTNode left, right;
    private int data;
    public BSTNode(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) left = new BSTNode(value);
            else left.insert(value);
        } else {
            if (right == null) right = new BSTNode(value);
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
        BSTNode BSTNode = new BSTNode(10);
       BSTNode.left = new BSTNode(5);
       BSTNode.right = new BSTNode(12);
        BSTNode.insert(4);
        BSTNode.insert(7);
        BSTNode.insert(11);
        BSTNode.insert(14);
        BSTNode.insert(13);
        System.out.println(BSTNode.contains(6));
        System.out.println(BSTNode.contains(10));
       BSTNode.printInOrderTraversal();
        System.out.println();
        BSTNode.printPreOrderTraversal();
        System.out.println();
        BSTNode.printPostOrderTraversal();
    }

}
