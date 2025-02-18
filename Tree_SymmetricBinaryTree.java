public class Tree_SymmetricBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        // Level 2
        root.left = new Node(2);
        root.right = new Node(2);

        // Level 3
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        // Level 4
        root.left.left.left = new Node(5);
        root.left.left.right = new Node(6);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(7);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(5);

        System.out.println(isSymmetric(root.left,root.right));
    }

    static boolean isSymmetric(Node left,Node right){
        if(left==null || right==null)
            return left==right;
        
        return left.data==right.data &&
            isSymmetric(left.left, right.right) &&
            isSymmetric(left.right, right.left);
    }
}
