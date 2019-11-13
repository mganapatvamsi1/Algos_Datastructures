package binarySearchTree;

public class BST {
    private N root;

    private class N {
        N left, right;
        int data;

        public N(int data) {
            this.data = data;
        }
    }

    public void insert(int value) {
        root = insert(root,value);
    }

    public N insert(N root, int value) {
        if (root == null) {
            root = new N(value);
            return root;
        }
        if (value < root.data) root.left = insert(root.left,value);
        else root.right = insert(root.right, value);
        return root;
    }

    public N contains(int value) {
        return contains(root, value);
    }

    public N contains(N root, int value) {
        if (root == null || root.data == value) return root;
        if (value < root.data) return contains(root.left,value);
        else return contains(root.right,value);
    }

    public void printInOrderTraversal() {
        printInOrderTraversal(root);
    }

    public void printInOrderTraversal(N root) {
        if (root == null) return;
        if (root.left != null) printInOrderTraversal(root.left);
        System.out.print(root.data + " ");
        if (root.right != null) printInOrderTraversal(root.right);
    }


    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.printInOrderTraversal();
        System.out.println();
        if (null != bst.contains(7)) System.out.println("key found.!");
        else System.out.println("Key not found.!");
    }
}
