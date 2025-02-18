import java.util.ArrayList;

public class Tree_RootToNodeProblem {
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

        ArrayList<Integer> arr=new ArrayList<>();
        pathtonode(root,arr,17);
        System.out.println(arr);
    }

    static boolean pathtonode(Node root,ArrayList<Integer> arr,int k){
        if(root==null)  return false;
        
        arr.add(root.data);
        if(root.data==k)
            return true;
        if(pathtonode(root.left, arr, k) || pathtonode(root.right, arr, k))
            return true;
        
        arr.remove(arr.size()-1);
        return false;
    }

}
