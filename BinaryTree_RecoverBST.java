public class BinaryTree_RecoverBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static void inorder(Node root){
        if(root==null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(12);

        // Level 2
        root.left = new Node(20);
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
        root.right.right.right = new Node(8);

        Recover(root);
        inorder(root);
    }

    static Node first,middle,last;

    static void Recover(Node root){
        if(root==null)
            return;

        inorderRecover(root);

        if(first!=null && last!=null){
            int temp=first.data;
            first.data=last.data;
            last.data=temp;
        }
        else
        if(first!=null){
            int temp=first.data;
            first.data=middle.data;
            middle.data=temp;
        }
    }
    static Node prev;
    static void inorderRecover(Node root){
        if(root==null)
            return;
        
        inorderRecover(root.left);
        
        if(prev!=null && root.data<prev.data){
            if(first==null){
                first=prev;
                middle=root;
            }
            else
                last=root;
        }

        prev=root;
        inorderRecover(root.right);
    }
}
