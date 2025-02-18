public class Tree_TraversalRecursion {
    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(12);

        // Level 2
        root.left = new Node(10);
        root.right = new Node(14);

        // Level 3
        root.left.left = new Node(8);
        root.left.right = new Node(11);
        root.right.left = new Node(13);
        root.right.right = new Node(16);

        // Level 4
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(12);
        root.right.left.left = new Node(15);
        root.right.left.right = new Node(17);
        root.right.right.left = new Node(18);
        root.right.right.right = new Node(20);

        PreOrder_Traversal(root);
        System.out.println();
        InOrder_Traversal(root);
        System.out.println();
        PostOrder_Traversal(root);
        System.out.println();
    }

    static void PreOrder_Traversal(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        PreOrder_Traversal(root.left);
        PreOrder_Traversal(root.right);
    }

    static void InOrder_Traversal(Node root) {
        if (root == null)
            return;

        InOrder_Traversal(root.left);
        System.out.print(root.data + " ");
        InOrder_Traversal(root.right);
    }

    static void PostOrder_Traversal(Node root) {
        if (root == null)
            return;

        PostOrder_Traversal(root.left);
        PostOrder_Traversal(root.right);
        System.out.print(root.data + " ");
    }
}
