public class BinaryTree_LargestBSTinBST {
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

        System.out.println(largestBST(root));

    }

    static int largestBST(Node root) {
        int[] res = largest(root);

        return res[0];
    }

    static int[] largest(Node root){
        if(root==null)
            return new int[]{0,Integer.MAX_VALUE,Integer.MIN_VALUE};
        
        int[] left=largest(root.left);
        int[] right=largest(root.right);

        if(left[2]<root.data && root.data<right[1]){
            return new int[]{
                1+left[0]+right[0],
                Math.min(root.data,left[1]),
                Math.max(root.data,right[2])
            };
        }
        else{
            return new int[]{
                Math.max(left[0],right[0]),
                Integer.MIN_VALUE,
                Integer.MAX_VALUE
            };
        }
    }
}
