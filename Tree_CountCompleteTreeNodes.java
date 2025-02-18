
public class Tree_CountCompleteTreeNodes {
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
        int[] count=new int[1];
        BrutecountNodes(root,count);
        System.out.println(count[0]);

        System.out.println(OptimalfindCountNodes(root));
    }

    static int OptimalfindCountNodes(Node root){
        if(root==null)
            return 0;
        
        int leftHeight=findLeftHeight(root);
        int rightHeight=findRightHeight(root);

        if(leftHeight==rightHeight)
            return (1<<leftHeight)-1;
        
        return 1+OptimalfindCountNodes(root.left)+OptimalfindCountNodes(root.right);
    }

    static int findLeftHeight(Node root){
        Node node=root;
        int height=0;

        while(node!=null){
            height++;
            node=node.left;
        }
        return height;
    }

    static int findRightHeight(Node root){
        Node node=root;
        int height=0;

        while(node!=null){
            height++;
            node=node.right;
        }
        return height;
    }

    static void BrutecountNodes(Node root,int[] count){
        if(root==null)
            return;
        
        count[0]++;
        BrutecountNodes(root.left, count);
        BrutecountNodes(root.right, count);
    }
}
