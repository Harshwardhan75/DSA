
public class Tree_SameTreeOrNot {
    static class Node {
        int data;
        Node left, right;

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

        Node root2 = new Node(12);

        // Level 2
        root2.left = new Node(10);
        root2.right = new Node(14);

        // Level 3
        root2.left.left = new Node(8);
        root2.left.right = new Node(11);
        root2.right.left = new Node(13);
        root2.right.right = new Node(16);

        // Level 4
        root2.left.left.left = new Node(7);
        root2.left.left.right = new Node(9);
        root2.left.right.left = new Node(10);
        root2.left.right.right = new Node(12);
        // root2.right.left.left = new Node(15);
        // root2.right.left.right = new Node(17);
        // root2.right.right.left = new Node(18);
        // root2.right.right.right = new Node(20);

        System.out.println(isSameTree(root, root2));
    }

    static boolean isSameTree(Node root1,Node root2){
        if(root1==null || root2==null)
            return root1==root2;
        
        return root1.data==root2.data &&
            isSameTree(root1.left, root2.left) &&
            isSameTree(root1.right, root2.right);
    }
}
