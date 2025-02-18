
public class Tree_maxPathSum {

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
        int[] maxi=new int[1];
        maxi[0]=Integer.MIN_VALUE;
        System.out.println(maxSum(root,maxi));
    }

    static int maxSum(Node root,int[] maxi){
        if(root==null)
            return Integer.MIN_VALUE;
        
        int left=Math.max(0,maxSum(root.left,maxi));
        int right=Math.max(0,maxSum(root.right,maxi));

        maxi[0]=Math.max(maxi[0],left+right+root.data);

        return Math.max(left, right)+root.data;
    }
}
