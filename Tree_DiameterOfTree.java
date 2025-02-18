
public class Tree_DiameterOfTree {
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

        System.out.println(BruteFindDiameter(root));
        int[] maximum=new int[1];
        OptimalFindDiameter(root,maximum);
        System.out.println(maximum[0]);
    }

    static int OptimalFindDiameter(Node root,int[] maximum){
        if(root==null)
            return 0;
        
        int left=OptimalFindDiameter(root.left, maximum);
        int right=OptimalFindDiameter(root.right, maximum);

        maximum[0]=Math.max(maximum[0], left+right);

        return Math.max(left, right)+1;
    }

    
    static int maxi=0;
    static int BruteFindDiameter(Node root){
        if(root==null)
            return maxi;
        
        int left=findHeight(root.left);
        int right=findHeight(root.right);
            
        maxi=Math.max(maxi,left+right);
            
        BruteFindDiameter(root.left);
        BruteFindDiameter(root.right);

        return maxi;
    }

    static int findHeight(Node root){
        if(root==null)
            return 0;
        
        int left=findHeight(root.left);
        int right=findHeight(root.right);

        return Math.max(left, right)+1;
    }
}
