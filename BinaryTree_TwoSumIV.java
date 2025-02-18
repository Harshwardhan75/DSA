import java.util.*;

public class BinaryTree_TwoSumIV {
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

        System.out.println(findTwoSum(root, 128));
    }

    static List<Integer> findTwoSum(Node root, int key) {
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();
        int j = right.next();

        while (i < j) {
            int sum = i + j;

            if (sum == key)
                return Arrays.asList(i, j);

            if (sum < key)
                i = left.next();
            else
                j = right.next();
        }

        return null;
    }

    static class BSTIterator {
        Node root;
        Stack<Node> st;
        boolean reverse;

        public BSTIterator(Node root, boolean reverse) {
            this.root = root;
            st = new Stack<>();
            this.reverse = reverse;
            pushAll(root);
        }

        void pushAll(Node root) {
            Node temp = root;
            while (temp != null) {
                st.push(temp);
                if (reverse)
                    temp=temp.right;
                else
                    temp=temp.left;
            }
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }

        public int next() {
            Node temp = st.pop();
            if (reverse)
                pushAll(temp.left);
            else
                pushAll(temp.right);

            return temp.data;
        }
    }
}
