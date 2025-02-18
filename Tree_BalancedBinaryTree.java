public class Tree_BalancedBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int Optimal(Node root){
        if(root==null)
            return 0;
        
        int left=Optimal(root.left);
        int right=Optimal(root.right);
        
        if(left==-1 || right==-1)
            return -1;
        if(Math.abs(left-right)>=2)
            return -1;
        
        return Math.abs(left+right)+1;
    }

    static boolean Optimal_isBalanced(Node root){
        return Optimal(root)!=-1;                
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

        System.out.println(Brute_isBalanced(root));
        System.out.println(Optimal_isBalanced(root));
    }

    static int findHeight(Node root){
        if(root==null)
            return 0;
        
        int left=findHeight(root.left);
        int right=findHeight(root.right);

        return 1+Math.max(left, right);
    }

    static boolean Brute_isBalanced(Node root){
        if(root==null)
            return true;
        
        int leftHeight=findHeight(root.left);
        int rightHeight=findHeight(root.right);

        if(Math.abs(leftHeight-rightHeight)>=2)
            return false;
        
        return Brute_isBalanced(root.left) && Brute_isBalanced(root.right);
    }

}
