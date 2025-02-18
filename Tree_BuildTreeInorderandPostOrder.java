import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tree_BuildTreeInorderandPostOrder {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node constructTreeHard(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        Node root = buildHard(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
        return root;
    }

    static Node buildHard(int[] in, int istart, int iend, int[] post, int pstart, int pend, Map<Integer, Integer> map) {
        if (istart > iend || pstart > pend)
            return null;

        Node root = new Node(post[pend]);
        int indexroot = map.get(root.data);
        int left = indexroot - istart;
        root.left = buildHard(in, istart, indexroot - 1, post, pstart, pstart + left - 1, map);
        root.right = buildHard(in, indexroot + 1, iend, post, pstart + left, pend - 1, map);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[] { 40, 20, 50, 10, 60, 30 };
        int[] postorder = new int[] { 40, 50, 20, 60, 30, 10 };

        Node root = constructTreeEasy(inorder, postorder);

        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        inorderTraversal(root, in);
        postorderTraversal(root, post);
        boolean flag = true;
        for (int i = 0; i < in.size(); i++) {
            if (in.get(i) != inorder[i]) {
                flag = false;
                break;
            }
        }

        for (int i = 0; i < post.size(); i++) {
            if (post.get(i) != postorder[i]) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }

    static Node constructTreeEasy(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        int[] pindex = new int[] { postorder.length - 1 };
        return buildEasy(postorder, inorder, 0, inorder.length - 1, map, pindex);
    }

    static Node buildEasy(int[] post, int[] in, int start, int end, Map<Integer, Integer> map, int[] index) {
        if (start > end)
            return null;

        Node root = new Node(post[index[0]--]);
        int indexroot = map.get(root.data);
        root.right = buildEasy(post, in, indexroot + 1, end, map, index);
        root.left = buildEasy(post, in, start, indexroot - 1, map, index);

        return root;
    }

    static void inorderTraversal(Node root, ArrayList<Integer> arr) {
        if (root == null)
            return;

        inorderTraversal(root.left, arr);
        arr.add(root.data);
        inorderTraversal(root.right, arr);
    }

    static void postorderTraversal(Node root, ArrayList<Integer> arr) {
        if (root == null)
            return;

        postorderTraversal(root.left, arr);
        postorderTraversal(root.right, arr);
        arr.add(root.data);
    }
}
