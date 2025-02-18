import java.util.*;

public class Tree_LeftRightViewOfTree {
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

        LeftView(root, arr, 0);
        System.out.println(arr);
        arr.clear();
        RightView(root, arr, 0);
        System.out.println(arr);

    }

    static void LeftView(Node root, ArrayList<Integer> arr, int level) {
        if (root == null)
            return;

        if (arr.size() == level)
            arr.add(root.data);

        LeftView(root.left, arr, level + 1);
        LeftView(root.right, arr, level + 1);
    }

    static void RightView(Node root, ArrayList<Integer> arr, int level) {
        if (root == null)
            return;

        if (arr.size() == level)
            arr.add(root.data);

        RightView(root.right, arr, level + 1);
        RightView(root.left, arr, level + 1);
    }
}
