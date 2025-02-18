public class BinaryTree_LCAinBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(12);

        // Level 2
        root.left = new Node(8);
        root.right = new Node(16);

        // Level 3
        root.left.left = new Node(7);
        root.left.right = new Node(10);
        root.right.left = new Node(14);
        root.right.right = new Node(18);

        // Level 4
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(13);
        root.right.right.right = new Node(20);

        System.out.println(findLCA(root, root.left.left, root.left.right).data);
    }

    static Node findLCA(Node root, Node p, Node q) {
        if (root == null)
            return null;

        if(p.data<root.data && q.data<root.data)
            return findLCA(root.left, p, q);
        else
        if(p.data>root.data && q.data>root.data)
            return findLCA(root.left, p, q);
        else
            return root;
    }
}
