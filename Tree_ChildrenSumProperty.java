
public class Tree_ChildrenSumProperty {
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
        childsumproperty(root);
        inorder(root);
    }

    static void childsumproperty(Node root){
        if(root==null)
            return;
        
        int sum=0;
        if(root.left!=null) sum+=root.left.data;
        if(root.right!=null) sum+=root.right.data;

        if(sum>=root.data)
            root.data=sum;
        else{
            if(root.left!=null) root.left.data=root.data;
            if(root.right!=null) root.right.data=root.data;
        }

        childsumproperty(root.left);
        childsumproperty(root.right);

        sum=0;
        if(root.left!=null) sum+=root.left.data;
        if(root.right!=null) sum+=root.right.data;

        if(root.left!=null || root.right!=null)
            root.data=sum;
    }

    static void inorder(Node root){
        if(root==null)
            return ;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
}
