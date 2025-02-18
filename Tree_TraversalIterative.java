import java.util.ArrayList;
import java.util.Stack;

public class Tree_TraversalIterative {
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

        ArrayList<Integer> arr = PostOrder_TraversalIterative2Stack(root);

        System.out.println(arr);
    }

    static ArrayList<Integer> PreOrder_TraversalIterative(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            Node temp = st.pop();
            arr.add(temp.data);

            if (temp.right != null)
                st.push(temp.right);
            if (temp.left != null)
                st.push(temp.left);
        }

        return arr;
    }

    static ArrayList<Integer> InOrder_TraversalIterative(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node curr = root;

        while (true) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                if (st.isEmpty())
                    break;

                Node temp = st.pop();
                arr.add(temp.data);
                curr = temp;
                curr = curr.right;
            }
        }

        return arr;
    }

    static ArrayList<Integer> PostOrder_TraversalIterative2Stack(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Node> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            Node temp = st1.pop();
            st2.push(temp.data);
            if (temp.right != null)
                st1.push(temp.left);
            if (temp.left != null)
                st1.push(temp.right);
        }

        while(!st2.isEmpty())
            arr.add(st2.pop());

        return arr;
    }
}
