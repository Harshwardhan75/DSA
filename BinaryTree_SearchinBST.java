public class BinaryTree_SearchinBST {
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

        System.out.println(iterativeSearch(root,20));
        System.out.println(recursiveSearch(root,20));
        // inorder(root);
    }

    static boolean recursiveSearch(Node root,int key){
        if(root==null)
            return false;
        
        if(root.data==key)
            return true;

        return root.data<key?
            recursiveSearch(root.right, key):
            recursiveSearch(root.left, key);
    }

    static boolean iterativeSearch(Node root, int key) {
        while (root != null) {
            if (root.data == key)
                return true;
            root = root.data < key ? root.right : root.left;
        }

        return false;
    }

}
