import java.util.ArrayList;
import java.util.Stack;

public class Tree_BoundaryTraversal {
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
        
        ArrayList<Integer> arr=Boundarytraversal(root);
        System.out.println(arr);
    }

    static boolean isLeaf(Node root){
        return root.left==null && root.right==null;
    }

    static ArrayList<Integer> Boundarytraversal(Node root){
        ArrayList<Integer> arr=new ArrayList<>();
        if(!isLeaf(root))   arr.add(root.data);
        addLeftBoundary(root,arr);
        addLeafNodes(root,arr);
        addRightBoundary(root,arr);

        return arr;
    }

    static void addLeftBoundary(Node root,ArrayList<Integer> arr){
        Node curr=root.left;
        while(curr!=null){
            if(!isLeaf(curr))   arr.add(curr.data);
            curr=curr.left!=null?curr.left:curr.right;
        }
    }

    static void addLeafNodes(Node root,ArrayList<Integer> arr){
        if(root==null)
            return ;
        
        if(isLeaf(root))
        {
            arr.add(root.data);
            return;
        }

        addLeafNodes(root.left, arr);
        addLeafNodes(root.right, arr);
    }

    static void addRightBoundary(Node root,ArrayList<Integer> arr){
        Node curr=root.right;
        Stack<Integer> st=new Stack<>();

        while(curr!=null){
            if(!isLeaf(curr))   st.push(curr.data);

            curr=curr.right!=null?curr.right:curr.left;
        }

        while(!st.isEmpty())    arr.add(st.pop());
    }
}
