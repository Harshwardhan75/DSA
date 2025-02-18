import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Tree_ZigZagTraversal {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static ArrayList<ArrayList<Integer>> ZigZag(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        boolean LefttoRight = true;

        while (!que.isEmpty()) {
            int size = que.size();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 1; i <= size; i++) {
                Node temp = que.poll();
                if (temp.left != null)
                    que.offer(temp.left);
                if (temp.right != null)
                    que.offer(temp.right);

                arr.add(temp.data);
            }

            if (!LefttoRight)
                Collections.reverse(arr);
            LefttoRight=!LefttoRight;
            result.add(arr);
        }

        return result;
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

        ArrayList<ArrayList<Integer>> arr = ZigZag(root);

        System.out.println(arr);
    }

}
