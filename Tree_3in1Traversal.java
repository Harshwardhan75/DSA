import java.util.ArrayList;
import java.util.Stack;

public class Tree_3in1Traversal {
    static class Node {
        Node left, right;
        int data;

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

        ThreeinOneTraversal(root);
    }

    static class Pair {
        Node node;
        int count;

        Pair(Node root, int n) {
            this.node = root;
            count = n;
        }
    }

    static void ThreeinOneTraversal(Node root) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        while (!st.isEmpty()) {
            Pair p = st.pop();
            if (p.count == 1) {
                pre.add(p.node.data);
                p.count++;
                st.push(p);
                if (p.node.left != null)
                st.push(new Pair(p.node.left, 1));
            } 
            else
            if (p.count == 2) {
                in.add(p.node.data);
                p.count++;
                st.push(p);
                if (p.node.right != null)
                    st.push(new Pair(p.node.right, 1));
            }
            else{
                post.add(p.node.data);
            }
        }

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }
}
