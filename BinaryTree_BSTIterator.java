import java.util.*;

public class BinaryTree_BSTIterator {
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

        BSTIterator it=new BSTIterator(root);
        while(it.hasNext())
            System.out.println(it.next());
    }

    static class BSTIterator{
        Node root;
        Stack<Node> st;
        public BSTIterator(Node root) {
            this.root=root;
            st=new Stack<>();
            pushAll(root);
        }

        public void pushAll(Node root){
            Node temp=root;
            while(temp!=null){
                st.push(temp);
                temp=temp.left;
            }
        }

        public int next(){
            Node temp=st.pop();
            pushAll(temp.right);
            return temp.data;
        }

        public boolean hasNext(){
            return !st.isEmpty();
        }
    }
}
