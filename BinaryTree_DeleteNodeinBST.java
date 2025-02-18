public class BinaryTree_DeleteNodeinBST {
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
        
        inorder(root);
        System.out.println();
        root=delete(root,14);
        inorder(root);
    }

    static Node delete(Node root,int key){
        Node curr=root,prev=root;
        while(curr!=null && curr.data!=key){
            prev=curr;
            curr=curr.data<key?curr.right:curr.left;
        }

        if(curr==null)  return root;

        if(prev.left!=null && prev.left.data==key)
            prev.left=helper(curr);
        else
            prev.right=helper(curr);
        
        return root;
    }

    static Node helper(Node root){
        if(root.left==null)
            return root.right;
        else if(root.right==null)
            return root.left;
        else{
            Node temp=root.left;
            while(temp.right!=null)
                temp=temp.right;
            temp.right=root.right;
            return root.left;
        }
    }

    static void inorder(Node root){
        if(root==null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

}
