package graphs.dfs;

import binarySearchTree.BST;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;

class Node {
    int value;
    Node left, right;
    public Node(int val) {
        this.value = val;
    }
    public static Node buildTree(Iterator<String> iterator) {
        String next = iterator.next();
        if (next.equals("x")) return null;
        Node node = new Node(Integer.parseInt(next));
        node.left = buildTree(iterator);
        node.right = buildTree(iterator);
        return node;
    }
    public static void printTree(Node root, StringBuilder str) {
        if (root == null) str.append("x ");
        else {
            str.append(root.value+" ");
            printTree(root.left, str);
            printTree(root.right, str);
        }
    }
}

class Node1 {
    Node1 left, right;
    int data;

    public Node1(int data) {
        this.data = data;
    }
}

public class DFS1 {
    /* Searching for a node in a Binary Tree whose value is equal to the target. */
    public static Node dfs(Node root, int target) {
        if (root == null || root.value == target) return root;
        Node left = dfs(root.left, target);
        if (left != null) return left;
        return dfs(root.right, target);
    }

    /* Finding the max. height of a BinaryTree. */
    public static int getMaxTreeDepth(Node root) {
        // null node adds no depth
        if (root == null) return 0;
        // Depth of current node's sub-tree = max depth of the two subtrees + 1 provided by current node.
        return Math.max(getMaxTreeDepth(root.left), getMaxTreeDepth(root.right)) + 1;
    }

    /* Visible Tree Node(Once asked by microsoft). */
    public static int countVisibleNodes(Node root) {
        // Start "maxValueSoFar" with smallest integer value possible so that
        // any value root has is smaller than itself.
        return countVisibleNodes(root, Integer.MIN_VALUE);
    }

    public static int countVisibleNodes(Node root, int maxValueSoFar) {
        if (root == null) return 0;
        int totalCount = 0;
        if (root.value >= maxValueSoFar) totalCount++;
        // "maxValueSoFar" of the child node is the larger value of previous max and current node value.
        totalCount += countVisibleNodes(root.left, Math.max(maxValueSoFar, root.value));
        totalCount += countVisibleNodes(root.right, Math.max(maxValueSoFar, root.value));
        return totalCount;
    }

    /* Valid Binary Search Tree. */ //TODO: not sure if this is correct or not
    public static boolean isValidBST(Node root) {
        if (root == null) return false;
        return root.left.value <= root.value || root.right.value >= root.value;
    }

    /* Valid Binary Search Tree. */ // this is the correct solution
    public static boolean isValid(Node root) {
        return isValid(root, Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    public static boolean isValid(Node root, int min, int max) {
        if (root == null) return true;
        if (root.value >= min && root.value <= max) return true;
        return isValid(root.left, min, root.value) && isValid(root.right, root.value, max);
    }

    /* Serialize and Deserialize Binary Tree. */
    // i.e, Serialize function that converts the binary tree to a string
    // meaning we can simply do a DFS and append the node value to the string.
    // Deserialize function to convert string to a binary tree.
    // we need to encode null nodes, otherwise we wouldn't be able to tell if we have reached leaf nodes when we deserialize.
    // Note: we use 'x' here as a placeholder for the null node.
    // The time complexity is O(N) since each node is visited once.
    public static String serialize(Node root) {
        StringJoiner res = new StringJoiner(" ");
        serializeDFS(root, res);
        return res.toString();
    }
    public static void serializeDFS(Node root, StringJoiner result) {
        if (root == null) {
            result.add("x");
            return;
        }
        result.add(Integer.toString(root.value));
        serializeDFS(root.left, result);
        serializeDFS(root.right, result);
    }

    public static Node deserialize(String root) {
        return deserializeDFS(Arrays.stream(root.split(" ")).iterator());
    }

    public static Node deserializeDFS(Iterator<String> nodes) {
        String nextValue = nodes.next();
        if (nextValue.equals("x")) return null;
        Node current = new Node(Integer.parseInt(nextValue));
        current.left = deserializeDFS(nodes);
        current.right = deserializeDFS(nodes);
        return current;
    }

    /* Lowest Common Ancestor (LCA). */ //TODO: check this over again
    public static Node lca(Node root, Node node1, Node node2) {
        if (root == null) return null;

        if (root.equals(node1) || root.equals(node2)) return root;
        Node left = lca(root.left, node1, node2);
        Node right = lca(root.right, node1, node2);

        if (left != null && right != null) return root;

        if (left != null) return left;
        if (right != null) return right;

        return null;
    }

    //TODO: check this over again
    public static Node findNode(Node root, int target) {
        if (root == null) return null;
        if (root.value == target) return root;
        Node leftSearch = findNode(root.left, target);
        if (leftSearch != null) {
            return leftSearch;
        }
        return findNode(root.right, target);
    }
    //TODO: check this over again
    public static boolean compareNode(Node root, String target){
        if (root == null) return "null" == target;
        if (Integer.toString(root.value) == target) return true;
        return false;
    }
    //TODO: check this over again
    public static String getValue(Node root){
        if (root == null) return "null";
        return String.valueOf(root.value);
    }


    public static void main(String[] args) {
        
    }
}
