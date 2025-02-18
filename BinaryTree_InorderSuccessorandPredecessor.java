public class BinaryTree_InorderSuccessorandPredecessor {
    
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

        inorder(root);
        System.out.println();
        System.out.println(Predecessor(root,18));
        System.out.println(Successor(root,18));
    }

    static int Predecessor(Node root,int key){
        int ans=-1;
        while(root!=null){
            if(root.data<key){
                ans=root.data;
                root=root.right;
            }
            else
                root=root.left;
        }

        return ans;
    }

    static int Successor(Node root,int key){
        int ans=-1;
        while(root!=null){
            if(root.data<=key)
                root=root.right;
            else{
                ans=root.data;
                root=root.left;
            }
        }

        return ans;
    }
}
