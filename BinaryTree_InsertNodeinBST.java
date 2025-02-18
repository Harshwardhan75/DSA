public class BinaryTree_InsertNodeinBST {
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
        
        root=insert(root,15);

        inorder(root);
    }

    static Node insert(Node root,int key){
        Node temp=root;
        Node prev=root;
        while(temp!=null){
            prev=temp;
            temp=temp.data<key?temp.right:temp.left;
        }

        if(prev.data<key)
            prev.right=new Node(key);
        else
            prev.left=new Node(key);
        
        return root;
    }

    static void inorder(Node root){
        if(root==null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
}
